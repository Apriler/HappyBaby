package com.happybaby.happybaby.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.happybaby.happybaby.R;



public class GridFragment extends Fragment {

    private TableLayout gridTab;   //格子圈tab

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_grid, container, false);

        return rootView;
    }


}
