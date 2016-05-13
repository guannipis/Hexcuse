package com.example.viewdemo.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

/**
 * Created by Hexcuse on 2016/5/13.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class ImageManager {

	/**
	 * 通过URL加载网络图片资源，效率略低，可以优化
	 * @param imageView
	 * @param url
	 */
	public static void setBitmap(final ImageView imageView, String url) {
		OkHttpUtils.get().url(url).build().execute(new BitmapCallback() {
			@Override
			public void onError(Request request, Exception e) {

			}

			@Override
			public void onResponse(final Bitmap response) {
				imageView.setImageBitmap(response);
			}
		});
	}
}
