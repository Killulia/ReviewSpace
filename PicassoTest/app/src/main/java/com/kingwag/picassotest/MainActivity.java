package com.kingwag.picassotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.iv_picasso);
        Picasso.with(this).load("http://ec4.images-amazon.com/images/I/71JzN0EJiIL._SL1500_.jpg")
                .into(imageView);
    }
}
