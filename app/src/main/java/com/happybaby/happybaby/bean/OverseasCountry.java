package com.happybaby.happybaby.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */

public class OverseasCountry {


    private int code;
    private String msg;
    private DataBeen data;

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

    public DataBeen getData() {
        return data;
    }

    public void setData(DataBeen data) {
        this.data = data;
    }

    public static class DataBeen {


        private AdListBean ad_list;
        private GoodsThingsBean goods_things;
        private CategoryListBean category_list;
        private HotRecommendBean hot_recommend;
        private HotEventListBean hot_event_list;
        private HotShowListBean hot_show_list;
        private GuessLikeBean guess_like;

        public AdListBean getAd_list() {
            return ad_list;
        }

        public void setAd_list(AdListBean ad_list) {
            this.ad_list = ad_list;
        }

        public GoodsThingsBean getGoods_things() {
            return goods_things;
        }

        public void setGoods_things(GoodsThingsBean goods_things) {
            this.goods_things = goods_things;
        }

        public CategoryListBean getCategory_list() {
            return category_list;
        }

        public void setCategory_list(CategoryListBean category_list) {
            this.category_list = category_list;
        }

        public HotRecommendBean getHot_recommend() {
            return hot_recommend;
        }

        public void setHot_recommend(HotRecommendBean hot_recommend) {
            this.hot_recommend = hot_recommend;
        }

        public HotEventListBean getHot_event_list() {
            return hot_event_list;
        }

        public void setHot_event_list(HotEventListBean hot_event_list) {
            this.hot_event_list = hot_event_list;
        }

        public HotShowListBean getHot_show_list() {
            return hot_show_list;
        }

        public void setHot_show_list(HotShowListBean hot_show_list) {
            this.hot_show_list = hot_show_list;
        }

        public GuessLikeBean getGuess_like() {
            return guess_like;
        }

        public void setGuess_like(GuessLikeBean guess_like) {
            this.guess_like = guess_like;
        }

        public static class AdListBean {
            /**
             * module_type : carousel_figure_module
             * module_name : 轮播图
             * module_icon :
             * more : {"event_type":"","is_show":false}
             * rank :
             * template : 1
             * data : {"list":[{"ad_id":"11025","advert_id":"GG20161207008","ad_name":"秋冬美妆嘉年华","/10/4/an
             */

            private String module_type;
            private String module_name;
            private String module_icon;
            private MoreBean more;
            private String rank;
            private String template;
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

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
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
                 * event_type :
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
                private List<ListBean> list;

                public List<ListBean> getList() {
                    return list;
                }

                public void setList(List<ListBean> list) {
                    this.list = list;
                }

                public static class ListBean {
                    /**
                     * ad_id : 11025
                     * advert_id : GG20161207008
                     * ad_name : 秋冬美妆嘉年华
                     * ad_link : http://sale.baobeigezi.com/2016/11/10
                     * ad_type : link
                     * ad_area : 0
                     * ad_etime : 2016-12-31 10:00:00
                     * ad_introduction : 美丽即刻绽放|全场直降包邮包税
                     * ad_word : 秋冬美妆嘉年华
                     * activity_id : null
                     * product_id :
                     * event_id :
                     * raider_id :
                     * h5_link_ios : http://sale.baobeigezi.com/2016/11/10/ios/index.html
                     * h5_link_android : http://sale.baobeigezi.com/2016/11/10/android/index.html
                     * h5_name : 秋冬美妆嘉年华
                     * h5_share : {"h5_share_title":"","h5_share_content":"","h5_share_pic":""}
                     * ad_pic_400 : http://image.baoimg.net/da/201612/2016120715004127047058_400x400.jpg
                     * ad_pic_250 : http://img02.baoimg.net/da/201612/2016120715004127047058_250x250.jpg
                     * ad_pic_100 : http://img03.baoimg.net/da/201612/2016120715004127047058_100x100.jpg
                     * ad_pic : http://img01.baoimg.net/da/201612/2016120715004127047058.jpg
                     * search_keyword :
                     * category_id :
                     * category_name :
                     * brand_id :
                     * brand_name :
                     * brand_logo :
                     * event_type : type_link
                     * ad_delivery :
                     */

                    private String ad_id;
                    private String advert_id;
                    private String ad_name;//标题字段
                    private String ad_link;
                    private String ad_type;
                    private String ad_area;
                    private String ad_etime;
                    private String ad_introduction;//广告字段
                    private String ad_word;
                    private Object activity_id;
                    private String product_id;
                    private String event_id;
                    private String raider_id;
                    private String h5_link_ios;
                    private String h5_link_android;//h5android界面跳转
                    private String h5_name;
                    private H5ShareBean h5_share;
                    private String ad_pic_400;
                    private String ad_pic_250;
                    private String ad_pic_100;
                    private String ad_pic;//图片字段
                    private String search_keyword;
                    private String category_id;
                    private String category_name;
                    private String brand_id;
                    private String brand_name;
                    private String brand_logo;
                    private String event_type;
                    private String ad_delivery;

                    public String getAd_id() {
                        return ad_id;
                    }

                    public void setAd_id(String ad_id) {
                        this.ad_id = ad_id;
                    }

                    public String getAdvert_id() {
                        return advert_id;
                    }

                    public void setAdvert_id(String advert_id) {
                        this.advert_id = advert_id;
                    }

                    public String getAd_name() {
                        return ad_name;
                    }

                    public void setAd_name(String ad_name) {
                        this.ad_name = ad_name;
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

                    public String getAd_introduction() {
                        return ad_introduction;
                    }

                    public void setAd_introduction(String ad_introduction) {
                        this.ad_introduction = ad_introduction;
                    }

                    public String getAd_word() {
                        return ad_word;
                    }

                    public void setAd_word(String ad_word) {
                        this.ad_word = ad_word;
                    }

                    public Object getActivity_id() {
                        return activity_id;
                    }

                    public void setActivity_id(Object activity_id) {
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

                    public String getRaider_id() {
                        return raider_id;
                    }

                    public void setRaider_id(String raider_id) {
                        this.raider_id = raider_id;
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

                    public String getBrand_logo() {
                        return brand_logo;
                    }

                    public void setBrand_logo(String brand_logo) {
                        this.brand_logo = brand_logo;
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
        /*
        好物推荐


         */
        public static class GoodsThingsBean {
            /**
             * module_type : good_things_module
             * module_name : 好物推荐
             * module_icon : http://static.baocdn.com/images/user/hwtj_26.png?1457323390
             * more : {"event_type":"type_goods_thing","is_show":true}
             * rank :
             * template : 1
             * data : {"list":[{"raider_id":"447","title":"拿什么拯救你的时尚公主病","introduction":"实际可行的时尚生
             */

            private String module_type;
            private String module_name;
            private String module_icon;
            private MoreBeanX more;
            private String rank;
            private String template;
            private DataBeanX data;

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

            public MoreBeanX getMore() {
                return more;
            }

            public void setMore(MoreBeanX more) {
                this.more = more;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public DataBeanX getData() {
                return data;
            }

            public void setData(DataBeanX data) {
                this.data = data;
            }

            public static class MoreBeanX {
                /**
                 * event_type : type_goods_thing
                 * is_show : true
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

            public static class DataBeanX {
                private List<ListBeanX> list;

                public List<ListBeanX> getList() {
                    return list;
                }

                public void setList(List<ListBeanX> list) {
                    this.list = list;
                }

                public static class ListBeanX {
                    /**
                     * raider_id : 447
                     * title : 拿什么拯救你的时尚公主病
                     * introduction : 实际可行的时尚生活方式，无拘无束的活力与感觉，这就是我要的。

                     * phone_head_pic : http://img03.baoimg.net/photo/201612/2016120717001136275010.jpg
                     * phone_small_pic : http://img01.baoimg.net/photo/201612/2016120717000139575035_100x100.jpg
                     * uid : 2000023
                     * nick_name : 少年
                     * avatar : http://img03.baoimg.net/photo/201510/2015100713003335514532_100x100.jpg
                     * like_num : 3
                     * link :
                     * comment_num : 1
                     */

                    private String raider_id;
                    private String title;
                    private String introduction;
                    private String phone_head_pic;
                    private String phone_small_pic;
                    private String uid;
                    private String nick_name;
                    private String avatar;
                    private String like_num;
                    private String link;
                    private String comment_num;

                    public String getRaider_id() {
                        return raider_id;
                    }

                    public void setRaider_id(String raider_id) {
                        this.raider_id = raider_id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getIntroduction() {
                        return introduction;
                    }

                    public void setIntroduction(String introduction) {
                        this.introduction = introduction;
                    }

                    public String getPhone_head_pic() {
                        return phone_head_pic;
                    }

                    public void setPhone_head_pic(String phone_head_pic) {
                        this.phone_head_pic = phone_head_pic;
                    }

                    public String getPhone_small_pic() {
                        return phone_small_pic;
                    }

                    public void setPhone_small_pic(String phone_small_pic) {
                        this.phone_small_pic = phone_small_pic;
                    }

                    public String getUid() {
                        return uid;
                    }

                    public void setUid(String uid) {
                        this.uid = uid;
                    }

                    public String getNick_name() {
                        return nick_name;
                    }

                    public void setNick_name(String nick_name) {
                        this.nick_name = nick_name;
                    }

                    public String getAvatar() {
                        return avatar;
                    }

                    public void setAvatar(String avatar) {
                        this.avatar = avatar;
                    }

                    public String getLike_num() {
                        return like_num;
                    }

                    public void setLike_num(String like_num) {
                        this.like_num = like_num;
                    }

                    public String getLink() {
                        return link;
                    }

                    public void setLink(String link) {
                        this.link = link;
                    }

                    public String getComment_num() {
                        return comment_num;
                    }

                    public void setComment_num(String comment_num) {
                        this.comment_num = comment_num;
                    }
                }
            }
        }
        /*
        分类精选


         */


        public static class CategoryListBean {
            /**
             * module_type : oversea_category_module
             * module_name : 分类精选
             * module_icon : http://static.baocdn.com/images/user/fljx_26.png?1457323390
             * more : {"event_type":"","is_show":false}
             * rank :
             * template : 1
             * data : {"list":[{"id":"294","category_id":"28","category_name":"奶粉","201608/2016080311001386697045.jpg"}]}
             */

            private String module_type;
            private String module_name;
            private String module_icon;
            private MoreBeanXX more;
            private String rank;
            private String template;
            private DataBeanXX data;

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

            public MoreBeanXX getMore() {
                return more;
            }

            public void setMore(MoreBeanXX more) {
                this.more = more;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public DataBeanXX getData() {
                return data;
            }

            public void setData(DataBeanXX data) {
                this.data = data;
            }

            public static class MoreBeanXX {
                /**
                 * event_type :
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

            public static class DataBeanXX {
                private List<ListBeanXX> list;

                public List<ListBeanXX> getList() {
                    return list;
                }

                public void setList(List<ListBeanXX> list) {
                    this.list = list;
                }

                public static class ListBeanXX {
                    /**
                     * id : 294
                     * category_id : 28
                     * category_name : 奶粉
                     * category_pic : da/201601/201601268000666574026.png
                     * category_pic_new : da/201606/201606148001898012325.jpg
                     * country_id : 8
                     * sort : 1
                     * status : 1
                     * is_delete : 0
                     * createtime : 2016-06-14 08:59:46
                     * updatetime : 2016-06-14 08:59:51
                     * deletetime : null
                     * createoperator : chenhaiyan
                     * updateoperator : chenhaiyan
                     * deleteoperator : null
                     * alias :
                     * category_pic_link : http://image.baoimg.net/da/201606/201606148001898012325.jpg
                     */

                    private String id;
                    private String category_id;
                    private String category_name;
                    private String category_pic;
                    private String category_pic_new;
                    private String country_id;
                    private String sort;
                    private String status;
                    private String is_delete;
                    private String createtime;
                    private String updatetime;
                    private Object deletetime;
                    private String createoperator;
                    private String updateoperator;
                    private Object deleteoperator;
                    private String alias;
                    private String category_pic_link;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
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

                    public String getCategory_pic() {
                        return category_pic;
                    }

                    public void setCategory_pic(String category_pic) {
                        this.category_pic = category_pic;
                    }

                    public String getCategory_pic_new() {
                        return category_pic_new;
                    }

                    public void setCategory_pic_new(String category_pic_new) {
                        this.category_pic_new = category_pic_new;
                    }

                    public String getCountry_id() {
                        return country_id;
                    }

                    public void setCountry_id(String country_id) {
                        this.country_id = country_id;
                    }

                    public String getSort() {
                        return sort;
                    }

                    public void setSort(String sort) {
                        this.sort = sort;
                    }

                    public String getStatus() {
                        return status;
                    }

                    public void setStatus(String status) {
                        this.status = status;
                    }

                    public String getIs_delete() {
                        return is_delete;
                    }

                    public void setIs_delete(String is_delete) {
                        this.is_delete = is_delete;
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

                    public Object getDeletetime() {
                        return deletetime;
                    }

                    public void setDeletetime(Object deletetime) {
                        this.deletetime = deletetime;
                    }

                    public String getCreateoperator() {
                        return createoperator;
                    }

                    public void setCreateoperator(String createoperator) {
                        this.createoperator = createoperator;
                    }

                    public String getUpdateoperator() {
                        return updateoperator;
                    }

                    public void setUpdateoperator(String updateoperator) {
                        this.updateoperator = updateoperator;
                    }

                    public Object getDeleteoperator() {
                        return deleteoperator;
                    }

                    public void setDeleteoperator(Object deleteoperator) {
                        this.deleteoperator = deleteoperator;
                    }

                    public String getAlias() {
                        return alias;
                    }

                    public void setAlias(String alias) {
                        this.alias = alias;
                    }

                    public String getCategory_pic_link() {
                        return category_pic_link;
                    }

                    public void setCategory_pic_link(String category_pic_link) {
                        this.category_pic_link = category_pic_link;
                    }
                }
            }
        }

        /*
        热门推荐


         */

        public static class HotRecommendBean {
            /**
             * module_type : hot_recommended_module
             * module_name : 热门推荐
             * module_icon : http://static.baocdn.com/images/user/baokuan_26.png?1457323390
             * more : {"event_type":"","is_show":false}
             * rank :
             * template : 1
             * data : {"list":[{"ad_id":"7828","advert_id":"GG20160727020","ad_name":"美赞臣&雅培奶粉包邮包税"606/201606149002421173241.png"},"product_icon_new":null}]}
             */

            private String module_type;
            private String module_name;
            private String module_icon;
            private MoreBeanXXX more;
            private String rank;
            private String template;
            private DataBeanXXX data;

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

            public MoreBeanXXX getMore() {
                return more;
            }

            public void setMore(MoreBeanXXX more) {
                this.more = more;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public DataBeanXXX getData() {
                return data;
            }

            public void setData(DataBeanXXX data) {
                this.data = data;
            }

            public static class MoreBeanXXX {
                /**
                 * event_type :
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

            public static class DataBeanXXX {
                private List<ListBeanXXX> list;
                private List<ProductListBean> product_list;

                public List<ListBeanXXX> getList() {
                    return list;
                }

                public void setList(List<ListBeanXXX> list) {
                    this.list = list;
                }

                public List<ProductListBean> getProduct_list() {
                    return product_list;
                }

                public void setProduct_list(List<ProductListBean> product_list) {
                    this.product_list = product_list;
                }

                public static class ListBeanXXX {
                    /**
                     * ad_id : 7828
                     * advert_id : GG20160727020
                     * ad_name : 美赞臣&雅培奶粉包邮包税
                     * ad_link :
                     * ad_type : event
                     * ad_area : 1207
                     * ad_etime : 2017-07-01 10:00:00
                     * ad_introduction : 美赞臣&雅培奶粉专场
                     * ad_word : 包邮包税极速达
                     * activity_id : 0
                     * product_id :
                     * event_id : 6396
                     * raider_id :
                     * h5_link_ios : /ios/index.html
                     * h5_link_android : /android/index.html
                     * h5_name :
                     * h5_share : {"h5_share_title":"","h5_share_content":"","h5_share_pic":""}
                     * ad_pic_400 : http://img03.baoimg.net/da/201607/2016072718002273433637_400x400.jpg
                     * ad_pic_250 : http://img01.baoimg.net/da/201607/2016072718002273433637_250x250.jpg
                     * ad_pic_100 : http://img03.baoimg.net/da/201607/2016072718002273433637_100x100.jpg
                     * ad_pic : http://image.baoimg.net/da/201607/2016072718002273433637.jpg
                     * search_keyword :
                     * category_id :
                     * category_name :
                     * brand_id :
                     * brand_name :
                     * brand_logo :
                     * event_type : type_events
                     * ad_delivery :
                     */

                    private String ad_id;
                    private String advert_id;
                    private String ad_name;
                    private String ad_link;
                    private String ad_type;
                    private String ad_area;
                    private String ad_etime;
                    private String ad_introduction;
                    private String ad_word;
                    private int activity_id;
                    private String product_id;
                    private String event_id;
                    private String raider_id;
                    private String h5_link_ios;
                    private String h5_link_android;
                    private String h5_name;
                    private H5ShareBeanX h5_share;
                    private String ad_pic_400;
                    private String ad_pic_250;
                    private String ad_pic_100;
                    private String ad_pic;
                    private String search_keyword;
                    private String category_id;
                    private String category_name;
                    private String brand_id;
                    private String brand_name;
                    private String brand_logo;
                    private String event_type;
                    private String ad_delivery;

                    public String getAd_id() {
                        return ad_id;
                    }

                    public void setAd_id(String ad_id) {
                        this.ad_id = ad_id;
                    }

                    public String getAdvert_id() {
                        return advert_id;
                    }

                    public void setAdvert_id(String advert_id) {
                        this.advert_id = advert_id;
                    }

                    public String getAd_name() {
                        return ad_name;
                    }

                    public void setAd_name(String ad_name) {
                        this.ad_name = ad_name;
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

                    public String getAd_introduction() {
                        return ad_introduction;
                    }

                    public void setAd_introduction(String ad_introduction) {
                        this.ad_introduction = ad_introduction;
                    }

                    public String getAd_word() {
                        return ad_word;
                    }

                    public void setAd_word(String ad_word) {
                        this.ad_word = ad_word;
                    }

                    public int getActivity_id() {
                        return activity_id;
                    }

                    public void setActivity_id(int activity_id) {
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

                    public String getRaider_id() {
                        return raider_id;
                    }

                    public void setRaider_id(String raider_id) {
                        this.raider_id = raider_id;
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

                    public H5ShareBeanX getH5_share() {
                        return h5_share;
                    }

                    public void setH5_share(H5ShareBeanX h5_share) {
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

                    public String getBrand_logo() {
                        return brand_logo;
                    }

                    public void setBrand_logo(String brand_logo) {
                        this.brand_logo = brand_logo;
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

                    public static class H5ShareBeanX {
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

                public static class ProductListBean {
                    /**
                     * product_id : 13212
                     * goods_id : 4733
                     * shop_id : 0
                     * category_id : 1455
                     * country_id : 8
                     * sellcountry_id : 72
                     * brand_id : 1842
                     * brand_name : Child Life
                     * brand_logo : http://static.baocdn.com/
                     * is_oversea : 2
                     * createtime : 2014-10-20 11:09:30
                     * updatetime : 2016-12-09 18:11:12
                     * first_onshelftime : 2015-09-22 11:41:28
                     * name : 包邮包税 美国直邮Child Life婴幼儿钙镁锌液体钙16盎司 474ml
                     * short_title : 包邮 钙镁锌液体钙474ml
                     * image : photo/201607/2016072912002532388331.jpg
                     * market_price : 13.72
                     * store_price : 93.99
                     * is_nostock : 0
                     * event_type : type_goods
                     * product_icon : ["http://static.baocdn.com/images/activity/baoyou.png"]
                     * sold_number : 4242
                     * activity_price : 93.99
                     * recommended_reason :
                     * country_flag : http://image.baoimg.net/da/201606/201606149002421173241.png
                     * country_name : 美国
                     * image_url_400 : http://img01.baoimg.net/photo/201607/2016072912002532388331_400x400.jpg
                     * image_url_250 : http://img02.baoimg.net/photo/201607/2016072912002532388331_250x250.jpg
                     * image_url_100 : http://image.baoimg.net/photo/201607/2016072912002532388331_100x100.jpg
                     * image_url_50 : http://img02.baoimg.net/photo/201607/2016072912002532388331_50x50.jpg
                     * image_url : http://img02.baoimg.net/photo/201607/2016072912002532388331.jpg
                     * currency_market_price : 13.72
                     * currency_symbol : $
                     * refer_text_url : amazon.com
                     * likeNumber : 605
                     * commentNumber : 318
                     * sellcountry_info : {"country_name":"美国","mobi_image_url":"http://image.baoimg.net/da/201606/201606149002421173241.png"}
                     * product_icon_new : [{"url":"http://static.baocdn.com/images/activity/baoyou_v262.png","height":44,"width":88}]
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
                         * mobi_image_url : http://image.baoimg.net/da/201606/201606149002421173241.png
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
                         * url : http://static.baocdn.com/images/activity/baoyou_v262.png
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
        /*
        热门活动


         */

        public static class HotEventListBean {
            /**
             * module_type : hot_event_module
             * module_name : 热门活动
             * module_icon : http://static.baocdn.com/images/user/rmhd_26.png?1457323390
             * more : {"event_type":"","is_show":false}
             * rank :
             * template : 1
             * data : {"list":[{"ad_id":"10072","advert_id":"GG20161026005","ad_name":"秋季香水口红专场",
             */

            private String module_type;
            private String module_name;
            private String module_icon;
            private MoreBeanXXXX more;
            private String rank;
            private String template;
            private DataBeanXXXX data;

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

            public MoreBeanXXXX getMore() {
                return more;
            }

            public void setMore(MoreBeanXXXX more) {
                this.more = more;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public DataBeanXXXX getData() {
                return data;
            }

            public void setData(DataBeanXXXX data) {
                this.data = data;
            }

            public static class MoreBeanXXXX {
                /**
                 * event_type :
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

            public static class DataBeanXXXX {
                private List<ListBeanXXXX> list;

                public List<ListBeanXXXX> getList() {
                    return list;
                }

                public void setList(List<ListBeanXXXX> list) {
                    this.list = list;
                }

                public static class ListBeanXXXX {
                    /**
                     * ad_id : 10072
                     * advert_id : GG20161026005
                     * ad_name : 秋季香水口红专场
                     * ad_link :
                     * ad_type : event
                     * ad_area : 1201
                     * ad_etime : 2016-12-31 10:00:00
                     * ad_introduction : 秋季香水口红专场直降包邮包税
                     * ad_word : 让ta遇见你就心跳加速
                     * activity_id : 0
                     * product_id :
                     * event_id : 8002
                     * raider_id :
                     * h5_link_ios : /ios/index.html
                     * h5_link_android : /android/index.html
                     * h5_name :
                     * h5_share : {"h5_share_title":"","h5_share_content":"","h5_share_pic":""}
                     * ad_pic_400 : http://image.baoimg.net/da/201610/2016102610002811383178_400x400.jpg
                     * ad_pic_250 : http://image.baoimg.net/da/201610/2016102610002811383178_250x250.jpg
                     * ad_pic_100 : http://image.baoimg.net/da/201610/2016102610002811383178_100x100.jpg
                     * ad_pic : http://img03.baoimg.net/da/201610/2016102610002811383178.jpg
                     * search_keyword :
                     * category_id :
                     * category_name :
                     * brand_id :
                     * brand_name :
                     * brand_logo :
                     * event_type : type_events
                     * ad_delivery :
                     */

                    private String ad_id;
                    private String advert_id;
                    private String ad_name;
                    private String ad_link;
                    private String ad_type;
                    private String ad_area;
                    private String ad_etime;
                    private String ad_introduction;
                    private String ad_word;
                    private int activity_id;
                    private String product_id;
                    private String event_id;
                    private String raider_id;
                    private String h5_link_ios;
                    private String h5_link_android;
                    private String h5_name;
                    private H5ShareBeanXX h5_share;
                    private String ad_pic_400;
                    private String ad_pic_250;
                    private String ad_pic_100;
                    private String ad_pic;
                    private String search_keyword;
                    private String category_id;
                    private String category_name;
                    private String brand_id;
                    private String brand_name;
                    private String brand_logo;
                    private String event_type;
                    private String ad_delivery;

                    public String getAd_id() {
                        return ad_id;
                    }

                    public void setAd_id(String ad_id) {
                        this.ad_id = ad_id;
                    }

                    public String getAdvert_id() {
                        return advert_id;
                    }

                    public void setAdvert_id(String advert_id) {
                        this.advert_id = advert_id;
                    }

                    public String getAd_name() {
                        return ad_name;
                    }

                    public void setAd_name(String ad_name) {
                        this.ad_name = ad_name;
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

                    public String getAd_introduction() {
                        return ad_introduction;
                    }

                    public void setAd_introduction(String ad_introduction) {
                        this.ad_introduction = ad_introduction;
                    }

                    public String getAd_word() {
                        return ad_word;
                    }

                    public void setAd_word(String ad_word) {
                        this.ad_word = ad_word;
                    }

                    public int getActivity_id() {
                        return activity_id;
                    }

                    public void setActivity_id(int activity_id) {
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

                    public String getRaider_id() {
                        return raider_id;
                    }

                    public void setRaider_id(String raider_id) {
                        this.raider_id = raider_id;
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

                    public H5ShareBeanXX getH5_share() {
                        return h5_share;
                    }

                    public void setH5_share(H5ShareBeanXX h5_share) {
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

                    public String getBrand_logo() {
                        return brand_logo;
                    }

                    public void setBrand_logo(String brand_logo) {
                        this.brand_logo = brand_logo;
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

                    public static class H5ShareBeanXX {
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

        /*
        最热晒图


         */

        public static class HotShowListBean {
            /**
             * module_type : hot_show_module
             * module_name : 最热晒图
             * module_icon : http://static.baocdn.com/images/user/zrst_26.png?1457323390
             * more : {"event_type":"event_tag_detail","is_show":true,"tag_id":"3270"}
             * rank :
             * template : 1
             * data : {"list":[{"show_id":"1007408","g"},"is_zan":0}]}
             */

            private String module_type;
            private String module_name;
            private String module_icon;
            private MoreBeanXXXXX more;
            private String rank;
            private String template;
            private DataBeanXXXXX data;

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

            public MoreBeanXXXXX getMore() {
                return more;
            }

            public void setMore(MoreBeanXXXXX more) {
                this.more = more;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public DataBeanXXXXX getData() {
                return data;
            }

            public void setData(DataBeanXXXXX data) {
                this.data = data;
            }

            public static class MoreBeanXXXXX {
                /**
                 * event_type : event_tag_detail
                 * is_show : true
                 * tag_id : 3270
                 */

                private String event_type;
                private boolean is_show;
                private String tag_id;

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

                public String getTag_id() {
                    return tag_id;
                }

                public void setTag_id(String tag_id) {
                    this.tag_id = tag_id;
                }
            }

            public static class DataBeanXXXXX {
                private List<ListBeanXXXXX> list;

                public List<ListBeanXXXXX> getList() {
                    return list;
                }

                public void setList(List<ListBeanXXXXX> list) {
                    this.list = list;
                }

                public static class ListBeanXXXXX {
                    /**
                     * show_id : 1007408
                     * content : %EF%BC%83%E9%99%AA%E5%A8%83%E6%88%90%E9%95%BF%E7%9A%84%E5%A5%BD%E7%89%A9%EF%BC%83%E9%80%82%E5%90%88%E5%B9%BC%E5%84%BF%E5%9B%AD%E5%AE%9D%E5%AE%9D%E5%92%8C%E5%B0%8F%E5%AD%A6%E7%AB%A5%EF%BC%8C%E5%BE%88%E6%8B%89%E9%A3%8E%EF%BC%8C%E7%8E%B0%E5%9C%A8%E8%83%8C%E7%A8%8D%E5%BE%AE%E6%9C%89%E7%82%B9%E5%A4%A7%EF%BC%8C%E6%98%8E%E5%B9%B4%E4%BC%B0%E8%AE%A1%E5%90%88%E9%80%82%E3%80%82
                     * show_image : http://img01.baoimg.net/bg1/M00/00/28/wKgQyVdOUdaACVmDAAKXsYctekk008_400x400.jpg
                     * zan_num : 127
                     * user_info : {"id":"3914674","uid":"14287158","nick_name":"骑着上帝流浪去","verify_phone":"1","verify_
                     * is_zan : 0
                     */

                    private String show_id;
                    private String content;
                    private String show_image;
                    private String zan_num;
                    private UserInfoBean user_info;
                    private int is_zan;

                    public String getShow_id() {
                        return show_id;
                    }

                    public void setShow_id(String show_id) {
                        this.show_id = show_id;
                    }

                    public String getContent() {
                        return content;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }

                    public String getShow_image() {
                        return show_image;
                    }

                    public void setShow_image(String show_image) {
                        this.show_image = show_image;
                    }

                    public String getZan_num() {
                        return zan_num;
                    }

                    public void setZan_num(String zan_num) {
                        this.zan_num = zan_num;
                    }

                    public UserInfoBean getUser_info() {
                        return user_info;
                    }

                    public void setUser_info(UserInfoBean user_info) {
                        this.user_info = user_info;
                    }

                    public int getIs_zan() {
                        return is_zan;
                    }

                    public void setIs_zan(int is_zan) {
                        this.is_zan = is_zan;
                    }

                    public static class UserInfoBean {
                        /**
                         * id : 3914674
                         * uid : 14287158
                         * nick_name : 骑着上帝流浪去
                         * verify_phone : 1
                         * verify_email : 0
                         * category : 1
                         * name :
                         * tel :
                         * gender : 0
                         * birthday : 0000-00-00
                         * marriage : 2
                         * avatar : http://img03.baoimg.net/photo/201604/2016040610003359228664_100x100.png
                         * country : 0
                         * province : 0
                         * city : 0
                         * area : 0
                         * address :
                         * zipcode :
                         * id_card :
                         * earning :
                         * hobby :
                         * score : 105
                         * order_num : 0
                         * status : 1
                         * createip : 123.126.109.217
                         * createtime : 2015-09-23 15:50:01
                         * updatetime : 2016-04-06 10:00:28
                         * lastlogintime : 2016-12-13 14:10:19
                         * last_sign : 2016-04-07 09:14:53
                         * source : 0
                         * remarks : null
                         * add_user :
                         * primary_user : 0
                         * is_shop : 1
                         * shop_open_time : 2016-08-03 17:44:02
                         * personal_signature : 还没有写签名哦~
                         * is_signature : 0
                         * verify_avatar : true
                         * middle_avatar : http://img03.baoimg.net/photo/201604/2016040610003359228664_250x250.png
                         * big_avatar : http://img03.baoimg.net/photo/201604/2016040610003359228664_400x400.png
                         */

                        private String id;
                        private String uid;
                        private String nick_name;
                        private String verify_phone;
                        private String verify_email;
                        private String category;
                        private String name;
                        private String tel;
                        private String gender;
                        private String birthday;
                        private String marriage;
                        private String avatar;
                        private String country;
                        private String province;
                        private String city;
                        private String area;
                        private String address;
                        private String zipcode;
                        private String id_card;
                        private String earning;
                        private String hobby;
                        private String score;
                        private String order_num;
                        private String status;
                        private String createip;
                        private String createtime;
                        private String updatetime;
                        private String lastlogintime;
                        private String last_sign;
                        private String source;
                        private Object remarks;
                        private String add_user;
                        private String primary_user;
                        private String is_shop;
                        private String shop_open_time;
                        private String personal_signature;
                        private int is_signature;
                        private boolean verify_avatar;
                        private String middle_avatar;
                        private String big_avatar;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getUid() {
                            return uid;
                        }

                        public void setUid(String uid) {
                            this.uid = uid;
                        }

                        public String getNick_name() {
                            return nick_name;
                        }

                        public void setNick_name(String nick_name) {
                            this.nick_name = nick_name;
                        }

                        public String getVerify_phone() {
                            return verify_phone;
                        }

                        public void setVerify_phone(String verify_phone) {
                            this.verify_phone = verify_phone;
                        }

                        public String getVerify_email() {
                            return verify_email;
                        }

                        public void setVerify_email(String verify_email) {
                            this.verify_email = verify_email;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getTel() {
                            return tel;
                        }

                        public void setTel(String tel) {
                            this.tel = tel;
                        }

                        public String getGender() {
                            return gender;
                        }

                        public void setGender(String gender) {
                            this.gender = gender;
                        }

                        public String getBirthday() {
                            return birthday;
                        }

                        public void setBirthday(String birthday) {
                            this.birthday = birthday;
                        }

                        public String getMarriage() {
                            return marriage;
                        }

                        public void setMarriage(String marriage) {
                            this.marriage = marriage;
                        }

                        public String getAvatar() {
                            return avatar;
                        }

                        public void setAvatar(String avatar) {
                            this.avatar = avatar;
                        }

                        public String getCountry() {
                            return country;
                        }

                        public void setCountry(String country) {
                            this.country = country;
                        }

                        public String getProvince() {
                            return province;
                        }

                        public void setProvince(String province) {
                            this.province = province;
                        }

                        public String getCity() {
                            return city;
                        }

                        public void setCity(String city) {
                            this.city = city;
                        }

                        public String getArea() {
                            return area;
                        }

                        public void setArea(String area) {
                            this.area = area;
                        }

                        public String getAddress() {
                            return address;
                        }

                        public void setAddress(String address) {
                            this.address = address;
                        }

                        public String getZipcode() {
                            return zipcode;
                        }

                        public void setZipcode(String zipcode) {
                            this.zipcode = zipcode;
                        }

                        public String getId_card() {
                            return id_card;
                        }

                        public void setId_card(String id_card) {
                            this.id_card = id_card;
                        }

                        public String getEarning() {
                            return earning;
                        }

                        public void setEarning(String earning) {
                            this.earning = earning;
                        }

                        public String getHobby() {
                            return hobby;
                        }

                        public void setHobby(String hobby) {
                            this.hobby = hobby;
                        }

                        public String getScore() {
                            return score;
                        }

                        public void setScore(String score) {
                            this.score = score;
                        }

                        public String getOrder_num() {
                            return order_num;
                        }

                        public void setOrder_num(String order_num) {
                            this.order_num = order_num;
                        }

                        public String getStatus() {
                            return status;
                        }

                        public void setStatus(String status) {
                            this.status = status;
                        }

                        public String getCreateip() {
                            return createip;
                        }

                        public void setCreateip(String createip) {
                            this.createip = createip;
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

                        public String getLastlogintime() {
                            return lastlogintime;
                        }

                        public void setLastlogintime(String lastlogintime) {
                            this.lastlogintime = lastlogintime;
                        }

                        public String getLast_sign() {
                            return last_sign;
                        }

                        public void setLast_sign(String last_sign) {
                            this.last_sign = last_sign;
                        }

                        public String getSource() {
                            return source;
                        }

                        public void setSource(String source) {
                            this.source = source;
                        }

                        public Object getRemarks() {
                            return remarks;
                        }

                        public void setRemarks(Object remarks) {
                            this.remarks = remarks;
                        }

                        public String getAdd_user() {
                            return add_user;
                        }

                        public void setAdd_user(String add_user) {
                            this.add_user = add_user;
                        }

                        public String getPrimary_user() {
                            return primary_user;
                        }

                        public void setPrimary_user(String primary_user) {
                            this.primary_user = primary_user;
                        }

                        public String getIs_shop() {
                            return is_shop;
                        }

                        public void setIs_shop(String is_shop) {
                            this.is_shop = is_shop;
                        }

                        public String getShop_open_time() {
                            return shop_open_time;
                        }

                        public void setShop_open_time(String shop_open_time) {
                            this.shop_open_time = shop_open_time;
                        }

                        public String getPersonal_signature() {
                            return personal_signature;
                        }

                        public void setPersonal_signature(String personal_signature) {
                            this.personal_signature = personal_signature;
                        }

                        public int getIs_signature() {
                            return is_signature;
                        }

                        public void setIs_signature(int is_signature) {
                            this.is_signature = is_signature;
                        }

                        public boolean isVerify_avatar() {
                            return verify_avatar;
                        }

                        public void setVerify_avatar(boolean verify_avatar) {
                            this.verify_avatar = verify_avatar;
                        }

                        public String getMiddle_avatar() {
                            return middle_avatar;
                        }

                        public void setMiddle_avatar(String middle_avatar) {
                            this.middle_avatar = middle_avatar;
                        }

                        public String getBig_avatar() {
                            return big_avatar;
                        }

                        public void setBig_avatar(String big_avatar) {
                            this.big_avatar = big_avatar;
                        }
                    }
                }
            }
        }
        /*
        猜你喜欢


         */

        public static class GuessLikeBean {
            /**
             * module_type : may_like_module
             * module_name : 猜你喜欢
             * module_icon : http://static.baocdn.com/images/user/may_like_26.png?1457323390
             * more : {"event_type":"","is_show":false}
             * rank :
             * template : 1
             * data : {"list":[]}
             */

            private String module_type;
            private String module_name;
            private String module_icon;
            private MoreBeanXXXXXX more;
            private String rank;
            private String template;
            private DataBeanXXXXXX data;

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

            public MoreBeanXXXXXX getMore() {
                return more;
            }

            public void setMore(MoreBeanXXXXXX more) {
                this.more = more;
            }

            public String getRank() {
                return rank;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public String getTemplate() {
                return template;
            }

            public void setTemplate(String template) {
                this.template = template;
            }

            public DataBeanXXXXXX getData() {
                return data;
            }

            public void setData(DataBeanXXXXXX data) {
                this.data = data;
            }

            public static class MoreBeanXXXXXX {
                /**
                 * event_type :
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

            public static class DataBeanXXXXXX {
                private List<?> list;

                public List<?> getList() {
                    return list;
                }

                public void setList(List<?> list) {
                    this.list = list;
                }
            }
        }
    }
}
