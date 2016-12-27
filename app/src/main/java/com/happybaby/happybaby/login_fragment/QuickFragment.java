package com.happybaby.happybaby.login_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.activity.BaseApplication;
import com.happybaby.happybaby.activity.LoginActivity;
import com.happybaby.happybaby.activity.RegisterActivity;
import com.happybaby.happybaby.bean.User;
import com.happybaby.happybaby.fragment.MineFragment;

import org.greenrobot.eventbus.EventBus;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
//import com.yztc.youbadbad.App;


/**
 * 快速登录
 */
public class QuickFragment extends Fragment implements View.OnClickListener {


    private EditText mPhonenumber;
    private EditText mPassword;
    private Button mLoginButton;
    private TextView mTextViewRegister;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quick, container, false);
        initView(view);

        return view;
//        return super.onCreateView(inflater,container,savedInstanceState);

    }

    private void initView(View view) {
        mPhonenumber = (EditText) view.findViewById(R.id.phonenumber);
        mPassword = (EditText) view.findViewById(R.id.password);
        mLoginButton = (Button) view.findViewById(R.id.btn_biglogin);

        mLoginButton.setOnClickListener(this);
        mTextViewRegister = (TextView) view.findViewById(R.id.textView_register);
        mTextViewRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.textView_register:
//
                Intent intent= new Intent(getContext(), RegisterActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_biglogin:
                submit();//denglu

                break;
        }
    }

    private void submit() {
        // validate
        String phonenumberString = mPhonenumber.getText().toString().trim();
        Log.e("data","phonenumberString==="+phonenumberString);
        if (TextUtils.isEmpty(phonenumberString)) {
            Toast.makeText(getContext(), "用户名 / 手机 / 邮箱地址", Toast.LENGTH_SHORT).show();
            return;
        }

        String passwordString = mPassword.getText().toString().trim();
        Log.e("data","passwordString==="+passwordString);
        if (TextUtils.isEmpty(passwordString)) {
            Toast.makeText(getContext(), "输入密码", Toast.LENGTH_SHORT).show();
            return;
        }

        BmobUser.loginByAccount(phonenumberString, passwordString, new LogInListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (user != null) {
                    Toast.makeText(getContext(), "用户登陆成功", Toast.LENGTH_SHORT).show();
                    MineFragment.flag=true;
                    getActivity().finish();//返回用户界面
                    BaseApplication.setUser(user);
//
                } else {
                    Toast.makeText(getContext(), "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
