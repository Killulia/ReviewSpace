package com.kingwag.day11review;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by kingwag on 2016/12/16.
 */

public class KFragment extends Fragment {
    private Button button;
    private onBtClicklistner istner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_layout, container, false);
        button = (Button) view.findViewById(R.id.btgrag);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               istner.onClick(button.getText().toString());
            }
        });
        return view;
    }

    public interface onBtClicklistner{
        void onClick(String str);
    }

    public void setOnclick(onBtClicklistner onBtClicklistner){
        this.istner = onBtClicklistner;
    }

}
