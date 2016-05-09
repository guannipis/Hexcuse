package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;
import com.example.viewdemo.common.bean.Constants;
import com.example.viewdemo.common.bean.DataListViewBean;
import com.example.viewdemo.module.home.adapter.DataLvAdapter;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by llbt on 2016/4/22.
 */
public class DataFragment extends BaseFragment implements View.OnClickListener {

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
	private List<DataListViewBean.ResultBean.ActivityListBean> activityList;
	private DataListViewBean.ResultBean.ActivityListBean mActivityListBean;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		contentView = inflater.inflate(R.layout.fragment_data, null);
		initView();
		setListener();
		return contentView;
	}

	private void initView() {
		tv_band.setText(getString(R.string.game_finish));
		mPtrFrameLayout = (PtrFrameLayout) contentView.findViewById(R.id.ptrframe);
		ll_hero = (LinearLayout) contentView.findViewById(R.id.ll_hero);
		ll_rank = (LinearLayout) contentView.findViewById(R.id.ll_rank);
		ll_item = (LinearLayout) contentView.findViewById(R.id.ll_item);
		ll_ladder = (LinearLayout) contentView.findViewById(R.id.ll_ladder);
		ll_data = (LinearLayout) contentView.findViewById(R.id.ll_data);
		ll_league = (LinearLayout) contentView.findViewById(R.id.ll_league);
		data_lv = (ListView) contentView.findViewById(R.id.data_lv);

		mPtrFrameLayout.setResistance(1.7f);
		// the following are default settings
		mPtrFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);
		mPtrFrameLayout.setDurationToClose(200);
		mPtrFrameLayout.setDurationToCloseHeader(1000);
		// default is false
		mPtrFrameLayout.setPullToRefresh(true);
		// default is true
		mPtrFrameLayout.setKeepHeaderWhenRefresh(false);


//		mPtrFrameLayout.autoRefresh();
//		final StoreHouseHeader header = new StoreHouseHeader(getContext());
//		header.setPadding(0, PtrLocalDisplay.designedDP2px(15), 0, 0);
		activityList = new ArrayList<>();
		mDataLvAdapter = new DataLvAdapter(getActivity().getApplicationContext());
		getData();
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
	}

	@Override
	public void onRefreshBegin(final PtrFrameLayout frame) {
//
		if(mDataLvAdapter == null){
			getData();
		}else {
			mDataLvAdapter.notifyDataSetChanged();
		}
		frame.refreshComplete();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
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

	private void getData() {
		OkHttpUtils.get().url(Constants.Data_URL).build().execute(new StringCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(String response) {
				try {
					JSONArray array = new JSONObject(response).getJSONObject("result").getJSONArray("activity_list");
					for (int i = 0; i < array.length(); i++) {
						JSONObject object = array.getJSONObject(i);
						mActivityListBean = new DataListViewBean.ResultBean.ActivityListBean();
						mActivityListBean.setContent(object.getString("content"));
						mActivityListBean.setTitle(object.getString("title"));
						mActivityListBean.setType(object.getInt("type"));
						mActivityListBean.setIcon_url(object.getString("icon_url"));
						activityList.add(mActivityListBean);
					}
					mDataLvAdapter.addList(activityList);
					data_lv.setAdapter(mDataLvAdapter);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
