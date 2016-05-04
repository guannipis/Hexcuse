package com.example.viewdemo.common.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * Created by llbt on 2016/4/25.
 */
public class ActivityCollector {

	private static Stack<Object> pageStack;

	public ActivityCollector(){
		pageStack = new Stack<>();
	}

	public static void addActivity(Object object) {
		if(!pageStack.contains(object)){
			pageStack.add(object);
		}
	}

	public static void removeActivity(Object object) {
		if(object instanceof Activity){
			((Activity)object).finish();
		}else if(object instanceof Fragment){
			((Fragment)object).getActivity().finish();
		}
		pageStack.remove(object);
	}

	public static void finishAll(){
		int size = pageStack.size();
		for(int i =0; i < size; i++){
			removeActivity(pageStack.get(i));
		}
		pageStack.clear();
	}
}
