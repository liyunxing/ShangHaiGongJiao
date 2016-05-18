package com.shjt.map;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;

import org.json.JSONObject;

import com.shjt.map.utils.HttpHelper;
import com.shjt.map.utils.HttpCallback;
import com.shjt.map.utils.ToastUtils;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.*;

public class RealBusActivity extends BaseActivity {

	EditText lineEdit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_real_bus);
        
        setupViews();
    }
    
    private void setupViews() {
    	getView(R.id.search).setOnClickListener(this);
    	
    	lineEdit = getView(R.id.line_edit);
    	
    }
    
    public void onClick(int id) {
		switch (id) {
		case R.id.search:
			onSearch();
			break;
			
		}
    }
    
    private void onSearch() {
    	String line = lineEdit.getText().toString();
    	if (TextUtils.isEmpty(line)) {
    		ToastUtils.showToast(mContext, "请输入线路");
    		return;
    	}
    	
    	
    }
    
	public static void getLine(int src, String lineId) {

		String px_get_line = "http://61.129.57.96:8014/Project/Ver1/getLine.ashx";
		String pd_get_line = "http://114.80.178.10:8000/palmbus_service/PalmBusJgj/getLine.do";

		String date = getDateString();
		String my = getMD5String(ShJtMap.getPXMD5String() + date);

		// pu xi
		StringBuilder puXi = new StringBuilder(px_get_line);
		puXi.append("?lineid=" + lineId);
		puXi.append("&my=" + my);
		puXi.append("&t=" + date);

		// pu dong
		StringBuilder puDong = new StringBuilder(pd_get_line);
		try {
			puDong.append("?lineid=" + URLEncoder.encode(lineId, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		puDong.append("&my=" + getMD5String(ShJtMap.getPDMD5String() + date));
		puDong.append("&t=" + date);

		String url = puXi.toString();
		HttpHelper.getStringVolley(url, tag, new HttpCallback() {

			@Override
			public void onSuccess(String response) {
				
			}

			@Override
			public void onError() {
				
			}
			
		});
		
	}
    
    
    
    private static String getDateString() {
      Calendar calendar = Calendar.getInstance();
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = Integer.valueOf(calendar.get(Calendar.YEAR));
      arrayOfObject[1] = Integer.valueOf(1 + calendar.get(Calendar.MONTH));
      arrayOfObject[2] = Integer.valueOf(calendar.get(Calendar.DATE));
      arrayOfObject[3] = Integer.valueOf(calendar.get(Calendar.HOUR_OF_DAY));
      arrayOfObject[4] = Integer.valueOf(calendar.get(Calendar.MINUTE));
      return String.format("%04d-%02d-%02d%02d:%02d", arrayOfObject);
    }
    
    private static String getMD5String(String src) {
      return MD5Util.MD5(src);
    }
}
