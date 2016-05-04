package com.example.viewdemo.common.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.viewdemo.R;

/**
 * Created by llbt on 2016/4/22.
 * Activity的基类
 */
public class BaseActivity extends AppCompatActivity{

	private TextView tv_band;

	@Override
	public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
		super.onCreate(savedInstanceState, persistentState);
		ActivityCollector.addActivity(this);
	}

	protected void setBandTitle(int id){
		tv_band = (TextView)findViewById(R.id.tv_band_title);
		tv_band.setText(id);
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}

}
