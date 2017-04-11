package com.yztctech.android11_07_customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

/**
 * 演示自定义Dialog
 */
public class MainActivity extends AppCompatActivity {

    private OutDialog outDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //实例化自定义的Dialog，实现其抽象方法
        outDialog = new OutDialog(this) {

            @Override
            void out() {
                finish();
            }
        };
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            outDialog.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}
