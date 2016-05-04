package com.example.llbt.hexcuse;

import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * Created by llbt on 2016/4/18.
 */
public class OkHttpClientManager {

	private OkHttpClient mOkHttpClient;
	private Handler mDelivery;

	private static class singletonLoader{
		private static final OkHttpClientManager mInstance = new OkHttpClientManager();
	}
	public static OkHttpClientManager getInstance(){
		return singletonLoader.mInstance;
    }

	private OkHttpClientManager(){
		mOkHttpClient = new OkHttpClient();
		mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
		mDelivery = new Handler(Looper.getMainLooper());
	}


	public static abstract class ResultCallback<T>{

		public abstract void onError(Request request);

		public abstract void onResponse(T response);
	}



}
