package com.happybaby.happybaby.greendao;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by jianquan on 2016/12/27.
 */

public class CartBean extends BmobObject implements Parcelable {

        /**
         * product_id : 29532
         * brand_name : A2
         * name : 【包邮包税】新西兰A2 Platinum酪蛋白婴儿3段奶粉（1-3周岁宝宝）900g 【保质期2018年3月】
         * product_image : http://image.baoimg.net/photo/201606/2016061310003240007625_400x400.jpg
         * image_url_400 : http://image.baoimg.net/photo/201606/2016061310003240007625_400x400.jpg
         * is_nostock : 0
         * no_activity_price : 173.00
         * store_price : 173
         * home_market_price :
         * country_name : 保税
         * country_flag : http://img01.baoimg.net/da/201606/2016061410001145960149.png
         * refer_text_url :
         * activity_icon : [{"url":"http://static01.baocdn.com/images/activity/bybs_v262.png","height":44,"weight":132}]
         * product_icon_new : [{"url":"http://static01.baocdn.com/images/activity/bybs_v262.png","height":44,"weight":132}]
         */

        private String product_id;
        private String brand_name;
        private String name;
        private String product_image;
        private String image_url_400;
        private int is_nostock;
        private String no_activity_price;
        private double store_price;
        private String home_market_price;
        private String country_name;
        private String country_flag;
        private String refer_text_url;
        private boolean isCheck;
        private int num;//数量


        public boolean isCheck() {
            return isCheck;
        }

        public void setCheck(boolean check) {
            isCheck = check;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        private List<ActivityIconBean> activity_icon;
        private List<ProductIconNewBean> product_icon_new;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProduct_image() {
            return product_image;
        }

        public void setProduct_image(String product_image) {
            this.product_image = product_image;
        }

        public String getImage_url_400() {
            return image_url_400;
        }

        public void setImage_url_400(String image_url_400) {
            this.image_url_400 = image_url_400;
        }

        public int getIs_nostock() {
            return is_nostock;
        }

        public void setIs_nostock(int is_nostock) {
            this.is_nostock = is_nostock;
        }

        public String getNo_activity_price() {
            return no_activity_price;
        }

        public void setNo_activity_price(String no_activity_price) {
            this.no_activity_price = no_activity_price;
        }

        public double getStore_price() {
            return store_price;
        }

        public void setStore_price(int store_price) {
            this.store_price = store_price;
        }

        public String getHome_market_price() {
            return home_market_price;
        }

        public void setHome_market_price(String home_market_price) {
            this.home_market_price = home_market_price;
        }

        public String getCountry_name() {
            return country_name;
        }

        public void setCountry_name(String country_name) {
            this.country_name = country_name;
        }

        public String getCountry_flag() {
            return country_flag;
        }

        public void setCountry_flag(String country_flag) {
            this.country_flag = country_flag;
        }

        public String getRefer_text_url() {
            return refer_text_url;
        }

        public void setRefer_text_url(String refer_text_url) {
            this.refer_text_url = refer_text_url;
        }

        public List<ActivityIconBean> getActivity_icon() {
            return activity_icon;
        }

        public void setActivity_icon(List<ActivityIconBean> activity_icon) {
            this.activity_icon = activity_icon;
        }

        public List<ProductIconNewBean> getProduct_icon_new() {
            return product_icon_new;
        }

        public void setProduct_icon_new(List<ProductIconNewBean> product_icon_new) {
            this.product_icon_new = product_icon_new;
        }

        public static class ActivityIconBean implements Parcelable {
            /**
             * url : http://static01.baocdn.com/images/activity/bybs_v262.png
             * height : 44
             * weight : 132
             */

            private String url;
            private int height;
            private int weight;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.url);
                dest.writeInt(this.height);
                dest.writeInt(this.weight);
            }

            public ActivityIconBean() {
            }

            protected ActivityIconBean(Parcel in) {
                this.url = in.readString();
                this.height = in.readInt();
                this.weight = in.readInt();
            }

            public static final Creator<ActivityIconBean> CREATOR = new Creator<ActivityIconBean>() {
                @Override
                public ActivityIconBean createFromParcel(Parcel source) {
                    return new ActivityIconBean(source);
                }

                @Override
                public ActivityIconBean[] newArray(int size) {
                    return new ActivityIconBean[size];
                }
            };
        }

        public static class ProductIconNewBean implements Parcelable {
            /**
             * url : http://static01.baocdn.com/images/activity/bybs_v262.png
             * height : 44
             * weight : 132
             */

            private String url;
            private int height;
            private int weight;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.url);
                dest.writeInt(this.height);
                dest.writeInt(this.weight);
            }

            public ProductIconNewBean() {
            }

            protected ProductIconNewBean(Parcel in) {
                this.url = in.readString();
                this.height = in.readInt();
                this.weight = in.readInt();
            }

            public static final Creator<ProductIconNewBean> CREATOR = new Creator<ProductIconNewBean>() {
                @Override
                public ProductIconNewBean createFromParcel(Parcel source) {
                    return new ProductIconNewBean(source);
                }

                @Override
                public ProductIconNewBean[] newArray(int size) {
                    return new ProductIconNewBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.product_id);
            dest.writeString(this.brand_name);
            dest.writeString(this.name);
            dest.writeString(this.product_image);
            dest.writeString(this.image_url_400);
            dest.writeInt(this.is_nostock);
            dest.writeString(this.no_activity_price);
            dest.writeDouble(this.store_price);
            dest.writeString(this.home_market_price);
            dest.writeString(this.country_name);
            dest.writeString(this.country_flag);
            dest.writeString(this.refer_text_url);
            dest.writeList(this.activity_icon);
            dest.writeList(this.product_icon_new);
        }

        public CartBean() {
        }

        protected CartBean(Parcel in) {
            this.product_id = in.readString();
            this.brand_name = in.readString();
            this.name = in.readString();
            this.product_image = in.readString();
            this.image_url_400 = in.readString();
            this.is_nostock = in.readInt();
            this.no_activity_price = in.readString();
            this.store_price = in.readDouble();
            this.home_market_price = in.readString();
            this.country_name = in.readString();
            this.country_flag = in.readString();
            this.refer_text_url = in.readString();
            this.activity_icon = new ArrayList<ActivityIconBean>();
            in.readList(this.activity_icon, ActivityIconBean.class.getClassLoader());
            this.product_icon_new = new ArrayList<ProductIconNewBean>();
            in.readList(this.product_icon_new, ProductIconNewBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<CartBean> CREATOR = new Parcelable.Creator<CartBean>() {
            @Override
            public CartBean createFromParcel(Parcel source) {
                return new CartBean(source);
            }

            @Override
            public CartBean[] newArray(int size) {
                return new CartBean[size];
            }
        };
    }


