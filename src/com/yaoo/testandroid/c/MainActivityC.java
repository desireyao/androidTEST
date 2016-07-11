package com.yaoo.testandroid.c;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.R.layout;
import com.yaoo.testandroid.R.menu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivityC extends Activity {

	private final Timer timer = new Timer();
	
	private TimerTask task = new TimerTask() {  
		
	    @Override  
	    public void run() {  
	        // TODO Auto-generated method stub  
	        Message message = new Message();  
	        message.what = 1;  
	        handler.sendMessage(message);  
	    }  
	}; ; 
	
	Handler handler = new Handler(Looper.getMainLooper()) {
		
	    @Override  
	    public void handleMessage(Message msg) {  
	        // TODO Auto-generated method stub  
	        // 要做的事情  
	        super.handleMessage(msg);  
	        Toast.makeText(getApplicationContext(), "handleMessage",Toast.LENGTH_SHORT).show();
	    }  
	}; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_c);
//		timer.schedule(task,1000,10000); 
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);    
	    executor.scheduleWithFixedDelay(    
	            new EchoServer(),    
	            0,    
	            10 * 1000,    
	            TimeUnit.MILLISECONDS);    
		
	}
	
	class EchoServer implements Runnable{

		@Override
		public void run() {
			// TODO
			System.out.println("EchoServer");
		}
	}
}
