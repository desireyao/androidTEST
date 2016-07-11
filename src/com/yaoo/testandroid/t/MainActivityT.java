package com.yaoo.testandroid.t;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;

public class MainActivityT extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_t);
		
		test();
	}

	private void test() {
		// TODO
		Resources res = getResources();
		final String packageName = getPackageName();
		int id = res.getIdentifier("activity_main", "layout", packageName);
		System.out.println("activity_main:" + id);
		System.out.println("R.drawable.ic_launcher:" + R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_t, menu);
		return true;
	}

}
