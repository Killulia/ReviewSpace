package com.kingwag.okhttp3test;

import java.util.HashMap;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by kingwag on 2016/12/12.
 */
//1.创建 创建 I API
public interface LitchiapiService {

    //固定url
    @GET("GetFeeds?column=0&PageSize=10&pageIndex=1")
    Call<ResponseBody> getLitchiString();

    //动态url
    @GET("{path}?column=0&PageSize=10&pageIndex=1")
    Call<ResponseBody> getLitchiString(@Path("path") String path);

    //查询参数
    @GET("GetFeeds")
    Call<ResponseBody> getLitchiString(
            @Query("column") int column,
            @Query("PageSize") int PageSize,
            @Query("pageIndex") int pageIndex);

    //参数与动态混合
    @GET("{path}")
    Call<ResponseBody> getLitchiString(
            @Path("path") String path,
            @Query("column") int column,
            @Query("PageSize") int PageSize,
            @Query("pageIndex") int pageIndex);

    //参数集合
    @GET("GetFeeds")
    Call<ResponseBody> getLitchiString(@QueryMap HashMap<String, Integer> map);
}
