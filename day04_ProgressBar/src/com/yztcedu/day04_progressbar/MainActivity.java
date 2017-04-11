package com.yztcedu.day04_progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	
	ProgressBar mPbOne;
	int count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPbOne = (ProgressBar) findViewById(R.id.pb_one);
		
	}
	
	public void changeProgressClick(View view) {
		count ++;
		mPbOne.setProgress(count);
		mPbOne.setSecondaryProgress(count+10);
	}
}
