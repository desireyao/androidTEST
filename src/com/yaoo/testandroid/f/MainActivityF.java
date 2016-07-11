package com.yaoo.testandroid.f;

import java.util.Collections;
import java.util.List;

import com.yaoo.testandroid.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.view.Menu;

public class MainActivityF extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_f);
		
//		getInstalledPackageName(this);
//		getRunningProcess();
		
		getCurrentRunningApp();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity, menu);
		return true;
	}
	
	//获取所有安装程序的名称
	public void getInstalledPackageName(Context context)
    {
        PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        
        for ( int i = 0; i < pinfo.size(); i++ ){
//        	 System.out.println("app包名:" + pinfo.get(i).packageName);
        	 try {
        		 ApplicationInfo applicationInfo = packageManager.getApplicationInfo(pinfo.get(i).packageName,PackageManager.GET_META_DATA);
        		 System.out.println("applicationInfo.sourceDir:" + applicationInfo.sourceDir);
			 } catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	 System.out.println(pinfo.get(i));
        }
    }
	
	public void getCurrentRunningApp(){
		
		//获得最近运行的应用  
		ActivityManager mActivityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE) ;  
		List<ActivityManager.RecentTaskInfo> appList = mActivityManager.getRecentTasks(100, 1);  
		for (ActivityManager.RecentTaskInfo running : appList) {  
		    System.out.println(running.origActivity.getClassName());  
		}  
		
	}
 	
	
    //获取正在运行的所有程序名称 
    public void getRunningProcess(){  
          
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);  
        //获取正在运行的应用  
        List<RunningAppProcessInfo> run = am.getRunningAppProcesses();  
        //获取包管理器，在这里主要通过包名获取程序的图标和程序名  
        PackageManager pm = this.getPackageManager();  
        for(RunningAppProcessInfo ra : run){   
        	  //过滤系统应用
              if(ra.processName.contains("com.android")){
            	  continue;
              }
              System.out.println("ra.processName: " + ra.processName);
        }  
    }
    
    public void getApkPath(){
    	
    	PackageManager manager = getPackageManager();
    	Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
    	mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

    	List<ResolveInfo> apps = manager.queryIntentActivities(mainIntent, 0);
    	Collections.sort(apps, new ResolveInfo.DisplayNameComparator(manager));
    }
}
