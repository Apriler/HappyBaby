package com.happybaby.happybaby.search;

import java.util.List;

/**
 * Created by jianquan on 2016/12/29.
 */

public class HotSearchBean {

    /**
     * code : 1
     * msg : 成功!
     * data : {"indexWord":{"key_word":"红酒","recommend":"1","ad_type":"link","link":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_ios":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_android":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_name":"红酒","ad_name":"红酒"},"hotWords":[{"key_word":"红酒","recommend":"2","ad_type":"link","link":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_ios":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_android":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_name":"红酒","ad_name":"红酒","color":"#DC143C"},{"key_word":"戴森","recommend":"2","ad_type":"goods","product_id":"56323","color":"#DC143C"},{"key_word":"空气净化","recommend":"1","ad_type":"goods","product_id":"50150"},{"key_word":"A2","recommend":"1","ad_type":"event","event_id":"8411"},{"key_word":"保温杯","recommend":"1","ad_type":"event","event_id":"8405"},{"key_word":"牙膏","recommend":"1","ad_type":"event","event_id":"8471"},{"key_word":"包包","recommend":"1","ad_type":"link","link":"http://sales.baobeigezi.com/activity-html/2016/11/74db120f0a8e5646ef5a30154e9f6deb.html","h5_link_ios":"http://sales.baobeigezi.com/activity-html/2016/11/74db120f0a8e5646ef5a30154e9f6deb.html","h5_link_android":"http://sales.baobeigezi.com/activity-html/2016/11/74db120f0a8e5646ef5a30154e9f6deb.html","h5_name":"包包","ad_name":"包包"},{"key_word":"KM口红","recommend":"1","ad_type":"event","event_id":"8336"},{"key_word":"燕窝","recommend":"1","ad_type":"event","event_id":"8340"},{"key_word":"羊毛围巾","recommend":"2","ad_type":"event","event_id":"8322","color":"#DC143C"}]}
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
         * indexWord : {"key_word":"红酒","recommend":"1","ad_type":"link","link":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_ios":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_android":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_name":"红酒","ad_name":"红酒"}
         * hotWords : [{"key_word":"红酒","recommend":"2","ad_type":"link","link":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_ios":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_link_android":"http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html","h5_name":"红酒","ad_name":"红酒","color":"#DC143C"},{"key_word":"戴森","recommend":"2","ad_type":"goods","product_id":"56323","color":"#DC143C"},{"key_word":"空气净化","recommend":"1","ad_type":"goods","product_id":"50150"},{"key_word":"A2","recommend":"1","ad_type":"event","event_id":"8411"},{"key_word":"保温杯","recommend":"1","ad_type":"event","event_id":"8405"},{"key_word":"牙膏","recommend":"1","ad_type":"event","event_id":"8471"},{"key_word":"包包","recommend":"1","ad_type":"link","link":"http://sales.baobeigezi.com/activity-html/2016/11/74db120f0a8e5646ef5a30154e9f6deb.html","h5_link_ios":"http://sales.baobeigezi.com/activity-html/2016/11/74db120f0a8e5646ef5a30154e9f6deb.html","h5_link_android":"http://sales.baobeigezi.com/activity-html/2016/11/74db120f0a8e5646ef5a30154e9f6deb.html","h5_name":"包包","ad_name":"包包"},{"key_word":"KM口红","recommend":"1","ad_type":"event","event_id":"8336"},{"key_word":"燕窝","recommend":"1","ad_type":"event","event_id":"8340"},{"key_word":"羊毛围巾","recommend":"2","ad_type":"event","event_id":"8322","color":"#DC143C"}]
         */

        private IndexWordBean indexWord;
        private List<HotWordsBean> hotWords;

        public IndexWordBean getIndexWord() {
            return indexWord;
        }

        public void setIndexWord(IndexWordBean indexWord) {
            this.indexWord = indexWord;
        }

        public List<HotWordsBean> getHotWords() {
            return hotWords;
        }

        public void setHotWords(List<HotWordsBean> hotWords) {
            this.hotWords = hotWords;
        }

        public static class IndexWordBean {
            /**
             * key_word : 红酒
             * recommend : 1
             * ad_type : link
             * link : http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html
             * h5_link_ios : http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html
             * h5_link_android : http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html
             * h5_name : 红酒
             * ad_name : 红酒
             */

            private String key_word;
            private String recommend;
            private String ad_type;
            private String link;
            private String h5_link_ios;
            private String h5_link_android;
            private String h5_name;
            private String ad_name;

            public String getKey_word() {
                return key_word;
            }

            public void setKey_word(String key_word) {
                this.key_word = key_word;
            }

            public String getRecommend() {
                return recommend;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

            public String getAd_name() {
                return ad_name;
            }

            public void setAd_name(String ad_name) {
                this.ad_name = ad_name;
            }
        }

        public static class HotWordsBean {
            /**
             * key_word : 红酒
             * recommend : 2
             * ad_type : link
             * link : http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html
             * h5_link_ios : http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html
             * h5_link_android : http://sales.baobeigezi.com/activity-html/2016/11/9cfdf10e8fc047a44b08ed031e1f0ed1.html
             * h5_name : 红酒
             * ad_name : 红酒
             * color : #DC143C
             * product_id : 56323
             * event_id : 8411
             */

            private String key_word;
            private String recommend;
            private String ad_type;
            private String link;
            private String h5_link_ios;
            private String h5_link_android;
            private String h5_name;
            private String ad_name;
            private String color;
            private String product_id;
            private String event_id;

            public String getKey_word() {
                return key_word;
            }

            public void setKey_word(String key_word) {
                this.key_word = key_word;
            }

            public String getRecommend() {
                return recommend;
            }

            public void setRecommend(String recommend) {
                this.recommend = recommend;
            }

            public String getAd_type() {
                return ad_type;
            }

            public void setAd_type(String ad_type) {
                this.ad_type = ad_type;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
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

            public String getAd_name() {
                return ad_name;
            }

            public void setAd_name(String ad_name) {
                this.ad_name = ad_name;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
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
        }
    }
}
