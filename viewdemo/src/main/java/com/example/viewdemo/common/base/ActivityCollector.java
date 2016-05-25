package com.example.viewdemo.common.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by llbt on 2016/4/25.
 */
public class ActivityCollector {

	private static Stack<Activity> pageStack;
	private static ActivityCollector instance;

	public ActivityCollector(){
		pageStack = new Stack<>();
	}

	public static ActivityCollector getInstance(){
		if(instance == null){
			synchronized (ActivityCollector.class){
				if(instance == null){
					instance = new ActivityCollector();
				}
			}
		}
		return instance;
	}

	public void addActivity(Activity activity) {
		if(activity != null){
			pageStack.add(activity);
		}
	}

	public void removeActivity(Activity activity) {
		if(pageStack != null && activity != null){
			pageStack.remove(activity);
			activity.finish();
		}

	}

	public Activity getLastActivity(){
		return pageStack.lastElement();
	}

	public void finishAll(){
		int size = pageStack.size();
		for(int i =0; i < size; i++){
			removeActivity(getLastActivity());
		}
		pageStack.clear();
	}
}
