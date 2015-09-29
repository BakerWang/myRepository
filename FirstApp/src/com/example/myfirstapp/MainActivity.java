package com.example.myfirstapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.net.Uri;
import android.net.wifi.p2p.WifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager.Channel;
import android.net.wifi.p2p.WifiP2pManager.ChannelListener;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.MediaStore;
import android.support.v4.print.PrintHelper;
import android.util.Log;
import android.util.LruCache;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.VideoView;

import com.example.myfirstapp.db.FeedReaderContract;
import com.example.myfirstapp.db.FeedReaderDbHelper;
import com.example.myfirstapp.opengl.OpenGLES20Activity;
import com.example.myfirstapp.photo.BitmapWorkerTask;
import com.example.myfirstapp.photo.ImageDetailActivity;
import com.example.myfirstapp.photo.PhotoUtils;
import com.example.myfirstapp.photo.Preview;

@SuppressWarnings("deprecation")
public class MainActivity extends Activity implements ChannelListener {

	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	public final static String TAG = "com.example.myfirstapp.tag";

	public String mCurrentPhotoPath;

	public static final int REQUEST_PICK_CONTACT = 1; // ѡ����ϵ��

	public static final int REQUEST_IMAGE_CAPTURE = 2;// ����ץȡ����ͼ

	public static final int REQUEST_TAKE_PHOTO = 3;// ����

	public static final int REQUEST_VIDEO_CAPTURE = 4;// ¼��Ƶ

	// private CameraDevice mCamera;
	private Camera mCamera;

	private Preview mPreview;

	private ImageView mImageView;

	private VideoView mVideoView;

	private Bitmap mPlaceHolderBitmap;

	private LruCache<String, Bitmap> mMemoryCache;

	// Set the Share Intent(���÷����intent)
	private ShareActionProvider mShareActionProvider;

	NfcAdapter mNfcAdapter;
	// Flag to indicate that Android Beam is available
	boolean mAndroidBeamAvailable = false;

	private final IntentFilter intentFilter = new IntentFilter();
	private WifiP2pManager mManager;
	private Channel mChannel;

	private boolean isWifiP2pEnabled = false;

	private BroadcastReceiver receiver = null;

	public void setIsWifiP2pEnabled(boolean isWifiP2pEnabled) { // ����һ������Ƿ�����WiFiֱ��
		this.isWifiP2pEnabled = isWifiP2pEnabled;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Indicates a change in the Wi-Fi P2P status.
		intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION);

		// Indicates a change in the list of available peers.
		intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION);

		// Indicates the state of Wi-Fi P2P connectivity has changed.
		intentFilter
				.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION);

		// Indicates this device's details have changed.
		intentFilter
				.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION);

		mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
		mChannel = mManager.initialize(this, getMainLooper(), null);

		// getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		// ������minSdkVersion������11�����, Ӧ����ô��:
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// NFC isn't available on the device
		// �����������android:required="false"�������Ҫ�ڴ����в���NFC��Android Beam�ļ������Ƿ�֧�֡�

		PackageManager pm = this.getPackageManager(); // ���PackageManager����

		if (!pm.hasSystemFeature(PackageManager.FEATURE_NFC)) {
			/*
			 * Disable NFC features here. For example, disable menu items or
			 * buttons that activate NFC-related features
			 */

			// Android Beam file transfer isn't supported
		} else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
			// If Android Beam isn't available, don't continue.
			mAndroidBeamAvailable = false;
			/*
			 * Disable Android Beam file transfer features here.
			 */

			// Android Beam file transfer is available, continue
		} else {
			mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

		}

		// Get max available VM memory, exceeding this amount will throw an
		// OutOfMemory exception. Stored in kilobytes as LruCache takes an
		// int in its constructor.
		final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

		// Use 1/8th of the available memory for this memory cache.
		final int cacheSize = maxMemory / 8;

		mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap bitmap) {
				// The cache size will be measured in kilobytes rather than
				// number of items.
				return bitmap.getByteCount() / 1024;
			}
		};

	}

	// ����һ���µ�BroadcastReceiver������ϵͳ��Wi-Fi P2P��״̬�仯��
	// @Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)) {
			// Determine if Wifi P2P mode is enabled or not, alert
			// the Activity.
			int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
			if (state == WifiP2pManager.WIFI_P2P_STATE_ENABLED) {
				setIsWifiP2pEnabled(true);
			} else {
				setIsWifiP2pEnabled(false);
			}
		} else if (WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)) {

			// The peer list has changed! We should probably do something about
			// that.

		} else if (WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION
				.equals(action)) {

			// Connection state changed! We should probably do something about
			// that.

		} else if (WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION
				.equals(action)) {
			/*
			DeviceListFragment fragment = (DeviceListFragment) 
					.getFragmentManager().findFragmentById(R.id.frag_list);
			fragment.updateThisDevice((WifiP2pDevice) intent
					.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE));
					*/

		}
	}

	// Call to update the share intent
	private void setShareIntent(Intent shareIntent) {
		if (mShareActionProvider != null) {
			mShareActionProvider.setShareIntent(shareIntent);
		}
	}

	/** ���û������ťʱ�ᱻ���� */
	public void sendMessage(View view) {
		// ��Ӧ��ť���¼������߼�
		// Intent ����Я�������������͵ļ��ϵ�key-value���Ӷԣ�����extras��
		// putExtra()�����Ѽ�����Ϊ��һ����������ֵ��Ϊ�ڶ���������
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		// �����ڶ���activity
		startActivity(intent);
	}

	/** ���û���� �鿴��ͼ ��ťʱ�ᱻ���� */
	public void openMap(View view) {
		// Implicit intents������������Ҫ�������������������ʹ�õ�������һ����Ҫִ�еĶ��������actionָ����������������
		// Map point based on address
		Uri location = Uri
				.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
		// Or map point based on latitude/longitude
		// Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param
		// is zoom level
		Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

		// ���ж��Ӧ��ʱ�����û��Լ�ѡ��򿪷�ʽ
		// Always use string resources for UI text. This says something like
		// "Share this photo with"
		String title = (String) getResources().getText(R.string.chooser_title);
		// Create and start the chooser
		Intent chooser = Intent.createChooser(mapIntent, title);
		startActivity(chooser);

		// ����㴥����һ��intent������û���κ�һ��app��ȥ�������intent����ô���app��crash��
		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(
				mapIntent, 0);
		boolean isIntentSafe = activities.size() > 0;
		// Start an activity if it's safe
		if (isIntentSafe) {
			startActivity(mapIntent);
		}

		// ��绰
		Uri number = Uri.parse("tel:5551234");
		Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
		// startActivity(callIntent);

		// �鿴��ҳ
		Uri webpage = Uri.parse("http://www.android.com");
		Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

		// �����ʼ�
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		// The intent does not have a URI, so declare the "text/plain" MIME type
		emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
		emailIntent.putExtra(Intent.EXTRA_EMAIL,
				new String[] { "jon@example.com" }); // recipients
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
		emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
		emailIntent.putExtra(Intent.EXTRA_STREAM,
				Uri.parse("content://path/to/email/attachment"));
		// You can also attach multiple items by passing an ArrayList of Uris

	}

	/** �鿴ͼƬ */
	public void openPic(View view) {
		Intent intent = new Intent(this, ImageDetailActivity.class);
		startActivity(intent);
	}

	/** OpenGL */
	public void OpenGL(View view) {
		Intent intent = new Intent(this, OpenGLES20Activity.class);
		startActivity(intent);
	}

	// ��������һ��activity����һ���ǵ���ġ���Ҳ������������һ��activityȻ�����һ��result������
	// Ϊ�˽������result������Ҫʹ��startActivityForResult() ��������startActivity()��
	private void pickContact() {
		Intent pickContactIntent = new Intent(Intent.ACTION_PICK,
				Uri.parse("content://contacts"));
		pickContactIntent.setType(Phone.CONTENT_TYPE); // Show user only
														// contacts w/ phone
														// numbers
		startActivityForResult(pickContactIntent, REQUEST_PICK_CONTACT);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// Check which request we're responding to
		if (requestCode == REQUEST_PICK_CONTACT) {
			// Make sure the request was successful
			if (resultCode == RESULT_OK) {
				// The user picked a contact.
				// The Intent's data Uri identifies which contact was selected.

				// Do something with the contact here (bigger example below)
			}
		}
		// �鿴����ͼ
		if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
			Bundle extras = data.getExtras();
			Bitmap imageBitmap = (Bitmap) extras.get("data");
			mImageView.setImageBitmap(imageBitmap);
		}

		// ������Ƶ
		if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
			Uri videoUri = data.getData();
			mVideoView.setVideoURI(videoUri);
		}

	}

	// Ϊ action bar ���ֲ˵���Ŀ����ͨ���� activity ��ʵ�� onCreateOptionsMenu() �ص������� inflate
	// �˵���Դ�Ӷ���ȡ Menu ����
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// ΪActionBar��չ�˵���
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);

		// Locate MenuItem with ShareActionProvider
		MenuItem item = menu.findItem(R.id.action_share);

		// Fetch and store ShareActionProvider
		mShareActionProvider = (ShareActionProvider) item.getActionProvider();
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * ���û�����ĳһ��������ť���� action overflow �е�������Ŀ��ϵͳ������ activity
	 * ��onOptionsItemSelected()�ص������� �ڸ÷�����ʵ���������MenuItem��getItemId()���ж��ĸ���Ŀ������ -
	 * ���ص� ID ��ƥ����������Ӧ�� <item> Ԫ���� <android:id> ���Ե�ֵ��
	 * */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// ��������ť�ĵ���¼�
		switch (item.getItemId()) {
		case R.id.action_search:
			// openSearch();
			return true;
		case R.id.action_settings:
			// openSettings();
			return true;
		case R.id.action_share:
			Intent shareIntent = new Intent();
			setShareIntent(shareIntent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* Checks if external storage is available for read and write */
	public boolean isExternalStorageWritable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		}
		return false;
	}

	/* Checks if external storage is available to at least read */
	public boolean isExternalStorageReadable() {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)
				|| Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			return true;
		}
		return false;
	}

	public void do_SharedPreferences() {
		// �������һ����Խ�С��key-value������Ҫ���棬��Ӧ��ʹ��SharedPreferences APIs
		// ��ȡSharedPreference
		Context context = this.getApplication().getApplicationContext();
		SharedPreferences sharedPref = context.getSharedPreferences(
				getString(R.string.preference_file_key), Context.MODE_PRIVATE);

		// дShared Preference
		SharedPreferences.Editor editor = sharedPref.edit();
		editor.putString(getString(R.string.preference_file_key),
				"SharedPreferences ����ֵ");
		editor.commit();

		// ��Shared Preference
		String value = sharedPref.getString(
				getString(R.string.preference_file_key), "");

	}

	public void do_InternalStorage() {
		Context context = this.getApplication().getApplicationContext();
		// ���浽Internal Storage
		String filename = "myfile";
		File file = new File(context.getFilesDir(), filename);
		String string = "Hello world!";
		FileOutputStream outputStream;

		try {
			outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
			outputStream.write(string.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ���������Ҫ����һЩ�ļ��������ʹ��createTempFile()����
		File file2;
		String url = "anotherfile";
		try {
			String fileName = Uri.parse(url).getLastPathSegment();
			file2 = File.createTempFile(fileName, null, context.getCacheDir());
		} catch (IOException e) {
			// Error while creating file
		}
	}

	// �����ļ���External Storage
	public void do_ExternalStorage() {
		if (!isExternalStorageReadable())
			return;
		if (!isExternalStorageWritable())
			return;

		Context context = this.getApplication().getApplicationContext();

		String filename = "myfile";
		File file = new File(context.getFilesDir(), filename);
		String string = "Hello world!";
		FileOutputStream outputStream;

		try {
			outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
			outputStream.write(string.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ���������Ҫ����һЩ�ļ��������ʹ��createTempFile()����
		File file2;
		String url = "anotherfile";
		try {
			String fileName = Uri.parse(url).getLastPathSegment();
			file2 = File.createTempFile(fileName, null, context.getCacheDir());
		} catch (IOException e) {
			// Error while creating file
		}
	}

	public void do_DataBase() {
		Context context = this.getApplication().getApplicationContext();
		// �����Ϣ��DB
		// Gets the data repository in write mode
		FeedReaderDbHelper mDbHelper = new FeedReaderDbHelper(context);
		SQLiteDatabase db = mDbHelper.getWritableDatabase();

		// Create a new map of values, where column names are the keys
		ContentValues values = new ContentValues();
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID, "id");
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title");
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CONTENT, "content");

		// Insert the new row, returning the primary key value of the new row
		long newRowId = 0;
		newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME,
				FeedReaderContract.FeedEntry.COLUMN_NAME_NULLABLE, values);

		// ��DB�ж�ȡ��Ϣ
		db = mDbHelper.getReadableDatabase();

		// Define a projection that specifies which columns from the database
		// you will actually use after this query.
		String[] projection = { FeedReaderContract.FeedEntry._ID,
				FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE };
		String selection = FeedReaderContract.FeedEntry._ID
				+ FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE;
		String[] selectionArgs = { FeedReaderContract.FeedEntry._ID,
				FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE };

		// How you want the results sorted in the resulting Cursor
		String sortOrder = FeedReaderContract.FeedEntry._ID + " DESC";

		Cursor cursor = db.query(FeedReaderContract.FeedEntry.TABLE_NAME,
				projection, // The columns to return
				selection, // The columns for the WHERE clause
				selectionArgs, // The values for the WHERE clause
				null, // don't group the rows
				null, // don't filter by row groups
				sortOrder // The sort order
				);

		cursor.moveToFirst();
		long itemId = cursor.getLong(cursor
				.getColumnIndexOrThrow(FeedReaderContract.FeedEntry._ID));

		// ɾ��DB�е���Ϣ
		String table_name = "mytable";
		// Define 'where' part of query.
		selection = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID
				+ " LIKE ?";
		// Specify arguments in placeholder order.
		String[] selelectionArgs = { String.valueOf(itemId) };
		// Issue SQL statement.
		db.delete(table_name, selection, selectionArgs);

		// ��������
		db = mDbHelper.getReadableDatabase();

		// New value for one column
		ContentValues values2 = new ContentValues();
		values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title");

		// Which row to update, based on the ID
		String selection2 = FeedReaderContract.FeedEntry.COLUMN_NAME_ENTRY_ID
				+ " LIKE ?";
		String[] selectionArgs2 = { String.valueOf(itemId) };

		int count = db.update(table_name, values, selection, selectionArgs);
	}

	// Android�н�����ί�и�����Ӧ�õķ����ǣ�����һ��Intent���������Ҫ�Ķ��������������������֣�
	// Intent �����������ⲿ Activity, ��һЩ��������Ƭ�Ĵ��롣
	private void dispatchTakePictureIntent(int actionCode) {
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
		}
		// Ensure that there's a camera activity to handle the intent
		if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
			// Create the File where the photo should go
			File photoFile = null;
			try {
				photoFile = PhotoUtils.createImageFile();
				mCurrentPhotoPath = "file:" + photoFile.getAbsolutePath();
			} catch (IOException ex) {
				// Error occurred while creating the File
			}
			// Continue only if the File was successfully created
			if (photoFile != null) {
				takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
						Uri.fromFile(photoFile));
				startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
			}
		}
	}

	// ʹ�����������¼����Ƶ(Record a Video with a Camera App)
	private void dispatchTakeVideoIntent() {
		Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
			startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
		}
	}

	// �����Ƭ�����(Add the Photo to a Gallery)
	private void galleryAddPic() {
		Intent mediaScanIntent = new Intent(
				Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
		File f = new File(mCurrentPhotoPath);
		Uri contentUri = Uri.fromFile(f);
		mediaScanIntent.setData(contentUri);
		this.sendBroadcast(mediaScanIntent);
	}

	// ��������ͼƬ(Decode a Scaled Image)
	private void zoomPic() {
		// Get the dimensions of the View
		int targetW = mImageView.getWidth();
		int targetH = mImageView.getHeight();

		// Get the dimensions of the bitmap
		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		bmOptions.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
		int photoW = bmOptions.outWidth;
		int photoH = bmOptions.outHeight;

		// Determine how much to scale down the image
		int scaleFactor = Math.min(photoW / targetW, photoH / targetH);

		// Decode the image file into a Bitmap sized to fill the View
		bmOptions.inJustDecodeBounds = false;
		bmOptions.inSampleSize = scaleFactor;
		bmOptions.inPurgeable = true;

		Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
		mImageView.setImageBitmap(bitmap);
	}

	// ���������(Open the Camera Object)
	private boolean safeCameraOpen(int id) {
		boolean qOpened = false;

		try {
			releaseCameraAndPreview();
			mCamera = Camera.open(id);
			qOpened = (mCamera != null);
		} catch (Exception e) {
			Log.e(getString(R.string.app_name), "failed to open Camera");
			e.printStackTrace();
		}

		return qOpened;
	}

	private void releaseCameraAndPreview() {
		mPreview.setCamera(null);
		if (mCamera != null) {
			mCamera.release();
			mCamera = null;
		}
	}

	// ��ӡһ��ͼƬ
	private void doPhotoPrint(Context c) {
		PrintHelper photoPrinter = new PrintHelper(c);
		photoPrinter.setScaleMode(PrintHelper.SCALE_MODE_FIT);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.print);
		photoPrinter.printBitmap("droids.jpg - test print", bitmap);
	}

	private WebView mWebView;

	// ��ӡHTML�ĵ�
	private void doWebViewPrint(final Context c) {
		// Create a WebView object specifically for printing
		WebView webView = new WebView(c);
		webView.setWebViewClient(new WebViewClient() {

			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				return false;
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				Log.i(TAG, "page finished loading " + url);
				createWebPrintJob(view, c);
				mWebView = null;
			}
		});

		// Generate an HTML document on the fly:
		String htmlDocument = "<html><body><h1>Test Content</h1><p>Testing, "
				+ "testing, testing...</p></body></html>";
		webView.loadDataWithBaseURL(null, htmlDocument, "text/HTML", "UTF-8",
				null);

		// Keep a reference to WebView object until you pass the
		// PrintDocumentAdapter
		// to the PrintManager
		mWebView = webView;
	}

	private List<PrintJob> mPrintJobs;

	// ����һ����ӡ����
	private void createWebPrintJob(WebView webView, Context c) {

		// Get a PrintManager instance
		PrintManager printManager = (PrintManager) c
				.getSystemService(Context.PRINT_SERVICE);

		// Get a print adapter instance
		PrintDocumentAdapter printAdapter = webView
				.createPrintDocumentAdapter();

		// Create a print job with name and adapter instance
		String jobName = getString(R.string.app_name) + " Document";
		PrintJob printJob = printManager.print(jobName, printAdapter,
				new PrintAttributes.Builder().build());

		// Save the job object for later status checking
		mPrintJobs.add(printJob);
	}

	// ��ʼ�첽����λͼ��ֻ��Ҫ����һ���µ�����ִ��������:
	public void loadBitmap(int resId, ImageView imageView) {

		if (cancelPotentialWork(resId, imageView)) {
			final BitmapWorkerTask task = new BitmapWorkerTask(imageView);
			final BitmapWorkerTask.AsyncDrawable asyncDrawable = new BitmapWorkerTask.AsyncDrawable(
					getResources(), mPlaceHolderBitmap, task);
			imageView.setImageDrawable(asyncDrawable);
			task.execute(resId);
		}
	}

	public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
		if (getBitmapFromMemCache(key) == null) {
			mMemoryCache.put(key, bitmap);
		}
	}

	public Bitmap getBitmapFromMemCache(String key) {
		return mMemoryCache.get(key);
	}

	// ȡ�����ͼƬ
	public void loadBitmap(int resId) {
		final String imageKey = String.valueOf(resId);

		final Bitmap bitmap = getBitmapFromMemCache(imageKey);
		if (bitmap != null) {
			mImageView.setImageBitmap(bitmap);
		} else {
			mImageView.setImageResource(R.drawable.image_placeholder);
			BitmapWorkerTask task = new BitmapWorkerTask(mImageView);
			task.execute(resId);
		}
	}

	public static boolean cancelPotentialWork(int data, ImageView imageView) {
		final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);

		if (bitmapWorkerTask != null) {
			final int bitmapData = bitmapWorkerTask.data;
			if (bitmapData != data) {
				// Cancel previous task
				bitmapWorkerTask.cancel(true);
			} else {
				// The same work is already in progress
				return false;
			}
		}
		// No task associated with the ImageView, or an existing task was
		// cancelled
		return true;
	}

	private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
		if (imageView != null) {
			final Drawable drawable = imageView.getDrawable();
			if (drawable instanceof BitmapWorkerTask.AsyncDrawable) {
				final BitmapWorkerTask.AsyncDrawable asyncDrawable = (BitmapWorkerTask.AsyncDrawable) drawable;
				return asyncDrawable.getBitmapWorkerTask();
			}
		}
		return null;
	}

	@Override
	public void onChannelDisconnected() {
		// TODO Auto-generated method stub

	}

}
