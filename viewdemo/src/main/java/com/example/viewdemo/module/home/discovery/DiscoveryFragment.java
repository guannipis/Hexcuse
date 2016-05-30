package com.example.viewdemo.module.home.discovery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragment;
import com.example.viewdemo.common.bean.DiscoveryBean;

import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by llbt on 2016/4/22.
 */
public class DiscoveryFragment extends BaseFragment implements DiscoveryContract.DiscoveryView {

	private PtrFrameLayout mPtrFrameLayout;
	private View convertView;
	private TextView tv_band_title;
	private DiscoveryContract.DiscoveryPresenter mPresenter;

	/**
	 * ListView的实现方式
	 */
//	private DiscoveryListViewAdapter mDiscoveryListViewAdapter;
//	private ListView lv_discovery;

	/**
	 * RecyclerView的实现方式
 	 */
	private RecyclerView rv_discovery;
	private DiscoveryRecyclerViewAdapter mDiscoveryRecyclerViewAdapte;

	/**
	 * 得到Fragment的实例
	 * @return
	 */
	public static DiscoveryFragment newInstance(){
		return new DiscoveryFragment();
	}

	public DiscoveryFragment(){

	}

	@Override
	public void setPresenter(DiscoveryContract.DiscoveryPresenter presenter) {
		this.mPresenter = presenter;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		convertView = inflater.inflate(R.layout.fragment_discovery, null);
		initView();
		return convertView;
	}

	@Override
	public void onResume() {
		super.onResume();
		mPresenter.start();
	}

	private void initView() {
		mPtrFrameLayout = (PtrFrameLayout) convertView.findViewById(R.id.ptrframe);
		rv_discovery = (RecyclerView)convertView.findViewById(R.id.rv_discovery);
		tv_band_title = (TextView) convertView.findViewById(R.id.tv_band_title);
		mDiscoveryRecyclerViewAdapte = new DiscoveryRecyclerViewAdapter(getActivity().getApplicationContext());
		rv_discovery.setLayoutManager(new LinearLayoutManager(getActivity()));
		tv_band_title.setText(R.string.news);
		initPtr();
	}

	/**
	 * 初始化下拉刷新控件
	 */
	private void initPtr(){
//		lv_discovery = (ListView) convertView.findViewById(R.id.lv_discovery);
//		mDiscoveryListViewAdapter = new DiscoveryListViewAdapter(getActivity().getApplicationContext());
		mPtrFrameLayout.setPtrHandler(this);
	}

	/**
	 * 重写checkCanDoRefresh方法，判断RecyclerView是否在最顶部，如果是，则返回true，能下拉刷新。如果否，能返回false，不能下拉
	 * @param frame
	 * @param content
	 * @param header
	 * @return
	 */
	@Override
	public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
		ViewGroup viewGroup = (ViewGroup) content;
		RecyclerView view = (RecyclerView) viewGroup.getChildAt(1);
		LinearLayoutManager layoutManager = (LinearLayoutManager) view.getLayoutManager();
		if (layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition()) != null
				&& layoutManager.findViewByPosition(layoutManager.findFirstVisibleItemPosition()).getTop() == 0
				&& layoutManager.findFirstVisibleItemPosition() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void onRefreshBegin(PtrFrameLayout frame) {
		mPresenter.refreshData();
	}

	/**
	 * 展示recyclerView的数据
	 * @param datas
	 */
	@Override
	public void showRecyclerView(final List<DiscoveryBean.ResultBean> datas) {
		mDiscoveryRecyclerViewAdapte.setDatas(datas);
        rv_discovery.setAdapter(mDiscoveryRecyclerViewAdapte);
		mDiscoveryRecyclerViewAdapte.setOnItemClickLitener(new DiscoveryRecyclerViewAdapter.onItemClickListener(){

			@Override
			public void onItemClick(View view, int position) {
				String url = datas.get(position).getNewUrl();
				toNewsActivity(url);
			}

			@Override
			public void onItemLongClick(View view, int position) {

			}
		});
	}

	/**
	 * 显示信息，包括提示信息，错误信息等
	 * @param message
	 */
	@Override
	public void showMessage(String message) {

	}

	/**
	 * 刷新数据
	 */
	@Override
	public void refreshComplete() {
		mPtrFrameLayout.refreshComplete();
	}

	@Override
	public void toNewsActivity(String url) {
		NewsActivity.startNewsActivity(getActivity().getApplicationContext(), url);
	}

}
