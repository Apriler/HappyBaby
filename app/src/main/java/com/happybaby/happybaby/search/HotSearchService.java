package com.happybaby.happybaby.search;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by jianquan on 2016/12/29.
 */

public interface HotSearchService {

    //热门搜索
    @GET("getWord")
    Observable<HotSearchBean> getHotSearchEntityCall();

    //搜索
    @GET("search_result_v26?r=android&cart_id=864855027637836& c=vivoRelease&v=3.0.21&page=1&agent=android&local_cart_id=864855027637836&size=10")
    Observable<SearchBean> getSearchEntityCall(
            @Query("key_word") String path

    );
}
