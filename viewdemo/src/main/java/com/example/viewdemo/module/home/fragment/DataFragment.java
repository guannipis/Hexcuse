package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
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
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		activityList = new ArrayList<>();
		getData();
		mDataLvAdapter = new DataLvAdapter(getContext());
		mDataLvAdapter.addList(activityList);
		data_lv.setAdapter(mDataLvAdapter);
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
		getData();
		frame.refreshComplete();
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

	private void getData(){
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder().url(Constants.Data_URL).build();
		Call call = okHttpClient.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Request request, IOException e) {

			}

			@Override
			public void onResponse(Response response) throws IOException {
				if(response.isSuccessful()){
					try {
						JSONArray array = new JSONObject(response.body().string()).getJSONArray("result");
						for(int i = 0; i <= array.length(); i++){
							JSONObject object = array.getJSONObject(i);
							mActivityListBean = new DataListViewBean.ResultBean.ActivityListBean();
							mActivityListBean.setContent(object.getString("content"));
							mActivityListBean.setTitle(object.getString("title"));
							activityList.add(mActivityListBean);
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
}
