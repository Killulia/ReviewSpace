package com.test.eventbusreview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import de.greenrobot.event.EventBus;



/**
 * Created by kingwag on 2016/12/3.
 */

public class CFragment extends Fragment {
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_layout2, container, false);
        initView(view);
        return view;
    }
    private void initView(View rootview) {
        button = (Button) rootview.findViewById(R.id.frag_bt2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(button.getText().toString());
            }
        });

    }
}
