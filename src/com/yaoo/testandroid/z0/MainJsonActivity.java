package com.yaoo.testandroid.z0;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.json.Person;
import com.yaoo.testandroid.json.Role;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainJsonActivity extends Activity {

	private Button btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_json);
		
		init();  //yaoh
	}

	private void init() {
		// TODO
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				buildJsonArray();
				parseJsonArray();
			}
		});
	}
	
	private void test(){
		
		Person person = new Person();
		person.setName("yaohui1");
		person.setAge(26);
		
		List<Role> list = new ArrayList<Role>();
		for (int i = 0; i < 5; i++) {
			Role role = new Role();
			role.setJob("job" + i);
			role.setJob_address("address" + i);
			list.add(role);
		}
		person.setRolelist(list);
		String json = person.buildJson();
		
		System.out.println("json:" + json);
	}
	
	private String buildJsonArray(){
		
//		JSONArray ja = new JSONArray();
//		
//		for (int i = 0; i < 10; i++) {
//			
//			JSONObject jo = new JSONObject();
//			try {
//				jo.put("key", "value" + i);
//				ja.put(jo);
//			} catch (JSONException e) {
//				e.printStackTrace();
//			}
//		}
//		Log.e("TAG", ja.toString());
		
		JSONObject jo = new JSONObject();
		try {
			
			jo.put("key1",null);
			jo.putOpt("key2",null);
			
			jo.put("key3","");
			jo.putOpt("key4","");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.e("TAG", jo.toString());
		
		return jo.toString();
	}
	
	private void parseJsonArray(){
		
		try {
//			System.out.println("jsonArray: " + jsonArray.length());
//			String string = new JSONObject("{}").optString("yao");
//			String string = new JSONObject("{}").getString("yao");
			
//			JSONArray ja = new JSONObject("{\"yao\":[]}").optJSONArray("yao");
			JSONArray ja = new JSONArray("[{\"id\":3,\"userHead\":\"http://paonan580.com/uploads/user/z/Y/zYy9r9faaagq2L0S9ZlhLibEYEGrJTAN.jpg\",\"info\":{\"summary\":\"有需要录制语音、视频、主持的可以找我哦，欢迎发私活!~\"},\"userId\":6,\"imgWidth\":320,\"imgHeight\":400,\"fileImg\":\"http://paonan580.com/uploads/video/N/i/NiwOhcgbbvnP5GApOn9C9rpAiOpmqgQp.jpg\",\"filePath\":\"http://paonan580.com/uploads/video/b/h/bhwcZsHj6jZWPA3JoysI5rcF_WtTi60t.mp4\",\"playTimes\":20,\"concern\":1,\"collect\":1,\"createTime\":\"4天前\"},{\"id\":2,\"userHead\":\"http://paonan580.com/uploads/user/4/B/4BLWoKqkVST6Zm3aB9PxDnqzuVc5IodO.jpg\",\"info\":{\"summary\":\"有需要录制语音、视频、主持的可以找我哦，欢迎发私活!~\"},\"userId\":44,\"imgWidth\":320,\"imgHeight\":480,\"fileImg\":\"http://paonan580.com/uploads/video/N/i/NiwOhcgbbvnP5GApOn9C9rpAiOpmqgQp.jpg\",\"filePath\":\"http://paonan580.com/uploads/video/b/h/bhwcZsHj6jZWPA3JoysI5rcF_WtTi60t.mp4\",\"playTimes\":4,\"concern\":1,\"collect\":1,\"createTime\":\"4天前\"}]");
			Log.e("TAG", "String: " + ja.toString());   //此处返回的结果是""
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
