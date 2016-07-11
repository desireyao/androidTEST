package com.yaoo.testandroid.z1;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;

public class MainActivityZ1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_z1);
		
		float xdpi = getResources().getDisplayMetrics().xdpi;
	    float ydpi = getResources().getDisplayMetrics().ydpi;
	        
	    Log.e("TAG", "xdpi: " + xdpi + " ydpi: " + ydpi);   
	        
	    DisplayMetrics dm =  getResources().getDisplayMetrics();
	    Log.e("TAG", dm.density + " ; " + dm.densityDpi);
	}

}
