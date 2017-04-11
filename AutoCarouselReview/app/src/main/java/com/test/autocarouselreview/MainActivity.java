package com.test.autocarouselreview;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout mLinearlayout;
    private ImageView pointer;
    private RelativeLayout rlRoot;
    private ArrayList<ImageView> data;
    private int[] imgs = new int[]{R.mipmap.t2, R.mipmap.t3, R.mipmap.t4};
    private int previousPos;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
