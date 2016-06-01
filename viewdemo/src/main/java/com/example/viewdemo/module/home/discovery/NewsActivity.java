package com.example.viewdemo.module.home.discovery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseActivity;
import com.example.viewdemo.common.bean.DiscoveryBean;
import com.example.viewdemo.utils.ImageManager;

/**
 * Created by Hexcuse on 2016/5/30.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class NewsActivity extends BaseActivity implements NewsContract.NewsView{

	private ImageView iv_title;
	private WebView news_web;

	private NewsContract.NewsPresenter mNewsPresenter;

	private CollapsingToolbarLayout mCollapsingToolbarLayout;

	public static void startNewsActivity(Context context, DiscoveryBean.ResultBean resultBean){
		Intent intent = new Intent(context, NewsActivity.class);
		intent.putExtra("resultBean", resultBean);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);
		initView();
	}

	private void initView(){
		Intent intent = getIntent();
		DiscoveryBean.ResultBean resultBean = (DiscoveryBean.ResultBean) intent.getSerializableExtra("resultBean");
		iv_title = (ImageView)findViewById(R.id.ivImage);
		news_web = (WebView)findViewById(R.id.news_web);
		mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
		mCollapsingToolbarLayout.setTitle(resultBean.getTitle());
		mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedTitleStyle);
		mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedTitleStyle);
		String url = resultBean.getImgs().get(0);
		iv_title.setTag(url);
		ImageManager.setBitmap(iv_title, url);
		mNewsPresenter = new NewsPresenter(getApplicationContext(), this);
		mNewsPresenter.loadNews();
		news_web.loadUrl(url);
		news_web.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		news_web.getSettings().setLoadWithOverviewMode(true);
	}

	@Override
	public void showNews() {

	}

	@Override
	public void setPresenter(NewsContract.NewsPresenter presenter) {

	}
}
