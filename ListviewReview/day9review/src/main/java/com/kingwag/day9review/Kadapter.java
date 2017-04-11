package com.kingwag.day9review;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kingwag on 2016/12/20.
 */

public class Kadapter extends BaseAdapter {
    private List<String> strings;
    private Context context;
    private LayoutInflater inflater;

    public Kadapter(Context context,List<String> strings ) {
        this.strings = strings;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int i) {
        return strings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Myholder myholder = null;
        if (view == null){
            view = inflater.inflate(R.layout.item_list,viewGroup,false);
            myholder = new Myholder(view);
            view.setTag(myholder);
        }else {
            myholder = (Myholder) view.getTag();
        }
        myholder.textView.setText(strings.get(i));
        return view;
    }

    public static class Myholder{
        TextView textView;

        public Myholder(View rootView) {
            textView = (TextView) rootView.findViewById(R.id.item_tv);
        }
    }

}
