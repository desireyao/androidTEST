package com.yaoo.testandroid.k;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;
import com.yaoo.testandroid.k.services.TestService;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.Menu;

public class MainActivityK extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_k);
//		LogUtil.i("MainActivityK.this:" + MainActivityK.this);
//		
		Intent intent = new Intent(this,TestService.class);
		startService(intent);
		bindService(intent, connection,BIND_AUTO_CREATE);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_k, menu);
		return true;
	}
	
	ServiceConnection connection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO
		}
	};
}
