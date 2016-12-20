package com.happybaby.happybaby.base;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/20.
 */

public class BaseActivity extends AppCompatActivity {


    private Toast toast;

    protected  void showToast(String text){

        if(toast==null){
            toast=Toast.makeText(this,text,Toast.LENGTH_SHORT);

        }else {
            toast.setText(text);
        }
        toast.show();
    }
}
