package com.happybaby.happybaby.gridfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private LinearLayout addotLayout;  //轮播图圆点
    private List<GridBean.DataBeanX.DataBean.ListBean> list;  //轮播图网址

    private List<GridBean.DataBeanX.DataBean.ListBean> themeList;  //热门图片网址
    private LayoutInflater mInflater;  //布局解析

    private ViewPager mGridVp;    //热门图片ViewPager
    private LinearLayout mIdGallery;  //热门的图片和文言布局


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        mInflater=LayoutInflater.from(getContext());
        initView(rootView);
        initData();
        return rootView;
    }


    private void initData() {
        themeList = new ArrayList<>();

    }

    //初始化视图
    private void initView(final View rootView) {
        gridVp = (ViewPager) rootView.findViewById(R.id.grid_vp);
        views = new ArrayList<>();  //实例化轮播图集合

        //打开异步下载
        GridDownLoadTask task = new GridDownLoadTask(GridUrlContants.GRID_BASE);
        task.setOnGridLoadListener(new GridDownLoadTask.OnGridLoadListener() {
            @Override
            public void downSuccess(String result) {
                //数据解析
                Gson gson = new Gson();
                GridBean gridBean = gson.fromJson(result, GridBean.class);

                //轮播图加载
                list = gridBean.getData().get(0).getData().getList();
                for (int i = 0; i < list.size(); i++) {
                    String ad_pic = list.get(i).getAd_pic();
                    ImageView view = new ImageView(getContext());
                    view.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(getContext()).load(ad_pic).into(view);
                    views.add(view);
                }
                GridAdapter gridAdapter = new GridAdapter(views);
                gridVp.setAdapter(gridAdapter);

                //热门图片模块加载
                themeList = gridBean.getData().get(1).getData().getList();
                    for (int i = 0; i < themeList.size(); i++) {
                    //获取滑动布局的viewgroup
                    View itemForScrollView = mInflater.inflate(R.layout.place_hot_view, mIdGallery, false);
                    //滑动布局的两个组件
                    ImageView mIvItem = (ImageView) itemForScrollView.findViewById(R.id.pic_iv);
                    TextView mTvItem = (TextView) itemForScrollView.findViewById(R.id.name_tv);
                    //循环添加数据
                    Picasso.with(getContext()).load(themeList.get(i).getTag_image()).into(mIvItem);
                    mTvItem.setText(themeList.get(i).getTag_name());
                    mIdGallery.addView(itemForScrollView);
                }
                //全球达人模块


            }
        });
        task.execute();
        //实例化圆点，并与轮播图片绑定
        addotLayout = (LinearLayout) rootView.findViewById(R.id.addot_layout);
        gridVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                //改变圆点状态
                for (int i = 0; i < addotLayout.getChildCount(); i++) {
                    ImageView iv = (ImageView) addotLayout.getChildAt(i); //获得圆点的view
                    if (i == position) { //当前圆点被选中
                        iv.setImageResource(R.mipmap.icon_single_event_indicator_check);
                    } else {
                        iv.setImageResource(R.mipmap.icon_single_event_indicator_normal);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mGridVp = (ViewPager) rootView.findViewById(R.id.grid_vp);

        mIdGallery = (LinearLayout) rootView.findViewById(R.id.id_gallery);
    }

}
