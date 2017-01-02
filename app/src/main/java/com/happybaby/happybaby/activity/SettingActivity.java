package com.happybaby.happybaby.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.User;
import com.happybaby.happybaby.fragment.MineFragment;

public class SettingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mImageviewBack;
    private Button mBtnBacklogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
        if( MineFragment.flag){
            mBtnBacklogin.setVisibility(View.VISIBLE);
        }
        else {
            mBtnBacklogin.setVisibility(View.GONE);
        }
    }

    private void initView() {
        mImageviewBack = (ImageView) findViewById(R.id.imageview_back);
        mBtnBacklogin = (Button) findViewById(R.id.btn_backlogin);

        mImageviewBack.setOnClickListener(this);
        mBtnBacklogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageview_back:
                finish();
                break;
            case R.id.btn_backlogin:
                User.logOut();   //清除缓存用户对象
                MineFragment.flag=false;
                showToast("注销成功");
                finish();
                break;
        }
    }
}
