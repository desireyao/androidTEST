package com.yaoo.testandroid.l;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.l.utils.AssetsUtil;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivityL extends Activity {

	public static final String TAG = "MainActivityL";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_l);
		String txt = AssetsUtil.getFile4Assets(this,"test.txt");
		Log.e(TAG,txt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_l, menu);
		return true;
	}
}
