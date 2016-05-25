package com.example.viewdemo.module.home.data;

import android.os.Bundle;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseActivity;

/**
 * Created by Hexcuse on 2016/5/25.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class HeroActivity extends BaseActivity {

	private TextView tv_band_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hero);
		initView();
	}

	private void initView(){
		setBandTitle(R.string.hero);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
