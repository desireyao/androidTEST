package com.yaoo.testandroid.z5.view;

import com.yaoh.utils.Logger;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MyRelativeLayout extends RelativeLayout{

	public MyRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.dispatchTouchEvent(ev);
	}
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		
		Logger.e("onInterceptTouchEvent");
		if(ev.getAction() ==  MotionEvent.ACTION_MOVE){
			return true;
		}
		return super.onInterceptTouchEvent(ev);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		Logger.e("onTouchEvent");
		return super.onTouchEvent(event);
	}

}
