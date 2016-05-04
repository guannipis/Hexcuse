package com.example.okhttpclientmanager;

/**
 * Created by llbt on 2016/4/18.
 */
public class OkhttpClientManager {

	private OkhttpClientManager(){

	};
	private static class singletonLoader{
		private static final OkhttpClientManager Instance = new OkhttpClientManager();
	}

	public static OkhttpClientManager getInstance(){
		return singletonLoader.Instance;
	}

}
