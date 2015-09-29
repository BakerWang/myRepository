package com.example.myfirstapp;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShareActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

		// Create the text view
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);

		// Set the text view as the activity layout
		setContentView(textView);

		Uri data = intent.getData();

		// Figure out what to do based on the intent type
		if (intent.getType().indexOf("image/") != -1) {
			// Handle intents with image data ...
		} else if (intent.getType().equals("text/plain")) {
			// Handle intents with text ...
		}

		// Create intent to deliver some kind of result data
		//������뷵��һ��result����������Ǹ�activity��������Ҫִ��setResult()��ͨ��ָ��һ��result code��result intent��
		//����Ĳ����ɹ�֮���û���Ҫ���ص�ԭ����activity��ͨ��ִ��finish() ���رձ������activity��
		Intent result = new Intent("com.example.RESULT_ACTION",
				Uri.parse("content://result_uri"));
		setResult(Activity.RESULT_OK, result);
		finish();

	}

}