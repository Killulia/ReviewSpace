package com.kingwag.review3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 1.set方法
 *              Activity  ----> Fragment(公开Set方法)
 *              Fragment(getActivity)  ----> Activity(公开Set方法)
 * 2.setArguments方法
 *              Fragment  ----> Fragment
 *              Activity -----> Fragment
 *
 *
 */
public class MainActivity extends AppCompatActivity {

	FragmentManager mFragmentManager;
	FirstFragment mFirstFragment;
	LinearLayout mLlContainer;
	SecondFragment mSecondFragment;
	String bttext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mFragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		FirstFragment fragment1 = new FirstFragment();
		SecondFragment fragment2 = new SecondFragment();
		transaction.add(R.id.ll_container, fragment1,"1");
		transaction.add(R.id.ll_container, fragment2,"2");
		transaction.commit();


	}
	public String getText1(){
		SecondFragment fragment = (SecondFragment) mFragmentManager.findFragmentByTag("2");
		View view = fragment.putView();
		TextView textView = (TextView) view.findViewById(R.id.tv_second);
		this.bttext = textView.getText().toString();
		return this.bttext;
	}















}
