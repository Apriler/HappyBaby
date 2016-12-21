package com.happybaby.happybaby.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class MyLike {

    /**
     * code : 1
     * msg : 成功！

     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**

         */

        private String size;
        private String page;
        private int total_page;
        private List<ListBean> list;

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public int getTotal_page() {
            return total_page;
        }

        public void setTotal_page(int total_page) {
            this.total_page = total_page;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * product_id : 43924
             * goods_id : 41670
             * shop_id : 0
             * category_id : 1510
             * country_id : 8
             * sellcountry_id : 88
             * brand_id : 316
             * brand_name : 雅诗兰黛Estee Lauder
             * brand_logo : http://static.baocdn.com/photo/201411/2014112411001370673937.jpg
             * is_oversea : 2
             * createtime : 2016-08-10 16:33:34
             * updatetime : 2016-12-13 14:54:44
             * first_onshelftime : 2016-08-10 16:33:48
             * name : 【包邮包税】美国直邮ESTEE LAUDER雅诗兰黛 红石榴微循环精华水清爽型 200ml
             * short_title : 清爽型精华200ml
             * image : photo/201608/2016081016000201807736.jpg
             * market_price : 45.52
             * store_price : 301.81
             * is_nostock : 0
             * event_type : type_goods
             * product_icon : ["http://static.baocdn.com/images/activity/zhijiang.png","http://static.baocdn.com/images/activity/baoyou.png"]
             * sold_number : 1
             * activity_price : 301.81
             * recommended_reason :
             * country_flag : http://img03.baoimg.net/da/201606/201606149002421173241.png
             * country_name : 美国
             * image_url_400 : http://img01.baoimg.net/photo/201608/2016081016000201807736_400x400.jpg
             * image_url_250 : http://img02.baoimg.net/photo/201608/2016081016000201807736_250x250.jpg
             * image_url_100 : http://image.baoimg.net/photo/201608/2016081016000201807736_100x100.jpg
             * image_url_50 : http://image.baoimg.net/photo/201608/2016081016000201807736_50x50.jpg
             * image_url : http://image.baoimg.net/photo/201608/2016081016000201807736.jpg
             * currency_market_price : 45.52
             * currency_symbol : $
             * refer_text_url : amazon.com
             * likeNumber : 9
             * commentNumber : 10
             * sellcountry_info : {"country_name":"美国","mobi_image_url":"http://img03.baoimg.net/da/201606/201606149002421173241.png"}
             * product_icon_new : [{"url":"http://static.baocdn.com/images/activity/zhijiang_v262.png","height":44,"width":88},{"url":"http://static.baocdn.com/images/activity/bybs_v262.png","height":44,"width":132}]
             * is_activity : true
             */

            private String product_id;
            private String goods_id;
            private String shop_id;
            private String category_id;
            private String country_id;
            private String sellcountry_id;
            private String brand_id;
            private String brand_name;
            private String brand_logo;
            private String is_oversea;
            private String createtime;
            private String updatetime;
            private String first_onshelftime;
            private String name;
            private String short_title;
            private String image;
            private String market_price;
            private String store_price;
            private int is_nostock;
            private String event_type;
            private String sold_number;
            private String activity_price;
            private String recommended_reason;
            private String country_flag;
            private String country_name;
            private String image_url_400;
            private String image_url_250;
            private String image_url_100;
            private String image_url_50;
            private String image_url;
            private String currency_market_price;
            private String currency_symbol;
            private String refer_text_url;
            private int likeNumber;
            private int commentNumber;
            private SellcountryInfoBean sellcountry_info;
            private boolean is_activity;
            private List<String> product_icon;
            private List<ProductIconNewBean> product_icon_new;

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getShop_id() {
                return shop_id;
            }

            public void setShop_id(String shop_id) {
                this.shop_id = shop_id;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCountry_id() {
                return country_id;
            }

            public void setCountry_id(String country_id) {
                this.country_id = country_id;
            }

            public String getSellcountry_id() {
                return sellcountry_id;
            }

            public void setSellcountry_id(String sellcountry_id) {
                this.sellcountry_id = sellcountry_id;
            }

            public String getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(String brand_id) {
                this.brand_id = brand_id;
            }

            public String getBrand_name() {
                return brand_name;
            }

            public void setBrand_name(String brand_name) {
                this.brand_name = brand_name;
            }

            public String getBrand_logo() {
                return brand_logo;
            }

            public void setBrand_logo(String brand_logo) {
                this.brand_logo = brand_logo;
            }

            public String getIs_oversea() {
                return is_oversea;
            }

            public void setIs_oversea(String is_oversea) {
                this.is_oversea = is_oversea;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getFirst_onshelftime() {
                return first_onshelftime;
            }

            public void setFirst_onshelftime(String first_onshelftime) {
                this.first_onshelftime = first_onshelftime;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getShort_title() {
                return short_title;
            }

            public void setShort_title(String short_title) {
                this.short_title = short_title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getStore_price() {
                return store_price;
            }

            public void setStore_price(String store_price) {
                this.store_price = store_price;
            }

            public int getIs_nostock() {
                return is_nostock;
            }

            public void setIs_nostock(int is_nostock) {
                this.is_nostock = is_nostock;
            }

            public String getEvent_type() {
                return event_type;
            }

            public void setEvent_type(String event_type) {
                this.event_type = event_type;
            }

            public String getSold_number() {
                return sold_number;
            }

            public void setSold_number(String sold_number) {
                this.sold_number = sold_number;
            }

            public String getActivity_price() {
                return activity_price;
            }

            public void setActivity_price(String activity_price) {
                this.activity_price = activity_price;
            }

            public String getRecommended_reason() {
                return recommended_reason;
            }

            public void setRecommended_reason(String recommended_reason) {
                this.recommended_reason = recommended_reason;
            }

            public String getCountry_flag() {
                return country_flag;
            }

            public void setCountry_flag(String country_flag) {
                this.country_flag = country_flag;
            }

            public String getCountry_name() {
                return country_name;
            }

            public void setCountry_name(String country_name) {
                this.country_name = country_name;
            }

            public String getImage_url_400() {
                return image_url_400;
            }

            public void setImage_url_400(String image_url_400) {
                this.image_url_400 = image_url_400;
            }

            public String getImage_url_250() {
                return image_url_250;
            }

            public void setImage_url_250(String image_url_250) {
                this.image_url_250 = image_url_250;
            }

            public String getImage_url_100() {
                return image_url_100;
            }

            public void setImage_url_100(String image_url_100) {
                this.image_url_100 = image_url_100;
            }

            public String getImage_url_50() {
                return image_url_50;
            }

            public void setImage_url_50(String image_url_50) {
                this.image_url_50 = image_url_50;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getCurrency_market_price() {
                return currency_market_price;
            }

            public void setCurrency_market_price(String currency_market_price) {
                this.currency_market_price = currency_market_price;
            }

            public String getCurrency_symbol() {
                return currency_symbol;
            }

            public void setCurrency_symbol(String currency_symbol) {
                this.currency_symbol = currency_symbol;
            }

            public String getRefer_text_url() {
                return refer_text_url;
            }

            public void setRefer_text_url(String refer_text_url) {
                this.refer_text_url = refer_text_url;
            }

            public int getLikeNumber() {
                return likeNumber;
            }

            public void setLikeNumber(int likeNumber) {
                this.likeNumber = likeNumber;
            }

            public int getCommentNumber() {
                return commentNumber;
            }

            public void setCommentNumber(int commentNumber) {
                this.commentNumber = commentNumber;
            }

            public SellcountryInfoBean getSellcountry_info() {
                return sellcountry_info;
            }

            public void setSellcountry_info(SellcountryInfoBean sellcountry_info) {
                this.sellcountry_info = sellcountry_info;
            }

            public boolean isIs_activity() {
                return is_activity;
            }

            public void setIs_activity(boolean is_activity) {
                this.is_activity = is_activity;
            }

            public List<String> getProduct_icon() {
                return product_icon;
            }

            public void setProduct_icon(List<String> product_icon) {
                this.product_icon = product_icon;
            }

            public List<ProductIconNewBean> getProduct_icon_new() {
                return product_icon_new;
            }

            public void setProduct_icon_new(List<ProductIconNewBean> product_icon_new) {
                this.product_icon_new = product_icon_new;
            }

            public static class SellcountryInfoBean {
                /**
                 * country_name : 美国
                 * mobi_image_url : http://img03.baoimg.net/da/201606/201606149002421173241.png
                 */

                private String country_name;
                private String mobi_image_url;

                public String getCountry_name() {
                    return country_name;
                }

                public void setCountry_name(String country_name) {
                    this.country_name = country_name;
                }

                public String getMobi_image_url() {
                    return mobi_image_url;
                }

                public void setMobi_image_url(String mobi_image_url) {
                    this.mobi_image_url = mobi_image_url;
                }
            }

            public static class ProductIconNewBean {
                /**
                 * url : http://static.baocdn.com/images/activity/zhijiang_v262.png
                 * height : 44
                 * width : 88
                 */

                private String url;
                private int height;
                private int width;

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

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}
