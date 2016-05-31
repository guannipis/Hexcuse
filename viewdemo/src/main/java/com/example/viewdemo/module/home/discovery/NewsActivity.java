package com.example.viewdemo.module.home.discovery;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.ImageView;
import android.widget.TextView;

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
public class NewsActivity extends BaseActivity {

	private TextView tv_title;
	private ImageView iv_title;

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
		mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
		mCollapsingToolbarLayout.setTitle(resultBean.getTitle());
		mCollapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.White));
		mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));
		String url = resultBean.getImgs().get(0);
		iv_title.setTag(url);
		ImageManager.setBitmap(iv_title, url);
	}
}
