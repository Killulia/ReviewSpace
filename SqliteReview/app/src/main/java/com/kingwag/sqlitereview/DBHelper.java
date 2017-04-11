package com.kingwag.sqlitereview;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kingwag on 2016/11/24.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "kings.db";
    private static int VERSION = 1;
    public DBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student( _id integer primary key autoincrement,name text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
