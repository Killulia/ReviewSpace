package com.kingwag.sharedreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et);
        button = (Button) findViewById(R.id.bt);
        String result = PreferencesUtil.getString(this, "KEY");
        if (result!=null){
            editText.setText(result);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = editText.getText().toString();
                PreferencesUtil.putString(MainActivity.this,"KEY",str);
            }
        });
    }
}
