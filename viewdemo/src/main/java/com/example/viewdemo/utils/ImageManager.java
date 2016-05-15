package com.example.viewdemo.utils;

import android.content.Context;
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

	private static ImageMemoryCache memoryCache = null;

	private ImageManager(){}

	private static class Instance{
		private static ImageManager instance = new ImageManager();
	}

	public static ImageManager getInstance(Context context){
		if(memoryCache == null){
			memoryCache = new ImageMemoryCache(context.getApplicationContext());
		}
		return Instance.instance;
	}



	/**
	 * 通过URL加载网络图片资源，效率略低，可以优化
	 * @param imageView
	 * @param url
	*/
	public void setBitmap(final ImageView imageView, final String url) {
		Bitmap bitmap = memoryCache.getBitmapFromCache(url);
		if(bitmap != null){
			imageView.setImageBitmap(bitmap);
			Log.d("cache====", url);
		}else{
			OkHttpUtils.get().url(url).build().execute(new BitmapCallback() {
				@Override
				public void onError(Request request, Exception e) {

				}

				@Override
				public void onResponse(final Bitmap response) {
					memoryCache.addBitmapToCache(url, response);
					imageView.setImageBitmap(response);

					Log.d("response====", url);
				}
			});
		}

	}
}
