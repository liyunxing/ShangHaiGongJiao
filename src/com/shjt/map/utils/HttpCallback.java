package com.shjt.map.utils;

import org.json.JSONObject;

public interface HttpCallback {
	public void onSuccess(String json);

    public void onError();
    
//    public void onError(String msg);
}
