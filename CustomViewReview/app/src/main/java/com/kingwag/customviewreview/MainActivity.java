package com.kingwag.customviewreview;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Map;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private NotificationManager manager;
    Notification notification;
    BlankFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setTicker("ticker")
                .setContentInfo("info")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("title")
                .setContentText("text")
                .setDefaults(Notification.DEFAULT_ALL);
        notification = builder.build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    return;
                }
                NotificationCompat.BigPictureStyle style = new android.support.v4.app.NotificationCompat.BigPictureStyle(builder);
                style.bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
                Notification notification2 = style.build();
                manager.notify(100,notification2);

            }
        });


    }
}
