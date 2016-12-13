package com.happybaby.happybaby.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 首页viewpager+tablayout的适配器
 */
public class ContentAdapter extends FragmentPagerAdapter {

	List<Fragment> mFragmentList;
	List<String> mStrList;

	public ContentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> strList) {
		super(fm);
		this.mFragmentList = fragments;
		this.mStrList = strList;
	}

	@Override
	public int getCount() {
		return mFragmentList != null ? mFragmentList.size() : 0;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragmentList != null ? mFragmentList.get(position) : null;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return mStrList != null ? mStrList.get(position) : "";
	}
}
