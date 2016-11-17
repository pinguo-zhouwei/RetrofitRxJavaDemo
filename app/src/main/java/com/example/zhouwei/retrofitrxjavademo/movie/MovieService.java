package com.example.zhouwei.retrofitrxjavademo.movie;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhouwei on 16/11/16.
 */

public interface MovieService {
    //获取豆瓣Top250 榜单
    @GET("top250")
    Observable<MovieSubject> getTop250(@Query("start") int start, @Query("count")int count);

}
