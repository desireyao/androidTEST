package com.yaoh.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

/**
 * @author yaohui
 * @time 2016-3-14
 * @param 可以得到行号和方法名
 * @param 保存服务器上下发的数据
 */

public class Logger {
	
	private static final String ERROR = "error";

	private static final String APPNAME = "NdooSdkCore";
	
	private final static boolean logFlag = true;
	public  final static String tag = "TAG";
	private final static int logLevel = Log.VERBOSE;
	private static String mClassName;
	private static Logger mylog;
	
	public static final boolean WRITE_DATA_TOFILE = true;
	
	/**
	 * LOG路径, 把一些必要的信息写到文件里, 方便调试查看
	 */
	public final static String LOG_PATH = Environment.getExternalStorageDirectory().getPath()
			+ File.separator
			+ "SDKLOG"
			+ File.separator;

	/**
	 * 记录c<->s通信数据的文件全名, 并不总是记录到文件.
	 */
	public final static String LOG_DATA = LOG_PATH + "log.txt";
	

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
			
//			return mClassName + "[ " + Thread.currentThread().getName() + ": "
//					+ st.getFileName() + ":" 
//			        + st.getLineNumber() + " "
//					+ st.getMethodName() + " ]";
			
			return new StringBuffer()
			           .append(mClassName)
			           .append("[ ")
			           .append(Thread.currentThread().getName())
			           .append(": ")
					   .append(st.getFileName())
					   .append(":")
					   .append(st.getLineNumber())
					   .append(" ")
					   .append(st.getMethodName())
					   .append(" ]")
					   .toString();
		}
		return null;
	}
	
	public static void i(Object str) {
		
		getLog();
		
		if (logFlag) {
			if (logLevel <= Log.INFO) {
				String name = getFunctionName();
				if (name != null) {
//					Log.i(tag, name + " - " + str);
					Log.i(tag, new StringBuffer().append(name).append(" - ").append(str).toString());
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
	public static void d(Object str) {
		
		getLog();
		if (logFlag) {
			if (logLevel <= Log.DEBUG) {
				String name = getFunctionName();
				if (name != null) {
					Log.d(tag, new StringBuffer().append(name).append(" - ").append(str).toString());
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
	public static void v(Object str) {
		
		getLog();
		if (logFlag) {
			if (logLevel <= Log.VERBOSE) {
				String name = getFunctionName();
				if (name != null) {
					Log.v(tag, new StringBuffer().append(name).append(" - ").append(str).toString());
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
	public static void w(Object str) {
		
		getLog();
		if(logFlag){
			if(logLevel <= Log.WARN){
				String name = getFunctionName();
				if(name != null){
					Log.w(tag, new StringBuffer().append(name).append(" - ").append(str).toString());
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
	public static void e(Object str) {
		
		getLog();
		if (logFlag) {
			if (logLevel <= Log.ERROR) {
				String name = getFunctionName();
				if (name != null) {
					Log.e(tag, new StringBuffer().append(name).append(" - ").append(str).toString());
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
		
		getLog();
		if (logFlag) {
			if (logLevel <= Log.ERROR) {
				Log.e(tag, ERROR, ex);
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
		
		getLog();
		if (logFlag) {
			String line = getFunctionName();
//			Log.e(tag, "{Thread:" + Thread.currentThread().getName() + "}" + "[" + mClassName + line + ":] " + log + "\n", tr);
			Log.e(tag, new StringBuffer().append("{Thread:")
					.append(Thread.currentThread().getName())
					.append("}").append("[").append( mClassName).append(line)
					.append(":] ").append(log).append("\n").toString(), tr);
			
		}
	}
	
	/*
	 * 把向服务器发出的数据和服务器返回的数据写到文件中
	 */
	public static void writeDataToFile(String sendMsg, String responseMsg) {
		
		if (Logger.WRITE_DATA_TOFILE) {
			
			synchronized (Logger.class) {
				OutputStream os = null;
				try {
					
					StringBuffer data = new StringBuffer();
					// 时间
					data.append(new Date());
					data.append("\r\n\n\n");

					// 请求的数据
					data.append(sendMsg);
					data.append("\r\n\n\n");

					// 响应的数据
					data.append(responseMsg);
					data.append("\r\n\n\n");

					File saveFile = new File(LOG_PATH);
					if (!saveFile.exists()) {
						saveFile.mkdirs();
					}
					os = new FileOutputStream(LOG_DATA, true);
					os.write(data.toString().getBytes("utf-8"));
					
				} catch (Exception e) {
					  Logger.v(e.getMessage());
				} finally {
					if (null != os) {
						try {
							os.close();
						} catch (IOException e) {
							e.printStackTrace();
							// ignore exception
						}
				    }
			    }
			}
		}
	}
	
	
}
