package com.shjt.map;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class RealBusActivity extends BaseActivity {

	Button search;
	EditText lineEdit;
	
	
	ListView tipListView;
	
	View favourPanel;
	ListView favourListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_real_bus);
		
		setupViews();
		
	}
	
	private void setupViews() {
		search = getView(R.id.search);
		search.setOnClickListener(this);
		lineEdit = getView(R.id.line_edit);
		
		tipListView = getView(R.id.auto_tips_list);
		
		
	}
}
