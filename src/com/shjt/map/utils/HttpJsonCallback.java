package com.shjt.map.utils;

import org.json.JSONObject;

public interface HttpJsonCallback {
	public void jsonParser(JSONObject json);

    public void onError();
    
//    public void onError(String msg);
}
