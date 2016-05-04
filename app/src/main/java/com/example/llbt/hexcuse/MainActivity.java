package com.example.llbt.hexcuse;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity{

	private Toolbar tb;
	private RecyclerView rv;
	private RvAdapter mRvAdapter;
	private List<String> datas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tb = (Toolbar)findViewById(R.id.toolbar);
		tb.setTitle("xiaoxi");
//		tb.setLogo(R.mipmap.ic_launcher);
		setSupportActionBar(tb);
		tb.setNavigationIcon(R.mipmap.ic_launcher);
		datas = new ArrayList<>();
		for(int i = 0; i < 20; i++){
			datas.add(i + "");
		}
		tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
			@Override
			public boolean onMenuItemClick(MenuItem menuItem) {
				return false;
			}
		});

		rv = (RecyclerView)findViewById(R.id.recyclerview);
//		rv.setLayoutManager(new LinearLayoutManager(this));
//		rv.setLayoutManager(new GridLayoutManager(this, 3));
		rv.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
		mRvAdapter = new RvAdapter(this, datas);


		tb.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "fanhui", Toast.LENGTH_SHORT).show();
				mRvAdapter.addData(4);
			}
		});

		mRvAdapter.setOnItemClickLitene(new RvAdapter.OnItemClickLitener() {
			@Override
			public void onItemClick(View view, int position) {
				mRvAdapter.addData(position);
			}

			@Override
			public void onItemLongClick(View view, int position) {
				mRvAdapter.removeData(position);
			}
		});

		rv.setAdapter(mRvAdapter);
	}


}
