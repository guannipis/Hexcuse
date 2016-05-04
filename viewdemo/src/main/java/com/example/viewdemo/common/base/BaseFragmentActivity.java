package com.example.viewdemo.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.example.viewdemo.R;

/**
 * Created by llbt on 2016/4/22.
 * FragmentActivity的基类
 */
public class BaseFragmentActivity extends FragmentActivity{

	private TextView tv_band;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		ActivityCollector.addActivity(this);
	}

	protected void intiBand(){
		tv_band = (TextView)findViewById(R.id.tv_band_title);
	}

	protected void setBandTitle(int id){
		tv_band.setText(id);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
//		ActivityCollector.removeActivity(this);
	}
}
