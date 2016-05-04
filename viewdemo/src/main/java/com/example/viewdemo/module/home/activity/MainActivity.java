package com.example.viewdemo.module.home.activity;

import android.support.v4.app.FragmentActivity;

/**
 * 主页面，采用Fragment＋viewpager＋RadioButton
 *
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragmentActivity;
import com.example.viewdemo.module.home.adapter.ViewPagerAdapter;
import com.example.viewdemo.module.home.fragment.DataFragment;
import com.example.viewdemo.module.home.fragment.DiscoveryFragment;
import com.example.viewdemo.module.home.fragment.MeFragment;
import com.example.viewdemo.module.home.fragment.VideoFragment;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

	private RadioButton[] rb_main;       //主页面下方四个radiobutton的集合
	private RadioButton rb_me;
	private RadioButton rb_home;
	private RadioButton rb_discovery;
	private RadioButton rb_video;

	private int currentPosition;

	private ViewPager vp_main;
	private Fragment[] mFragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		addListener();

	}

	private void initView(){
		rb_main = new RadioButton[4];
		vp_main = (ViewPager)findViewById(R.id.vp);
		rb_main[0] = (RadioButton)findViewById(R.id.rb_me);
		rb_main[1] = (RadioButton)findViewById(R.id.rb_home);
		rb_main[2] = (RadioButton)findViewById(R.id.rb_discovery);
		rb_main[3] = (RadioButton)findViewById(R.id.rb_video);
		mFragments = new Fragment[]{new MeFragment(), new DataFragment(), new DiscoveryFragment(), new VideoFragment()};
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments);
		vp_main.setAdapter(adapter);
		vp_main.setCurrentItem(0);
		rb_main[0].setChecked(true);
	}

	private void addListener(){
		rb_main[0].setOnClickListener(this);
		rb_main[1].setOnClickListener(this);
		rb_main[2].setOnClickListener(this);
		rb_main[3].setOnClickListener(this);
		vp_main.addOnPageChangeListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.rb_me:
				vp_main.setCurrentItem(0);
			    break;
			case R.id.rb_home:
				vp_main.setCurrentItem(1);
				break;
			case R.id.rb_discovery:
				vp_main.setCurrentItem(2);
				break;
			case R.id.rb_video:
				vp_main.setCurrentItem(3);
				break;
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		for(int i = 0; i <= position; i++){
			rb_main[i].setChecked(true);
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
