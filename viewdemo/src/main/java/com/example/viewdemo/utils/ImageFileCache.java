package com.example.viewdemo.utils;

import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.security.PublicKey;

/**
 * Created by guanni on 2016/5/15.
 */
public class ImageFileCache {

	private static final String CACHEID = "ViewDemo";

	public ImageFileCache() {

	}

	public Bitmap getBitmap(String url){

	}

	public void saveBitmap(String url, Bitmap bitmap){

	}

	/**
	 * 得到缓存目录
	 * @return
	 */
	private String getDirectory(){
		return getSDCardPath() + "/" + CACHEID;
	}

	/**
	 * 得到SD卡路径
	 * @return
	 */
	private String getSDCardPath(){
		boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		if(sdCardExist){
			return Environment.getExternalStorageDirectory().toString();
		}
		return null;
	}

}
