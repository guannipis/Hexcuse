package com.example.viewdemo.module.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.bean.DataListViewBean;
import com.example.viewdemo.utils.ImageManager;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/6.
 *
 * @Package [${package_name}.${file_name}]
 * @ClassName: [${type_name}]
 * @Description: ${todo}(用一句话描述该文件做什么)
 */
public class DataLvAdapter extends BaseAdapter {

	private List<DataListViewBean.ResultBean.ActivityListBean> mList = new ArrayList<>();
	private LayoutInflater mLayoutInflater;

	private static final int TYPE_MAP = 0;
	private static final int TYPE_NORMAL = 1;
	private static final int TYPE_COUNT = 2;

	public DataLvAdapter(Context context) {
		mLayoutInflater = LayoutInflater.from(context);
	}

	public void addList(List<DataListViewBean.ResultBean.ActivityListBean> data) {
		this.mList.clear();
		if (data != null && data.size() > 0) {
			this.mList.addAll(data);
		}
	}

	@Override
	public int getItemViewType(int position) {
		if (mList.get(position).getType() == TYPE_MAP) {
			return TYPE_MAP;
		} else{
			return TYPE_NORMAL;
		}
	}

	@Override
	public int getViewTypeCount() {
		return TYPE_COUNT;
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
		int currentType = getItemViewType(i);
		ViewHolder holder;
		if (currentType == TYPE_MAP) {
			String url = mList.get(i).getIcon_url();
			if (view == null) {
				view = mLayoutInflater.inflate(R.layout.listview_fullmap, viewGroup, false);
				holder = new ViewHolder();
				holder.iv_data = (ImageView) view.findViewById(R.id.iv_full);
				holder.iv_data.setTag(mList.get(i).getIcon_url());
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}
			String tag = (String)holder.iv_data.getTag();
			if(tag != null && tag.equals(url)){
				ImageManager.setBitmap(holder.iv_data, url);
			}
		} else{String url = mList.get(i).getIcon_url();

			if (view == null) {
				view = mLayoutInflater.inflate(R.layout.listview_data, viewGroup, false);
				holder = new ViewHolder();
				holder.iv_data = (ImageView) view.findViewById(R.id.iv_data);
				holder.tv_title = (TextView) view.findViewById(R.id.tv_title);
				holder.tv_content = (TextView) view.findViewById(R.id.tv_content);
				holder.iv_data.setTag(mList.get(i).getIcon_url());
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}
			holder.tv_title.setText(mList.get(i).getTitle());
			holder.tv_content.setText(mList.get(i).getContent());
			String tag = (String)holder.iv_data.getTag();
			if(tag != null && tag.equals(url)){
				ImageManager.setBitmap(holder.iv_data, url);
			}
		}
		return view;
	}

	class ViewHolder {

		private TextView tv_title;
		private TextView tv_content;
		private ImageView iv_data;

	}
}
