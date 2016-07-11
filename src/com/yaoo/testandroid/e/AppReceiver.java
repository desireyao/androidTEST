package com.yaoo.testandroid.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author yaohui
 * @time   2016-2-22
 * @param 
 */
public class AppReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("onReceive:" + intent.getAction() + ";" + intent.getData().getSchemeSpecificPart());
	}
}
