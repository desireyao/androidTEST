package com.yaoo.testandroid.o;

import java.util.Hashtable;

import android.util.Log;

/**
 * @author yaohui
 * @time 2016-3-14
 * @param 可以得到行号和方法名
 */

public class Logger {
	
	private static final String APPNAME = "yaoh";
	
	private final static boolean logFlag = true;
	public  final static String tag = "TAG";
	private final static int logLevel = Log.VERBOSE;
	private static String mClassName;
	private static Logger mylog;

	private Logger(String name) {
		mClassName = name;
	}

	private static Logger getLog() {

		if (mylog == null) {
			mylog = new Logger(APPNAME);
		}
		return mylog;
	}

	public static String getFunctionName() {

		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		if (sts == null) {
			return null;
		}
		
		for (StackTraceElement st : sts) {

			if (st.isNativeMethod()) {
				continue;
			}
			if (st.getClassName().equals(Thread.class.getName())) {
				continue;
			}
			
			if (st.getClassName().equals(mylog.getClass().getName())) {
				continue;
			}
			
			
			return mClassName + "[ " + Thread.currentThread().getName() + ": "
					+ st.getFileName() + ":" 
			        + st.getLineNumber() + " "
					+ st.getMethodName() + " ]";
		}
		return null;
	}
	
	public static void i(Object str) {
		
		getLog();
		
		if (logFlag) {
			if (logLevel <= Log.INFO) {
				String name = getFunctionName();
				if (name != null) {
					Log.i(tag, name + " - " + str);
				} else {
					Log.i(tag, str.toString());
				}
			}
		}
	}

	/**
	 * The Log Level:d
	 * 
	 * @param str
	 */
	public void d(Object str) {
		
		getLog();
		if (logFlag) {
			if (logLevel <= Log.DEBUG) {
				String name = getFunctionName();
				if (name != null) {
					Log.d(tag, name + " - " + str);
				} else {
					Log.d(tag, str.toString());
				}
			}
		}
	}

	/**
	 * The Log Level:V
	 * 
	 * @param str
	 */
	public void v(Object str) {
		
		getLog();
		
		if (logFlag) {
			if (logLevel <= Log.VERBOSE) {
				String name = getFunctionName();
				if (name != null) {
					Log.v(tag, name + " - " + str);
				} else {
					Log.v(tag, str.toString());
				}
			}
		}
	}

	/**
	 * The Log Level:w
	 * 
	 * @param str
	 */
	public void w(Object str) {
		
		getLog();
		
		if(logFlag){
			if(logLevel <= Log.WARN){
				String name = getFunctionName();
				if(name != null){
					Log.w(tag, name + " - " + str);
				}else{
					Log.w(tag, str.toString());
				}
			}
		}
	}

	/**
	 * The Log Level:e
	 * 
	 * @param str
	 */
	public void e(Object str) {
		if (logFlag) {
			if (logLevel <= Log.ERROR) {
				String name = getFunctionName();
				if (name != null) {
					Log.e(tag, name + " - " + str);
				} else {
					Log.e(tag, str.toString());
				}
			}
		}
	}

	/**
	 * The Log Level:e
	 * 
	 * @param ex
	 */
	public void e(Exception ex) {
		if (logFlag) {
			if (logLevel <= Log.ERROR) {
				Log.e(tag, "error", ex);
			}
		}
	}

	/**
	 * The Log Level:e
	 * 
	 * @param log
	 * @param tr
	 */
	public void e(String log, Throwable tr) {
		
		if (logFlag) {
			String line = getFunctionName();
			Log.e(tag, "{Thread:" + Thread.currentThread().getName() + "}" + "[" + mClassName + line + ":] " + log + "\n", tr);
		}
	}
}
