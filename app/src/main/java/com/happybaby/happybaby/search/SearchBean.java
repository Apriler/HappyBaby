package com.happybaby.happybaby.search;

import java.util.List;

/**
 * Created by jianquan on 2016/12/29.
 */

public class SearchBean {


    /**
     * code : 1
     * msg : 成功！
     * data : {"size":"10","page":"1","total_page":1,"list":[{"product_id":"47434","market_price":"29.00","store_price":"217.50","name":"【预售5天包包邮包税2支】德国直邮MAM 晶彩耐高温防摔玻璃奶瓶 170ml-蓝色","is_oversea":"2","image_url_400":"http://img02.baoimg.net/photo/201608/2016083019001706763042_400x400.jpg","image_url_250":"http://img03.baoimg.net/photo/201608/2016083019001706763042_250x250.jpg","image_url_100":"http://img01.baoimg.net/photo/201608/2016083019001706763042_100x100.jpg","image_url_50":"http://img01.baoimg.net/photo/201608/2016083019001706763042_50x50.jpg","image_url":"http://img02.baoimg.net/photo/201608/2016083019001706763042.jpg","currency_market_price":"29.00","currency_symbol":"\u20ac","sellcountry_info":{"country_name":"德国","mobi_image_url":"http://image.baoimg.net/da/201606/2016061414002244769999.png"},"refer_text_url":"","activity_icon":"","is_nostock":0,"is_new":0,"is_new_icon":"","activity_price":"","short_title":"","product_icon":["http://static.baocdn.com/images/activity/manjian.png"],"product_icon_new":[{"url":"http://static.baocdn.com/images/activity/manjian_v262.png","height":44,"width":88}],"brand_id":"371","brand_name":"MAM","brand_logo":"http://static.baocdn.com/photo/201412/2014123014000616811228.jpg","sold_numbber":0,"sold_number":0,"commentNumber":0,"likeNumber":0,"country_flag":"http://image.baoimg.net/da/201606/2016061414002244769999.png","country_name":"德国"}],"total":1}
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
         * size : 10
         * page : 1
         * total_page : 1
         * list : [{"product_id":"47434","market_price":"29.00","store_price":"217.50","name":"【预售5天包包邮包税2支】德国直邮MAM 晶彩耐高温防摔玻璃奶瓶 170ml-蓝色","is_oversea":"2","image_url_400":"http://img02.baoimg.net/photo/201608/2016083019001706763042_400x400.jpg","image_url_250":"http://img03.baoimg.net/photo/201608/2016083019001706763042_250x250.jpg","image_url_100":"http://img01.baoimg.net/photo/201608/2016083019001706763042_100x100.jpg","image_url_50":"http://img01.baoimg.net/photo/201608/2016083019001706763042_50x50.jpg","image_url":"http://img02.baoimg.net/photo/201608/2016083019001706763042.jpg","currency_market_price":"29.00","currency_symbol":"\u20ac","sellcountry_info":{"country_name":"德国","mobi_image_url":"http://image.baoimg.net/da/201606/2016061414002244769999.png"},"refer_text_url":"","activity_icon":"","is_nostock":0,"is_new":0,"is_new_icon":"","activity_price":"","short_title":"","product_icon":["http://static.baocdn.com/images/activity/manjian.png"],"product_icon_new":[{"url":"http://static.baocdn.com/images/activity/manjian_v262.png","height":44,"width":88}],"brand_id":"371","brand_name":"MAM","brand_logo":"http://static.baocdn.com/photo/201412/2014123014000616811228.jpg","sold_numbber":0,"sold_number":0,"commentNumber":0,"likeNumber":0,"country_flag":"http://image.baoimg.net/da/201606/2016061414002244769999.png","country_name":"德国"}]
         * total : 1
         */

        private String size;
        private String page;
        private int total_page;
        private int total;
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

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * product_id : 47434
             * market_price : 29.00
             * store_price : 217.50
             * name : 【预售5天包包邮包税2支】德国直邮MAM 晶彩耐高温防摔玻璃奶瓶 170ml-蓝色
             * is_oversea : 2
             * image_url_400 : http://img02.baoimg.net/photo/201608/2016083019001706763042_400x400.jpg
             * image_url_250 : http://img03.baoimg.net/photo/201608/2016083019001706763042_250x250.jpg
             * image_url_100 : http://img01.baoimg.net/photo/201608/2016083019001706763042_100x100.jpg
             * image_url_50 : http://img01.baoimg.net/photo/201608/2016083019001706763042_50x50.jpg
             * image_url : http://img02.baoimg.net/photo/201608/2016083019001706763042.jpg
             * currency_market_price : 29.00
             * currency_symbol : €
             * sellcountry_info : {"country_name":"德国","mobi_image_url":"http://image.baoimg.net/da/201606/2016061414002244769999.png"}
             * refer_text_url :
             * activity_icon :
             * is_nostock : 0
             * is_new : 0
             * is_new_icon :
             * activity_price :
             * short_title :
             * product_icon : ["http://static.baocdn.com/images/activity/manjian.png"]
             * product_icon_new : [{"url":"http://static.baocdn.com/images/activity/manjian_v262.png","height":44,"width":88}]
             * brand_id : 371
             * brand_name : MAM
             * brand_logo : http://static.baocdn.com/photo/201412/2014123014000616811228.jpg
             * sold_numbber : 0
             * sold_number : 0
             * commentNumber : 0
             * likeNumber : 0
             * country_flag : http://image.baoimg.net/da/201606/2016061414002244769999.png
             * country_name : 德国
             */

            private String product_id;
            private String market_price;
            private String store_price;
            private String name;
            private String is_oversea;
            private String image_url_400;
            private String image_url_250;
            private String image_url_100;
            private String image_url_50;
            private String image_url;
            private String currency_market_price;
            private String currency_symbol;
            private SellcountryInfoBean sellcountry_info;
            private String refer_text_url;
            private String activity_icon;
            private int is_nostock;
            private int is_new;
            private String is_new_icon;
            private String activity_price;
            private String short_title;
            private String brand_id;
            private String brand_name;
            private String brand_logo;
            private int sold_numbber;
            private int sold_number;
            private int commentNumber;
            private int likeNumber;
            private String country_flag;
            private String country_name;
            private List<String> product_icon;
            private List<ProductIconNewBean> product_icon_new;

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIs_oversea() {
                return is_oversea;
            }

            public void setIs_oversea(String is_oversea) {
                this.is_oversea = is_oversea;
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

            public SellcountryInfoBean getSellcountry_info() {
                return sellcountry_info;
            }

            public void setSellcountry_info(SellcountryInfoBean sellcountry_info) {
                this.sellcountry_info = sellcountry_info;
            }

            public String getRefer_text_url() {
                return refer_text_url;
            }

            public void setRefer_text_url(String refer_text_url) {
                this.refer_text_url = refer_text_url;
            }

            public String getActivity_icon() {
                return activity_icon;
            }

            public void setActivity_icon(String activity_icon) {
                this.activity_icon = activity_icon;
            }

            public int getIs_nostock() {
                return is_nostock;
            }

            public void setIs_nostock(int is_nostock) {
                this.is_nostock = is_nostock;
            }

            public int getIs_new() {
                return is_new;
            }

            public void setIs_new(int is_new) {
                this.is_new = is_new;
            }

            public String getIs_new_icon() {
                return is_new_icon;
            }

            public void setIs_new_icon(String is_new_icon) {
                this.is_new_icon = is_new_icon;
            }

            public String getActivity_price() {
                return activity_price;
            }

            public void setActivity_price(String activity_price) {
                this.activity_price = activity_price;
            }

            public String getShort_title() {
                return short_title;
            }

            public void setShort_title(String short_title) {
                this.short_title = short_title;
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

            public int getSold_numbber() {
                return sold_numbber;
            }

            public void setSold_numbber(int sold_numbber) {
                this.sold_numbber = sold_numbber;
            }

            public int getSold_number() {
                return sold_number;
            }

            public void setSold_number(int sold_number) {
                this.sold_number = sold_number;
            }

            public int getCommentNumber() {
                return commentNumber;
            }

            public void setCommentNumber(int commentNumber) {
                this.commentNumber = commentNumber;
            }

            public int getLikeNumber() {
                return likeNumber;
            }

            public void setLikeNumber(int likeNumber) {
                this.likeNumber = likeNumber;
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
                 * country_name : 德国
                 * mobi_image_url : http://image.baoimg.net/da/201606/2016061414002244769999.png
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
                 * url : http://static.baocdn.com/images/activity/manjian_v262.png
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
