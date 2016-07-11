package com.yaoo.testandroid.n.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author yaohui
 * @time   2016-3-9
 * @param 
 */
public class SharedPreferenceUtil {
	
	public static final String PREFS_NAME = "PREFS_NAME";
	public static final String TURE_OR_FALSE = "TURE_OR_FALSE";
	
	public static final String AD_TYPES = "AD_TYPES";
	
	
	
	public static void saveBoolean(Context context,boolean b){
		
	  SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	  SharedPreferences.Editor editor = settings.edit();
	  editor.putBoolean(TURE_OR_FALSE, b);
	  // Commit the edits!
	  editor.commit();
	}
	
	public static boolean getBoolean(Context context){
		
	   SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	   boolean if_turn_on = settings.getBoolean(TURE_OR_FALSE, false);
	   
	   return if_turn_on;
	}
	
	public static void saveString(Context context,String string){
		
	    SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString(AD_TYPES, string);
		// Commit the edits!
		editor.commit();
	}
	
	public static String getString(Context context){
		
		   SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		   String string = settings.getString(AD_TYPES,"");
		   return string;
	}
}
