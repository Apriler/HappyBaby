package com.happybaby.happybaby.search;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by jianquan on 2016/12/29.
 */

@Entity
public class MyData {
    @Id
    private Long _id;
    @Unique
    private String name;
    @Generated(hash = 1825206326)
    public MyData(Long _id, String name) {
        this._id = _id;
        this.name = name;
    }
    @Generated(hash = 2083622869)
    public MyData() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
