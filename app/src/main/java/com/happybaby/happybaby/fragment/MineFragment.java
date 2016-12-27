package com.happybaby.happybaby.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.BaseApplication;
import com.happybaby.happybaby.activity.ChangeUserNameActivity;
import com.happybaby.happybaby.activity.LoginActivity;
import com.happybaby.happybaby.activity.RegisterActivity;
import com.happybaby.happybaby.bean.User;
import com.happybaby.happybaby.inter.ProgressBarInter;
import com.happybaby.happybaby.login_fragment.QuickFragment;
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
public class MineFragment extends Fragment implements View.OnClickListener,ProgressBarInter{


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
    private LinearLayout mLlMine;//我的界面头部
    public static boolean flag = false;
    private LinearLayout mLlMineIslogin;
    private TextView mTvUserName;//名字
    private TextView mTvUserText;//签名
    private ProgressBar mProgressBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        StartProgressBar();
        if (flag) {
            mLlMine.setVisibility(View.INVISIBLE);//登陆成功，显示个人头像
            mLlMineIslogin.setVisibility(View.VISIBLE);
            User user = BaseApplication.getUser();
            mTvUserName.setText(user.getUsername());

        } else {
            mLlMine.setVisibility(View.VISIBLE);//登陆不成功
            mLlMineIslogin.setVisibility(View.INVISIBLE);
        }
        StopProgressBar();
    }

    private void initView(View view) {
        mPersonTvLogin = (TextView) view.findViewById(R.id.person_tv_login);

        mPersonTvLogin.setOnClickListener(this);
        mPersonTvRegister = (TextView) view.findViewById(R.id.person_tv_register);
        mPersonTvRegister.setOnClickListener(this);
        mLlMine = (LinearLayout) view.findViewById(R.id.ll_mine_notlogin);
        mLlMine.setOnClickListener(this);
        mLlMineIslogin = (LinearLayout) view.findViewById(R.id.ll_mine_islogin);
        mLlMineIslogin.setOnClickListener(this);
        mTvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        mTvUserName.setOnClickListener(this);
        mTvUserText = (TextView) view.findViewById(R.id.tv_user_text);
        mTvUserText.setOnClickListener(this);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);

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
            case R.id.ll_mine_notlogin://没有登录的时候
                intent.setClass(getActivity(), LoginActivity.class);
                break;
            case R.id.ll_mine_islogin://登录的时候
                intent.setClass(getActivity(), ChangeUserNameActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void StartProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void StopProgressBar() {
        mProgressBar.setVisibility(View.GONE);
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
