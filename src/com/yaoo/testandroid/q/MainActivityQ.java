package com.yaoo.testandroid.q;


import com.yaoh.loadjarassets.utils.LoadAsstes;
import com.yaoo.testandroid.R;
import com.yaoo.testandroid.o.Logger;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;

public class MainActivityQ extends Activity {

	private ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_q);
		initView();
	}

	@SuppressLint("NewApi")
	private void initView() {
		
		imageView = (ImageView) findViewById(R.id.iv);
		LoadAsstes load = new LoadAsstes();
		Drawable drawable = load.getDrawable(this);
		Logger.i("drawable:" + drawable);
		
		imageView.setBackground(drawable);
		
	}
	
	private void test(){
		
		ProgressBar pb = new ProgressBar(this,null,android.R.attr.progressBarStyleHorizontal);
	}
}
