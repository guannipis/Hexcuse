package com.example.viewdemo.module.home.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;

/**
 * Created by llbt on 2016/4/22.
 */
public class MeFragment extends BaseFragment{

	private Toolbar mToolbar;

	public static MeFragment newInstance(){
		return new MeFragment();
	}

	public MeFragment(){

	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view  = inflater.inflate(R.layout.fragment_me, null);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
	}
}
