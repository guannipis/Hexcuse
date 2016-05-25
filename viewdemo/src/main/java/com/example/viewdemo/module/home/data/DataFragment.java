package com.example.viewdemo.module.home.data;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;
import com.example.viewdemo.common.bean.DataListViewBean;

import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by llbt on 2016/4/22.
 */
public class DataFragment extends BaseFragment implements View.OnClickListener, DataContract.View, AdapterView.OnItemClickListener {

	private View contentView;
	private PtrFrameLayout mPtrFrameLayout;
	private LinearLayout ll_hero;
	private LinearLayout ll_rank;
	private LinearLayout ll_item;
	private LinearLayout ll_ladder;
	private LinearLayout ll_data;
	private LinearLayout ll_league;
	private ListView data_lv;
	private DataLvAdapter mDataLvAdapter;

	private DataContract.Presenter mPresenter;

	public static DataFragment newInstance(){
		return new DataFragment();
	}

	public DataFragment(){

	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		contentView = inflater.inflate(R.layout.fragment_data, null);
		initView();
		setListener();
		return contentView;
	}

	@Override
	public void onResume() {
		super.onResume();
		mPresenter.start();
	}

	@Override
	public void setPresenter(DataContract.Presenter presenter) {
		this.mPresenter = presenter;
	}

	private void initView() {
		mPtrFrameLayout = (PtrFrameLayout) contentView.findViewById(R.id.ptrframe);
		ll_hero = (LinearLayout) contentView.findViewById(R.id.ll_hero);
		ll_rank = (LinearLayout) contentView.findViewById(R.id.ll_rank);
		ll_item = (LinearLayout) contentView.findViewById(R.id.ll_item);
		ll_ladder = (LinearLayout) contentView.findViewById(R.id.ll_ladder);
		ll_data = (LinearLayout) contentView.findViewById(R.id.ll_data);
		ll_league = (LinearLayout) contentView.findViewById(R.id.ll_league);
		data_lv = (ListView) contentView.findViewById(R.id.data_lv);
		initPtr();
	}

	private void initPtr(){
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

//		getData();
//		data_lv.setEmptyView(R.id.tv_empty);
	}

	private void setListener() {
		mPtrFrameLayout.setPtrHandler(this);

		ll_hero.setOnClickListener(this);
		ll_league.setOnClickListener(this);
		ll_data.setOnClickListener(this);
		ll_ladder.setOnClickListener(this);
		ll_rank.setOnClickListener(this);
		ll_item.setOnClickListener(this);

		data_lv.setOnItemClickListener(this);
	}

	@Override
	public void onRefreshBegin(final PtrFrameLayout frame) {
//
		this.mPtrFrameLayout = frame;
		if(mDataLvAdapter == null){
			mPresenter.refreshListView();
		}else {
			mPresenter.refreshListView();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.ll_hero:
				toActivity(new HeroActivity());
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


	@Override
	public void showListView(List<DataListViewBean.ResultBean.ActivityListBean> activityList) {
		mDataLvAdapter = new DataLvAdapter(getActivity().getApplicationContext());
		mDataLvAdapter.addList(activityList);
		data_lv.setAdapter(mDataLvAdapter);
	}

	@Override
	public void showError(String error) {

	}

	@Override
	public void refreshComplete() {
		mPtrFrameLayout.refreshComplete();
	}

	@Override
	public void toActivity(Activity activity) {
		startActivity(new Intent(getActivity(), activity.getClass()));
	}


	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
		mPresenter.onItemClick(i);
	}
}
