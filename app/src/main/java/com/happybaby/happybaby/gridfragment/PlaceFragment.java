package com.happybaby.happybaby.gridfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.google.gson.Gson;
import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.GridAdapter;
import com.happybaby.happybaby.bean.GridBean;
import com.happybaby.happybaby.contant.GridUrlContants;
import com.happybaby.happybaby.task.GridDownLoadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlaceFragment extends Fragment {
    private List<ImageView> views; //轮播图集合
    private ViewPager gridVp;   //格子圈轮播图
    private List<GridBean.DataBeanX> gridList; //轮播图数据源
    private LinearLayout addotLayout;  //轮播图圆点


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_place, container, false);

        initView(rootView);
        initData();
        return rootView;
    }


    private void initData() {
        gridList=new ArrayList<>();

    }

    //实例化视图
    private void initView(View rootView) {
        gridVp= (ViewPager) rootView.findViewById(R.id.grid_vp);
        views=new ArrayList<>();
        //打开异步下载
        GridDownLoadTask task= new GridDownLoadTask(GridUrlContants.GRID_BASE);
        task.setOnGridLoadListener(new GridDownLoadTask.OnGridLoadListener() {
            @Override
            public void downSuccess(String result) {
                //数据解析
                Gson gson=new Gson();
                GridBean gridBean=gson.fromJson(result,GridBean.class);
                List<GridBean.DataBeanX.DataBean.ListBean> list = gridBean.getData().get(0).getData().getList();
                for (int i = 0 ; i < list. size(); i ++){
                    String ad_pic = list.get(i).getAd_pic();
                    ImageView view = new ImageView(getContext());
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(getContext()).load(ad_pic).into(view);
                    views.add(view);
                }
                GridAdapter gridAdapter= new GridAdapter(views);
                gridVp.setAdapter(gridAdapter);
            }
        });
        task.execute();
        //实例化圆点，并与轮播图片绑定
        addotLayout= (LinearLayout) rootView.findViewById(R.id.addot_layout);
        gridVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                //改变圆点状态
                for (int i=0;i<addotLayout.getChildCount();i++){
                    ImageView iv= (ImageView) addotLayout.getChildAt(i); //获得圆点的view
                    if (i==position){ //当前圆点被选中
                        iv.setImageResource(R.mipmap.icon_single_event_indicator_check);
                    }else {
                        iv.setImageResource(R.mipmap.icon_single_event_indicator_normal);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });

    }

}
