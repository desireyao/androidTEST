package com.yaoo.testandroid.z3;

import java.util.HashMap;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;

public class MainActivityZ3 extends Activity {

	SparseArray<String> array = new SparseArray<String>();
	HashMap<String,String> maps = new HashMap<String, String>();
 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_z3);
		
//		array.put(1, "value");
//		Log.e("TAG", array.get(0));
//		Log.e("TAG", array.get(1));
//		Log.e("TAG", array.get(10));
//		maps.put("key", "value");
//		Log.e("TAG", maps.get("10"));
		Log.e("TAG", maps.get("kk") + "");
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_z3, menu);
		return true;
	}

}
