package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

/**
 * Created by llbt on 2016/4/22.
 */
public class DataFragment extends BaseFragment{

	private View contentView;
	private PtrFrameLayout mPtrFrameLayout;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		contentView = inflater.inflate(R.layout.fragment_data, null);
		initView();
		setListener();
		return contentView;
	}

	private void initView(){
		tv_band.setText(getString(R.string.game_finish));
		mPtrFrameLayout = (PtrFrameLayout)contentView.findViewById(R.id.ptrframe);
		mPtrFrameLayout.setResistance(1.7f);
		// the following are default settings
		mPtrFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);
		mPtrFrameLayout.setDurationToClose(200);
		mPtrFrameLayout.setDurationToCloseHeader(1000);
        // default is false
		mPtrFrameLayout.setPullToRefresh(true);
        // default is true
		mPtrFrameLayout.setKeepHeaderWhenRefresh(true);
		final StoreHouseHeader header = new StoreHouseHeader(getContext());
		header.setPadding(0, 15, 0, 0);
	}

	private void setListener(){
		mPtrFrameLayout.setPtrHandler(new PtrHandler() {
			@Override
			public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
				return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
			}

			@Override
			public void onRefreshBegin(PtrFrameLayout frame) {
				frame.postDelayed(new Runnable() {
					@Override
					public void run() {
						mPtrFrameLayout.refreshComplete();
						Log.i("mPtrFrameLayout====", "mPtrFrameLayout");
					}
				}, 1800);
			}
		});
	}

}
