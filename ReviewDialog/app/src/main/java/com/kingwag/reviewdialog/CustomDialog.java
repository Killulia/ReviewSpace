package com.kingwag.reviewdialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kingwag on 2016/11/19.
 */

public class CustomDialog extends Dialog {
    OnclickListener onclickListener;
    LayoutInflater inflater;
    TextView mTvTitle;
    Button mButton;
    String mTitleStr;

    public CustomDialog(Context context) {
        super(context);
        inflater = LayoutInflater.from(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_custom);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mButton = (Button) findViewById(R.id.bt_ha);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTvTitle.setText(mTitleStr);
            }
        });

    }

    public void setOnclickListener(OnclickListener onclickListener1){
        this.onclickListener = onclickListener1;
    }

    // 对外暴露一个设置标题的方法
    public void setTitleStr(String title) {
        this.mTitleStr = title;
    }

    public interface OnclickListener{
        void onClick();
    }
}
