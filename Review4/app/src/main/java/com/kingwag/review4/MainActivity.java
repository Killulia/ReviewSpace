package com.kingwag.review4;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mGetTv;
    private Button mGetBt;
    FragmentManager manager;
    FirstFragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        fragment = new FirstFragment();
        transaction.add(R.id.activity_main, fragment);
        transaction.commit();
    }

    private void initView() {
        mGetTv = (TextView) findViewById(R.id.get_tv);
        mGetBt = (Button) findViewById(R.id.get_bt);
        mGetBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.get_bt:

                fragment.setOnclickListner(new FirstFragment.OnclickListner() {
                    @Override
                    public void getText(String str) {
                        mGetTv.setText(str);
                    }
                });

                break;
        }
    }
}
