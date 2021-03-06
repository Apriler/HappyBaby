package com.happybaby.happybaby.adapter;



import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.List;

/**
 * Created by Administrator on 2016/12/19.
 */

public class ProductADAdapter extends PagerAdapter {
    private List<ImageView> listViews;

    public ProductADAdapter(List<ImageView> listViews) {
        this.listViews = listViews;
    }

    //销毁视图
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(listViews.get(position));
    }
    @Override
    public int getCount() {
        return listViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    //创建视图
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view=listViews.get(position);
        container.addView(view);
        return view;
    }
}
