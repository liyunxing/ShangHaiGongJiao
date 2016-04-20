package com.shjt.map.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtils {
	
	public static void showToast(Context context, String text, int duration, int gravity, int xOffset, int yOffset) {
		if (TextUtils.isEmpty(text)) {
			return;
		}
		Toast toast = Toast.makeText(context, text, duration);
		if (gravity != -1) {
			toast.setGravity(gravity, xOffset, yOffset);
		}
		
		toast.show();
	}

	public static void showToast(Context context, int textId, int duration, int gravity, int xOffset, int yOffset) {
		String text = context.getResources().getString(textId);
		showToast(context, text, duration, gravity, xOffset, yOffset);
	}
	
	public static void showToast(Context context, String text) {
		showToastDefault(context, text, Toast.LENGTH_LONG);
	}
	
	public static void showToast(Context context, int textId) {
		showToastDefault(context, textId, Toast.LENGTH_LONG);
	}
	
	public static void showToast(Context context, int textId, int duration) {
		showToastDefault(context, textId, duration);
	}
	
	public static void showToastDefault(Context context, int textId, int duration) {
		showToast(context, textId, duration, -1, 0, 0);
	}
	
	public static void showToastDefault(Context context, String text, int duration) {
		showToast(context, text, duration, -1, 0, 0);
	}
	
	public static void showToastAtTop(Context context, int textId, int duration) {
		showToast(context, textId, duration, Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 0);
	}
	
	public static void showToastInCenter(Context context, int textId, int duration) {
		showToast(context, textId, duration, Gravity.CENTER, 0, 0);
	}
}


