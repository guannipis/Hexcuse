package com.example.viewdemo.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.viewdemo.R;

import java.util.concurrent.TimeoutException;
import java.util.zip.Inflater;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by llbt on 2016/4/22.
 * Fragment的基类
 */
public class BaseFragment extends Fragment {

	protected TextView tv_band;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.band, null);
		tv_band = (TextView)view.findViewById(R.id.tv_band_title);
//		initView();
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	protected void setBandTitle(int id){
		tv_band.setText(id);
	}

//	protected void initView(){
//
//	}
}
