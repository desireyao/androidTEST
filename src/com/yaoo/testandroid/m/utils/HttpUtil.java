package com.yaoo.testandroid.m.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import android.os.Handler;
import android.os.Looper;

/**
 * @author yaohui
 * @time   2016-3-8
 * @param 
 */
public class HttpUtil {
	
	Handler handler = new Handler(Looper.getMainLooper());
	
	public static HttpUtil httpUtil;
	public static HttpUtil get(){
		
		if(httpUtil == null){
			synchronized (HttpUtil.class) {
				if(httpUtil == null){
					httpUtil = new HttpUtil();
				} 
			}
		}
		return httpUtil;
	}
	
	/**
     * 通过HttpURLConnection模拟post表单提交
     * @param path
     * @param params 例如"name=zhangsan&age=21"
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	public static String sendPostRequestByForm(String path, Map<String,Object> requestParamsMap) throws Exception{
    	
    	PrintWriter printWriter = null; 
        StringBuffer params = new StringBuffer();  
        
         // 组织请求参数  
         Iterator it = requestParamsMap.entrySet().iterator();  
         while (it.hasNext()) {  
             Map.Entry element = (Map.Entry) it.next();  
             params.append(element.getKey());  
             params.append("=");  
             params.append(element.getValue());  
             params.append("&");  
         }  
         
        if (params.length() > 0) {  
             params.deleteCharAt(params.length() - 1);  
        }   
    	 
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");          // 提交模式
        conn.setConnectTimeout(5000);           //连接超时 单位毫秒
        conn.setReadTimeout(2000);              //读取超时 单位毫秒
        conn.setDoOutput(true);                 // 是否输入参数
        
        printWriter = new PrintWriter(conn.getOutputStream());  
        // 发送请求参数  
        printWriter.write(params.toString());  
        printWriter.flush();  
        if(conn.getResponseCode() == 200){
           InputStream inStream = conn.getInputStream();
           return readInputStream(inStream);
        }else{
        	return null;
        }
    }
   
        /**
         * 从输入流中读取数据
         * @param inStream
         * @return
         * @throws Exception
         */
     public static String readInputStream(InputStream inStream) throws Exception{
        	
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while((len = inStream.read(buffer)) !=-1 ){
                outStream.write(buffer, 0, len);
            }
            String data = outStream.toString();//网页的二进制数据
            outStream.close();
            inStream.close();
            return data;
        }
        
        class Executor implements Runnable{

        	private String path;
        	private Map<String,Object> params;
        	
			public Executor(String path, Map<String,Object> params) {
				super();
				this.path = path;
				this.params = params;
			}

			@Override
			public void run() {
			   synchronized (Executor.class) {
				 try{
					final String result = sendPostRequestByForm(path,params);
					successNotify(result);
				 }catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
           }

		private void successNotify(final String result) {
				
				handler.post(new Runnable() {
					@Override
					public void run() {
						httpCallBack.success(result);
					}
				});
			}
        }
        
        private HttpCallBack httpCallBack;
        
        public interface HttpCallBack{
        	public void success(String result);
        }
        
        
        public void startHttpPost(String path,Map<String,Object> params,HttpCallBack httpCallBack){
        	
        	this.httpCallBack = httpCallBack;
        	new Thread(new Executor(path, params)).start();
        }	
}
