package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view  = inflater.inflate(R.layout.fragment_me, null);
		mToolbar = (Toolbar)view.findViewById(R.id.fl_toolbar);
		return view;
	}
}
