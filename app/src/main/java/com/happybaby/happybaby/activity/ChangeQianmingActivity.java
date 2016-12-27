package com.happybaby.happybaby.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.bean.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class ChangeQianmingActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTvChangemsgTitle;
    private TextView mTvChangemsgSave;//保存按钮
    private LinearLayout mActivityChangeMsg;
    private Toolbar mToolbarChangeMsg;
    private EditText mEdtInputQianming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_qianming);
        initView();
        //返回键
        setSupportActionBar(mToolbarChangeMsg);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //得到返回来的值,设置到输入框上
        Intent intent = getIntent();
        String qianming = intent.getStringExtra("QIANMING");
        mEdtInputQianming.setText(qianming);

    }

    private void initView() {
        mTvChangemsgTitle = (TextView) findViewById(R.id.tv_changemsg_title);
        mTvChangemsgSave = (TextView) findViewById(R.id.tv_changemsg_save);
        mActivityChangeMsg = (LinearLayout) findViewById(R.id.activity_change_msg);
        mTvChangemsgSave.setOnClickListener(this);
        mToolbarChangeMsg = (Toolbar) findViewById(R.id.toolbar_change_msg);
        mToolbarChangeMsg.setOnClickListener(this);
        mEdtInputQianming = (EditText) findViewById(R.id.edt_inputqianming);
        mEdtInputQianming.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_changemsg_save://保存用户昵称
                final String qianming = mEdtInputQianming.getEditableText().toString();
                if (qianming == null){
                    showToast("还没有写签名噢~~");
                    User newUser = new User();
                    newUser.setQianming("还没有写签名噢~~");
                    User bmobUser = User.getCurrentUser(User.class);
                    newUser.update(bmobUser.getObjectId(), new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if (e == null) {
                                showToast("更新用户信息成功");
                                Intent intent1=new Intent();
                                //把用户重新设置完的名字返回
                                intent1.putExtra("NEWQIANMING","还没有写签名噢~~");
                                setResult(104,intent1);
                                finish();
                            } else {
                                showToast("更新用户信息失败:" + e.getMessage());
                            }
                        }
                    });
                    return ;
                }
                User newUser = new User();
                newUser.setQianming(qianming);
                User bmobUser = User.getCurrentUser(User.class);
                newUser.update(bmobUser.getObjectId(), new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e == null) {
                            showToast("更新用户信息成功");
                            Intent intent1=new Intent();
                            //把用户重新设置完的名字返回
                            intent1.putExtra("NEWQIANMING",qianming);
                            setResult(104,intent1);
                            finish();
                        } else {
                            showToast("更新用户信息失败:" + e.getMessage());
                        }
                    }
                });
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);

    }

}
