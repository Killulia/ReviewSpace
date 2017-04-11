package com.kingwag.day1review;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

public class MainActivity extends AppCompatActivity {
    ViewStub viewStub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewStub = (ViewStub) findViewById(R.id.stub);
        viewStub.inflate();
    }

    public void hstub(View view){
        viewStub.inflate();
    }
}
