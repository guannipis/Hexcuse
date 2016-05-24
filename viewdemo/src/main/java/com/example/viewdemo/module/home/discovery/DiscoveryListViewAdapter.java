package com.example.viewdemo.module.home.discovery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.bean.DiscoveryBean;
import com.example.viewdemo.utils.ImageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/13.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class DiscoveryListViewAdapter extends BaseAdapter {

	private Context mContext;
	private List<DiscoveryBean.ResultBean> datas = new ArrayList<DiscoveryBean.ResultBean>();

	private static final int TYPE_NORMAL = 0;
	private static final int TYPE_MAP = 2;

	public DiscoveryListViewAdapter(Context context) {
		this.mContext = context;
	}

	public void setDatas(List<DiscoveryBean.ResultBean> mDatas) {
		this.datas.clear();
		if (mDatas != null && mDatas.size() > 0) {
			this.datas.addAll(mDatas);
		}

	}

	@Override
	public int getItemViewType(int position) {
		if (datas.get(position).getImg_type() == TYPE_MAP) {
			return TYPE_MAP;
		} else if (datas.get(position).getImg_type() == TYPE_NORMAL) {
			return TYPE_NORMAL;
		} else {
			return 100;
		}
	}

	@Override
	public int getViewTypeCount() {
		return 3;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int i) {
		return datas.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		int current = getItemViewType(i);
		ViewHolder holder;
		if (current == TYPE_NORMAL) {
			String url = datas.get(i).getImgs().get(0);
			if (view == null) {
				holder = new ViewHolder();
				view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_discovery, viewGroup, false);
				holder.tv_title = (TextView) view.findViewById(R.id.tv_title);
				holder.iv_discovery = (ImageView) view.findViewById(R.id.iv_discovery);

				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}
			holder.iv_discovery.setTag(datas.get(i).getImgs().get(0));
			holder.tv_title.setText(datas.get(i).getTitle());
			String tag = (String) holder.iv_discovery.getTag();
			holder.iv_discovery.setImageBitmap(null);
			ImageManager.setBitmap(holder.iv_discovery, datas.get(i).getImgs().get(0));
		} else if (current == TYPE_MAP) {
			String url = datas.get(i).getImgs().get(0);
			if (view == null) {
				holder = new ViewHolder();
				view = LayoutInflater.from(mContext).inflate(R.layout.listview_fullmap, viewGroup, false);
				holder.iv_discovery = (ImageView) view.findViewById(R.id.iv_full);
				view.setTag(holder);
			} else {
				holder = (ViewHolder) view.getTag();
			}
			holder.iv_discovery.setTag(datas.get(i).getImgs().get(0));
			String tag = (String) holder.iv_discovery.getTag();
			holder.iv_discovery.setImageBitmap(null);
			ImageManager.setBitmap(holder.iv_discovery, datas.get(i).getImgs().get(0));
		}
		return view;
	}

	class ViewHolder {
		private ImageView iv_discovery;
		private TextView tv_title;
	}
}
