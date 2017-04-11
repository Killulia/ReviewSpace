package com.kingwag.day11review;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import static com.kingwag.day11review.R.id.btgrag;

public class MainActivity extends AppCompatActivity implements KFragment.onBtClicklistner {
    private FragmentManager manager;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textfr);
        manager = getSupportFragmentManager();
        KFragment kFragment = new KFragment();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_main, kFragment);
        transaction.commit();
        kFragment.setOnclick(this);

    }

    @Override
    public void onClick(String str) {
        textView.setText(str);
    }
}
