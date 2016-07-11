package com.yaoo.testandroid.v;

import java.util.List;

import com.yaoo.testandroid.R;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;

public class GetLocalCoord extends Activity {

	private double latitude = 0.0;
	private double longitude = 0.0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getTitude();
	}

	void getTitude() {

		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		List<String> list = locationManager.getAllProviders();
		Log.e("TAG","list: " +  list);
		
		if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			
			Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if (location != null) { 
				latitude = location.getLatitude();
				longitude = location.getLongitude();
				Log.e("TAG","GPS_PROVIDER: latitude: " + latitude + " longitude: " + longitude);
			} else {
				
				locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 0,locationListener);
				Location _location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				if (_location != null) {
					latitude = _location.getLatitude(); // 经度
					longitude = _location.getLongitude(); // 纬度
					Log.e("TAG","NETWORK_PROVIDER : latitude: " + latitude + " longitude: " + longitude);
				}
			}
		}
	}
	
	LocationListener locationListener = new LocationListener() {
		
		@Override
		public void onStatusChanged(String provider, int status,Bundle extras) {

		 }
			// Provider被enable时触发此函数，比如GPS被打开
			@Override
			public void onProviderEnabled(String provider) {

			}

			// Provider被disable时触发此函数，比如GPS被关闭
			@Override
			public void onProviderDisabled(String provider) {

			}

			// 当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
			@Override
			public void onLocationChanged(Location location) {
				
				if (location != null) {
					
					Log.e("TAG","Location changed : Lat: " + location.getLatitude() 
							+ " Lng: " + location.getLongitude());
					
				    latitude = location.getLatitude();       // 经度
					longitude = location.getLongitude();     // 纬度
				}
			}
		};
}
