package com.happybaby.happybaby.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by jianquan on 2016/12/26.
 * 数据库管理基类
 */

public class ShoppingCartDBHelper {
    public static final String DB_NAME="happybaby.db";
    private static ShoppingCartDBHelper cartDBHelper;
    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    //私有化构造方法
    private ShoppingCartDBHelper(Context context) {
        //初始化数据库信息
        devOpenHelper=new DaoMaster.DevOpenHelper(context,DB_NAME);

    }

    //单例模式获工具类对象
    public static ShoppingCartDBHelper newInstance(Context context){
        if (null==cartDBHelper){
            synchronized (ShoppingCartDBHelper.class){
                if (null==cartDBHelper){
                    cartDBHelper=new ShoppingCartDBHelper(context);
                }
            }
        }
        return cartDBHelper;
    }

    //获取数据库
    public static SQLiteDatabase getReadableDatabase(Context context){
        newInstance(context);
        return devOpenHelper.getReadableDatabase();
    }

    //获得DaoMaster的单例
    public static DaoMaster getDaoMaster(Context context) {
        if (null == daoMaster) {
            synchronized (ShoppingCartDBHelper.class) {
                if (null == daoMaster) {
                    daoMaster = new DaoMaster(getReadableDatabase(context));
                }
            }
        }
        return daoMaster;
    }

    //获得DaoSession单例
    public static DaoSession getDaoSession(Context context) {
        if (null == daoSession) {
            synchronized (ShoppingCartDBHelper.class) {
                if (null == daoSession) {
                    daoSession = getDaoMaster(context).newSession();
                }
            }
        }
        return daoSession;
    }





}
