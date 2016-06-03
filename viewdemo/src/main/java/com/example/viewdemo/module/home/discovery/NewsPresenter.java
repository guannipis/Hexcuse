package com.example.viewdemo.module.home.discovery;

import android.content.Context;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Hexcuse on 2016/6/1.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class NewsPresenter implements NewsContract.NewsPresenter {

	private NewsContract.NewsView mNewsView;
	private Context context;

	public NewsPresenter(Context context, NewsContract.NewsView newsView) {
		this.context = context;
		this.mNewsView = newsView;

	}

	@Override
	public void start() {

	}

	@Override
	public void loadNews(String url) {
		OkHttpUtils.get().url(url).build().execute(new StringCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(String response) {
				mNewsView.showNews(response);
			}
		});
	}
}
