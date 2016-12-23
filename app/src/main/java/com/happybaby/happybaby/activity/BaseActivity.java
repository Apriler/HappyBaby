package com.happybaby.happybaby.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.happybaby.happybaby.R;

import cn.bmob.v3.Bmob;





/**
 * Created by bodhixu on 2016/11/28.
 * Activity的基类
 * 在子类中可以随意调用Toast方法，和改变状态栏颜色的方法，
 */

public class BaseActivity extends AppCompatActivity {

    private Toast toast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addStatusBar(getResources().getColor(R.color.colorPrimary));

    }

    //显示Toast
    protected void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }
    protected void loge(String s){
        Log.e("data",s);
    }

    /**
     * 用颜色填充状态栏
     * @param color
     */
    public void addStatusBar(int color) {
        View statusBarView = new View(this);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                getStatusBarHeight(this));
        statusBarView.setBackgroundColor(color);

        ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
        contentView.addView(statusBarView, lp);
    }

    /**
     * 获得状态栏高度
     * @param context
     * @return
     */
    public int getStatusBarHeight(Context context)
    {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
    //Activity的转场动画
    public void gotoActivity( Context context,Class<?> cls){
        Intent intent = new Intent(context, cls);
        startActivity(intent);
        overridePendingTransition(R.anim.in, R.anim.out);
    }

}
