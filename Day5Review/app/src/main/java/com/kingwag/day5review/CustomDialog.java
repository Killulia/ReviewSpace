package com.kingwag.day5review;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

/**
 * Created by kingwag on 2016/12/13.
 */

public abstract class CustomDialog extends Dialog {
    public CustomDialog(Context context) {
        //使用自定义dialog样式
        super(context, R.style.CustomStyle);

        //制定布局
        setContentView(R.layout.dialog_layout);

        //确定
        findViewById(R.id.posi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                out();
            }
        });

        //取消
        findViewById(R.id.posi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancel();
            }
        });

    }

    public abstract void out();
}
