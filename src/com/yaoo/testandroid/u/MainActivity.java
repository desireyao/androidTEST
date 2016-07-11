package com.yaoo.testandroid.u;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		getPixel();
		getProcessors();
	}

	private void getPixel() {
		// TODO
		DisplayMetrics dm = new DisplayMetrics();  
        getWindowManager().getDefaultDisplay().getMetrics(dm);  
        
        float width =  dm.widthPixels;   
        float height = dm.heightPixels; 
        System.out.println("width:" + width + ";height:" + height);
        
        float density = dm.density;   
        System.out.println("density:" + density);
	}
	
	private void getProcessors(){
		
		int count = Runtime.getRuntime().availableProcessors();
		System.out.println("count:" + count);
	}
}
