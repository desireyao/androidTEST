package com.yaoo.testandroid.z4;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivityZ4 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_z4);
		
		Intent intent = new Intent(this,MyIntentService.class);
		startService(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_z4, menu);
		return true;
	}

}
