package com.shjt.map;

import org.json.JSONObject;

import com.shjt.map.utils.HttpHelper;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BaseActivity extends Activity implements View.OnClickListener {
	public static String tag;
	protected Activity mContext = null;
	protected final boolean DEGUG = true;
	protected int resId = -1;

	TextView title;
	Button left;
	Button right;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		tag = this.getClass().getSimpleName();

//		PushAgent.getInstance(this).onAppStart();
	}

	@Override
	protected void onStart() {
		super.onStart();
		setupAppTitle();
	}

	@Override
	protected void onResume() {
		super.onResume();
		
//		Bugtags.onResume(this);
//		StatUtils.onStatActivityStart(this, resId);
	}

	@Override
	protected void onPause() {
		super.onPause();
		
//		Bugtags.onPause(this);
//		StatUtils.onStatActivityEnd(this, resId);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		HttpHelper.cancelRequest(tag);
	}

	private void setupAppTitle() {
		Intent intent = new Intent(this, getClass());
		ResolveInfo app = getPackageManager().resolveActivity(intent, 0);
		resId = app.activityInfo.labelRes;

		title = (TextView) findViewById(R.id.app_title);
		if (title != null) {title.setText(resId);}

		left = (Button) findViewById(R.id.left);
		if (left != null) {
			left.setVisibility(View.VISIBLE);
			left.setOnClickListener(this);
		}
		right = (Button) findViewById(R.id.right);
		if (right != null) {
			right.setOnClickListener(this);
		}
	}
	
	
	public static boolean isSuccess(int code) {
		return code == 100;
	}

	public static int getResultCode(JSONObject json) {
		if (json == null) {
			return -1;
		}
		return json.optInt("result_code");
	}
	
	public static String getResultMessage(JSONObject json) {
		if (json == null) {
			return "error";
		}
		return json.optString("result_message");
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		if (id == R.id.left) {
			finish();
			return;
		}
		onClick(id);
	}
	
	public void onClick(int id) {
		
	}
	
	public <T extends View> T getView(int viewId) {
		return getView(this, viewId);
	}
	
	public static <T extends View> T getView(Activity activity, int viewId) {
	    return (T)activity.findViewById(viewId);
	}
}
