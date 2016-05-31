package com.example.viewdemo.module.home.discovery;

import com.example.viewdemo.common.base.BasePresenter;
import com.example.viewdemo.common.base.BaseView;
import com.example.viewdemo.common.bean.DiscoveryBean;

import java.util.List;

/**
 * Created by Hexcuse on 2016/5/26.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public interface DiscoveryContract {

	interface DiscoveryView extends BaseView<DiscoveryPresenter>{

		void showRecyclerView(List<DiscoveryBean.ResultBean> datas);

		void showMessage(String message);

		void refreshComplete();

		void toNewsActivity(DiscoveryBean.ResultBean resultBean);

	}

	interface DiscoveryPresenter extends BasePresenter{

		void getRecyclerView();

		void refreshData();

	}

}
