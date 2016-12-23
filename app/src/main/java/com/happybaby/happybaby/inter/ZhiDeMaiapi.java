package com.happybaby.happybaby.inter;

import com.happybaby.happybaby.bean.ZhiDeMai1;
import com.happybaby.happybaby.bean.ZhiDeMai2;
import com.happybaby.happybaby.constant.ZhideMaiContants;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/12/22.
 */

public interface ZhiDeMaiapi {
    @GET(ZhideMaiContants.ZHIDEMAI_LUNBO_URL)
    Observable<ZhiDeMai1> getData();
}


