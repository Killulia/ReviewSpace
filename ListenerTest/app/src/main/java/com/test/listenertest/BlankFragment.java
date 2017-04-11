package com.test.listenertest;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private Button button;
    private ButtonListener buttonListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container,false);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (buttonListener!=null) {
                    buttonListener.onValue(button.getText().toString());
                }
            }
        });
        return view;
    }


    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }
}
