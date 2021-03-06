package com.example.viewdemo.module.home.discovery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.bean.DiscoveryBean;
import com.example.viewdemo.utils.ImageManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hexcuse on 2016/5/9.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class DiscoveryRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


	public interface onItemClickListener{
		void onItemClick(View view, int position);
		void onItemLongClick(View view, int position);
	}

	private onItemClickListener mOnItemClickListener;

	public void setOnItemClickLitener(onItemClickListener mOnItemClickListener){
		this.mOnItemClickListener = mOnItemClickListener;
	}


	private Context mContext;
	private List<DiscoveryBean.ResultBean> datas = new ArrayList<>();

	private static final int TYPE_NORMAL = 0;
	private static final int TYPE_MAP = 2;

	public DiscoveryRecyclerViewAdapter(Context context) {
		this.mContext = context;
	}

	public void setDatas(List<DiscoveryBean.ResultBean> mDatas){
		this.datas.clear();
		if(mDatas != null && mDatas.size() > 0){
			this.datas.addAll(mDatas);
			DiscoveryRecyclerViewAdapter.this.notifyDataSetChanged();
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
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		if(viewType == TYPE_MAP){
			FullHolderView fullHolderView = new FullHolderView(LayoutInflater.from(mContext).inflate(R.layout.listview_fullmap, parent, false));
			return fullHolderView;
		}else{
			MyHolderView holderView = new MyHolderView(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_discovery, parent, false));
			return holderView;
		}

	}

	@Override
	public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
		if(holder instanceof MyHolderView){
			String url = datas.get(position).getImgs().get(0);
			((MyHolderView)holder).tv_title.setText(datas.get(position).getTitle());
			((MyHolderView)holder).iv_discovery.setTag(url);
			((MyHolderView) holder).tv_read.setText(String.valueOf(datas.get(position).getClick()));
			((MyHolderView) holder).tv_time.setText(datas.get(position).getDate());
			((MyHolderView) holder).iv_discovery.setImageBitmap(null);
			ImageManager.setBitmap(((MyHolderView) holder).iv_discovery, url);
		}else if(holder instanceof FullHolderView){
			String url = datas.get(position).getImgs().get(0);
			((FullHolderView) holder).tv_fullmap.setText(datas.get(position).getTitle());
			((FullHolderView)holder).iv_discovery.setTag(url);
			((FullHolderView) holder).iv_discovery.setImageBitmap(null);
			ImageManager.setBitmap(((FullHolderView) holder).iv_discovery, url);
		}
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mOnItemClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
			}
		});

		holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				mOnItemClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
				return true;
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
		private TextView tv_time;
		private TextView tv_read;

		public MyHolderView(View itemView) {
			super(itemView);
			iv_discovery = (ImageView)itemView.findViewById(R.id.iv_discovery);
			tv_title = (TextView)itemView.findViewById(R.id.tv_title);
			tv_time = (TextView)itemView.findViewById(R.id.tv_time);
			tv_read = (TextView)itemView.findViewById(R.id.tv_read);
			setListener(itemView);
		}
	}

	class FullHolderView extends RecyclerView.ViewHolder {

		private ImageView iv_discovery;
		private TextView tv_fullmap;

		public FullHolderView(View itemView) {
			super(itemView);
			iv_discovery = (ImageView)itemView.findViewById(R.id.iv_full);
			tv_fullmap = (TextView)itemView.findViewById(R.id.tv_fullmap);
			setListener(itemView);
		}
	}

	private void setListener(View v){
		v.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mOnItemClickListener.onItemClick(v, );
			}
		});

		v.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View view) {
				return true;
			}
		});
	}
}



