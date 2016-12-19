package com.happybaby.happybaby.bean.ManyRecommend;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */

public class Data1  {

    /**
     * module_type : hot_message_module
     * module_name : 热门消息
     * module_icon : http://static01.baocdn.com/images/user/hot_message_26.png?1457323390
     * more : {"event_type":"type_hot_message","is_show":false}
     * rank : 0
     * template : 1
     * data : {"icon":"http://static01.baocdn.com/images/user/hot_logo.png","list":[{"ad_id":"10803","ad_name":"当季正流行","adpos_type":"1","ad_link":"http://sale.baobeigezi.com/2016/11/10","ad_type":"link","ad_area":"0","ad_etime":"2016-12-31 10:00:00","ad_word":"当季正流行","ad_introduction":"当季流行大牌美妆，贴心推荐","activity_id":"","product_id":"","event_id":"","object_type":"","h5_link_ios":"http://sale.baobeigezi.com/2016/11/10/ios/index.html","h5_link_android":"http://sale.baobeigezi.com/2016/11/10/android/index.html","h5_name":"当季正流行","h5_share":{"h5_share_title":"","h5_share_content":"","h5_share_pic":""},"ad_pic_400":"http://image.baoimg.net/da/201611/2016112421001368280264_400x400.jpg","ad_pic_250":"http://image.baoimg.net/da/201611/2016112421001368280264_250x250.jpg","ad_pic_100":"http://image.baoimg.net/da/201611/2016112421001368280264_100x100.jpg","ad_pic":"http://image.baoimg.net/da/201611/2016112421001368280264.jpg","search_keyword":"","category_id":"","category_name":"","brand_id":"","brand_name":"","event_type":"","ad_delivery":""},{"ad_id":"9242","ad_name":"宝贝格子货损赔付通知！","adpos_type":"1","ad_link":"http://help.baobeigezi.com/app/gzquan/bill3","ad_type":"link","ad_area":"0","ad_etime":"2016-12-30 00:00:00","ad_word":"宝贝格子货损赔付通知！","ad_introduction":"宝贝格子货损赔付通知！","activity_id":"","product_id":"","event_id":"","object_type":"","h5_link_ios":"http://help.baobeigezi.com/app/gzquan/bill3/ios/index.html","h5_link_android":"http://help.baobeigezi.com/app/gzquan/bill3/android/index.html","h5_name":"宝贝格子货损赔付通知！","h5_share":{"h5_share_title":"","h5_share_content":"","h5_share_pic":""},"ad_pic_400":false,"ad_pic_250":false,"ad_pic_100":false,"ad_pic":false,"search_keyword":"","category_id":"","category_name":"","brand_id":"","brand_name":"","event_type":"","ad_delivery":""},{"ad_id":"11021","ad_name":"客服中心对物流咨询的统一解答","adpos_type":"1","ad_link":"http://sale.baobeigezi.com/app/gzquan/bill7","ad_type":"link","ad_area":"0","ad_etime":"2016-12-22 10:00:00","ad_word":"客服中心对物流咨询的统一解答","ad_introduction":"客服中心对物流咨询的统一解答","activity_id":"","product_id":"","event_id":"","object_type":"","h5_link_ios":"http://sale.baobeigezi.com/app/gzquan/bill7/ios/index.html","h5_link_android":"http://sale.baobeigezi.com/app/gzquan/bill7/android/index.html","h5_name":"客服中心对物流咨询的统一解答","h5_share":{"h5_share_title":"","h5_share_content":"","h5_share_pic":""},"ad_pic_400":false,"ad_pic_250":false,"ad_pic_100":false,"ad_pic":false,"search_keyword":"","category_id":"","category_name":"","brand_id":"","brand_name":"","event_type":"","ad_delivery":""}]}
     */

    private String module_type;
    private String module_name;
    private String module_icon;
    private MoreBean more;
    private int rank;
    private int template;
    private DataBean data;

    public String getModule_type() {
        return module_type;
    }

    public void setModule_type(String module_type) {
        this.module_type = module_type;
    }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getModule_icon() {
        return module_icon;
    }

    public void setModule_icon(String module_icon) {
        this.module_icon = module_icon;
    }

    public MoreBean getMore() {
        return more;
    }

    public void setMore(MoreBean more) {
        this.more = more;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getTemplate() {
        return template;
    }

    public void setTemplate(int template) {
        this.template = template;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class MoreBean {
        /**
         * event_type : type_hot_message
         * is_show : false
         */

        private String event_type;
        private boolean is_show;

        public String getEvent_type() {
            return event_type;
        }

        public void setEvent_type(String event_type) {
            this.event_type = event_type;
        }

        public boolean isIs_show() {
            return is_show;
        }

        public void setIs_show(boolean is_show) {
            this.is_show = is_show;
        }
    }

    public static class DataBean {
        /**
         * icon : http://static01.baocdn.com/images/user/hot_logo.png
         * list : [{"ad_id":"10803","ad_name":"当季正流行","adpos_type":"1","ad_link":"http://sale.baobeigezi.com/2016/11/10","ad_type":"link","ad_area":"0","ad_etime":"2016-12-31 10:00:00","ad_word":"当季正流行","ad_introduction":"当季流行大牌美妆，贴心推荐","activity_id":"","product_id":"","event_id":"","object_type":"","h5_link_ios":"http://sale.baobeigezi.com/2016/11/10/ios/index.html","h5_link_android":"http://sale.baobeigezi.com/2016/11/10/android/index.html","h5_name":"当季正流行","h5_share":{"h5_share_title":"","h5_share_content":"","h5_share_pic":""},"ad_pic_400":"http://image.baoimg.net/da/201611/2016112421001368280264_400x400.jpg","ad_pic_250":"http://image.baoimg.net/da/201611/2016112421001368280264_250x250.jpg","ad_pic_100":"http://image.baoimg.net/da/201611/2016112421001368280264_100x100.jpg","ad_pic":"http://image.baoimg.net/da/201611/2016112421001368280264.jpg","search_keyword":"","category_id":"","category_name":"","brand_id":"","brand_name":"","event_type":"","ad_delivery":""},{"ad_id":"9242","ad_name":"宝贝格子货损赔付通知！","adpos_type":"1","ad_link":"http://help.baobeigezi.com/app/gzquan/bill3","ad_type":"link","ad_area":"0","ad_etime":"2016-12-30 00:00:00","ad_word":"宝贝格子货损赔付通知！","ad_introduction":"宝贝格子货损赔付通知！","activity_id":"","product_id":"","event_id":"","object_type":"","h5_link_ios":"http://help.baobeigezi.com/app/gzquan/bill3/ios/index.html","h5_link_android":"http://help.baobeigezi.com/app/gzquan/bill3/android/index.html","h5_name":"宝贝格子货损赔付通知！","h5_share":{"h5_share_title":"","h5_share_content":"","h5_share_pic":""},"ad_pic_400":false,"ad_pic_250":false,"ad_pic_100":false,"ad_pic":false,"search_keyword":"","category_id":"","category_name":"","brand_id":"","brand_name":"","event_type":"","ad_delivery":""},{"ad_id":"11021","ad_name":"客服中心对物流咨询的统一解答","adpos_type":"1","ad_link":"http://sale.baobeigezi.com/app/gzquan/bill7","ad_type":"link","ad_area":"0","ad_etime":"2016-12-22 10:00:00","ad_word":"客服中心对物流咨询的统一解答","ad_introduction":"客服中心对物流咨询的统一解答","activity_id":"","product_id":"","event_id":"","object_type":"","h5_link_ios":"http://sale.baobeigezi.com/app/gzquan/bill7/ios/index.html","h5_link_android":"http://sale.baobeigezi.com/app/gzquan/bill7/android/index.html","h5_name":"客服中心对物流咨询的统一解答","h5_share":{"h5_share_title":"","h5_share_content":"","h5_share_pic":""},"ad_pic_400":false,"ad_pic_250":false,"ad_pic_100":false,"ad_pic":false,"search_keyword":"","category_id":"","category_name":"","brand_id":"","brand_name":"","event_type":"","ad_delivery":""}]
         */

        private String icon;
        private List<ListBean> list;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * ad_id : 10803
             * ad_name : 当季正流行
             * adpos_type : 1
             * ad_link : http://sale.baobeigezi.com/2016/11/10
             * ad_type : link
             * ad_area : 0
             * ad_etime : 2016-12-31 10:00:00
             * ad_word : 当季正流行
             * ad_introduction : 当季流行大牌美妆，贴心推荐
             * activity_id :
             * product_id :
             * event_id :
             * object_type :
             * h5_link_ios : http://sale.baobeigezi.com/2016/11/10/ios/index.html
             * h5_link_android : http://sale.baobeigezi.com/2016/11/10/android/index.html
             * h5_name : 当季正流行
             * h5_share : {"h5_share_title":"","h5_share_content":"","h5_share_pic":""}
             * ad_pic_400 : http://image.baoimg.net/da/201611/2016112421001368280264_400x400.jpg
             * ad_pic_250 : http://image.baoimg.net/da/201611/2016112421001368280264_250x250.jpg
             * ad_pic_100 : http://image.baoimg.net/da/201611/2016112421001368280264_100x100.jpg
             * ad_pic : http://image.baoimg.net/da/201611/2016112421001368280264.jpg
             * search_keyword :
             * category_id :
             * category_name :
             * brand_id :
             * brand_name :
             * event_type :
             * ad_delivery :
             */

            private String ad_id;
            private String ad_name;
            private String adpos_type;
            private String ad_link;
            private String ad_type;
            private String ad_area;
            private String ad_etime;
            private String ad_word;
            private String ad_introduction;
            private String activity_id;
            private String product_id;
            private String event_id;
            private String object_type;
            private String h5_link_ios;
            private String h5_link_android;
            private String h5_name;
            private H5ShareBean h5_share;
            private String ad_pic_400;
            private String ad_pic_250;
            private String ad_pic_100;
            private String ad_pic;
            private String search_keyword;
            private String category_id;
            private String category_name;
            private String brand_id;
            private String brand_name;
            private String event_type;
            private String ad_delivery;

            public String getAd_id() {
                return ad_id;
            }

            public void setAd_id(String ad_id) {
                this.ad_id = ad_id;
            }

            public String getAd_name() {
                return ad_name;
            }

            public void setAd_name(String ad_name) {
                this.ad_name = ad_name;
            }

            public String getAdpos_type() {
                return adpos_type;
            }

            public void setAdpos_type(String adpos_type) {
                this.adpos_type = adpos_type;
            }

            public String getAd_link() {
                return ad_link;
            }

            public void setAd_link(String ad_link) {
                this.ad_link = ad_link;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getAd_area() {
                return ad_area;
            }

            public void setAd_area(String ad_area) {
                this.ad_area = ad_area;
            }

            public String getAd_etime() {
                return ad_etime;
            }

            public void setAd_etime(String ad_etime) {
                this.ad_etime = ad_etime;
            }

            public String getAd_word() {
                return ad_word;
            }

            public void setAd_word(String ad_word) {
                this.ad_word = ad_word;
            }

            public String getAd_introduction() {
                return ad_introduction;
            }

            public void setAd_introduction(String ad_introduction) {
                this.ad_introduction = ad_introduction;
            }

            public String getActivity_id() {
                return activity_id;
            }

            public void setActivity_id(String activity_id) {
                this.activity_id = activity_id;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }

            public String getEvent_id() {
                return event_id;
            }

            public void setEvent_id(String event_id) {
                this.event_id = event_id;
            }

            public String getObject_type() {
                return object_type;
            }

            public void setObject_type(String object_type) {
                this.object_type = object_type;
            }

            public String getH5_link_ios() {
                return h5_link_ios;
            }

            public void setH5_link_ios(String h5_link_ios) {
                this.h5_link_ios = h5_link_ios;
            }

            public String getH5_link_android() {
                return h5_link_android;
            }

            public void setH5_link_android(String h5_link_android) {
                this.h5_link_android = h5_link_android;
            }

            public String getH5_name() {
                return h5_name;
            }

            public void setH5_name(String h5_name) {
                this.h5_name = h5_name;
            }

            public H5ShareBean getH5_share() {
                return h5_share;
            }

            public void setH5_share(H5ShareBean h5_share) {
                this.h5_share = h5_share;
            }

            public String getAd_pic_400() {
                return ad_pic_400;
            }

            public void setAd_pic_400(String ad_pic_400) {
                this.ad_pic_400 = ad_pic_400;
            }

            public String getAd_pic_250() {
                return ad_pic_250;
            }

            public void setAd_pic_250(String ad_pic_250) {
                this.ad_pic_250 = ad_pic_250;
            }

            public String getAd_pic_100() {
                return ad_pic_100;
            }

            public void setAd_pic_100(String ad_pic_100) {
                this.ad_pic_100 = ad_pic_100;
            }

            public String getAd_pic() {
                return ad_pic;
            }

            public void setAd_pic(String ad_pic) {
                this.ad_pic = ad_pic;
            }

            public String getSearch_keyword() {
                return search_keyword;
            }

            public void setSearch_keyword(String search_keyword) {
                this.search_keyword = search_keyword;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
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

            public String getEvent_type() {
                return event_type;
            }

            public void setEvent_type(String event_type) {
                this.event_type = event_type;
            }

            public String getAd_delivery() {
                return ad_delivery;
            }

            public void setAd_delivery(String ad_delivery) {
                this.ad_delivery = ad_delivery;
            }

            public static class H5ShareBean {
                /**
                 * h5_share_title :
                 * h5_share_content :
                 * h5_share_pic :
                 */

                private String h5_share_title;
                private String h5_share_content;
                private String h5_share_pic;

                public String getH5_share_title() {
                    return h5_share_title;
                }

                public void setH5_share_title(String h5_share_title) {
                    this.h5_share_title = h5_share_title;
                }

                public String getH5_share_content() {
                    return h5_share_content;
                }

                public void setH5_share_content(String h5_share_content) {
                    this.h5_share_content = h5_share_content;
                }

                public String getH5_share_pic() {
                    return h5_share_pic;
                }

                public void setH5_share_pic(String h5_share_pic) {
                    this.h5_share_pic = h5_share_pic;
                }
            }
        }
    }
}
