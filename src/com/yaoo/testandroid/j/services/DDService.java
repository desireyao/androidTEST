package com.yaoo.testandroid.j.services;

import com.yaoo.testandroid.j.aidl.IRemoteService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * @author yaohui
 * @time   2016-2-29
 * @param 
 */
public class DDService extends Service {
	
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("DDService onCreate........" + "Thread: " + Thread.currentThread().getName());
    }
    @Override
    public IBinder onBind(Intent arg0) {
        System.out.println("DDService onBind");
        return mBinder;
    }
 
    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
    	
        public int getPid(){
            System.out.println("Thread: " + Thread.currentThread().getName());
            int pid = android.os.Process.myPid();
            System.out.println("DDService getPid " + pid);
            return  pid;
        }
        
        public void basicTypes(int anInt, long aLong, boolean aBoolean,
            float aFloat, double aDouble, String aString) {
        	
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("basicTypes aDouble: " + aDouble +" anInt: " + anInt+" aBoolean " + aBoolean+" aString " + aString);
        }
    };
}
