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

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxActivity extends AppCompatActivity {

    private EditText phoneEdt, pswEdt;

    private Retrofit retrofit;

    private LoginApiService loginApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
        initView();
        initRetrofit();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.POST_BASE_URL)     // baseurl
                .client(OkHttpUtils.newOkHttpClient(this))  //OkHttpClient单例模式
                .addConverterFactory(GsonConverterFactory.create()) //Gson解析
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //RXJava回调
                .build();
        loginApiService = retrofit.create(LoginApiService.class);
    }

    private void initView() {
        phoneEdt = (EditText) findViewById(R.id.phone_edt);
        pswEdt = (EditText) findViewById(R.id.psw_edt);
        findViewById(R.id.regist_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = phoneEdt.getEditableText().toString();
                String psw = pswEdt.getEditableText().toString();

                //RXJava处理Retrofit
                loginApiService.getLoginRxCall(phone, psw)//获得被观察者
                    .subscribeOn(Schedulers.newThread()) //在新线程中执行请求
                    .observeOn(AndroidSchedulers.mainThread())//在UI线程回调
                    .subscribe(new Subscriber<LoginBean>() { //被观察者订阅观察者//Subscriber就是观察者
                        @Override
                        public void onCompleted() {}

                        @Override
                        public void onError(Throwable e) {}

                        @Override
                        public void onNext(LoginBean loginBean) {
                            Log.e("Tag", "thread = " + Thread.currentThread().getName());
                            Log.e("Tag", "loginBean = " + loginBean.getResult().getResultMsg());
                        }
                    });

            }
        });
    }
}
