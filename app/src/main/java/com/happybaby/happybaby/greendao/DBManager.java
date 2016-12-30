package com.happybaby.happybaby.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2016/12/29.
 */

public class DBManager {
    private static final String DB_NAME = "happybaby.db";
    private static DBManager dbManager;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static DaoMaster.DevOpenHelper devOpenHelper;
    private Context context;
    private DBManager(Context context) {
        this.context= context;
        devOpenHelper= new DaoMaster.DevOpenHelper(context,DB_NAME);
        getDaoMaster(context);
        getDaoSession(context);
    }
    /**
     * 获得单例 DbManager 对象
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context){
        if (null == dbManager){
            synchronized (DBManager.class){
                if (null == dbManager){
                    dbManager= new DBManager(context);
                }
            }
        }
        return dbManager;
    }

    public static SQLiteDatabase getReadableDatabase(Context context){
        if (null==devOpenHelper){
            getInstance(context);
        }
        return devOpenHelper.getReadableDatabase();
    }

    public static DaoMaster getDaoMaster(Context context){
        if (null == daoMaster){
            synchronized (DaoMaster.class){
                if (null == daoMaster){
                    daoMaster = new DaoMaster(getReadableDatabase(context));
                }
            }
        }
        return  daoMaster;
    }

    public static DaoSession getDaoSession(Context context){
        if (null == daoSession){
            synchronized (DaoSession.class){
                if (null == daoSession){
                    daoSession= getDaoMaster(context).newSession();
                }
            }
        }
    return daoSession;
    }

}
