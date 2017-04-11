package com.kingwag.sqlitereview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingwag on 2016/11/24.
 */

public class DBManager {
    public static final String TABLE_NAME = "student";
    public static final String NAME_KEY = "name";
    public static final String NMAE_INDEX = "name";
    private DBHelper helper;
    public DBManager(Context context) {
        helper = new DBHelper(context);
    }

    public void add(Student student){
        SQLiteDatabase  db = helper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_KEY,student.getName());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }
    public List<Student> quearyAll(){
        List<Student> studentList = new ArrayList<>();
        //打开数据库
        SQLiteDatabase  db = helper.getReadableDatabase();
        //操作数据库
        Cursor cursor = db.query(
                TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        //获得列索引
        int nameIndex = cursor.getColumnIndex(NMAE_INDEX);
        //移动游标，向集合添加元素
        while (cursor.moveToNext()){
            String name = cursor.getString(nameIndex);
            Student student = new Student(name);
            studentList.add(student);
        }
        //关闭游标
        cursor.close();
        //关闭数据库
        db.close();
        return studentList;

    }
}
