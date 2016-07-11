package com.yaoo.testandroid.g;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yaoo.testandroid.R;
import com.yaoo.testandroid.g.TimeService.NotifyCallBack;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivityG extends Activity implements NotifyCallBack{

	private TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_g);
		
		textView = (TextView) findViewById(R.id.tv_info);
		TimeService.callBack = this;
		TimeService.scheduleSend(this, 5000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_activity_g, menu);
		return true;
	}

	@Override
	public void onSuccess() {
		// TODO
		 String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		 String text = textView.getText().toString();
		 textView.setText(text + "\n" + time);
	}
}
