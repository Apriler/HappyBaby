package com.happybaby.happybaby.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Tost工具类，解决多个Toast时长问题
 *
 */
public class ToastUtils {

    private static Toast toast;

    public static void showToast(Context context, String text) {
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

    /**
     * 网络访问错误
     * @param context
     */
    public static void showEorrorToast(Context context) {
        if (toast == null) {
            toast = Toast.makeText(context, "网络错误", Toast.LENGTH_SHORT);
        } else {
            toast.setText("网络错误");
        }
        toast.show();
    }

}
