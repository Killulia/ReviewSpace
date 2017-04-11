package com.kingwag.day6review;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "create");
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "stop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MainActivity", "restart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "destroy");
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d("MainActivity", "save");
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
