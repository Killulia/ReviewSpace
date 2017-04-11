package com.kingwag.review6;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FragmentManager manager;
    private FragmentTabHost host;
    private TabWidget mTabWidget;
    private String[] strings = {"1","2","3"};
    private String[] tags = {"in","out","hin"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        host = (FragmentTabHost) findViewById(R.id.tab_host);
        mTabWidget = (TabWidget) findViewById(R.id.tabs);
        host.setup(this,manager,R.id.tabcontent);
        for (int i=0;i<strings.length;i++){
            host.addTab(host.newTabSpec(tags[i]).setIndicator(getTextView(strings[i])));
            host.getTabWidget().getChildAt(i).setBackgroundResource(R.color.colorPrimaryDark);
        }

    }

    private View getTextView(String text){
        View view = LayoutInflater.from(this).inflate(R.layout.fragment_index, null);
        TextView textView = (TextView) view.findViewById(R.id.tv_fragment);
        textView.setText(text);
        return view;
    }
}
