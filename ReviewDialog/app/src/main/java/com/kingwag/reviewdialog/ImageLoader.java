package com.kingwag.reviewdialog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kingwag on 2016/11/19.
 */

public class ImageLoader extends AsyncTask<Object, Void, byte[]> {
    private String murl =null;
   private ImageView imageView;

    public ImageLoader(ImageView imageView, String url) {
        this.imageView = imageView;
        this.murl = url;
    }
    public ImageLoader setImageUrl(String mImageUrl) {
        this.murl = mImageUrl;
        return this; // 链式调用，返回当前异步任务自身
    }

    public ImageLoader setIvPhoto(ImageView ivPhoto) {
        this.imageView = ivPhoto;
        return this;
    }
    public ImageLoader() {
        super();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected byte[] doInBackground(Object... strings) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(murl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            BufferedInputStream bis = null;
            ByteArrayOutputStream bos = null;
            if (conn.getResponseCode() == 200){
                InputStream is = conn.getInputStream();
                bis = new BufferedInputStream(is);
                bos = new ByteArrayOutputStream();
                int len = 0;
                byte[] bytes = new byte[1024];
                while ((len = bis.read(bytes))!=-1){
                    bos.write(bytes,0,len);
                    bos.flush();
                }

                bis.close();
                return bos.toByteArray();


            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }





    @Override
    protected void onPostExecute(byte[] bytes) {
        super.onPostExecute(bytes);
        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        imageView.setImageBitmap(bitmap);
    }
}
