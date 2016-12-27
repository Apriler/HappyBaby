package com.happybaby.happybaby.greendao;

import android.content.Context;

/**
 * Created by jianquan on 2016/12/26.
 */

public class DbManager {
    public static final String DB_NAME="happybaby.db";
    private static  DbManager dbManager;
    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private Context mContext;

    private DbManager(Context context) {
        this.mContext = context;
        //初始化数据库信息
        devOpenHelper=new DaoMaster.DevOpenHelper(context,DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }





    private void getDaoSession(Context context) {
    }

    private void getDaoMaster(Context context) {
    }
}
