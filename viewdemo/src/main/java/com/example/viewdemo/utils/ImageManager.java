package com.example.viewdemo.utils;

import android.graphics.Bitmap;
import android.util.Log;
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

	private static Bitmap bitmap;

	/**
	 * 通过URL加载图片，首先从内存缓存中加载，则请求网络获取
	 * 获取得到图片后，储存在内存中
	 *
	 * @param imageView
	 * @param url
	 */
	public static void setBitmapCache(final ImageView imageView, final String url) {
		String tag = (String) imageView.getTag();
		if (tag != null && tag.equals(url)) {
			bitmap = ImageMemoryCache.getInstance().getBitmapFromCache(url);
			if (bitmap != null) {
				imageView.setImageBitmap(bitmap);
				Log.d("cache====", url);
			} else {
				OkHttpUtils.get().url(url).build().execute(new BitmapCallback() {
					@Override
					public void onError(Request request, Exception e) {

					}

					@Override
					public void onResponse(final Bitmap response) {
						ImageMemoryCache.getInstance().addBitmapToCache(url, response);         //储存图片到缓存中
						imageView.setImageBitmap(response);

						Log.d("response====", url);
					}
				});
			}
		}
	}


	/**
	 * 通过URL加载图片，首先从内存缓存中加载，如果找不到，则从文件中加载，如果找不到，则请求网络获取
	 * 获取得到图片后，储存在内存中，并下载储存在sd卡里
	 *
	 * @param imageView
	 * @param url
	 */
	public static void setBitmap(final ImageView imageView, final String url) {
		String tag = (String) imageView.getTag();
		if (tag != null && tag.equals(url)) {
			bitmap = ImageMemoryCache.getInstance().getBitmapFromCache(url);
			if (bitmap != null) {
				imageView.setImageBitmap(bitmap);
				Log.d("cache====", url);
			} else {
				bitmap = ImageFileCache.getInstance().getBitmap(url);
				if (bitmap != null) {
					imageView.setImageBitmap(bitmap);
					Log.d("file====", url);
				} else {
					OkHttpUtils.get().url(url).build().execute(new BitmapCallback() {
						@Override
						public void onError(Request request, Exception e) {

						}

						@Override
						public void onResponse(final Bitmap response) {
							ImageMemoryCache.getInstance().addBitmapToCache(url, response);
							ImageFileCache.getInstance().saveBitmap(url, response);             //储存图片到SD卡中
							imageView.setImageBitmap(response);

							Log.d("response====", url);
						}
					});
				}
			}
		}
	}
}
