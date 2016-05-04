package com.example.llbt.hexcuse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by llbt on 2016/4/14.
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {

	private List<String> datas;
	private Context mContext;

	public interface OnItemClickLitener{
		void onItemClick(View view, int position);
		void onItemLongClick(View view , int position);
	}

	private OnItemClickLitener mOnItemClickLitener;

	public void setOnItemClickLitene(OnItemClickLitener onItemClickLitener){
		this.mOnItemClickLitener = onItemClickLitener;
	}

	public RvAdapter(Context context, List<String> datas) {
		this.datas = datas;
		this.mContext = context;
	}

	@Override
	public int getItemCount() {
		return datas.size();
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		MyViewHolder holder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recyclerview_layout, parent, false));
		return holder;
	}


	@Override
	public void onBindViewHolder(final MyViewHolder holder, int position) {
		holder.tv.setText(datas.get(position));
		int height = (int)(Math.random() * 100 + 100);
		holder.tv.setHeight(height);
		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int pos = holder.getPosition();
				mOnItemClickLitener.onItemClick(holder.itemView, pos);
			}
		});

		holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				int pos = holder.getPosition();
				mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
				return false;
			}
		});
	}

	public void addData(int position){
		datas.add(position, "insert");
		notifyItemInserted(position);
	}

	public void removeData(int position){
		datas.remove(position);
		notifyItemRemoved(position);
	}

	class MyViewHolder extends RecyclerView.ViewHolder {

		TextView tv;

		public MyViewHolder(View itemView) {
			super(itemView);
			tv = (TextView) itemView.findViewById(R.id.id_num);
		}
	}

}
