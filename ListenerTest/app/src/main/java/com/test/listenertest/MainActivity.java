package com.test.listenertest;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private TextView mTv;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BlankFragment fragment = new BlankFragment();
        fragment.setButtonListener(new ButtonListener() {
            @Override
            public void onValue(String str) {
                mTv.setText(str);
            }
        });
        transaction.add(R.id.activity_main,fragment);
        transaction.commit();
    }


}
