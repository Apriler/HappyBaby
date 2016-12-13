package com.happybaby.happybaby.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.fragment.GridFragment;
import com.happybaby.happybaby.fragment.IndexFragment;
import com.happybaby.happybaby.fragment.OverseasFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost mFragmentTabHost;
    private FragmentManager mFragmentManager;
    private TabWidget mTabWidget;


    public static final String TAB_INDEX = "tab_index";
    public static final String TAB_EVENTS = "tab_events";
    public static final String TAB_EVENTS_TAKEPHOTO = "tab_events_takephoto";
    public static final String TAB_SHOPPING_CAR = "tab_shopping_car";
    public static final String TAB_PERSON = "tab_person";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mFragmentManager = getSupportFragmentManager();
        mTabWidget = (TabWidget)findViewById(android.R.id.tabs);
        // 绑定TabHost和tabContent，建立关联
        mFragmentTabHost.setup(this, mFragmentManager, android.R.id.tabcontent);

        mFragmentTabHost.addTab(buildTabSpec(R.drawable.tablayout_item_index,  TAB_INDEX),
                IndexFragment.class, null);
        mFragmentTabHost.addTab(buildTabSpec(R.drawable.tablayout_item_events, TAB_EVENTS),
                OverseasFragment.class, null);
        mFragmentTabHost.addTab(buildTabSpec(R.drawable.tablayout_item_events_new_takephoto, TAB_EVENTS_TAKEPHOTO),
                GridFragment.class, null);
        mFragmentTabHost.addTab(buildTabSpec(R.drawable.tablayout_item_shopping_car,  TAB_SHOPPING_CAR),
                IndexFragment.class, null);
        mFragmentTabHost.addTab(buildTabSpec(R.drawable.tablayout_item_person, TAB_PERSON),
                IndexFragment.class, null);
        //去掉分割线
        mFragmentTabHost.getTabWidget().setDividerDrawable(android.R.color.transparent);

    }

    public TabHost.TabSpec buildTabSpec(int imageId, String tag) {
        // 把布局解析成View
        View view = LayoutInflater.from(this).inflate(R.layout.item_navigation_view, null);
        ImageView ivTabIcon = (ImageView) view.findViewById(R.id.iv_tab_icon);

        // 从外部传递进来的图片Id设置上
        ivTabIcon.setImageResource(imageId);

        // 生成TabSpec(需要为当前Fragment绑定Tag标签，另外需要添加一个View)
        return mFragmentTabHost.newTabSpec(tag).setIndicator(view);
    }
}
