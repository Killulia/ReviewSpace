package com.kingwag.greendaoreview.activity;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.kingwag.greendaoreview.R;
import com.kingwag.greendaoreview.adapter.UserAdapter;
import com.kingwag.greendaoreview.bean.User;
import com.kingwag.greendaoreview.dao.DaoSession;
import com.kingwag.greendaoreview.db.UserManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private UserAdapter adapter;
    private List<User> users;
    private UserManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initManager();
        initData();
        initView();
    }

    private void initManager() {
        manager = new UserManager(this);
    }


    private void initData() {
        users = new ArrayList<>();
        for (int i = 0;i<5;i++){
            User user = new User(Long.valueOf(i),"user"+i);
            users.add(user);
        }
        try {
            manager.insertAll(users);
            users = manager.quearyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initView() {
        listView = (ListView) findViewById(R.id.listview);
        adapter = new UserAdapter(this,users);
        listView.setAdapter(adapter);
    }
}
