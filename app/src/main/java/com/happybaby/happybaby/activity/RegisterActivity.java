package com.happybaby.happybaby.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.User;
import com.happybaby.happybaby.fragment.MineFragment;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;


public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText mPhonenumber;
    private EditText mPassword;
    private Button mBtnYanzhengma;
    private Button mLoginButton;
    private ImageView mImageviewBack;
//    private Context mContext = App.app;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();


    }


    private void initView() {
        mPhonenumber = (EditText) findViewById(R.id.phonenumber);
        mPassword = (EditText) findViewById(R.id.password);
        mBtnYanzhengma = (Button) findViewById(R.id.btn_sendyanzhengma);
        mLoginButton = (Button) findViewById(R.id.loginButton);
        mImageviewBack = (ImageView) findViewById(R.id.imageview_back);//返回键
        mBtnYanzhengma.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        mImageviewBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sendyanzhengma://验证码
                String phonenumberString = mPhonenumber.getText().toString().trim();
                if (TextUtils.isEmpty(phonenumberString)) {
                    showToast("请输入您的手机号");
                    return;
                }

                BmobSMS.requestSMSCode(phonenumberString,"123", new QueryListener<Integer>() {
                    @Override
                    public void done(Integer smsId,BmobException ex) {
                        if(ex==null){//验证码发送成功
                            Log.i("Tag", "短信id："+smsId);//用于查询本次短信发送详情
                            mBtnYanzhengma.setClickable(false);
                        }
                    }
                });
                break;
            case R.id.loginButton://注册
                submit();
                break;
            case R.id.imageview_back:
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String phonenumberString = mPhonenumber.getText().toString().trim();
        if (TextUtils.isEmpty(phonenumberString)) {
            showToast("请输入您的手机号");
            return;
        }

        String passwordString = mPassword.getText().toString().trim();
        if (TextUtils.isEmpty(passwordString)) {
            showToast("请输入验证码");
            return;
        }
//        User user= new User();
//        user.setPhone(phonenumberString);
//        user.setKey(passwordString);
        BmobUser bu = new BmobUser();
//        bu.setUsername(phonenumberString);
//        bu.setPassword(passwordString);
//        //注意：不能用save方法进行注册
//        bu.signUp(new SaveListener<User>() {
//            @Override
//            public void done(User s, BmobException e) {
//                if (e == null) {
//                    showToast("注册成功:" + s.toString());
//                    finish();
//
//                } else {
//                    loge(e.getMessage());
//                }
//            }
//        });

        bu.signOrLoginByMobilePhone(phonenumberString, passwordString, new LogInListener<User>() {

            @Override
            public void done(User user, BmobException e) {
                if(user!=null){
                    Log.i("smile","用户登陆成功");
                    MineFragment.flag=true;
                    finish();
                }
            }
        });


    }
}
