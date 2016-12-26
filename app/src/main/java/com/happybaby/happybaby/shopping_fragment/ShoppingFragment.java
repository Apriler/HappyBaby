package com.happybaby.happybaby.shopping_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.happybaby.happybaby.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment implements View.OnClickListener{

    private TextView editTv;  //编辑点击
    private Boolean booleanTv=false;
    private RelativeLayout allLayout,commandLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_shopping, container, false);
        initView(rootView);


        return rootView;
    }

    private void initView(View rootView) {
        editTv= (TextView) rootView.findViewById(R.id.edit_tv);
        allLayout= (RelativeLayout) rootView.findViewById(R.id.all_layout);
        commandLayout= (RelativeLayout) rootView.findViewById(R.id.command_layout);
        editTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Tag","++++++++++++++++++++++=");

                if (booleanTv=!booleanTv){
                    editTv.setText("完成");
                    commandLayout.setVisibility(View.GONE);
                    allLayout.setVisibility(View.VISIBLE);



                }else {
                    editTv.setText("编辑");
                    allLayout.setVisibility(View.GONE);
                    commandLayout.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edit_tv:


                break;



        }


    }
}
