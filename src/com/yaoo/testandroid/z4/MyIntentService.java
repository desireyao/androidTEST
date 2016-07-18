package com.yaoo.testandroid.z4;

import com.yaoh.utils.Logger;

import android.app.IntentService;
import android.content.Intent;


public class MyIntentService extends IntentService{

	public MyIntentService() {
		
		super("MyIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		
		Logger.e("thread_name: " + Thread.currentThread().getName());
		
	}

}
