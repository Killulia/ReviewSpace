package com.test.tablayoutreview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by kingwag on 2016/12/4.
 */

public class MFragnent extends Fragment {
    int type = 0;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        switch (type){
            case 0:
                view = inflater.inflate(R.layout.frag_first, container, false);
                break;
            case 1:
                view = inflater.inflate(R.layout.frag_second, container, false);
                break;
            case 2:
                view = inflater.inflate(R.layout.frag_third, container, false);
                break;
        }
        return view;
    }

    public void setType(int type){
        this.type = type;
    }
}
