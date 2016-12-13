package com.happybaby.happybaby.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.GridBean;
import com.happybaby.happybaby.contant.GridUrlContants;
import com.happybaby.happybaby.task.GridDownLoadTask;

import java.util.ArrayList;
import java.util.List;


public class GridFragment extends Fragment {

    private List<View> views; //轮播图集合
    private TabLayout gridTab;   //格子圈tab
    private ViewPager gridVp;   //格子圈轮播图
    private List<GridBean.DataBeanX> gridList; //轮播图数据源
    private LinearLayout addotLayout;  //轮播图圆点


    //轮播图的下载回调
    private GridDownLoadTask.OnGridLoadListener onGridLoadListener=new GridDownLoadTask.OnGridLoadListener() {
        @Override
        public void downSuccess(String result) {
            //数据解析
            Gson gson=new Gson();
            GridBean gridBean=gson.fromJson(result,GridBean.class);
            gridList=gridBean.getData();
            for (GridBean.DataBeanX gdata:gridList){



            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_grid, container, false);

        initView(rootView);
        initData();
        return rootView;
    }

    private void initData() {
        gridList=new ArrayList<>();

    }

    //实例化视图
    private void initView(View rootView) {
        gridTab= (TabLayout) rootView.findViewById(R.id.grid_tab);
        gridVp= (ViewPager) rootView.findViewById(R.id.grid_vp);


    }

}
