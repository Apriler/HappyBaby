package com.happybaby.happybaby.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/20.
 */

public class BaseFragment extends Fragment{

    private Toast toast;

    //显示Toast
    protected void showToast(String text) {
        if (toast == null) {
            toast = Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }



}
