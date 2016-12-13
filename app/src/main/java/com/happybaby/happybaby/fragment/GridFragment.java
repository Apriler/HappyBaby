package com.happybaby.happybaby.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.GridBean;

import java.util.List;


public class GridFragment extends Fragment {

    private TabLayout gridTab;   //格子圈tab
    private ViewPager gridVp;   //格子圈轮播图
    private List<GridBean.DataBeanX> gridList; //轮播图数据源
    private LinearLayout addotLayout;  //轮播图圆点


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_grid, container, false);

        initView(rootView);
        return rootView;
    }

    //实例化视图
    private void initView(View rootView) {




    }

}
