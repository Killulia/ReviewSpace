package com.test.listviewreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import static com.test.listviewreview.R.id.list;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<NewsBean.ResultBean.DataBean> datas;
    private LAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
     //   initView();
    }

    private void initData() {
        datas = new ArrayList<>();
        final Gson gson = new Gson();
        new JsonTask("http://v.juhe.cn/toutiao/index?type=top&key=6ce2dfc57ad2abef3f6a51cf02cf9993", new JsonTask.OnDownloadLisntner() {
            @Override
            public void onSuccess(String result) {
                NewsBean strs = gson.fromJson(result, NewsBean.class);
                datas = strs.getResult().getData();
                Log.d("ha", String.valueOf(datas.size()));
                listView = (ListView) findViewById(list);
                adapter = new LAdapter(MainActivity.this, datas);
                listView.setAdapter(adapter);
            }
        }).execute();


    }

    private void initView() {
        listView = (ListView) findViewById(list);
        adapter = new LAdapter(MainActivity.this, datas);
        listView.setAdapter(adapter);
    }
}
