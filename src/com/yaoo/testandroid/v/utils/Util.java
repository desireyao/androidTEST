package com.yaoo.testandroid.v.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

import org.json.JSONException;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;

/**
 * @author yaohui
 * @time 2016-4-12
 * @param
 */
public class Util {

	public static String getCurrentNetType(Context context) {
		String type = "";
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info == null) {
			type = "null";
		} else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
			type = "wifi";
		} else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
			int subType = info.getSubtype();

			if (subType == TelephonyManager.NETWORK_TYPE_CDMA
					|| subType == TelephonyManager.NETWORK_TYPE_GPRS
					|| subType == TelephonyManager.NETWORK_TYPE_EDGE) {
				type = "2g";
			} else if (subType == TelephonyManager.NETWORK_TYPE_UMTS
					|| subType == TelephonyManager.NETWORK_TYPE_HSDPA
					|| subType == TelephonyManager.NETWORK_TYPE_EVDO_A
					|| subType == TelephonyManager.NETWORK_TYPE_EVDO_0
					|| subType == TelephonyManager.NETWORK_TYPE_EVDO_B) {
				type = "3g";
			} else if (subType == TelephonyManager.NETWORK_TYPE_LTE) {// LTE是3g到4g的过渡，是3.9G的全球标准
				type = "4g";
			}
		}
		return type;
	}

	/**
	 * 获取手机ip地址
	 * 
	 * @return
	 */
	public static String getPhoneIp() {
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface
					.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf
						.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()
							&& inetAddress instanceof Inet4Address) {
						// if (!inetAddress.isLoopbackAddress() && inetAddress
						// instanceof Inet6Address) {
						return inetAddress.getHostAddress().toString();
					}
				}
			}
		} catch (Exception e) {
		}
		return "";
	}

	/** 
	 * 获取手机基站信息 
	 * @throws JSONException  
	 */  
	public static void getGSMCellLocationInfo(Context context){  
	      
	    TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);  
	    String operator = manager.getNetworkOperator();  
	    /**通过operator获取 MCC 和MNC */  
	    
	    int mcc = Integer.parseInt(operator.substring(0, 3));  
	    int mnc = Integer.parseInt(operator.substring(3));
	    Log.e("TAG", "mcc: " + mcc + " mnc: " + mnc);
	    
	    GsmCellLocation location = (GsmCellLocation) manager.getCellLocation();  
	    
	    /**通过GsmCellLocation获取中国移动和联通 LAC 和cellID */  
	    int lac = location.getLac();  
	    int cellid = location.getCid();  
	    Log.e("TAG", "lac: " + lac + " cellid: " + cellid);
	
	    int strength = 0;  
	    /**通过getNeighboringCellInfo获取BSSS */  
	    List<NeighboringCellInfo> infoLists = manager.getNeighboringCellInfo();  
	    System.out.println("infoLists:"+infoLists+"     size:"+infoLists.size());  
	    for (NeighboringCellInfo info : infoLists) {  
	        strength+=(-133+2*info.getRssi());// 获取邻区基站信号强度    
	        //info.getLac();// 取出当前邻区的LAC   
	        //info.getCid();// 取出当前邻区的CID   
	        Log.e("TAG","rssi:"+info.getRssi()+"   strength:"+strength);  
	    }  
	    //以下内容是把得到的信息组合成json体，然后发送给我的服务器，获取经纬度信息 
	}
}
