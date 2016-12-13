package com.happybaby.happybaby.index_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.happybaby.happybaby.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Index_firstFragment extends Fragment {


    public Index_firstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_index_first, container, false);
    }

}
