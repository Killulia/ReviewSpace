package com.test.eventbustest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import org.greenrobot.eventbus.Subscribe;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.ThreadMode;
import static com.test.eventbustest.R.id.tv;
public class FirstActivity extends AppCompatActivity {
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        org.greenrobot.eventbus.EventBus.getDefault().register(this);
        btn = (Button) findViewById(R.id.btn_try);
        tv = (TextView) findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.EventBus.getDefault().unregister(this);
    }



    @Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public void helloEventBus(String message){
        tv.setText(message);
    }

}
