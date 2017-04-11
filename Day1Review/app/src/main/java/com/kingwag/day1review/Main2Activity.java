package com.kingwag.day1review;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.kingwag.day1review.R.id.texts;

public class Main2Activity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button button;
    private int count=0;
    private SeekBar seekBar;
    private TextView textView;
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button) findViewById(R.id.cash);
        progressBar = (ProgressBar) findViewById(R.id.pro);
        seekBar = (SeekBar) findViewById(R.id.seek);
        textView = (TextView) findViewById(texts);
        ratingBar = (RatingBar) findViewById(R.id.star);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    count++;
                    progressBar.setProgress(count);

            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("当前进度："+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                textView.setText("开始拖动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("停止拖动");
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                textView.setText("star num:"+v);
            }
        });
    }
}
