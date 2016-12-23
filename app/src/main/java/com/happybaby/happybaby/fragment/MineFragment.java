package com.happybaby.happybaby.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.LoginActivity;
import com.happybaby.happybaby.activity.RegisterActivity;
//import com.yztc.youbadbad.ui.other.activity.LogInActivity;
//import com.yztc.youbadbad.ui.other.activity.RegisterActivity;
//import com.yztc.youbadbad.ui.other.activity.SetActivity;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment implements View.OnClickListener {


    //    @BindView(R.id.ivSetting)
//    ImageView ivSetting;
//    @BindView(R.id.iv_message_lay)
//    ImageView ivMessageLay;
//    @BindView(R.id.person_tv_login)
//    TextView personTvLogin;
//    @BindView(R.id.person_tv_register)
//    TextView personTvRegister;
    private Context mContext;
    private TextView mPersonTvLogin;
    private TextView mPersonTvRegister;


    public MineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mPersonTvLogin = (TextView) view.findViewById(R.id.person_tv_login);

        mPersonTvLogin.setOnClickListener(this);
        mPersonTvRegister = (TextView) view.findViewById(R.id.person_tv_register);
        mPersonTvRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.person_tv_login://跳转到登录
                intent.setClass(getActivity(), LoginActivity.class);
                break;

            case R.id.person_tv_register://跳转到注册
                intent.setClass(getActivity(), RegisterActivity.class);
                break;
        }
        startActivity(intent);
    }

//
//    @OnClick({R.id.ivSetting, R.id.iv_message_lay, R.id.person_tv_login,R.id.person_tv_register})
//    public void onClick(View view) {
//        Intent intent = new Intent();
//        switch (view.getId()) {
//            case R.id.ivSetting:
//                intent.setClass(mContext,SetActivity.class);
//                 startActivity(intent);
//                break;
//            case R.id.iv_message_lay:
//                intent.setClass(mContext, LogInActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.person_tv_login:
//                intent.setClass(mContext,LogInActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.person_tv_register:
//                intent.setClass(mContext,RegisterActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }


}
