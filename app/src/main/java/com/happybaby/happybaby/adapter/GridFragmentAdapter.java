package com.happybaby.happybaby.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by jianquan on 2016/12/13.
 */

public class GridFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private List<String> stringList;

    public GridFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> stringList) {
        super(fm);
        this.fragments = fragments;
        this.stringList = stringList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return stringList.get(position);
    }
}
