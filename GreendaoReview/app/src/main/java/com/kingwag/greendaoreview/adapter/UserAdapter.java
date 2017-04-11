package com.kingwag.greendaoreview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kingwag.greendaoreview.R;
import com.kingwag.greendaoreview.bean.User;

import java.util.List;

/**
 * Created by kingwag on 2016/12/11.
 */

public class UserAdapter extends BaseAdapter {
    private List<User> users;
    private LayoutInflater inflater;

    public UserAdapter(Context context,List<User> users) {
        this.users = users;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyHolder holder = null;
        if (view==null){
            view = inflater.inflate(R.layout.item_list, viewGroup, false);
            holder = new MyHolder(view);
            view.setTag(holder);
        }else {
            holder = (MyHolder) view.getTag();
        }
        User user = users.get(i);
        holder.text.setText(user.getName());
        return view;
    }

    public static class MyHolder{
        TextView text;

        public MyHolder(View rootView) {
            text = (TextView) rootView.findViewById(R.id.item_text);
        }
    }
}
