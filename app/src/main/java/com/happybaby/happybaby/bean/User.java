package com.happybaby.happybaby.bean;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/12/21.
 */

public class User extends BmobUser {


    private String phone;
    private String key;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public String toString() {
        return "User{" +
                "phone='" + phone + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
