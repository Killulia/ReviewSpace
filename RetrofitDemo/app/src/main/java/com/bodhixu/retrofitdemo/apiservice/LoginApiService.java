package com.bodhixu.retrofitdemo.apiservice;

import com.bodhixu.retrofitdemo.bean.LoginBean;

import java.util.HashMap;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by bodhixu on 2016/12/12.
 */

public interface LoginApiService {

    //上传From表单（键值对）
    @POST("RegistServlet")
    @FormUrlEncoded
    Call<ResponseBody> getLoginCall(
            @Field("phone") String phone,
            @Field("psw") String psw
    );

    //上传From表单（键值对）
    @POST("RegistServlet")
    @FormUrlEncoded
    Call<ResponseBody> getLoginCall(@FieldMap HashMap<String, String> fieldMap);


    // 上传文件
    @POST("MutilUploadServlet")
    @Multipart
    //Call<ResponseBody> uploadFileCall(@Part(value = "images\"; filename=\"abc.png") RequestBody requestBody);
    Call<ResponseBody> uploadFileCall(@Part MultipartBody.Part requestBodyPart);

    //分块上传
    @POST("MutilUploadServlet")
    Call<ResponseBody> uploadMultiFilesCall(@Body MultipartBody requestBody);

    //上传From表单（键值对）
    @POST("RegistServlet")
    @FormUrlEncoded
    Call<LoginBean> getLoginGsonCall(
            @Field("phone") String phone,
            @Field("psw") String psw
    );

    //上传From表单（键值对）
    @POST("RegistServlet")
    @FormUrlEncoded
    Observable<LoginBean> getLoginRxCall(
            @Field("phone") String phone,
            @Field("psw") String psw
    );

}
