package com.kingwag.handlerreview;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private List<Integer> list;
    private MyAdaper adapter;
    private TextView textView;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String text = String.valueOf(msg.arg1);
            textView.setText(text);
        }
    };
//    private Runnable runable = new Runnable() {
//        @Override
//        public void run() {
//            int count = pager.getCurrentItem();
//            count++;
//            if (count>3){
//                count=0;
//            }
//            pager.setCurrentItem(count);
//
//            handler.postDelayed(runable, 2000);
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initview();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(R.mipmap.p1);
        list.add(R.mipmap.p2);
        list.add(R.mipmap.p3);
        list.add(R.mipmap.p4);
    }

    private void initview() {
        textView = (TextView) findViewById(R.id.tv);
//        pager = (ViewPager) findViewById(R.id.pager);
//        adapter = new MyAdaper(this, list);
//        pager.setAdapter(adapter);
//        pager.setOffscreenPageLimit(list.size() - 1);
//        pager.setCurrentItem(0);
//        handler.postDelayed(runable, 2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;

                while (count<5){
                    Message msg = new Message();
                    msg.arg1 = count;
                    handler.sendMessage(msg);
                    count++;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }


}
