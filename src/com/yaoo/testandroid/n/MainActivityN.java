package com.yaoo.testandroid.n;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;
import com.yaoo.testandroid.n.utils.SharedPreferenceUtil;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class MainActivityN extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_n);
		
//		SharedPreferenceUtil.saveBoolean(this, true);
//		boolean if_turn_on = SharedPreferenceUtil.getBoolean(this);
//		Toast.makeText(getApplicationContext(), "if_turn_on:" + if_turn_on, Toast.LENGTH_SHORT).show();
		
//		SharedPreferenceUtil.saveString(this,"yaoh");
		String result = SharedPreferenceUtil.getString(this);
		Log.e("TAG","result: " + (result.equals("")) + " " + null);
	}
}
