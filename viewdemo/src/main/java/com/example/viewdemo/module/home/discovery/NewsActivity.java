package com.example.viewdemo.module.home.discovery;

import android.content.Context;
import android.content.Intent;

import com.example.viewdemo.common.base.BaseActivity;

/**
 * Created by Hexcuse on 2016/5/30.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class NewsActivity extends BaseActivity {

	public static void startNewsActivity(Context context, String url){
		Intent intent = new Intent(context, NewsActivity.class);
		intent.putExtra("url", url);
		context.startActivity(intent);
	}

}
