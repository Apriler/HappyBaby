package com.happybaby.happybaby.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.ContentAdapter;
import com.happybaby.happybaby.activity.BaseActivity;
import com.happybaby.happybaby.login_fragment.LoginFragment;
import com.happybaby.happybaby.login_fragment.QuickFragment;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity {

    private Toolbar mToolbar;
    private TabLayout mTablayyoutLogin;
    private ViewPager mVpLogin;
    private List<String> Strlist;
    private List<Fragment> fraglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        //设置标题栏
        mToolbar.setTitle("登录");
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        //添加标题栏数据
        Strlist.add("快速登录");
        Strlist.add("密码登录");
        fraglist.add(new LoginFragment());
        fraglist.add(new QuickFragment());

        ContentAdapter adapter= new ContentAdapter(getSupportFragmentManager(),fraglist,Strlist);
        mVpLogin.setAdapter(adapter);
        mTablayyoutLogin.setupWithViewPager(mVpLogin);
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_login);
        mTablayyoutLogin = (TabLayout) findViewById(R.id.tablayyout_login);
        mVpLogin = (ViewPager) findViewById(R.id.vp_login);
        Strlist=new ArrayList<>();
        fraglist=new ArrayList<>();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
