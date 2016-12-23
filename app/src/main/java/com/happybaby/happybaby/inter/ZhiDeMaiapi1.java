package com.happybaby.happybaby.inter;

import com.happybaby.happybaby.bean.ZhiDeMai2;
import com.happybaby.happybaby.constant.ZhideMaiContants;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/22.
 */
public interface ZhiDeMaiapi1 {
    @GET(ZhideMaiContants.ZHIDEMAI_ITEM_NEW_PATH)
    Observable<ZhiDeMai2> getData(@Query("page") int page);
}