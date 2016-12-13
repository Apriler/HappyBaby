package com.happybaby.happybaby.task;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.happybaby.happybaby.util.HttpUtils;

import java.io.IOException;

/**
 * Created by jianquan on 2016/12/13.
 *
 */

public class GridDownLoadTask extends AsyncTask<Void,Void,String> {


    private String urlStr;
    private OnGridLoadListener onGridLoadListener;

    public void setOnGridLoadListener(OnGridLoadListener onGridLoadListener) {
        this.onGridLoadListener = onGridLoadListener;
    }

    public GridDownLoadTask(String urlStr) {
        this.urlStr = urlStr;
//        this.onGridLoadListener = onGridLoadListener;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            String result= HttpUtils.getString(urlStr);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //把result传递给调用者
        if (!TextUtils.isEmpty(result)){
            onGridLoadListener.downSuccess(result);
        }

    }


    public interface OnGridLoadListener{
        void downSuccess(String result);
    }

}
