package com.example.viewdemo.module.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.viewdemo.R;
import com.example.viewdemo.common.base.BaseFragmentActivity;
import com.example.viewdemo.module.home.data.DataFragment;
import com.example.viewdemo.module.home.data.DataPresenter;
import com.example.viewdemo.module.home.discovery.DiscoveryFragment;
import com.example.viewdemo.module.home.me.MeFragment;
import com.example.viewdemo.module.home.viedo.VideoFragment;

/**
 * 主页面，采用Fragment＋viewpager＋RadioButton
 */

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

	private RadioButton[] rb_main;       //主页面下方四个radiobutton的集合
	private RadioButton rb_me;
	private RadioButton rb_home;
	private RadioButton rb_discovery;
	private RadioButton rb_video;

	private int currentPosition;
	private Toolbar mToolbar;
	private TextView tv_toolbar;

	private ViewPager vp_main;
	private Fragment[] mFragments;
	private MeFragment meFragment;
	private DataFragment dataFragment;
	private DiscoveryFragment discoveryFragment;
	private VideoFragment videoFragment;

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
		mToolbar = (Toolbar) findViewById(R.id.common_toolbar);
		tv_toolbar = (TextView)findViewById(R.id.tv_toolbar);
		initViewPager();
	}

	private void initViewPager(){
		meFragment = MeFragment.newInstance();
		dataFragment = DataFragment.newInstance();
		discoveryFragment = new DiscoveryFragment();
		mFragments = new Fragment[]{meFragment, dataFragment, new DiscoveryFragment(), new VideoFragment()};
		ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragments);
		vp_main.setAdapter(adapter);
		vp_main.setCurrentItem(0);
		rb_main[0].setChecked(true);
		new DataPresenter(dataFragment);
	}

	private void addListener(){
		rb_main[0].setOnClickListener(this);
		rb_main[1].setOnClickListener(this);
		rb_main[2].setOnClickListener(this);
		rb_main[3].setOnClickListener(this);
		vp_main.addOnPageChangeListener(this);
		vp_main.setOffscreenPageLimit(3);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.rb_me:
				vp_main.setCurrentItem(0);
				tv_toolbar.setText("MAX+");
			    break;
			case R.id.rb_home:
				vp_main.setCurrentItem(1);
				tv_toolbar.setText(getResources().getString(R.string.data));
				break;
			case R.id.rb_discovery:
				vp_main.setCurrentItem(2);
				tv_toolbar.setText(getResources().getString(R.string.discovery));
				break;
			case R.id.rb_video:
				vp_main.setCurrentItem(3);
				tv_toolbar.setText(getResources().getString(R.string.video));
				break;
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	@Override
	public void onPageSelected(int position) {
		rb_main[position].setChecked(true);
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}
}
