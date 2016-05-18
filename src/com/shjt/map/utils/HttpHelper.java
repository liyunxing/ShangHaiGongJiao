package com.shjt.map.utils;

import java.io.File;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.shjt.map.AppContext;
import com.shjt.map.BuildConfig;


public class HttpHelper {

	private static RequestQueue  requestQueue = Volley.newRequestQueue(AppContext.getInstance());

	private final static int TIME_OUT_SECONDS = 20 * 1000;
	private final static int RETRY_MAX_TIMES = 3;

    public static void getJSONByVolley(String url, final String tag, final HttpCallback callback) {
    	if (TextUtils.isEmpty(url) || callback == null) {
    		Log.e("getJSONByVolley", "----------- param error");
    		return;
    	}
    	Log.e(tag, "--- get --- url = " + url);
    	if (!isNetworkConnected(AppContext.getInstance())) {
    		ToastUtils.showToast(AppContext.getInstance(), "未联网，请联网后再试");
    		
    		return;
    	}
    	
        final JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                    	if (BuildConfig.DEBUG) {
                    		Log.e(tag, "----get---- response json = "
                    				+ (response == null ? "null" : response.toString()));
                    	}


                        callback.onSuccess(response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    	Log.e(tag, "---------- Volley Error = " + error.toString());
                    	ToastUtils.showToast(AppContext.getInstance(), "出错了 : " + error.getMessage());
                    	
                        callback.onError();
                    }
                });
        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT_SECONDS, RETRY_MAX_TIMES, 1.0f));
        if (!TextUtils.isEmpty(tag)) {
            jsonRequest.setTag(tag);
        } 
        requestQueue.add(jsonRequest);
    }
    
    public static void getStringVolley(String url, final String tag, final HttpCallback callback) {
    	if (TextUtils.isEmpty(url) || callback == null) {
    		Log.e("getJSONByVolley", "----------- param error");
    		return;
    	}
    	Log.e(tag, "--- get --- url = " + url);
    	if (!isNetworkConnected(AppContext.getInstance())) {
    		ToastUtils.showToast(AppContext.getInstance(), "未联网，请联网后再试");
    		
    		return;
    	}
    	
        final StringRequest jsonRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    	if (BuildConfig.DEBUG) {
                    		Log.e(tag, "----get---- response json = "
                    				+ (response == null ? "null" : response.toString()));
                    	}

                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    	Log.e(tag, "---------- Volley Error = " + error.getMessage());
                    	ToastUtils.showToast(AppContext.getInstance(), "出错了 : " + error.getMessage());
                    	
                        callback.onError();
                    }
                });
        jsonRequest.setRetryPolicy(new DefaultRetryPolicy(TIME_OUT_SECONDS, RETRY_MAX_TIMES, 1.0f));
        if (!TextUtils.isEmpty(tag)) {
            jsonRequest.setTag(tag);
        } 
        requestQueue.add(jsonRequest);
    }

    public static void cancelRequest(String tag) {
    	if (TextUtils.isEmpty(tag)) {
    		return;
    	}
    	requestQueue.cancelAll(tag);
    }
    
 
	public static boolean isNetworkConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm != null) {
			NetworkInfo info = cm.getActiveNetworkInfo();
			if (info != null) {
				return true;
			}
		}
		return false;
	}
}
