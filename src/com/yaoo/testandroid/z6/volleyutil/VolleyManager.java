package com.yaoo.testandroid.z6.volleyutil;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyManager {
	
	private Context mContext;
	public static VolleyManager volleyManager;
	
	public static VolleyManager get(){
		
		if(volleyManager == null){
			synchronized (VolleyManager.class) {
				if(volleyManager == null){
					volleyManager = new VolleyManager();
				}
			}
		}
		return volleyManager;
	}
	
	
	public void doStringRequest(){
		
		RequestQueue mQueue = Volley.newRequestQueue(mContext);
		mQueue.add(buildRequest());
	}
	
	private StringRequest buildRequest(){
		
		StringRequest stringRequest = new StringRequest("http://www.baidu.com",  
                
				new Response.Listener<String>() {  
			        @Override  
                    public void onResponse(String response) { 
                        Log.d("TAG", response); 
                    }  
                }, 
                
                new Response.ErrorListener() {  
					@Override
					public void onErrorResponse(VolleyError error) {
						 Log.e("TAG", error.getMessage(), error); 
					}  
                });
       
           return stringRequest;
	}
	
    private void buildStringPostRequest(){
    	
    	StringRequest stringRequest = new StringRequest(Method.POST, "",  null, null) {  
    		
    	    @Override  
    	    protected Map<String, String> getParams(){  
    	    	
    	        Map<String, String> map = new HashMap<String, String>(); 
    	        
    	        map.put("params1", "value1");  
    	        map.put("params2", "value2");  
    	        
    	        return map;  
    	    }  
    	}; 
    }
    
    private JsonObjectRequest buildJsonPostRequest(){
    	
    	JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.POST, "", null, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
				// TODO Auto-generated method stub
				
			}
			
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				
			}
			
		});
    	return jsonObjectRequest;
    }

}
