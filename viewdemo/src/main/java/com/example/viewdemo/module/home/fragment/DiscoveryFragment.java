package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;

/**
 * Created by llbt on 2016/4/22.
 */
public class DiscoveryFragment extends BaseFragment{
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_discovery, null);
	}
}
