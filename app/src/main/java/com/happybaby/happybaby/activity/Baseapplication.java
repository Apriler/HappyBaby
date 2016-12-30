package com.happybaby.happybaby.activity;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.happybaby.happybaby.bean.User;
import com.happybaby.happybaby.greendao.DBManager;
import com.happybaby.happybaby.greendao.DaoMaster;
import com.happybaby.happybaby.greendao.ShoppoingCartManager;
import com.happybaby.happybaby.shopping_fragment.OkHttpClientHelper;

import java.io.InputStream;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2016/12/21.
 */

public class BaseApplication extends Application{
    public static BaseApplication app;
    private static User user;

    public DBManager dbManager;
    private ShoppoingCartManager manager;
    public SQLiteDatabase db;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        BaseApplication.user = user;
    }

    public ShoppoingCartManager getManager() {
        return manager;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
        Bmob.initialize(this, "6522770cbf901e04ebeb0c4960e4dbcc");
        app = this;
        dbManager= DBManager.getInstance(this);
        db=DBManager.getReadableDatabase(this);
        manager= new ShoppoingCartManager(this);

    }


//    private void initDatabase() {
//        helper = new DaoMaster.DevOpenHelper(this, "db_grid", null);
//        db = helper.getWritableDatabase();
//        daoMaster = new DaoMaster(db);
//
//        daoSession = daoMaster.newSession();
//    }
//    public static BaseApplication newInstance(){
//        return app;
//    }
//    public DaoSession getDaoSession(){
//        return daoSession;
//    }
//
//    public SQLiteDatabase getDb(){
//        return db;
//    }
//
//    private void initGlide() {
//        Glide.get(this).register(
//                GlideUrl.class,
//                InputStream.class,
//                new OkHttpUrlLoader.Factory(OkHttpClientHelper.getOkHttpSingletonInstance())
//        );
//    }
}
