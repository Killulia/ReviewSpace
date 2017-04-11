package com.yztcedu.day08_asynctask;

import com.yztcedu.day08_asynctask.AsyncTaskDemo.OnAsyncTaskListener;
import com.yztcedu.day08_asynctask.AsyncTaskDownloader.OnDownloadListener;
import com.yztcedu.day08_asynctask.AsyncTaskHttpLoader.OnRequestListener;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button mBtnStart, mBtnStop, mBtnRequest, mBtnLoadImage, mBtnDownload;
	private AsyncTaskDemo mAsyncTask;
	private TextView mTvAsyncTask;
	private ImageView mIvPhoto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mTvAsyncTask = (TextView)findViewById(R.id.tv_async_task);
		mBtnStart = (Button) findViewById(R.id.btn_start);
		mBtnStop = (Button)findViewById(R.id.btn_stop);
		mBtnRequest = (Button)findViewById(R.id.btn_request);
		mIvPhoto = (ImageView) findViewById(R.id.iv_photo);
		mBtnLoadImage = (Button)findViewById(R.id.btn_load_image);
		mBtnDownload = (Button) findViewById(R.id.btn_download);
		mBtnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mAsyncTask = new AsyncTaskDemo();
				mAsyncTask.setOnAsyncTaskListener(new OnAsyncTaskListener() {
					@Override
					public void onProgress(int progress) {
						mTvAsyncTask.setText("当前进度:"+progress);
					}
					
					@Override
					public void onFinish(String result) {
						mTvAsyncTask.setText("任务完成:"+result);
					}
					
					@Override
					public void onCanceled(String result) {
						mTvAsyncTask.setText("取消任务:"+result);
					}
				});
				mAsyncTask.execute(25);
			}
		});
		
		mBtnStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mAsyncTask.cancel(true);
			}
		});
		
		mBtnRequest.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AsyncTaskHttpLoader loader = new AsyncTaskHttpLoader();
				loader.execute("http://api.map.baidu.com/telematics/v3/weather?location=大连&output=json&ak=83d43d457680f29ff8ed1f1c20e5e96f");
				loader.setOnRequestListener(new OnRequestListener() {
					@Override
					public void onSuccess(String result) {
						
						mTvAsyncTask.setText("返回结果："+result);
					}
					
					@Override
					public void onFailure() {
						mTvAsyncTask.setText("返回失败");
					}
				});
			}
		});
		
		mBtnLoadImage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AsyncTaskImageLoader imageLoader = new AsyncTaskImageLoader();
				imageLoader.setIvPhoto(mIvPhoto).setImageUrl("http://pic2.ooopic.com/11/11/41/37b1OOOPIC87.jpg").execute();
			}
		});
		
		mBtnDownload.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				AsyncTaskDownloader download = new AsyncTaskDownloader("http://file.ws.126.net/3g/client/netease_newsreader_android.apk");
				download.setOnDownloadListener(new OnDownloadListener() {
					@Override
					public void onSuccess() {
						mTvAsyncTask.setText("下载成功");
					}
					
					@Override
					public void onProgress(int progress) {
						mTvAsyncTask.setText(String.valueOf(progress)+"%");
					}
					
					@Override
					public void onFailure() {
						mTvAsyncTask.setText("下载失败");
					}
				});
				String dir = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Download/";
				download.execute(dir, "android1602_test.apk");
			}
		});
		
		
	}
	
	
	
	
}
