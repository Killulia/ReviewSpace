package com.kingwag.day12review;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.simple.transformslibrary.Flip3DTransform;
import com.simple.transformslibrary.StackZoomInTransform;
import com.simple.transformslibrary.TransformUtil;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewAdapter adapter;
    private LinearLayout layout;
    private String[] strings = {"天问", "水寒", "工布", "惊睨"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initADDot();
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(strings.length-1);
        adapter = new ViewAdapter(this, strings);
        viewPager.setAdapter(adapter);
        TransformUtil.reverse(viewPager,new Flip3DTransform());
        //viewPager.setPageTransformer(true,new DepthPageTransformer());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setADDot(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initADDot() {
        layout = (LinearLayout) findViewById(R.id.point);
        for (int i = 0; i < strings.length; i++) {
            View itemView = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(30, 30);
            //设置间距
            params.leftMargin = 20;
            itemView.setLayoutParams(params);
            itemView.setBackgroundResource(R.drawable.btn_ad_dot);
            if (i == 0) {
                itemView.setSelected(true);
            }
            layout.addView(itemView);
        }
    }

    //根据位置，设置圆点高亮显示
    private void setADDot(int position) {
        //获得圆点数据
        int itemCount = layout.getChildCount();
        for (int i=0; i<itemCount; i++) {
            //获得具体的子View-圆点
            View itemView = layout.getChildAt(i);
            if (i == position % itemCount) { //高亮显示
                itemView.setSelected(true);
            } else {
                itemView.setSelected(false);
            }
        }
    }


}
