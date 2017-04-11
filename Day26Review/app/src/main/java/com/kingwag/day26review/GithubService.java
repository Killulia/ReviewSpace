package com.kingwag.day26review;



import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by kingwag on 2016/12/13.
 */

public interface GithubService {
//    @GET("GetFeeds?column=0&PageSize=10&pageIndex=1")
//    Call<ResponseBody> getUserString();

    @GET("index?type=top&key=6ce2dfc57ad2abef3f6a51cf02cf9993")
    Observable<BaseBean> getUserString();
}
