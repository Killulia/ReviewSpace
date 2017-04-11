package com.kingwag.day9review;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> strings;
    private ListView listview;
    private Button addbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        listview = (ListView) findViewById(R.id.list);
        addbt = (Button) findViewById(R.id.addbt);
        final Kadapter adapter = new Kadapter(this, strings);
        listview.setAdapter(adapter);
        addbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strings.add("" + (strings.size() + 1));
                adapter.notifyDataSetChanged();
                listview.setSelection(strings.size()-1);
            }
        });

        //滑动监听
        listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int atate) {
                switch (atate){
                    case SCROLL_STATE_IDLE:
                        Log.d("MainActivity", "滑动停止");
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        Log.d("MainActivity", "正在滑动");
                        break;
                    case SCROLL_STATE_FLING:
                        Log.d("MainActivity", "上抛");
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                Log.d("MainActivity", "onscroll");
            }
        });
    }

    private void initData() {
        strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(""+i);
        }
    }
}
