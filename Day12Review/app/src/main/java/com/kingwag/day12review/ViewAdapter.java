package com.kingwag.day12review;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kingwag on 2016/12/16.
 */

public class ViewAdapter extends PagerAdapter {
    private String[] strings;
    private Context context;
    private LayoutInflater inflater;
    public ViewAdapter(Context context, String[] strings) {
        this.context = context;
        this.strings = strings;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.item_paer, container, false);
        TextView textView = (TextView) view.findViewById(R.id.item_text);
        textView.setText(strings[position]);
        container.addView(view);
        return view;
    }
}
