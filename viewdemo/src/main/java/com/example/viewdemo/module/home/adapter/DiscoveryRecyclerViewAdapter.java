package com.example.viewdemo.module.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.bean.DiscoveryBean;
import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/9.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class DiscoveryRecyclerViewAdapter extends RecyclerView.Adapter<DiscoveryRecyclerViewAdapter.MyHolderView> {

	private Context mContext;
	private List<DiscoveryBean.ResultBean> datas = new ArrayList<DiscoveryBean.ResultBean>();

	private static final int TYPE_NORMAL = 0;
	private static final int TYPE_MAP = 2;

	public DiscoveryRecyclerViewAdapter(Context context) {
		this.mContext = context;
	}

	public void setDatas(List<DiscoveryBean.ResultBean> mDatas){
		this.datas.clear();
		if(mDatas != null && mDatas.size() > 0){
			this.datas.addAll(mDatas);
		}

	}

	@Override
	public int getItemViewType(int position) {
		if (datas.get(position).getImg_type() == TYPE_MAP){
			return TYPE_MAP;
		}else if(datas.get(position).getImg_type() == TYPE_NORMAL){
			return TYPE_NORMAL;
		}else{
			return 100;
		}
	}


	@Override
	public MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
		if(viewType == TYPE_MAP){
			MyHolderView holderView = new MyHolderView(LayoutInflater.from(mContext).inflate(R.layout.listview_fullmap, parent, false));
			return holderView;
		}else{
			MyHolderView holderView = new MyHolderView(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_discovery, parent, false));
			return holderView;
		}

	}

	@Override
	public void onBindViewHolder(MyHolderView holder, int position) {
		holder.tv_title.setText(datas.get(position).getTitle());
		setBitmap(holder, position);
	}

	private void setBitmap(final MyHolderView holder, int i) {
//		List<String> url = datas.get(i).getImgs();
		OkHttpUtils.get().url(datas.get(i).getImgs().get(0)).build().execute(new BitmapCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(Bitmap response) {
				holder.iv_discovery.setImageBitmap(response);
			}
		});
	}
	@Override
	public int getItemCount() {
		return datas.size();
	}

	class MyHolderView extends RecyclerView.ViewHolder {

		private ImageView iv_discovery;
		private TextView tv_title;

		public MyHolderView(View itemView) {
			super(itemView);
			iv_discovery = (ImageView)itemView.findViewById(R.id.iv_discovery);
			tv_title = (TextView)itemView.findViewById(R.id.tv_title);
		}
	}
}



