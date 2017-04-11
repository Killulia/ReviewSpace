package com.yztcedu.day08_asynctask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;

public class AsyncTaskHttpLoader extends AsyncTask<String, Integer, String>{

	private OnRequestListener onRequestListener;
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected String doInBackground(String... params) {
		HttpURLConnection conn = null;
		String result = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			URL url = new URL(params[0]);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000); // 网络超时时间
			conn.setReadTimeout(10000); // 服务器读取数据数据超时时间
			conn.setRequestMethod("GET");
//			conn.connect(); //可省略 Discuz!
			if (conn.getResponseCode() == 200) {
				InputStream is = conn.getInputStream();
				byte[] bytes = new byte[1024];
				int length;
				while((length = is.read(bytes)) != -1) {
					bos.write(bytes, 0, length);
					bos.flush();
				}
				is.close();
				result = bos.toString();
			}
		} catch (Exception e) {
			result = "error";
			e.printStackTrace();
		} finally {
			// 使用完关闭连接
			conn.disconnect();
		}
		return result;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		if (onRequestListener != null) {
			// 网络请求成功的判断
			if (!"error".equals(result)) {
				onRequestListener.onSuccess(result);
			} else {
				onRequestListener.onFailure();
			}
		}
	}

	@Override
	protected void onCancelled(String result) {
		super.onCancelled(result);
	}
	
	public void setOnRequestListener(OnRequestListener onRequestListener) {
		this.onRequestListener = onRequestListener;
	}

	public interface OnRequestListener {
		void onSuccess(String result);
		void onFailure();
	}

}
