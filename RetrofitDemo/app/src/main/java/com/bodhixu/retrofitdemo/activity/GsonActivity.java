package com.bodhixu.retrofitdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.bodhixu.retrofitdemo.R;
import com.bodhixu.retrofitdemo.apiservice.LoginApiService;
import com.bodhixu.retrofitdemo.bean.LoginBean;
import com.bodhixu.retrofitdemo.constant.UrlConstants;
import com.bodhixu.retrofitdemo.util.OkHttpUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GsonActivity extends AppCompatActivity {

    private EditText phoneEdt, pswEdt;

    private Retrofit retrofit;
    private LoginApiService loginApiService;
    private Call<LoginBean> call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
        initRetrofit();
        initView();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.POST_BASE_URL)
                .client(OkHttpUtils.newOkHttpClient(this))
                //添加GsonConverterFactory，将结果直接解析成JavaBean
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginApiService = retrofit.create(LoginApiService.class);
    }

    private void initView() {
        phoneEdt = (EditText) findViewById(R.id.phone_edt);
        pswEdt = (EditText) findViewById(R.id.psw_edt);
        findViewById(R.id.regist_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call = loginApiService.getLoginGsonCall(
                        phoneEdt.getEditableText().toString(),
                        pswEdt.getEditableText().toString()
                );
                call.enqueue(new Callback<LoginBean>() {
                    @Override
                    public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                        LoginBean loginBean = response.body();
                        Log.e("Tag", "msg = " + loginBean.getResult().getResultMsg());
                    }

                    @Override
                    public void onFailure(Call<LoginBean> call, Throwable t) {
                        Log.e("Tag", "onFailure = " + t.getMessage());
                    }
                });
            }
        });
    }
}
