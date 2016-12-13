package com.happybaby.happybaby.constant;

/**
 * Created by Administrator on 2016/12/13.
 */

public class OverseasConstant {
    //海外api接口地址
    public static final String BASE_URL = "http://v266.mapi.baobeigezi.com/v26_4/overseas/";

    //USA
    public static final String UP_URL1 = "http://v266.mapi.baobeigezi.com/v26_4/overseas/get_oversea_country_index?country=8&cart_id=867031025925444&r=android&agent=android&c=_360Release&v=3.0.2&local_cart_id=867031025925444";
    //Japan
    public static final String UP_URL2 = "http://v266.mapi.baobeigezi.com/v26_4/overseas/get_oversea_country_index?country=5&cart_id=867031025925444&r=android&agent=android&c=_360Release&v=3.0.2&local_cart_id=867031025925444";

    //usa
    public static final String UP_URL3 = "http://v266.mapi.baobeigezi.com/v26_4/overseas/get_may_like_product?country=8&cart_id=867031025925444&r=android&agent=android&c=_360Release&size=16&v=3.0.2&local_cart_id=867031025925444&page=1";
    // japan
    public static final String UP_URL4 = "http://v266.mapi.baobeigezi.com/v26_4/overseas/get_may_like_product?country=5&cart_id=867031025925444&r=android&agent=android&c=_360Release&size=16&v=3.0.2&local_cart_id=867031025925444&page=1";


    //国家数组
    public static final String[] COUNTRY_NAME = {"美国", "日本", "加拿大", "韩国", "德国", "澳大利亚", "意大利", "新西兰", "英国", "泰国", "荷兰", "新加坡", "法国", "中国台湾", "保税"};
    public static final int[] COUNTRY_ID = {8, 5, 3, 10, 12, 6, 17, 4, 14, 33, 9, 13, 16, 35, 0};

//保税	http://v266.mapi.baobeigezi.com/v26_4/overseas/get_bonded_index?cart_id=867031025925444&r=android&agent=android&c=_360Release&v=3.0.2&local_cart_id=867031025925444
    //   http://v266.mapi.baobeigezi.com/v26_4/overseas/get_bonded_product?cart_id=867031025925444&r=android&agent=android&c=_360Release&category_id=26&size=20&v=3.0.2&local_cart_id=867031025925444&page=1


}
