package com.kingwag.review5viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by kingwag on 2016/11/22.
 */

public class MyAdapter extends PagerAdapter {
    private List<Integer> list;
    private LayoutInflater inflater;

    public MyAdapter(Context context,List<Integer> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = inflater.inflate(R.layout.item_pager, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.item_iv);
        imageView.setImageResource(list.get(position));
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
