package com.happybaby.happybaby.activity;

import android.app.Application;

import com.happybaby.happybaby.bean.User;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2016/12/21.
 */

public class BaseApplication extends Application{
   private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        BaseApplication.user = user;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "6522770cbf901e04ebeb0c4960e4dbcc");

    }
}
