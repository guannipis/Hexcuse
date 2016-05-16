package com.example.viewdemo.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.PublicKey;

/**
 * Created by guanni on 2016/5/15.
 */
public class ImageFileCache {


	private static ImageFileCache mInstance;
	private static final String CACHEID = "ViewDemo";
	private static final String WHOLESALE_CONV = ".cache";

	public ImageFileCache() {

	}

	public static ImageFileCache getInstance() {
		if (mInstance == null) {
			synchronized (ImageFileCache.class) {
				if (mInstance == null) {
					mInstance = new ImageFileCache();
				}
			}
		}
		return mInstance;
	}

	/**
	 * 从缓存文件中获取图片
	 *
	 * @param url
	 * @return
	 */
	public Bitmap getBitmap(String url) {
		String path = getDirectory() + "/" + convertUrlToFileName(url);
		File file = new File(path);
		if (file.exists()) {
			Bitmap bitmap = BitmapFactory.decodeFile(path);
			if (bitmap == null) {
				file.delete();
			} else {
				updateFileTime(path);
				return bitmap;
			}
		}
		return null;
	}

	/**
	 * 缓存图片到文件中
	 *
	 * @param url
	 * @param bitmap
	 */
	public void saveBitmap(String url, Bitmap bitmap) {
		if (bitmap == null) {
			return;
		}

		String fileName = convertUrlToFileName(url);
		Log.d("fileName", fileName);
		String dir = getDirectory();
		File dirFile = new File(dir);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		File file = new File(dir + "/" + fileName);
		try {
			file.createNewFile();
			OutputStream outputStream = new FileOutputStream(file);
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将URL转成文件名储存
	 */
	private String convertUrlToFileName(String url) {
		String[] strs = url.split("/");
		return strs[strs.length - 1] + strs[strs.length - 2] + WHOLESALE_CONV;
	}

	/**
	 * 得到缓存目录
	 *
	 * @return
	 */
	private String getDirectory() {
		return getSDCardPath() + "/" + CACHEID;
	}

	/**
	 * 修改文件的最后修改时间
	 **/
	public void updateFileTime(String path) {
		File file = new File(path);
		long newModifiedTime = System.currentTimeMillis();
		file.setLastModified(newModifiedTime);
	}

	/**
	 * 得到SD卡路径
	 *
	 * @return
	 */
	private String getSDCardPath() {
		boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		if (sdCardExist) {
			return Environment.getExternalStorageDirectory().toString();
		}
		return null;
	}

}
