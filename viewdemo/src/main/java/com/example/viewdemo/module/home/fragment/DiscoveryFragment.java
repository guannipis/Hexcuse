package com.example.viewdemo.module.home.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;
import com.example.viewdemo.common.bean.Constants;
import com.example.viewdemo.common.bean.DiscoveryBean;
import com.example.viewdemo.module.home.adapter.DiscoveryListViewAdapter;
import com.example.viewdemo.module.home.adapter.DiscoveryRecyclerViewAdapter;
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
public class DiscoveryFragment extends BaseFragment {

	private PtrFrameLayout mPtrFrameLayout;
	private View convertView;
	private List<DiscoveryBean.ResultBean> datas;

	/**
	 * ListView的实现方式
	 */
//	private DiscoveryListViewAdapter mDiscoveryListViewAdapter;
//	private ListView lv_discovery;

	/**
	 * RecyclerView的实现方式
 	 */
	private RecyclerView rv_discovery;
	private DiscoveryRecyclerViewAdapter mDiscoveryRecyclerViewAdapte;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		convertView = inflater.inflate(R.layout.fragment_discovery, null);
		initView();
		return convertView;
	}

	private void initView() {
		mPtrFrameLayout = (PtrFrameLayout) convertView.findViewById(R.id.ptrframe);
		rv_discovery = (RecyclerView)convertView.findViewById(R.id.rv_discovery);
		mDiscoveryRecyclerViewAdapte = new DiscoveryRecyclerViewAdapter(getActivity().getApplicationContext());
		rv_discovery.setLayoutManager(new LinearLayoutManager(getActivity()));
//		lv_discovery = (ListView) convertView.findViewById(R.id.lv_discovery);
//		mDiscoveryListViewAdapter = new DiscoveryListViewAdapter(getActivity().getApplicationContext());
		mPtrFrameLayout.setPtrHandler(this);
		getData();
	}

	/**
	 * 重写checkCanDoRefresh方法，判断RecyclerView是否在最顶部，如果是，则返回true，能下拉刷新。如果否，能返回false，不能下拉
	 * @param frame
	 * @param content
	 * @param header
	 * @return
	 */
	@Override
	public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
		ViewGroup viewGroup = (ViewGroup) content;
		RecyclerView view = (RecyclerView) viewGroup.getChildAt(1);
		LinearLayoutManager layoutManager = (LinearLayoutManager) view.getLayoutManager();
		if (layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition()) != null
				&& layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition()).getTop() == 0
				&& layoutManager.findFirstVisibleItemPosition() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void onRefreshBegin(PtrFrameLayout frame) {
		if (mDiscoveryRecyclerViewAdapte == null) {
			getData();
		} else {
			getData();
			mDiscoveryRecyclerViewAdapte.notifyDataSetChanged();
		}
		frame.refreshComplete();
	}

	private void getData() {
		OkHttpUtils.get().url(Constants.Discovery_URL).build().execute(new StringCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(String response) {
				try {
					datas = new ArrayList<DiscoveryBean.ResultBean>();
					JSONArray array = new JSONObject(response).getJSONArray("result");
					for (int i = 0; i < array.length(); i++) {
						DiscoveryBean.ResultBean bean = new DiscoveryBean.ResultBean();
						bean.setTitle(array.getJSONObject(i).getString("title"));
						bean.setImg_type(array.getJSONObject(i).getInt("img_type"));
						JSONArray urlArray = array.getJSONObject(i).getJSONArray("imgs");
						List<String> stringList = new ArrayList<>();
						for (int j = 0; j < urlArray.length(); j++) {
							stringList.add(urlArray.getString(j));
							bean.setImgs(stringList);
						}
						datas.add(bean);
					}

//					mDiscoveryListViewAdapter.setDatas(datas);
//					lv_discovery.setAdapter(mDiscoveryListViewAdapter);
					mDiscoveryRecyclerViewAdapte.setDatas(datas);
					rv_discovery.setAdapter(mDiscoveryRecyclerViewAdapte);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
