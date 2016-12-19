package com.happybaby.happybaby.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.GridFragmentAdapter;
import com.happybaby.happybaby.gridfragment.FollowFragment;
import com.happybaby.happybaby.gridfragment.PlaceFragment;

import java.util.ArrayList;
import java.util.List;


public class GridFragment extends Fragment {

    private TabLayout gridTab;   //格子圈tab
    private FollowFragment followFragment;  //关注画面Fragment
    private PlaceFragment placeFragment;  //广场画面Fragment
    private GridFragmentAdapter gridFragmentAdapter; //tabLayout的adapter
    private List<Fragment> fraglist;        //fragment集合
    private List<String> Strlist;       //tab文言的集合
    private ViewPager fragVp;           //与tab关联的ViewPager
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_grid, container, false);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        gridTab= (TabLayout) rootView.findViewById(R.id.grid_tab);  //实例化格子圈tablayout
        followFragment=new FollowFragment();        //实例化关注画面Fragment
        placeFragment=new PlaceFragment();          //实例化广场  画面Fragment
        fraglist= new ArrayList<>();
        Strlist= new ArrayList<>();
        fragVp= (ViewPager) rootView.findViewById(R.id.frag_vp);
        fraglist.add(placeFragment);
        fraglist.add(followFragment);
        Strlist.add("广场");
        Strlist.add("关注");
        gridFragmentAdapter=new GridFragmentAdapter(getChildFragmentManager(),fraglist,Strlist);
        fragVp.setAdapter(gridFragmentAdapter);
        gridTab.setupWithViewPager(fragVp);
    }


}
