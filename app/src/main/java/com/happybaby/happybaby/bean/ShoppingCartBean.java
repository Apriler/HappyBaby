package com.happybaby.happybaby.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by jianquan on 2016/12/26.
 */

@Entity
public class ShoppingCartBean  {

    @Id
    private  long id;
    private String imageUrl;
    private double price;
    private String name;
    @Generated(hash = 1369728674)
    public ShoppingCartBean(long id, String imageUrl, double price, String name) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.price = price;
        this.name = name;
    }
    @Generated(hash = 1284272626)
    public ShoppingCartBean() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getImageUrl() {
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }


}