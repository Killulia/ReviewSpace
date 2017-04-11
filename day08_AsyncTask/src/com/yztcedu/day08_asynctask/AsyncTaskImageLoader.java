package com.yztcedu.day08_asynctask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class AsyncTaskImageLoader extends AsyncTask<String, Integer, byte[]>{
	
	private String mImageUrl;
	private ImageView mIvPhoto;
	

	public AsyncTaskImageLoader setImageUrl(String mImageUrl) {
		this.mImageUrl = mImageUrl;
		return this; // 链式调用，返回当前异步任务自身
	}

	public AsyncTaskImageLoader setIvPhoto(ImageView ivPhoto) {
		this.mIvPhoto = ivPhoto;
		return this;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected byte[] doInBackground(String... params) {
		HttpURLConnection conn = null;
		byte[] result = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			URL url = new URL(mImageUrl);
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
				result = bos.toByteArray();
			}
		} catch (Exception e) {
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
	protected void onPostExecute(byte[] result) {
		super.onPostExecute(result);
		if (result != null) {
			// 把字节数组转换为bitmap
			Bitmap bitmap = BitmapFactory.decodeByteArray(result, 0, result.length);
			if (mIvPhoto != null) {
				mIvPhoto.setImageBitmap(bitmap);
			}
		}
	}

}
