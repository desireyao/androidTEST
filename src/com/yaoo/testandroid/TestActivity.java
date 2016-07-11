package com.yaoo.testandroid;

import org.json.JSONArray;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class TestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		
		
		JSONArray ja = new JSONArray();
		Log.e("TAG", "length:" + ja.length());
	}
}
