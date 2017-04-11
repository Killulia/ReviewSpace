package com.kingwag.rxjavareview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kingwag.rxjavareview.bean.ResultBean;
import com.kingwag.rxjavareview.utils.OkHttpUtils;
import com.kingwag.rxjavareview.R;
import com.kingwag.rxjavareview.constants.UrlConstants;
import com.kingwag.rxjavareview.rxinterface.GithubService;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.kingwag.rxjavareview.R.id.getbt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Retrofit retrofit;
    private GithubService servicer;
    private Call<ResultBean> call;
    private TextView text;
    private Button getBt;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRetrofit();


    }

    private void initView() {
        text = (TextView) findViewById(R.id.test);
        getBt = (Button) findViewById(R.id.getbt);
        getBt.setOnClickListener(this);
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.BASE_URL)
                .client(OkHttpUtils.newOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        servicer = retrofit.create(GithubService.class);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getbt:
                servicer.getUserString()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<ResultBean>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(ResultBean resultBean) {
                                text.setText(resultBean.getStatus());
                            }
                        });

                break;
        }
    }

    private void doGet() {
        call.enqueue(new Callback<ResultBean>() {
            @Override
            public void onResponse(Call<ResultBean> call, Response<ResultBean> response) {
                String resuilt = null;
                ResultBean bean = null;
                try {
                    //resuilt = response.body().string();
                    bean = response.body();
                    text.setText(bean.getStatus());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResultBean> call, Throwable t) {

            }


        });
    }
}
