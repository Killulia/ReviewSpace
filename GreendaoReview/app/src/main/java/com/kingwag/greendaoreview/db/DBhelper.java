package com.kingwag.greendaoreview.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.kingwag.greendaoreview.dao.DaoMaster;
import com.kingwag.greendaoreview.dao.DaoSession;

/**
 * Created by kingwag on 2016/12/10.
 */

public class DBhelper {
    public static final String BE_NAME="user.db";
    private static DaoMaster.DevOpenHelper devOpenHelper;
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static SQLiteDatabase db;
    private static DBhelper dBhelper;

    private DBhelper(Context context){
        devOpenHelper = new DaoMaster.DevOpenHelper(context, BE_NAME);
    }

    public static DBhelper newInstance(Context context){
        if (dBhelper==null){
            synchronized (DBhelper.class){
                if (dBhelper == null) {
                    dBhelper = new DBhelper(context);
                }
            }
        }
        return dBhelper;
    }

    public static DaoSession getDaoSession(Context context){
        newInstance(context);
        db = devOpenHelper.getReadableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        return daoSession;
    }

}
