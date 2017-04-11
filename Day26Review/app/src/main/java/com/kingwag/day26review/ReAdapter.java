package com.kingwag.day26review;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by kingwag on 2016/12/17.
 */

public class ReAdapter extends BaseQuickAdapter<BaseBean.ResultBean.DataBean>{
    private Context context;
    public ReAdapter( Context context,List<BaseBean.ResultBean.DataBean> datas) {
        super(R.layout.item_layout,datas);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, BaseBean.ResultBean.DataBean dataBean) {
        baseViewHolder.setText(R.id.item_tv,dataBean.getTitle());
        if (dataBean.getThumbnail_pic_s().equals("")==false) {
            Picasso.with(context).load(dataBean.getThumbnail_pic_s()).into((ImageView) baseViewHolder.getView(R.id.item_iv));
        }
    }
}
