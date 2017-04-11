package com.kingwag.okhttp3test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button sameBt,asyncBt;
    private TextView text;
    Retrofit retrofit;
    LitchiapiService litchiapiService;
    retrofit2.Call<ResponseBody> call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initRetrofit();
    }

    private void initView() {
        sameBt = (Button) findViewById(R.id.get_same);
        asyncBt = (Button) findViewById(R.id.get_async);
        text = (TextView) findViewById(R.id.txt);
        sameBt.setOnClickListener(this);
        asyncBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.get_same://同步Get请求

            case R.id.get_async://异步Get请求

                //4.获得具体请求对象

                //固定Url
                //call = litchiapiService.getLitchiString();
                //动态Url
                //call = litchiapiService.getLitchiString("GetFeeds");
                //查询参数
                //call = litchiapiService.getLitchiString(0,10,1);
                //动态与参数混合
                //call = litchiapiService.getLitchiString("GetFeeds", 0, 10, 1);
                //参数集合
                HashMap<String, Integer> queryMap = new HashMap<>();
                queryMap.put("column",0);
                queryMap.put("PageSize",10);
                queryMap.put("pageIndex",1);
                call = litchiapiService.getLitchiString(queryMap);
                doGet();
                break;

        }
    }

    private void doGet() {
        //5.执行异步请求
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    String resuilt = response.body().string();
                    text.setText(resuilt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {

            }
        });
        return;
    }

    private void initRetrofit() {
        //2.创建Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.BASE_URL)
                .build();
        //3.创建API服务接口实例
        litchiapiService = retrofit.create(LitchiapiService.class);
    }
}
