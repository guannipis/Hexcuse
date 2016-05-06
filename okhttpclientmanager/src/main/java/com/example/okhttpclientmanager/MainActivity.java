package com.example.okhttpclientmanager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends Activity {

	private String click;
	private String title;
	private TextView tv;
	private Button btn;
//	private static String URL = "http://news.maxjia.com/maxnews/app/list/?&offset=0&limit=2";
	private static String URL = "http://news.maxjia.com/maxnews/app/list/?&offset=0&limit=2";

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
				.url(URL)
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
					String res = response.body().string();
					Log.d("res===", res);
					try {
						JSONArray array = new JSONObject(res).getJSONArray("result");
						JSONObject object = array.getJSONObject(1);
						click = object.getString("click");
						title = object.getString("title");
					} catch (JSONException e) {
						e.printStackTrace();
					}
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
//							Toast.makeText(MainActivity.this, res, Toast.LENGTH_SHORT).show();
							tv.setText(title);
						}
					});

				}
			}
		});
	}
}
