package com.example.viewdemo.module.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by llbt on 2016/4/22.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

	private Fragment[] mFragments;


	public ViewPagerAdapter(FragmentManager fm, Fragment[] mFragments) {
		super(fm);
		this.mFragments = mFragments;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments[position];
	}

	@Override
	public int getCount() {
		return mFragments.length;
	}
}
