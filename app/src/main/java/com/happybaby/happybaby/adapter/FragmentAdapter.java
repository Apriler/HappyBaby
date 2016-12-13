package com.happybaby.happybaby.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.happybaby.happybaby.voerseasfragment.BlankFragment;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    private List<BlankFragment> dates;
   private String[] mStrList;

    public FragmentAdapter(FragmentManager fm, List<BlankFragment> dates, String[] mStrList) {
        super(fm);
        this.dates=dates;
        this.mStrList=mStrList;
    }

    @Override
    public Fragment getItem(int position) {
        return dates.get(position);
    }



    @Override
    public int getCount() {
        return dates!=null?dates.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return mStrList!=null?mStrList[position]:"";


    }
}
