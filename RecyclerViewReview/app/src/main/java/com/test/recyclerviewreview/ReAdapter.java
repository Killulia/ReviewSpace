package com.test.recyclerviewreview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kingwag on 2016/11/26.
 */

public class ReAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<String> strings;
    private LayoutInflater inflater;
    private OnItemClickListner onItemClickListner;
    public ReAdapter(Context context,List<String> strings) {
        this.strings = strings;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_re, parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        String text = strings.get(position);
        ((MyHolder) holder).textView.setText(text);

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyHolder(final View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.re_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListner.onItemClick(itemView,getLayoutPosition());
                }
            });
        }


    }

    public void setOnItemClickListner(OnItemClickListner listner){
        this.onItemClickListner = listner;

    }

    public interface OnItemClickListner{
        void onItemClick(View view,int pisition);
    }





}
