package com.test.designreview.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.test.designreview.R;
import com.test.designreview.adapter.MainAdapter;
import com.test.designreview.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private List<String> list;
    private ViewPager pager;
    private List<Fragment> fragments;
    private MainAdapter adapter;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        initData();
        initView();



    }

    private void initData() {
        fragments = new ArrayList<>();
        list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            MainFragment fragment = new MainFragment();
            fragments.add(fragment);
            list.add("tab"+i);
        }
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tabLayout = (TabLayout) findViewById(R.id.tab);
        pager = (ViewPager) findViewById(R.id.pager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);
        adapter = new MainAdapter(getSupportFragmentManager(), list,fragments);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(list.size()-1);
        tabLayout.setupWithViewPager(pager);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.aname,
                R.string.apname

        );
        actionBarDrawerToggle.syncState();
    }
}
