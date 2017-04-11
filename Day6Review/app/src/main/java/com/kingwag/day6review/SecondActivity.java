package com.kingwag.day6review;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
/**
 * Created by kingwag on 2016/12/13.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("2ty", "Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("2ty", "Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("2ty", "Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("2ty", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("2ty", "Pause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        Log.d("2ty", "save");
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
