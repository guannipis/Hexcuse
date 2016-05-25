package com.example.viewdemo.common.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.viewdemo.R;

/**
 * Created by llbt on 2016/4/22.
 * Activity的基类
 */
public class BaseActivity extends Activity{

	private TextView tv_band;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityCollector.getInstance().addActivity(this);
	}

	protected void setBandTitle(int id){
		tv_band = (TextView)findViewById(R.id.tv_band_title);
		tv_band.setText(id);
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.getInstance().removeActivity(this);
	}

}
