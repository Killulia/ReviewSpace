package com.test.eventbusreview;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

import static com.test.eventbusreview.R.id.frag_bt2;
import static com.test.eventbusreview.R.id.main_tv;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button,button1;
    private ViewPager pager;
    private List<Fragment> fragments;
    private FragAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        initData();
        initView();
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        textView = (TextView) findViewById(main_tv);
        adapter = new FragAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(adapter);
        pager.setOffscreenPageLimit(fragments.size()-1);

    }

    private void initData() {
        fragments = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (i%2==0) {
                EFragment fragment = new EFragment();
                fragments.add(fragment);
            }else {
                CFragment fragment1 = new CFragment();
                fragments.add(fragment1);
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void helloEventBus(String message){
        textView.setText(message);
    }
}
