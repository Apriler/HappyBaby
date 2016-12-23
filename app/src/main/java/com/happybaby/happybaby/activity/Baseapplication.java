package com.happybaby.happybaby.activity;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2016/12/21.
 */

public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "6522770cbf901e04ebeb0c4960e4dbcc");
    }
}
