package com.kingwag.rxjavareview.rxinterface;

import com.kingwag.rxjavareview.bean.ResultBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by kingwag on 2016/12/13.
 */

public interface GithubService {
//    @GET("GetFeeds?column=0&PageSize=10&pageIndex=1")
//    Call<ResponseBody> getUserString();

    @GET("GetFeeds?column=0&PageSize=10&pageIndex=1")
    Observable<ResultBean> getUserString();
}
