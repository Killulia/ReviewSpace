package com.kingwag.day13review;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentTabHost tabHost;
    private TabWidget tabWidget;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        tabHost.setup(this,manager,android.R.id.tabcontent);
        tabHost.addTab(buildTabSpec(R.drawable.state_index,R.string.tab_index,"index"),KFragment.class,null);
        tabHost.addTab(buildTabSpec(R.drawable.state_category,R.string.tab_category,"category"),KFragment.class,null);
        tabHost.addTab(buildTabSpec(R.drawable.state_mine,R.string.tab_mine,"mine"),KFragment.class,null);
        tabHost.addTab(buildTabSpec(R.drawable.state_shop,R.string.tab_shop,"shop"),KFragment.class,null);
        tabHost.addTab(buildTabSpec(R.drawable.state_more,R.string.tab_more,"more"),KFragment.class,null);
        tabHost.getTabWidget().setDividerDrawable(android.R.color.transparent);
    }





    public TabHost.TabSpec buildTabSpec(int imageId, int textId, String tag) {
        // 把布局解析成View
        View view = LayoutInflater.from(this).inflate(R.layout.item_navigation_view, null);
        ImageView ivTabIcon = (ImageView) view.findViewById(R.id.iv_tab_icon);
        TextView tvTabText = (TextView)view.findViewById(R.id.tv_tab_text);
        // 从外部传递进来的图片Id和文字id设置上
        ivTabIcon.setImageResource(imageId);
        tvTabText.setText(textId);
        // 生成TabSpec(需要为当前Fragment绑定Tag标签，另外需要添加一个View)
        return tabHost.newTabSpec(tag).setIndicator(view);
    }

}
