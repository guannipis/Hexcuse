package com.example.viewdemo.module.home.discovery;

import com.example.viewdemo.common.base.BasePresenter;
import com.example.viewdemo.common.base.BaseView;

/**
 * Created by Hexcuse on 2016/6/1.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class NewsContract {

	interface NewsView extends BaseView<NewsPresenter>{

		void showNews();

	}

	interface NewsPresenter extends BasePresenter{

		void loadNews();
	}
}
