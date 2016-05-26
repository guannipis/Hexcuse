package com.example.viewdemo.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by llbt on 2016/4/22.
 * Fragment的基类
 */
public class BaseFragment extends Fragment implements PtrHandler{

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}


	@Override
	public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
		return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
	}

	@Override
	public void onRefreshBegin(PtrFrameLayout frame) {

	}

}
