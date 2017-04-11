package com.kingwag.customviewreview;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BlankFragment extends Fragment {
    public interface OnClickListner{
        void onClick(String str);
    }
    private Button button;
    public OnClickListner listner;
    public void setOnclicklistner(OnClickListner listner){
        this.listner = listner;
        String msg = button.getText().toString();
        listner.onClick(msg);
    }
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, null);
        // Inflate the layout for this fragment

        return view;
    }



}
