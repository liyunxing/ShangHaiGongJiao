package com.shjt.map;

import java.util.Map;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class AppContext extends Application {

	private static AppContext instance = null;

	@Override
	public void onCreate() {
		super.onCreate();
		setInstance(this);


	}

	
	@Override
	public void onLowMemory() {
		super.onLowMemory();

	}


	public static AppContext getInstance() {
		return instance;
	}

	public static void setInstance(AppContext instance) {
		AppContext.instance = instance;
	}



	private void debug() {
		long maxMemory = Runtime.getRuntime().maxMemory();
		// Log.e("", "------------ max memory = " +
		// Formatter.formatFileSize(this, maxMemory) + ", app memory = " +
		// Formatter.formatFileSize(this, maxMemory/8));

		// Log.e("", "------------ system info = " + new
		// SystemUtil().toString());
	}

}
