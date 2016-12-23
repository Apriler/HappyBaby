package com.happybaby.happybaby.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.FragmentAdapter;
import com.happybaby.happybaby.constant.MyConstant;
import com.happybaby.happybaby.constant.OverseasConstant;
import com.happybaby.happybaby.voerseasfragment.BlankFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverseasFragment extends Fragment {

    private FragmentAdapter adapter;

    private List<BlankFragment> dates;
    private TabLayout mTabLayoutOverseas;
    private ViewPager mViewpageOverseas;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overseas, container, false);

        initData();
        initView(view);


        return view;
    }

    private void initData() {
        dates=new ArrayList<>();
        for (int i = 0; i < OverseasConstant.COUNTRY_NAME.length; i++) {

            int count=OverseasConstant.COUNTRY_ID[i];
            BlankFragment fragment=new BlankFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(MyConstant.COUNTRY_KEY, count);
            fragment.setArguments(bundle);
            dates.add(fragment);
        }

    }

    private void initView(View view) {
        mTabLayoutOverseas = (TabLayout) view.findViewById(R.id.tab_layout_overseas);
        mViewpageOverseas = (ViewPager) view.findViewById(R.id.viewpage_overseas);
        adapter=new FragmentAdapter(getChildFragmentManager(),dates,OverseasConstant.COUNTRY_NAME);
        mViewpageOverseas.setAdapter(adapter);

        mTabLayoutOverseas.setupWithViewPager(mViewpageOverseas);
    }
}
