package com.yaoo.testandroid.k.services;

import com.yaoo.testandroid.k.LogUtil;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * @author yaohui
 * @time   2016-3-2
 * @param 
 */
public class TestService extends Service{

	LocalBinder localBinder = new LocalBinder();
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO
		LogUtil.i("onBind");
		return localBinder;
	}
	
	@Override
	public void onCreate() {
		// TODO
		LogUtil.i("onCreate");
		Context context = this;
		//-------------------------------------------------
		LogUtil.i("context:" + context);
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		LogUtil.i("onStartCommand");
		Context context = this;
		//-------------------------------------------------
		LogUtil.i("context:" + context);
		return super.onStartCommand(intent, flags, startId);
	}
	
	class LocalBinder extends Binder{
		
	}
}
