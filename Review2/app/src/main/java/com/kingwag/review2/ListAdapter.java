package com.kingwag.review2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kingwag on 2016/11/20.
 */

public class ListAdapter extends BaseAdapter {
    private List<String> list;
    private LayoutInflater inflater;

    public ListAdapter(Context context,List<String> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view = inflater.inflate(R.layout.item_list, viewGroup, false);
            String s = list.get(i);
            TextView textView = (TextView) view.findViewById(R.id.item_tv);
            textView.setText(s);
        }
        return view;
    }
}
