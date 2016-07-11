package com.yaoo.testandroid.m;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.m.utils.HttpUtil;
import com.yaoo.testandroid.m.utils.HttpUtil.HttpCallBack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityM extends Activity {

//	public static String  path = "http://cloud.bmob.cn/69e8d1710610fbd8/doPost"; 
	public static String  path = "http://172.16.4.200:8080/marketapi/submit"; 
	
	private Button btn;
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_m);
		init();
	}

	private void init() {
		// TODO
		btn = (Button) findViewById(R.id.button);
		tv = (TextView) findViewById(R.id.tv);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				doPost();
			}
		});
	}

	protected void doPost() {
		// TODO
		Map<String,Object> params = buildParams();
		HttpUtil.get().startHttpPost(path, params, new HttpCallBack() {
			
			@Override
			public void success(String result) {
				// TODO
				tv.setText(result);
			}
		});
	}

	private Map<String,Object> buildParams(){
		
		Map<String,Object> params = new HashMap<String,Object>();
		
		JSONObject jo = new JSONObject();
		try {
			jo.put("packagename","com.nduoa.nmarket");
			jo.put("channel","baidu");
			jo.put("mac","113.68.52.42");
			jo.put("versionCode","2016030815");
			jo.put("versionName","3.9.9.6");
			jo.put("imei","000000");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		params.put("request", jo.toString());
		return params;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_m, menu);
		return true;
	}
}
