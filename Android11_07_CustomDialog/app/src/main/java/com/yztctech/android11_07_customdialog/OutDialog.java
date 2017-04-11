package com.yztctech.android11_07_customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;

public abstract class OutDialog extends Dialog{

	public OutDialog(Context context) {
		//使用自定义Dialog样式
		super(context, R.style.customDialogStyle);
		
		//指定布局
		setContentView(R.layout.view_out_dialog);
		
		//确定
		findViewById(R.id.ok_button).setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				out();
			}
		});
		
		//取消
		findViewById(R.id.cancel_button).setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				cancel();
			}
		});
		
		//点击外部不可消失
		//setCancelable(false);
	}

	abstract void out();
	
}
