package com.yztcedu.day08_asynctask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class AsyncTaskDownloader extends AsyncTask<String, Integer, String>{

	private OnDownloadListener onDownloadListener;
	private String fileUrl;
	
	public AsyncTaskDownloader(String url) {
		this.fileUrl = url;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(String... params) {
		HttpURLConnection conn = null;
		String result = null;
		FileOutputStream fos = null;
//		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			URL url = new URL(fileUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000); // 网络超时时间
			conn.setReadTimeout(10000); // 服务器读取数据数据超时时间
			conn.setRequestMethod("GET");
//			conn.connect(); //可省略 Discuz!
			int contentLength = conn.getContentLength();
			// 创建文件夹和创建文件
			File dir = new File(params[0]);
			if (!dir.exists()) {
				dir.mkdir();
			}
			File file = new File(dir, params[1]);
			if(!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			if (conn.getResponseCode() == 200) {
				InputStream is = conn.getInputStream();
				byte[] bytes = new byte[1024];
				int length;
				int currLength = 0;
				while((length = is.read(bytes)) != -1) {
					currLength += length;
					int progress = (int)((currLength / (float)contentLength) * 100);
					// 把当前进度发布到onProgressUpdate方法中
					publishProgress(progress);
					fos.write(bytes, 0, length);
					fos.flush();
				}
				is.close();
			}
		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
		} finally {
			// 使用完关闭连接
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			conn.disconnect();
		}
		return result;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		// 返回回调下载进度
		if (onDownloadListener != null) {
			onDownloadListener.onProgress(values[0]);
		}
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (onDownloadListener != null) {
			// 网络请求成功的判断
			if (!"error".equals(result)) {
				onDownloadListener.onSuccess();
			} else {
				onDownloadListener.onFailure();
			}
		}
	}

	@Override
	protected void onCancelled(String result) {
		super.onCancelled(result);
	}
	
	public void setOnDownloadListener(OnDownloadListener onDownloadListener) {
		this.onDownloadListener = onDownloadListener;
	}

	public interface OnDownloadListener {
		void onSuccess();
		void onProgress(int progress);
		void onFailure();
	}

}
