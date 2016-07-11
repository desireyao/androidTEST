package com.yaoo.testandroid;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.TextView;

public class MainActivityW extends Activity {

	private TextView textview;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_w);
		
		textview = (TextView) findViewById(R.id.textview);
		getInfo(); //yaoh
	}
	
	private void getInfo() {      
		
        TelephonyManager mTm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);  
        
        String imei = mTm.getDeviceId();    
        String imsi = mTm.getSubscriberId();    
        String phoneModel = android.os.Build.MODEL; // 手机型号    
        String numer = mTm.getLine1Number(); // 手机号码，有的可得，有的不可得    
        String getSimOperatorName = mTm.getSimOperatorName();
        
        
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);    
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();    
        String mac = wifiInfo.getMacAddress();  
        int ip = wifiInfo.getIpAddress();
        String _ip = int2ip(ip);
        
        String androidVersion = android.os.Build.VERSION.RELEASE;
        String pkName = this.getPackageName();
        
        ConnectivityManager cm = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		
		String networkWay = null;
		if (info.getType() == ConnectivityManager.TYPE_WIFI) {
			networkWay = "wifi";
		} else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
			networkWay = "net";
	    }
		
        String string = ("运营商: " + getSimOperatorName 
        		+ " \n imei: " + imei + " \n imsi: " + imsi 
        		+ " \n phoneModel: " + phoneModel + "\n numer: " + numer
        		+ "\n mac: " + mac + "\n IP: " + _ip
        		+ "\n androidVersion:" + androidVersion + "\n packageName: " + pkName
        		+ "\n networkWay： " + networkWay
        		);
        
        List<PackageInfo> packages = getPackageManager().getInstalledPackages(0);

     		for (int i = 0; i < packages.size(); i++) {
     			PackageInfo packageInfo = packages.get(i);
     			// 如果属于非系统程序，则添加到列表显示
     			if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
     				
     				   String packageName = packageInfo.packageName;
//     				   string  += "\n " + packageName;
     			}
     		}
     		textview.setText(string);
    }
	
	public static String int2ip(int ipInt) {  
		
        StringBuilder sb = new StringBuilder();  
        sb.append(ipInt & 0xFF).append(".");  
        sb.append((ipInt >> 8) & 0xFF).append(".");  
        sb.append((ipInt >> 16) & 0xFF).append(".");  
        sb.append((ipInt >> 24) & 0xFF);  
        return sb.toString();  
    }
}
