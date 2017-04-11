package com.bodhixu.retrofitdemo.util;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by bodhixu on 2016/12/7.
 */
public class MyUtils {

    //将assets文件写入sdcard
    public static void writeAssetsToSdcard(Context context, String fileName) throws IOException {
        BufferedInputStream bis;
        BufferedOutputStream bos;
        InputStream is = context.getResources().getAssets().open(fileName);
        bis = new BufferedInputStream(is);
        FileOutputStream fis = new FileOutputStream(
                Environment.getExternalStorageDirectory() + File.separator + fileName);
        bos = new BufferedOutputStream(fis);
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len = bis.read(buffer)) != -1){
            bos.write(buffer, 0 ,len);
        }
        bis.close();
        bos.close();
    }
}
