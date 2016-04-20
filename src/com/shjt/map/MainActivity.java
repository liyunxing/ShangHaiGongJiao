package com.shjt.map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends BaseActivity {



	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setupViews();
    }
    
    private void setupViews() {
    	getView(R.id.line_query).setOnClickListener(this);
    	getView(R.id.change_query).setOnClickListener(this);
    	getView(R.id.nearby_bus).setOnClickListener(this);
    	getView(R.id.real_bus).setOnClickListener(this);
    	getView(R.id.more).setOnClickListener(this);
    	
    }
    
    public void onClick(int id) {
		switch (id) {
		case R.id.line_query:
			
			break;
		case R.id.change_query:
			
			break;
		case R.id.nearby_bus:
			
			break;
		case R.id.real_bus:
			startActivity(new Intent(mContext, RealBusActivity.class));
			break;
		case R.id.more:
			
			break;
			
		}
	}
}
