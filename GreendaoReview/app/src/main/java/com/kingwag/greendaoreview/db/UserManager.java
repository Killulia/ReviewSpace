package com.kingwag.greendaoreview.db;

import android.content.Context;

import com.kingwag.greendaoreview.dao.DaoSession;
import com.kingwag.greendaoreview.bean.User;
import com.kingwag.greendaoreview.dao.UserDao;

import java.util.List;

/**
 * Created by kingwag on 2016/12/11.
 */

public class UserManager {

    private DaoSession session;
    public UserDao userDao;

    public UserManager(Context context) {
        session = DBhelper.getDaoSession(context);
        userDao = session.getUserDao();
    }

    //插入一条数据
    public void insert(User user)throws Exception{
        if (user == null) {
            return;
        }
        userDao.insert(user);
    }

    //插入多条数据
    public void insertAll(List<User> users)throws Exception{
        if (users==null||users.size()==0){
            return;
        }
        userDao.insertInTx(users);
    }


    //删除数据
    public void delete(User user)throws Exception{
        if (user == null) {
            return;
        }
        userDao.delete(user);
    }

    //删除多条数据
    public void deleteAll()throws Exception{
        userDao.deleteAll();
    }

    //更新数据
    public void update(User user)throws Exception{
        if (user == null) {
            return;
        }
        userDao.update(user);
    }

    //查找所有数据
    public List<User> quearyAll(){
        return userDao.queryBuilder().list();
    }

    //查找一条数据
    public User queary(Long id){
        List<User> users = userDao.queryBuilder()
                .where(UserDao.Properties.Id.eq(id))
                .list();
        if (users==null||users.size()==0){
            return null;
        }
        return users.get(0);
    }

}
