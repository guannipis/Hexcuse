package com.example.viewdemo.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/**
 * Created by guanni on 2016/5/14.
 * 图片内存缓存类
 * 从内存读取数据速度是最快的，为了更大限度使用内存，这里使用了两层缓存。
 * 硬引用缓存不会轻易被回收，用来保存常用数据，不常用的转入软引用缓存。
 */
public class ImageMemoryCache {

	private static ImageMemoryCache mInstance;
	private static final int SOFT_CACHE_SIZE = 15;  //软引用缓存容量
	private static LruCache<String, Bitmap> sLruCache;   //硬引用缓存
	private static LinkedHashMap<String, SoftReference<Bitmap>> sSoftReference;     //软引用缓存

	/**
	 * 单例模式
	 */
	public static ImageMemoryCache getInstance(){
		if(mInstance == null){
			synchronized (ImageMemoryCache.class){
				if(mInstance == null){
					mInstance = new ImageMemoryCache();
				}
			}
		}
		return mInstance;
	}

	public ImageMemoryCache() {
		int messMemory = (int) Runtime.getRuntime().maxMemory();   //获取手机内存
		int cacheSize = messMemory / 8;         //最大缓存为内存的四分之一
		// 0.75是加载因子为经验值，true则表示按照最近访问量的高低排序，false则表示按照插入顺序排序
		sSoftReference = new LinkedHashMap<String, SoftReference<Bitmap>>(SOFT_CACHE_SIZE, 0.75f, false){
			@Override
			protected boolean removeEldestEntry(Entry eldest) {
				if(size() > SOFT_CACHE_SIZE){
					return true;
				}else{
					return false;
				}
			}
		};
		sLruCache = new LruCache<String, Bitmap>(cacheSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				if(value != null){
					return value.getByteCount();      //返回图片大小
				}else {
					return 0;
				}
			}

			@Override
			protected void entryRemoved(boolean evicted, String key, Bitmap oldValue, Bitmap newValue) {
				// 硬引用缓存容量满的时候，会根据LRU算法把最近没有被使用的图片转入此软引用缓存
				if(oldValue != null){
					sSoftReference.put(key, new SoftReference<Bitmap>(oldValue));
				}
			}
		};
	}

	/**
	 * 从缓存中获取图片
	 */
	public Bitmap getBitmapFromCache(String url){
		Bitmap bitmap;
		//先从硬引用缓存中获取
		synchronized (sLruCache){
			bitmap = sLruCache.get(url);
			if(bitmap != null){
				//如果找到的话，把元素移到LinkedHashMap的最前面，从而保证在LRU算法中是最后被删除
				sLruCache.remove(url);
				sLruCache.put(url, bitmap);
				return bitmap;
			}
		}
		//如果硬引用缓存中找不到，到软引用缓存中找
		synchronized (sSoftReference){
			SoftReference<Bitmap> bitmapSoftReference = sSoftReference.get(url);
			if(bitmapSoftReference != null){
				bitmap = bitmapSoftReference.get();
				if(bitmap != null){
					sSoftReference.remove(url);
					sLruCache.put(url, bitmap);
					return bitmap;
				}else {
					sSoftReference.remove(url);
				}
			}
		}
		return null;
	}

	/**
	 * 添加图片到缓存
	 */
	public void addBitmapToCache(String url, Bitmap bitmap){
		if(bitmap != null){
			synchronized (sLruCache){
				sLruCache.put(url, bitmap);
			}
		}
	}

	/**
	 * 清除所有缓存
	 */
	public void clearCache(){
		sSoftReference.clear();
	}
}
