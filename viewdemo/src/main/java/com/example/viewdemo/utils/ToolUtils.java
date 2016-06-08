package com.example.viewdemo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Hexcuse on 2016/6/3.
 *
 * @Package ${package_name}.${file_name}.
 * @ClassName: ${type_name}.
 * @Description: ${todo}(用一句话描述该文件做什么).
 */
public class ToolUtils {

	public static String getVersion(Context context){
		try {
			PackageManager manager = context.getApplicationContext().getPackageManager();
			PackageInfo info = manager.getPackageInfo(context.getApplicationContext().getPackageName(), 0);
			String version = info.versionName;
			return version;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
