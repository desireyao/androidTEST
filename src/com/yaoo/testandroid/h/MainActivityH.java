package com.yaoo.testandroid.h;

import java.util.Calendar;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivityH extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_h);
		
		init();

	}

	private void init() {
		// TODO
		Intent intent =new Intent(MainActivityH.this, alarmreceiver.class);
		intent.setAction("short");
		PendingIntent sender=PendingIntent.getBroadcast(MainActivityH.this, 0, intent, 0);

		//设定一个五秒后的时间
		Calendar calendar=Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		calendar.add(Calendar.SECOND, 5);

		AlarmManager alarm=(AlarmManager)getSystemService(ALARM_SERVICE);
		alarm.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
		
//		Intent intent =new Intent(this, alarmreceiver.class);
//		intent.setAction("repeating");
//		PendingIntent sender=PendingIntent
//		.getBroadcast(this, 0, intent, 0);
//		//开始时间
//		long firstime = SystemClock.elapsedRealtime();
//
//		AlarmManager am=(AlarmManager)getSystemService(ALARM_SERVICE);
//	    //5秒一个周期，不停的发送广播
//		am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstime, 5*1000, sender);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_h, menu);
		return true;
	}

	// 注意：receiver记得在manifest.xml注册
	public static class alarmreceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			if (intent.getAction().equals("short")) {
				Toast.makeText(context, "short alarm", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(context, "repeating alarm", Toast.LENGTH_LONG).show();
			}
		}
	}

}
