package com.example.viewdemo.module.home.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;

/**
 * Created by llbt on 2016/4/22.
 */
public class MeFragment extends BaseFragment{

	private TextView tv_band_title;
	private View contentView;

	public static MeFragment newInstance(){
		return new MeFragment();
	}

	public MeFragment(){

	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		contentView = inflater.inflate(R.layout.fragment_me, null);
		initView();
		return contentView;
	}

	private void initView(){
		tv_band_title = (TextView)contentView.findViewById(R.id.tv_band_title);
		tv_band_title.setText(R.string.my_account);
	}

	@Override
	public void onResume() {
		super.onResume();
	}
}
