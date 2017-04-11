package com.kingwag.day26review;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private XRecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private ReAdapter adapter;
    private BaseBean basebean;
    private List<BaseBean.ResultBean.DataBean> dataBeanList;
    //网络请求
    private Retrofit retrofit;
    private GithubService servicer;
    private Call<BaseBean> call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
        initData();

    }



    private void initData() {
        servicer.getUserString()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<BaseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(BaseBean resultBean) {
                        initView(resultBean);
//                        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
//                            @Override
//                            public void onRefresh() {
//
//
//                                recyclerView.refreshComplete();
//                            }
//
//                            @Override
//                            public void onLoadMore() {
//                                recyclerView.loadMoreComplete();
//                            }
//                        });
                    }
                });
    }

    private void initView(BaseBean resultBean) {
        basebean = resultBean;
        dataBeanList = basebean.getResult().getData();
        manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView = (XRecyclerView) findViewById(R.id.recycle);
        recyclerView.setPullRefreshEnabled(true); //支持下拉刷新
        recyclerView.setLoadingMoreEnabled(true);//支持上拉加载
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallBeat);//下拉刷新样式
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallBeat);//上拉刷新样式
        recyclerView.setLayoutManager(manager);
        adapter = new ReAdapter(MainActivity.this,dataBeanList);


        recyclerView.setAdapter(adapter);
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyConstants.BASE_URL)
                .client(OkHttpUtils.newOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        servicer = retrofit.create(GithubService.class);

    }
}
