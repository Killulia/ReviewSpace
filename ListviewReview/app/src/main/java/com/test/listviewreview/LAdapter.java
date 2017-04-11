package com.test.listviewreview;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by kingwag on 2016/12/9.
 */

public class LAdapter extends BaseAdapter {
    private List<NewsBean.ResultBean.DataBean> datas;
    private LayoutInflater inflater;
    private Context context;
    public LAdapter(Context context,List<NewsBean.ResultBean.DataBean> datas) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Myholder myholder = null;
        if (view==null){
            view = inflater.inflate(R.layout.item_layout, viewGroup, false);
            myholder = new Myholder(view);
            view.setTag(myholder);
        }else {
            myholder= (Myholder) view.getTag();
        }
        NewsBean.ResultBean.DataBean bean = datas.get(i);

        if (!TextUtils.isEmpty(bean.getThumbnail_pic_s02())){
            String url = bean.getThumbnail_pic_s02();

                Picasso.with(context).load(bean.getThumbnail_pic_s02()).into(myholder.img);

        }

        return view;
    }

    public static class Myholder{
        public ImageView img;

        public Myholder(View rootView) {
            img = (ImageView) rootView.findViewById(R.id.item_iv);
        }
    }

}
