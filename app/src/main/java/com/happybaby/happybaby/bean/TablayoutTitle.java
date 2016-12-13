package com.happybaby.happybaby.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class TablayoutTitle {

    /**
     * module_type : index_tab_module
     * module_name : 标签栏
     * module_icon :
     * more : {"event_type":"type_tab","is_show":false}
     * rank : 0
     * template : 1
     * data : [{"tab_name":"推荐","tab_type":"tuijian","h5_link_ios":"","h5_link_android":""},{"tab_name":"值得买","tab_type":"haowu","h5_link_ios":"","h5_link_android":""},{"tab_name":"助养","tab_type":"link","h5_link_ios":"http://sale.baobeigezi.com/2016/6/8_1/ios/index.html","h5_link_android":"http://sale.baobeigezi.com/2016/6/8_1/android/index.html"},{"tab_name":"进口奶粉","tab_type":"category","category_id":"28","h5_link_ios":"","h5_link_android":""},{"tab_name":"纸尿裤","tab_type":"category","category_id":"26","h5_link_ios":"","h5_link_android":""},{"tab_name":"辣妈专区","tab_type":"category","category_id":"8","h5_link_ios":"","h5_link_android":""},{"tab_name":"服饰轻奢","tab_type":"category","category_id":"12","h5_link_ios":"","h5_link_android":""},{"tab_name":"宝宝用品","tab_type":"category","category_id":"22","h5_link_ios":"","h5_link_android":""},{"tab_name":"美食营养","tab_type":"category","category_id":"20","h5_link_ios":"","h5_link_android":""},{"tab_name":"宝宝辅食","tab_type":"category","category_id":"24","h5_link_ios":"","h5_link_android":""},{"tab_name":"玩具图书","tab_type":"category","category_id":"10","h5_link_ios":"","h5_link_android":""},{"tab_name":"奶爸专区","tab_type":"category","category_id":"6","h5_link_ios":"","h5_link_android":""}]
     */

    private String module_type;
    private String module_name;
    private String module_icon;
    private MoreBean more;
    private int rank;
    private String template;
    private List<DataBean> data;

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

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class MoreBean {
        /**
         * event_type : type_tab
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
         * tab_name : 推荐
         * tab_type : tuijian
         * h5_link_ios :
         * h5_link_android :
         * category_id : 28
         */

        private String tab_name;
        private String tab_type;
        private String h5_link_ios;
        private String h5_link_android;
        private String category_id;

        public String getTab_name() {
            return tab_name;
        }

        public void setTab_name(String tab_name) {
            this.tab_name = tab_name;
        }

        public String getTab_type() {
            return tab_type;
        }

        public void setTab_type(String tab_type) {
            this.tab_type = tab_type;
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

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }
    }
}
