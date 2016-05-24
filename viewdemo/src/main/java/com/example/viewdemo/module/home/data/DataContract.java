package com.example.viewdemo.module.home.data;

import com.example.viewdemo.common.base.BasePresenter;
import com.example.viewdemo.common.base.BaseView;
import com.example.viewdemo.common.bean.DataListViewBean;

import java.util.List;

/**
 * Created by Hexcuse on 2016/5/19.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public interface DataContract {

	interface View extends BaseView<Presenter> {

		void showListView(List<DataListViewBean.ResultBean.ActivityListBean> activityList);

	}

	interface Presenter extends BasePresenter {

		void getListViewData(List<DataListViewBean.ResultBean.ActivityListBean> activityList);

	}
}
