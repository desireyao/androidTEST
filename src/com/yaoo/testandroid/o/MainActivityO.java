package com.yaoo.testandroid.o;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivityO extends Activity {

	public static final String TAG = "TAG";
	
//	private MyLogger logger = MyLogger.kLog();  
//    private MyLogger logger2 = MyLogger.jLog();  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_o);
		Logger.i("1");
		
	}
	
	public void testLog(View view){
		
		 // TODO Auto-generated method stub  
		
//		logger.i("This is log [01]"); 
//        logger.w("This is kesen log [02]");  
//        logger.v("This is kesen log [03]");  
//        logger.e("This is kesen log [04]");  
        
         Logger.i("2");
	}
}
