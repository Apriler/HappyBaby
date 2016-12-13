package com.happybaby.happybaby.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 网络加载工具类
 */

public class HttpUtils {

    //通过url地址，下载字符串
    public static String getString(String urlStr) throws IOException{

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);
        if (conn.getResponseCode() == 200) {
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            byte[] data = new byte[1024];
            int len = 0;
            StringBuffer buffer = new StringBuffer();
            while ((len = bis.read(data)) != -1){
                String txt = new String(data, 0, len,"UTF-8");
                buffer.append(txt);
            }
            bis.close();
            conn.disconnect();
            return buffer.toString();
        }
        return null;
    }





}
