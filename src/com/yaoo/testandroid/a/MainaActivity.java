package com.yaoo.testandroid.a;

import java.io.UnsupportedEncodingException;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maina);
		
		String string = "ABC我是姚晖";
		
		try {
			String str = new String(string.getBytes(),"GBK");
			String str1 = new String(str.getBytes("GBK"));
			System.out.println("str1:" + str1);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
