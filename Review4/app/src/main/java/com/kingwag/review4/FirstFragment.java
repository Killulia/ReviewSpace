package com.kingwag.review4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kingwag on 2016/11/22.
 */

public class FirstFragment extends Fragment {
    OnclickListner onclickListner;
    TextView textView;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View iview = inflater.inflate(R.layout.first_fragment, null);
        textView = (TextView) iview.findViewById(R.id.first_tv);

        return iview;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void setOnclickListner(OnclickListner listner){
        this.onclickListner = listner;
        String msg =textView.getText().toString();
        listner.getText(msg);
    }

    public void  getData(OnclickListner onclickListner1){
        String msg =textView.getText().toString();
        onclickListner1.getText(msg);
    }

    public interface OnclickListner{
        void getText(String str);
    }
}
