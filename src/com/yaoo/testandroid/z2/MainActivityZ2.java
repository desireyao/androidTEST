package com.yaoo.testandroid.z2;

import com.nduo.core.view.gif.GifView;
import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivityZ2 extends Activity {

	private GifView mGifView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_z2);
		
		  mGifView = (GifView)findViewById(R.id.loading);
		  mGifView.setGifImage(R.drawable.demo4);
	      mGifView.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_z2, menu);
		return true;
	}

}
