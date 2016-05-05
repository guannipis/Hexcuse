package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by llbt on 2016/4/22.
 */
public class DataFragment extends BaseFragment implements View.OnClickListener{

	private View contentView;
	private PtrFrameLayout mPtrFrameLayout;
	private LinearLayout ll_hero;
	private LinearLayout ll_rank;
	private LinearLayout ll_item;
	private LinearLayout ll_ladder;
	private LinearLayout ll_data;
	private LinearLayout ll_league;

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
		ll_hero = (LinearLayout)contentView.findViewById(R.id.ll_hero);
		ll_rank = (LinearLayout)contentView.findViewById(R.id.ll_rank);
		ll_item = (LinearLayout)contentView.findViewById(R.id.ll_item);
		ll_ladder = (LinearLayout)contentView.findViewById(R.id.ll_ladder);
		ll_data = (LinearLayout)contentView.findViewById(R.id.ll_data);
		ll_league = (LinearLayout)contentView.findViewById(R.id.ll_league);

		mPtrFrameLayout.setResistance(1.7f);
		// the following are default settings
		mPtrFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);
		mPtrFrameLayout.setDurationToClose(200);
		mPtrFrameLayout.setDurationToCloseHeader(1000);
        // default is false
		mPtrFrameLayout.setPullToRefresh(true);
        // default is true
		mPtrFrameLayout.setKeepHeaderWhenRefresh(true);

//		mPtrFrameLayout.autoRefresh();
//		final StoreHouseHeader header = new StoreHouseHeader(getContext());
//		header.setPadding(0, PtrLocalDisplay.designedDP2px(15), 0, 0);
	}

	private void setListener(){
		mPtrFrameLayout.setPtrHandler(this);

		ll_hero.setOnClickListener(this);
		ll_league.setOnClickListener(this);
		ll_data.setOnClickListener(this);
		ll_ladder.setOnClickListener(this);
		ll_rank.setOnClickListener(this);
		ll_item.setOnClickListener(this);
	}

	@Override
	public void onRefreshBegin(final PtrFrameLayout frame) {
		frame.postDelayed(new Runnable() {
			@Override
			public void run() {
				Log.i("auto====","auto");
				frame.refreshComplete();
			}
		}, 1800);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.ll_hero:
				break;
			case R.id.ll_rank:
				break;
			case R.id.ll_ladder:
				break;
			case R.id.ll_item:
				break;
			case R.id.ll_data:
				break;
			case R.id.ll_league:
				break;
		}
	}
}
