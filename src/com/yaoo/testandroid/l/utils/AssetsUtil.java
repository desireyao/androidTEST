package com.yaoo.testandroid.l.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;

/**
 * @author yaohui
 * @time   2016-3-7
 * @param  
 */
public class AssetsUtil {
	
    public static String getFile4Assets(Context context,String assetPath) {                    

    	String result = "";
    	try {
			InputStream is = context.getAssets().open(assetPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8")); 
            String line = null;
            while((line = reader.readLine()) != null){
                 result += line;
            }
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return result;
    }                             
}
