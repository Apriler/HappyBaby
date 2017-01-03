package com.happybaby.happybaby.search;

import android.content.Context;

import com.happybaby.happybaby.contant.IndexUrlContants;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络的工具类
 */

public class OkHttpClientUtils {
	private static OkHttpClientUtils mOkHttpClientUtils;  //本类对象的单例模式

	private static OkHttpClient mOkHttpClient;//OkHttpClient 的单例模式

	private OkHttpClientUtils() {

	}

	//获取 OkHttpClient  单例模式
	public static OkHttpClient newOkHttpClient(Context context) {
		if (mOkHttpClient == null) {
			synchronized (OkHttpClientUtils.class) {
				if (mOkHttpClient == null) {
					int cacheSize = 10 << 20; // 10 MiB
					//设置缓存
					Cache cache = new Cache(context.getCacheDir(), cacheSize);
					mOkHttpClient = new OkHttpClient().newBuilder()
							.connectTimeout(10, TimeUnit.SECONDS)
							.readTimeout(15, TimeUnit.SECONDS)
							.writeTimeout(15, TimeUnit.SECONDS)
							.cache(cache) //设置缓存
							.build();
				}
			}
		}
		return mOkHttpClient;
	}

	public static Retrofit getRetrofit(Context context,String url) {
		Retrofit retrofit = new Retrofit.Builder()
				.client(newOkHttpClient(context))
				.baseUrl(url)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
				.build();
		return retrofit;
	}

	//获取OkHttpUtils  单例模式
	public static OkHttpClientUtils newOkHttpUtils() {
		if (mOkHttpClientUtils == null) {
			synchronized (OkHttpClientUtils.class) {
				if (mOkHttpClientUtils == null) {
					mOkHttpClientUtils = new OkHttpClientUtils();
				}
			}
		}
		return mOkHttpClientUtils;
	}

}
