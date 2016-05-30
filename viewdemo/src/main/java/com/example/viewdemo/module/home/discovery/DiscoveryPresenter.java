package com.example.viewdemo.module.home.discovery;

import com.example.viewdemo.common.bean.Constants;
import com.example.viewdemo.common.bean.DiscoveryBean;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/26.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class DiscoveryPresenter implements DiscoveryContract.DiscoveryPresenter{

	private List<DiscoveryBean.ResultBean> datas;
	private DiscoveryContract.DiscoveryView mDiscoveryView;

	public DiscoveryPresenter(DiscoveryContract.DiscoveryView discoveryView) {
		this.mDiscoveryView = discoveryView;
		mDiscoveryView.setPresenter(this);
	}

	@Override
	public void start() {
		getRecyclerView();
	}

	@Override
	public void getRecyclerView() {
		OkHttpUtils.get().url(Constants.Discovery_URL).build().execute(new StringCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(String response) {
				datas = new ArrayList<>();
				try {
					JSONArray array = new JSONObject(response).getJSONArray("result");
					for (int i = 0; i < array.length(); i++) {
						DiscoveryBean.ResultBean bean = new DiscoveryBean.ResultBean();
						bean.setTitle(array.getJSONObject(i).getString("title"));
						bean.setNewUrl(array.getJSONObject(i).getString("newUrl"));
						if (!array.getJSONObject(i).isNull("img_type")) {
							bean.setImg_type(array.getJSONObject(i).getInt("img_type"));
						}
						JSONArray urlArray = array.getJSONObject(i).getJSONArray("imgs");
						List<String> stringList = new ArrayList<>();
						for (int j = 0; j < urlArray.length(); j++) {
							stringList.add(urlArray.getString(j));
							bean.setImgs(stringList);
						}
						datas.add(bean);
					}
					mDiscoveryView.showRecyclerView(datas);
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		});
	}
	@Override
	public void refreshData() {
		getRecyclerView();
		mDiscoveryView.refreshComplete();
	}

}
