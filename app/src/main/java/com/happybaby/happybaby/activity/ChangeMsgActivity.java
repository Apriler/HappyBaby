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

public class ChangeMsgActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTvChangemsgTitle;
    private TextView mTvChangemsgSave;
    private LinearLayout mActivityChangeMsg;
    private Toolbar mToolbarChangeMsg;
    private EditText mEdtInputname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_msg);
        initView();
        //返回键
        setSupportActionBar(mToolbarChangeMsg);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //得到返回来的值,设置到输入框上
        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
        mEdtInputname.setText(name);

    }

    private void initView() {
        mTvChangemsgTitle = (TextView) findViewById(R.id.tv_changemsg_title);
        mTvChangemsgSave = (TextView) findViewById(R.id.tv_changemsg_save);
        mActivityChangeMsg = (LinearLayout) findViewById(R.id.activity_change_msg);
        mTvChangemsgSave.setOnClickListener(this);
        mToolbarChangeMsg = (Toolbar) findViewById(R.id.toolbar_change_msg);
        mToolbarChangeMsg.setOnClickListener(this);
        mEdtInputname = (EditText) findViewById(R.id.edt_inputname);
        mEdtInputname.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_changemsg_save://保存用户昵称
                final String name = mEdtInputname.getEditableText().toString();
                if (name == null){
                    showToast("请输入名字");
                    return ;
                }
                User newUser = new User();
                newUser.setName(name);
                User bmobUser = User.getCurrentUser(User.class);
                newUser.update(bmobUser.getObjectId(), new UpdateListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e == null) {
                            showToast("更新用户信息成功");
                            Intent intent1=new Intent();
                            //把用户重新设置完的名字返回
                            intent1.putExtra("NEWNAME",name);
                            setResult(103,intent1);
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
