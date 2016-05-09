package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;
import com.example.viewdemo.common.bean.Constants;
import com.example.viewdemo.common.bean.DiscoveryBean;
import com.example.viewdemo.module.home.adapter.DiscoveryRecyclerViewAdapter;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llbt on 2016/4/22.
 */
public class DiscoveryFragment extends BaseFragment{

	private View convertView;
	private RecyclerView rv_discovery;
	private DiscoveryRecyclerViewAdapter mDiscoveryRecyclerViewAdapte;
	private List<DiscoveryBean.ResultBean> datas;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		convertView = inflater.inflate(R.layout.fragment_discovery, null);
		initView();
		return convertView;
	}

	private void initView(){
		rv_discovery = (RecyclerView)convertView.findViewById(R.id.rv_discovery);
		mDiscoveryRecyclerViewAdapte = new DiscoveryRecyclerViewAdapter(getActivity().getApplicationContext());
		datas = new ArrayList<DiscoveryBean.ResultBean>();
		getData();
	}

	private void getData(){
		OkHttpUtils.get().url(Constants.Discovery_URL).build().execute(new StringCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(String response) {
				try {
					JSONArray array = new JSONObject(response).getJSONArray("result");
					for(int i = 0; i < array.length(); i++){
						DiscoveryBean.ResultBean bean = new DiscoveryBean.ResultBean();
						bean.setTitle(array.getJSONObject(i).getString("title"));
						JSONArray urlArray = array.getJSONObject(i).getJSONArray("imgs");
						List<String> stringList = new ArrayList<>();
						for(int j = 0; j < urlArray.length(); j++){
							stringList.add(urlArray.getString(j));
							bean.setImgs(stringList);
						}
						datas.add(bean);
					}
					rv_discovery.setLayoutManager(new LinearLayoutManager(getActivity()));
					mDiscoveryRecyclerViewAdapte.setDatas(datas);
					rv_discovery.setAdapter(mDiscoveryRecyclerViewAdapte);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
