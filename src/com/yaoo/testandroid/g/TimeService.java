package com.yaoo.testandroid.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

/**
 * @author yaohui
 * @time   2016-2-24
 * @param 
 */
public class TimeService extends Service{
	
    private static final int REQUEST_CODE = 100;
	
	/** 定时任务执行时间间隔：默认10分钟 */
	private static final int INTERVAL_TIME = 5 * 1000;
	
	public static NotifyCallBack callBack;
	
	/** 执行定时获取数据任务，默认间隔10分钟 */
	public static void scheduleSend(Context context) {
		schedule(context, 0);
	}

	/** 执行定时获取数据任务，自定义间隔时间，大于0时有效 */
	public static void scheduleSend(Context context, int scheduleTime) {
		schedule(context, scheduleTime);
	}

	/** 执行定时获取数据任务 */
	private static void schedule(Context context, int time) {
		
		if (time <= 0) {
			time = INTERVAL_TIME;
		}
		Intent intent = new Intent(context, TimeService.class);
		PendingIntent pendingIntent = PendingIntent.getService(context,REQUEST_CODE, intent, PendingIntent.FLAG_NO_CREATE);
		AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
		if (null == pendingIntent) {
			pendingIntent = PendingIntent.getService(context, REQUEST_CODE,intent, PendingIntent.FLAG_CANCEL_CURRENT);
		} else {
			alarmManager.cancel(pendingIntent);
		}
		long firstTime = System.currentTimeMillis() + time;
		alarmManager.setRepeating(AlarmManager.RTC, firstTime, time,pendingIntent);
	}
	
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
    	
    	Toast.makeText(getApplicationContext(), "onStartCommand", Toast.LENGTH_SHORT).show();	
    	callBack.onSuccess();
    	
    	// TODO
    	return super.onStartCommand(intent, flags, startId);
    }
	
    public interface NotifyCallBack{
    	public void onSuccess();
    } 
    
	@Override
	public IBinder onBind(Intent intent) {
		// TODO
		return null;
	}
}
