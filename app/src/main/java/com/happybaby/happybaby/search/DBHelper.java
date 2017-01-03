package com.happybaby.happybaby.search;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.happybaby.happybaby.greendao.DaoMaster;
import com.happybaby.happybaby.greendao.DaoSession;


/**
 * Created by Administrator on 2016/12/29.
 */

public class DBHelper {
	private static final String DB_NAME = "bodhixu.db"; //数据库的名字

	private static DBHelper dbHelper;
	private static DaoMaster.DevOpenHelper devOpenHelper;
	private static DaoMaster daoMaster;
	private static DaoSession daoSession;

	//私有化构造方法
	private DBHelper(Context context) {
		devOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME);
	}

	//单例模式获得工具类对象
	public static DBHelper newInstance(Context context) {
		if (null == dbHelper) {
			synchronized (DBHelper.class) {
				if (null == dbHelper) {
					dbHelper = new DBHelper(context);
				}
			}
		}
		return dbHelper;
	}

	//获取数据库
	public static SQLiteDatabase getReadableDatabase(Context context) {
		newInstance(context);
		return devOpenHelper.getReadableDatabase();
	}

	//获得DaoMaster的单例
	public static DaoMaster getDaoMaster(Context context) {
		if (null == daoMaster) {
			synchronized (DBHelper.class) {
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
			synchronized (DBHelper.class) {
				if (null == daoSession) {
					daoSession = getDaoMaster(context).newSession();
				}
			}
		}
		return daoSession;
	}

}
