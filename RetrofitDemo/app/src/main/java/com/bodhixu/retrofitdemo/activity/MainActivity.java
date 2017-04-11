package com.bodhixu.retrofitdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bodhixu.retrofitdemo.R;
import com.bodhixu.retrofitdemo.apiservice.LitchiApiService;
import com.bodhixu.retrofitdemo.constant.UrlConstants;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Retrofit retrofit;

    private LitchiApiService litchiApiService;

    private Call<ResponseBody> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
        initView();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder() //创建Retrofit.Builder
                .baseUrl(UrlConstants.BASE_URL)  //绑定BaseUrl
                .build(); //创建创建Retrofit
        litchiApiService = retrofit.create(LitchiApiService.class); //创建接口对象

    }

    private void initView() {
        findViewById(R.id.normal_get_btn).setOnClickListener(this);
        findViewById(R.id.path_get_btn).setOnClickListener(this);
        findViewById(R.id.query_get_btn).setOnClickListener(this);
        findViewById(R.id.querymap_get_btn).setOnClickListener(this);
        findViewById(R.id.path_query_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.normal_get_btn: //固定Url
                call = litchiApiService.getLitchiCall();
                break;
            case R.id.path_get_btn: //动态Url
                call = litchiApiService.getLitchiCall("GetFeeds");
                break;
            case R.id.query_get_btn: //查询参数
                call = litchiApiService.getLitchiCall(0, 10, 1);
                break;
            case R.id.querymap_get_btn:
                HashMap<String, Integer> queryMap = new HashMap<>();
                queryMap.put("column", 0);
                queryMap.put("PageSize", 10);
                queryMap.put("pageIndex", 1);
                call = litchiApiService.getLitchiCall(queryMap);
                break;
            case R.id.path_query_btn: //动态url+path
                call = litchiApiService.getLitchiCall("GetFeeds", 0, 10, 1);
                break;
        }
        doGET();
    }

    //执行GET请求
    private void doGET() {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e("Tag", "result = " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Tag", "error = " + t.getMessage());
            }
        });
    }
}
