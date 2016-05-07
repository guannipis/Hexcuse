package com.example.viewdemo.module.home.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.bean.DataListViewBean;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.io.InputStream;
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
	private LayoutInflater mLayoutInflater;

	private static final int TYPE_MAP = 0;
	private static final int TYPE_NORMAL = 1;
	private static final int TYPE_COUNT = 2;

	public DataLvAdapter(Context context) {
		mLayoutInflater = LayoutInflater.from(context);
	}

	public void addList(List<DataListViewBean.ResultBean.ActivityListBean> data){
		if(data != null){
			this.mList.addAll(data);
		}
	}

	@Override
	public int getItemViewType(int position) {
		if(mList.get(position).getType() == TYPE_MAP){
			return TYPE_MAP;
		}else if(mList.get(position).getType() == TYPE_NORMAL){
			return TYPE_NORMAL;
		}else {
			return 100;
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
		if(currentType == TYPE_MAP){
			if(view == null){
				view = mLayoutInflater.inflate(R.layout.listview_fullmap, null);
				holder = new ViewHolder();
				holder.iv_data = (ImageView)view.findViewById(R.id.iv_full);
				view.setTag(holder);
			}else {
				holder = (ViewHolder) view.getTag();
			}
			try {
				holder.iv_data.setImageBitmap(getbitmap(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(currentType == TYPE_NORMAL){
			if(view == null){
				view = mLayoutInflater.inflate(R.layout.listview_data, null);
				holder = new ViewHolder();
				holder.iv_data = (ImageView)view.findViewById(R.id.iv_data);
				holder.tv_title = (TextView)view.findViewById(R.id.tv_title);
				holder.tv_content = (TextView)view.findViewById(R.id.tv_content);
				view.setTag(holder);
			}else {
				holder = (ViewHolder) view.getTag();
			}
			holder.tv_title.setText(mList.get(i).getTitle());
			holder.tv_content.setText(mList.get(i).getContent());
			try {
				holder.iv_data.setImageBitmap(getbitmap(i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return view;
	}

	private Bitmap getbitmap(int i) throws IOException {
		OkHttpClient okHttpClient = new OkHttpClient();
		Request request = new Request.Builder().url(mList.get(i).getIcon_url()).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		InputStream is = response.body().byteStream();
		Bitmap bitmap = BitmapFactory.decodeStream(is);
		return bitmap;
	}

	class ViewHolder{
		public ViewHolder() {
		}

		private TextView tv_title;
		private TextView tv_content;
		private ImageView iv_data;

	}
}
