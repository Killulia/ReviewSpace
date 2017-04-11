package com.yztcedu.day08_asynctask;

import android.os.AsyncTask;
import android.util.Log;

/**
 * 异步任务
 * 1.创建Java类，继承AsyncTask
 * 2.定义泛型参数类型
 * 	 Params:传递给异步任务的参数，比如URL
 *   Progress:执行进度类型，比如进度条中的进度，一般为整型
 *   Result:执行结果
 */
public class AsyncTaskDemo extends AsyncTask<Integer, Integer, String> {
	
	private OnAsyncTaskListener onAsyncTaskListener;
	
	// 准备初始化方法
	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		Log.v("sohot", "onPreExecute:"+Thread.currentThread().getName());
	}

	// 后台执行的方法
	@Override
	protected String doInBackground(Integer... params) {
		int count = params[0];
		for(int i = 0; i < count; i++) {
			if (isCancelled()) {
				return String.valueOf(i);
			}
			// 把当前进度发布到onProgressUpdate
			publishProgress(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Log.v("sohot", "doInBackground:"+Thread.currentThread().getName()+"index:"+i);
		}
		return "线程执行完成之后的返回结果";
	}

	// 更新进度执行的方法
	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		if (onAsyncTaskListener != null) {
			// 回调接口进度方法
			onAsyncTaskListener.onProgress(values[0]);
		}
		Log.v("sohot", "onProgressUpdate:"+Thread.currentThread().getName()+"--index:"+values[0]);
	}

	// 执行完成后接受结果的方法
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (onAsyncTaskListener != null) {
			// 回调完成接口方法
			onAsyncTaskListener.onFinish(result);
		}
		Log.v("sohot", "onPostExecute:"+Thread.currentThread().getName()+"--result:"+result);
	}

	// 异步任务被取消的时候回调
	@Override
	protected void onCancelled(String result) {
		super.onCancelled(result);
		if (onAsyncTaskListener != null) {
			// 回调取消接口方法
			onAsyncTaskListener.onCanceled(result);
		}
		Log.v("sohot", "onCancelled:"+result);
	}
	
	public void setOnAsyncTaskListener(OnAsyncTaskListener onAsyncTaskListener) {
		this.onAsyncTaskListener = onAsyncTaskListener;
	}
	
	public interface OnAsyncTaskListener {
		void onProgress(int progress);
		void onFinish(String result);
		void onCanceled(String result);
	}
	
	
}
