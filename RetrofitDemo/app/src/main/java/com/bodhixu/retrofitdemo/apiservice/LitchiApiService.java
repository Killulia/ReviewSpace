package com.bodhixu.retrofitdemo.apiservice;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by bodhixu on 2016/12/12.
 */

public interface LitchiApiService {

    //固定的请求路径
    @GET("GetFeeds?column=0&PageSize=10&pageIndex=1")
    Call<ResponseBody> getLitchiCall();

    //动态的url
    @GET("{path}?column=0&PageSize=10&pageIndex=1")
    Call<ResponseBody> getLitchiCall(@Path("path")String path);

    //查询参数
    @GET("GetFeeds")
    Call<ResponseBody> getLitchiCall(
            @Query("column") int column,
            @Query("PageSize") int PageSize,
            @Query("pageIndex") int pageIndex
    );

    //查询参数集合
    @GET("GetFeeds")
    Call<ResponseBody> getLitchiCall(@QueryMap HashMap<String, Integer> queryMap);

    //动态url + 查询参数
    @GET("{path}")
    Call<ResponseBody> getLitchiCall(
            @Path("path")String path,
            @Query("column") int column,
            @Query("PageSize") int PageSize,
            @Query("pageIndex") int pageIndex
    );

}
