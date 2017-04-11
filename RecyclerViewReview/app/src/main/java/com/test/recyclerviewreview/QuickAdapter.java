package com.test.recyclerviewreview;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by kingwag on 2016/11/27.
 */

public class QuickAdapter extends BaseQuickAdapter<String>{
    public QuickAdapter( List<String> data) {
        super(R.layout.item_re, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(R.id.re_tv, s);
    }
}
