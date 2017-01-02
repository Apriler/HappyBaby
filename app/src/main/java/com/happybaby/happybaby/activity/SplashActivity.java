package com.happybaby.happybaby.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.happybaby.happybaby.R;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final SharedPreferences share = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor edit = share.edit();
        //edit.putBoolean("FLAG",flag);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent();
                if (share.getBoolean("FLAG",false)==false){
                    intent.setClass(SplashActivity.this,InduceActivity.class);
                    edit.putBoolean("FLAG",true);
                    edit.commit();
                }else {
                    intent.setClass(SplashActivity.this,MainActivity.class);
                }
                startActivity(intent);
                finish();
            }
        },3000);

    }
}
