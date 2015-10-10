package com.example.myfirstapp;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.content.FileProvider;

//�ļ�ѡ�� �ڴ����ж����ļ�ѡ��Activity
public class FileSelectActivity extends Activity {

	// The path to the root of this app's internal storage
	private File mPrivateRootDir;
	// The path to the "images" subdirectory
	private File mImagesDir;
	// Array of files in the images subdirectory
	File[] mImageFiles;
	// Array of filenames corresponding to mImageFiles
	String[] mImageFilenames;

	ListView mFileListView;

	Intent mResultIntent;

	// Initialize the Activity
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// Set up an Intent to send back to apps that request a file
		mResultIntent = new Intent("com.example.myapp.ACTION_RETURN_FILE");
		// Get the files/ subdirectory of internal storage
		mPrivateRootDir = getFilesDir();
		// Get the files/images subdirectory;
		mImagesDir = new File(mPrivateRootDir, "images");
		// Get the files in the images subdirectory
		mImageFiles = mImagesDir.listFiles();
		// Set the Activity's result to null to begin with
		setResult(Activity.RESULT_CANCELED, null);
		/*
		 * Display the file names in the ListView mFileListView. Back the
		 * ListView with the array mImageFilenames, which you can create by
		 * iterating through mImageFiles and calling File.getAbsolutePath() for
		 * each File
		 */

		// һ��һ���û�ѡ����һ��������ļ������Ӧ�ñ�����ȷ�ĸ��ļ���ѡ���ˣ�Ȼ��Ϊ����ļ�����һ����Ӧ��URI��
		// Define a listener that responds to clicks on a file in the ListView
		mFileListView
				.setOnItemClickListener(new AdapterView.OnItemClickListener() {
					@Override
					/*
					 * When a filename in the ListView is clicked, get its
					 * content URI and send it to the requesting app
					 */
					public void onItemClick(AdapterView<?> adapterView,
							View view, int position, long rowId) {
						/*
						 * Get a File for the selected file name. Assume that
						 * the file names are in the mImageFilename array.
						 */
						File requestFile = new File(mImageFilenames[position]);

						/*
						 * Most file-related method calls need to be in
						 * try-catch blocks.
						 */
						// Use the FileProvider to get a content URI
						Uri fileUri = null;
						try {
							fileUri = FileProvider.getUriForFile(
									FileSelectActivity.this,
									"com.example.myfirstapp.fileprovider",
									requestFile);
						} catch (IllegalArgumentException e) {
							Log.e("File Selector",
									"The selected file can't be shared: " + "");
						}

						if (fileUri != null) {
							// Ϊ�ļ���Ȩ
							// Grant temporary read permission to the content
							// URI
							mResultIntent
									.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
							// Put the Uri and MIME type in the result Intent
							mResultIntent.setDataAndType(fileUri,
									getContentResolver().getType(fileUri));
							// Set the result
							FileSelectActivity.this.setResult(
									Activity.RESULT_OK, mResultIntent);
						} else {
							mResultIntent.setDataAndType(null, "");
							FileSelectActivity.this.setResult(RESULT_CANCELED,
									mResultIntent);
						}
					}

				});

	}

	/**
	 * 
	 * ���û��ṩһ��һ������ѡ�����ļ����������ص��ͻ���Ӧ�õķ�����һ��ʵ�ֵķ������ṩһ����ѡ�����һ����ɰ�ť��
	 * ʹ�ð�ť��android:onClick�����ֶ�Ϊ������һ���������ڸ÷����У�����finish())
	 * */
	public void onDoneClick(View v) {
		// Associate a method with the Done button
		finish();
	}

}