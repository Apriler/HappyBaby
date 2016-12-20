package com.happybaby.happybaby.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class ViewAdapter extends PagerAdapter {
    private List<View> dates;

    public ViewAdapter(List<View> dates) {
        this.dates = dates;
    }

    @Override
    public int getCount() {
        return dates != null ? dates.size() : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view==object;
    }
//销毁
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {


        container.removeView((View) object);
    }
//创建
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = dates.get(position );
        container.addView(view);
        return view;
    }
}
