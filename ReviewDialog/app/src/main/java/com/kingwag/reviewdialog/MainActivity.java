package com.kingwag.reviewdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("kingwag", "---onCreat");
        Button button = (Button) findViewById(R.id.bt);
        View view = LayoutInflater.from(this).inflate(R.layout.list_pop, null);
        final PopupWindow window = new PopupWindow(view,1000, 2000);
        window.setOutsideTouchable(false);
       //window.setFocusable(false);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SEcondActivity.class);
                startActivity(intent);
               /* intent.putExtra("main", 1);
                startActivityForResult(intent,100);*/
            }
        });


    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==100){
            String str = data.getStringExtra("second");
            Log.d("kingwag", str);
        }else {
            Log.d("kingwag", "no");
        }
    }*/

    /*@Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"hahah",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("kingwag", "---onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("kingwag", "---onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("kingwag", "---onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("kingwag", "---onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("kingwag", "---onReStart");
    }

    @Override
    protected void onDestroy() {
        Log.d("kingwag", "---onDestroy");
    }*/
}
