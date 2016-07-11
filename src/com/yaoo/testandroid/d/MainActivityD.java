package com.yaoo.testandroid.d;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

public class MainActivityD extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_d);
		
		Button btn = (Button) findViewById(R.id.btn);
		
		try {
			ApplicationInfo appInfo = this.getPackageManager().getApplicationInfo(getPackageName(),
			PackageManager.GET_META_DATA);
			String msg = appInfo.metaData.getString("data_Name");
			Log.e("TAG", "msg = " + msg );
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_d, menu);
		return true;
	}

}
