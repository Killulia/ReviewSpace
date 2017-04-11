package com.kingwag.day17reviewbyrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String imgUrl = "http://b.hiphotos.baidu.com/image/pic/item/42166d224f4a20a43721cde195529822720ed0dd.jpg";
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        img = (ImageView) findViewById(R.id.img);
    }
}
