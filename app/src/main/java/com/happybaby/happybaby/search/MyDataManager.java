package com.happybaby.happybaby.search;

import android.content.Context;

import com.happybaby.happybaby.greendao.DaoSession;
import com.happybaby.happybaby.greendao.MyDataDao;

import java.util.List;

/**
 * Created by jianquan on 2016/12/29.
 */

public class MyDataManager {

    private MyDataDao mDataDao;

    public MyDataManager(Context context) {
        DaoSession daoSession = DBHelper.getDaoSession(context);
        mDataDao = daoSession.getMyDataDao();
    }

    //插入一条数据
    public void insert(MyData stu) throws Exception {
        if (stu == null) {
            return;
        }
        mDataDao.insert(stu);
    }

    //查找所有数据
    public List<MyData> getAll() throws Exception{
        return mDataDao.queryBuilder().list();
    }
    //清空所有数据
    public void deleteAll(){
        mDataDao.deleteAll();
    }


}
