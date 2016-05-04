package com.example.okhttpclientmanager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends Activity {

	private TextView tv;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView)findViewById(R.id.tv);

		findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				initHttp();
			}
		});
	}

	private void initHttp() {
		//创建okHttpClient对象
		OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
		final Request request = new Request.Builder()
				.url("https://www.baidu.com/")
				.build();
//new call
		Call call = mOkHttpClient.newCall(request);
//请求加入调度
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Request request, IOException e) {
			}

			@Override
			public void onResponse(final Response response) throws IOException {
				if(response.isSuccessful()){
					Log.i("response===", response.body().string());
					final String res = response.body().string();
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
						}
					});

				}
			}
		});
	}
}
