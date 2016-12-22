package com.happybaby.happybaby.gridfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happybaby.happybaby.R;


public class FollowFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_follow, container, false);
        initView();
        return rootView;
    }

    private void initView() {
    }

}
