package com.happybaby.happybaby.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.adapter.ViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class InduceActivity extends AppCompatActivity {

    private ViewPager mVpInduce;
    private List<View> Reslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_induce);
        initView();
        View view1 = new View(this);
        view1.setBackgroundResource(R.mipmap.g_2);
        Reslist.add(view1);
        View view2 = new View(this);
        view2.setBackgroundResource(R.mipmap.g_3);
        Reslist.add(view2);
        View view3 = new View(this);
        view3.setBackgroundResource(R.mipmap.g_4);
        Reslist.add(view3);
        View view4 = new View(this);
        view4.setBackgroundResource(R.mipmap.g_5);
        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InduceActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Reslist.add(view4);
        ViewAdapter adapter = new ViewAdapter(Reslist);
        mVpInduce.setAdapter(adapter);

    }

    private void initView() {
        mVpInduce = (ViewPager) findViewById(R.id.vp_induce);
        Reslist=new ArrayList<>();
    }
}
