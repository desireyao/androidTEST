package com.yaoo.testandroid.json;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author yaohui
 * @time   2016-1-21
 * @param 
 */
public class Person {
	
	private String name;
	private int age;
	private List<Role> rolelist;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public List<Role> getRolelist() {
		return rolelist;
	}
	public void setRolelist(List<Role> rolelist) {
		this.rolelist = rolelist;
	}
	
	
	public String buildJson(){
	   
		JSONObject jo = new JSONObject();
		JSONObject jo_person = new JSONObject();
		try {
			jo_person.putOpt("name",getName());
			jo_person.putOpt("age",getAge());
			
			JSONArray ja = new JSONArray();
			for (int i = 0; i < rolelist.size(); i++) {
				JSONObject jo_rolelist = new JSONObject();
				jo_rolelist.putOpt("job", rolelist.get(i).getJob());
				jo_rolelist.putOpt("job_address", rolelist.get(i).getJob_address());
				ja.put(jo_rolelist);
			}
			jo_person.putOpt("rolelist",ja);
			jo.putOpt("person",jo_person);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jo.toString();
	}
}
