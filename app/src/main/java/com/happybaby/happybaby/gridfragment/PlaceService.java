package com.happybaby.happybaby.gridfragment;

import com.happybaby.happybaby.bean.PlaceBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by jianquan on 2016/12/20.
 */

public interface PlaceService {


    @GET("get_show_list?r=android&cart_id=d1fb74ae-f88f-416c-81e8-118e543a274e&session_id=2c61b55b7ba9f01132eb93c65802c813&c=vivoRelease&v=3.0.21&agent=android&local_cart_id=864855027637836&size=8")
    Observable<PlaceBean> getPlaceString(@Query("page") int i);
}
