package com.test.tablayoutreview;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.test.tablayoutreview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragments;
    private ViewPager pager;
    private TabLayout tabLayout;
    private FAdapter adapter;
    private List<String> strs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        adapter = new FAdapter(getSupportFragmentManager(), fragments, strs);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
    }

    private void initData() {
        fragments = new ArrayList<>();
        MFragnent frag1 = new MFragnent();
        frag1.setType(0);
        MFragnent frag2 = new MFragnent();
        frag2.setType(1);
        MFragnent frag3 = new MFragnent();
        frag3.setType(2);
        fragments.add(frag1);
        fragments.add(frag2);
        fragments.add(frag3);
        strs = new ArrayList<>();
        strs.add("首页");
        strs.add("数据");
        strs.add("新闻");
    }
}
