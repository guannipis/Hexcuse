package com.example.viewdemo.module.home.data;

import android.util.Log;

import com.example.viewdemo.common.bean.Constants;
import com.example.viewdemo.common.bean.DataListViewBean;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/19.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class DataPresenter implements DataContract.Presenter {

	private DataContract.View mDataView;
	private DataListViewBean.ResultBean.ActivityListBean mActivityListBean;
	private List<DataListViewBean.ResultBean.ActivityListBean> activityList;

	public DataPresenter(DataContract.View mDataView) {
		this.mDataView = mDataView;
		mDataView.setPresenter(this);
	}

	@Override
	public void getListViewData(final List<DataListViewBean.ResultBean.ActivityListBean> activityList) {
		OkHttpUtils.get().url(Constants.Data_URL).build().execute(new StringCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(String response) {
				Log.d("response=====", response);
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
						mDataView.showListView(activityList);
					}

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void start() {
		activityList = new ArrayList<>();
		getListViewData(activityList);
	}

}
