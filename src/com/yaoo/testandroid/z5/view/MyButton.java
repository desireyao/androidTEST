package com.yaoo.testandroid.z5.view;

import com.yaoh.utils.Logger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

public class MyButton extends Button{

	public MyButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Logger.e("onTouchEvent: " + "MyButton");
		return super.onTouchEvent(event);
	}

}
