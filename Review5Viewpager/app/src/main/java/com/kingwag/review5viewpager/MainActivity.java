package com.kingwag.review5viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Integer> imglist;
    private ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = (ViewPager) findViewById(R.id.pager);
        imglist = new ArrayList<>();
        imglist.add(R.mipmap.ic_launcher);
        imglist.add(R.mipmap.ic_launcher);
        imglist.add(R.mipmap.ic_launcher);
        MyAdapter adapter = new MyAdapter(this,imglist);
        pager.setAdapter(adapter);

    }
}
