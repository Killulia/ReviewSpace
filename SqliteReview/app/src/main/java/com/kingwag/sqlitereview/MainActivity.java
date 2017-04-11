package com.kingwag.sqlitereview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.kingwag.sqlitereview.R.id.bt_del;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button addbt,delbt,quebt;
    private TextView tv;
    private DBManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new DBManager(this);
        initview();
    }

    private void initview() {
        //实例化控件
        addbt = (Button) findViewById(R.id.bt_add);
        delbt = (Button) findViewById(bt_del);
        quebt = (Button) findViewById(R.id.bt_query);
        tv = (TextView) findViewById(R.id.tv);
        addbt.setOnClickListener(this);
        quebt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_add:
                Student stu = new Student("kingwag");
                Log.d("kingwag", "添加上");
                manager.add(stu);
                break;
            case R.id.bt_del:
                break;
            case R.id.bt_query:
                List<Student> students = new ArrayList<>();
                students = manager.quearyAll();
                Student stutest = students.get(0);
                tv.setText(stutest.getName());
                break;
        }
    }
}
