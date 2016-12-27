package com.happybaby.happybaby.bean;

import android.os.Parcel;
import android.os.Parcelable;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2016/12/21.
 */

public class User extends BmobUser {


    private String phone;
    private String key;
    private String Address;
    private String Touxiang;
    private String name;
    private String Qianming;

    public String getQianming() {
        return Qianming;
    }

    public void setQianming(String qianming) {
        Qianming = qianming;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTouxiang() {
        return Touxiang;
    }

    public void setTouxiang(String touxiang) {
        Touxiang = touxiang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
