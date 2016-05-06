package com.example.viewdemo.module.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.viewdemo.common.bean.DataListViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/6.
 *
 * @Package [${package_name}.${file_name}]
 * @ClassName: [${type_name}]
 * @Description: ${todo}(用一句话描述该文件做什么)
 */
public class DataLvAdapter extends BaseAdapter{

	private List<DataListViewBean.ResultBean.ActivityListBean> mList = new ArrayList<>();

	public DataLvAdapter(Context context) {

	}

	public void addList(List<DataListViewBean.ResultBean.ActivityListBean> data){
		if(data != null){
			this.mList.addAll(data);
		}
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int i) {
		return mList.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		return null;
	}
}
