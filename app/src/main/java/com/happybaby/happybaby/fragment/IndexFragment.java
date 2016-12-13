package com.happybaby.happybaby.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.happybaby.happybaby.R;

/**
 * 首页
 */
public class IndexFragment extends Fragment {

    private ImageView mImgTitleHomepage;
    private View mViewHomepage;
    private TabLayout mTablayout;
    private ViewPager mVpFrag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //解析布局
        View view = inflater.inflate(R.layout.fragment_index, container, false);
        initView(view);
        //OkHttpUtils okHttpUtils = OkHttpUtils.newInstance();



        return view;
    }

    private void initView(View view) {
        mImgTitleHomepage = (ImageView) view.findViewById(R.id.img_title_homepage);
        mViewHomepage = (View) view.findViewById(R.id.view_homepage);
        mTablayout = (TabLayout) view.findViewById(R.id.tablayout);
        mVpFrag = (ViewPager) view.findViewById(R.id.vp_frag);
    }
}
