package com.yaoo.testandroid.z6.mian;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;
import com.yaoo.testandroid.z6.volleyutil.VolleyManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivityZ6 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_z6);
		
		doVolleyGet();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_z6, menu);
		return true;
	}
	
	private void doVolleyGet(){
		
		VolleyManager.get().doStringRequest();
	}

}
