package com.yaoo.testandroid.e;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.IntentFilter;
import android.view.Menu;

public class MainActivityE extends Activity {

	public final static String PACKAGE_ADDED = "android.intent.action.PACKAGE_ADDED";
	public final static String PACKAGE_REPLACED = "android.intent.action.PACKAGE_REPLACED";
	public final static String PACKAGE_REMOVED = "android.intent.action.PACKAGE_REMOVED";
	
	
	public final static String ACTION_SCREEN_OFF = "android.intent.action.SCREEN_OFF";
	public final static String ACTION_SCREEN_ON = "android.intent.action.SCREEN_ON";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_e);
//		register();
	}
	
	private void register(){
		
 	   IntentFilter filter = new IntentFilter();
       filter.addAction(PACKAGE_ADDED);			    //添加动态广播的Action
       filter.addAction(PACKAGE_REPLACED);			//添加动态广播的Action
       filter.addAction(PACKAGE_REMOVED);			//添加动态广播的Action
       filter.addAction(ACTION_SCREEN_ON);			//添加动态广播的Action
       filter.addAction(ACTION_SCREEN_OFF);			//添加动态广播的Action
	   AppReceiver receiver = new AppReceiver();  
	   registerReceiver(receiver, filter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_e, menu);
		return true;
	}

}
