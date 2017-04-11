package com.yztcedu.day05_popupwindow;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
	
	LayoutInflater mInflater;
	View mLlRoot;
	PopupWindow mPopupWindow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mLlRoot = findViewById(R.id.ll_root);
		initPopupWindow();
	}
	
	public void initPopupWindow() {
		// 实例化视图解析器
		mInflater = LayoutInflater.from(this);
		// 把布局文件解析(实例化)成View
		View layout = mInflater.inflate(R.layout.popup_custom, null);
		mPopupWindow = new PopupWindow(layout, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		// popupWindow内部视图控件获取焦点
		mPopupWindow.setFocusable(true);
		// 设置popupwindow显示消去的动画
		mPopupWindow.setAnimationStyle(R.style.popupAnimation);
//		popupWindow.setOutsideTouchable(false); 
		// 设置背景后可以点击除popupwindow区域消去
		mPopupWindow.setBackgroundDrawable(new ColorDrawable());
	}
	
	public void showAsDropDownClick(View view) {
		// 根据传进去的View位置显示
		if (mPopupWindow != null && !mPopupWindow.isShowing()) {
			mPopupWindow.showAsDropDown(view);
		} else {
			mPopupWindow.dismiss();
		}

	}
	
	public void showAtLocationClick(View view) {
		// 在父View的指定对其方式显示
		if (mPopupWindow != null && !mPopupWindow.isShowing()) {
			mPopupWindow.showAtLocation(mLlRoot, Gravity.CENTER, 0, 0);
		} else {
			mPopupWindow.dismiss();
		}
		
	}
	
	
	
}
