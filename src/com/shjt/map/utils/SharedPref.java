package com.shjt.map.utils;


import com.shjt.map.AppContext;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

public final class SharedPref {
	
	public static SharedPreferences getPreferences() {
		return PreferenceManager.getDefaultSharedPreferences(AppContext.getInstance());
	}
	
	public static String getString(String key) {
		if (TextUtils.isEmpty(key)) {
			return "";
		}
		return getString(getPreferences(), key, "");
	}

	public static String getString(SharedPreferences sp, String key, String defValue) {
		if (TextUtils.isEmpty(key)) {
			return "";
		}
		if (sp == null) {sp = getPreferences();}
		return sp.getString(key, defValue);
	}
	
	public static void setString(String key, String value) {
		setString(getPreferences(), key, value);
	}
	
	public static void setString(SharedPreferences sp, String key, String value) {
		if (TextUtils.isEmpty(key)) {
			return;
		}
		if (sp == null) {sp = getPreferences();}
		SharedPreferences.Editor editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	public static int getInt(String key) {
		if (TextUtils.isEmpty(key)) {
			return -1;
		}
		return getInt(key, -1);
	}

	public static int getInt(String key, int defValue) {
		if (TextUtils.isEmpty(key)) {
			return -1;
		}
		SharedPreferences sp = getPreferences();
		return sp.getInt(key, defValue);
	}
	
	public static void setInt(String key, int value) {
		if (TextUtils.isEmpty(key)) {
			return;
		}
		SharedPreferences.Editor editor = getPreferences().edit();
		editor.putInt(key, value);
		editor.commit();
	}
	
	public static boolean getBoolean(String key) {
		if (TextUtils.isEmpty(key)) {
			return false;
		}
		return getBoolean(key, false);
	}

	public static boolean getBoolean(String key, boolean defValue) {
		if (TextUtils.isEmpty(key)) {
			return false;
		}
		SharedPreferences sp = getPreferences();
		return sp.getBoolean(key, defValue);
	}
	
	public static void setBoolean(String key, boolean value) {
		if (TextUtils.isEmpty(key)) {
			return;
		}
		SharedPreferences.Editor editor = getPreferences().edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
}
