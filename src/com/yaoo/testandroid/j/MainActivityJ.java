package com.yaoo.testandroid.j;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.j.aidl.IRemoteService;
import com.yaoo.testandroid.j.services.DDService;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivityJ extends Activity {

	private IRemoteService remoteService;
	
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_j);
		
		init();
	}
	
	private void init() {
		// TODO
		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivityJ.this,DDService.class);
				bindService(intent,conn,BIND_AUTO_CREATE);
			}
		});
	}

	ServiceConnection conn = new ServiceConnection() {
        
        @Override
        public void onServiceDisconnected(ComponentName name) {
        	
        }
         
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
        	
            remoteService = IRemoteService.Stub.asInterface(service);
            
            try {
                int pid = remoteService.getPid();
                int currentPid = android.os.Process.myPid();
                
                System.out.println("currentPID: " + currentPid + "  remotePID: " + pid);
                remoteService.basicTypes(12, 1223, true, 12.2f, 12.3, "我们的爱，我明白");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("bind success! " + remoteService.toString());
        }
    };
}
