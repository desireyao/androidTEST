package com.yaoo.testandroid.p;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;

public class MainActivityp extends Activity{

	Handler handler = new Handler();
	Excutor excutor = new Excutor();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activityp);
		
		handler.post(new Runnable() {
			
			@Override
			public void run() {
				excutor.onSuccess();
			}
		});
	}
	
	class Excutor implements CallBack{

		@Override
		public void onSuccess() {
			// TODO
			
		}

		@Override
		public void onFailed() {
			// TODO
			
		}
	}
}
