package com.bodhixu.retrofitdemo.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.bodhixu.retrofitdemo.R;
import com.bodhixu.retrofitdemo.apiservice.LoginApiService;
import com.bodhixu.retrofitdemo.constant.UrlConstants;
import com.bodhixu.retrofitdemo.util.MyUtils;
import com.bodhixu.retrofitdemo.util.OkHttpUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText phoneEdt, pswEdt;

    private Retrofit retrofit;
    private LoginApiService loginApiService;
    private Call<ResponseBody> call;

    public static final String FILE_PATH = Environment.getExternalStorageDirectory()
            + File.separator + "abc.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initRetrofit();
        initView();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstants.POST_BASE_URL)
                .client(OkHttpUtils.newOkHttpClient(this)) //设置OkHttpClient单例模式
                .build();
        loginApiService = retrofit.create(LoginApiService.class);
    }

    private void initView() {
        phoneEdt = (EditText) findViewById(R.id.phone_edt);
        pswEdt = (EditText) findViewById(R.id.psw_edt);
        findViewById(R.id.regist_btn).setOnClickListener(this);
        findViewById(R.id.regist_map_btn).setOnClickListener(this);
        findViewById(R.id.updateFile_btn).setOnClickListener(this);
        findViewById(R.id.updateMulti_btn).setOnClickListener(this);
        //将assets文件写sdcard
        try {
            MyUtils.writeAssetsToSdcard(this, "abc.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        String phone = phoneEdt.getEditableText().toString();
        String psw = pswEdt.getEditableText().toString();
        switch (view.getId()) {
            case R.id.regist_btn: //post键值对
                call = loginApiService.getLoginCall(phone, psw);
                doPost();
                break;
            case R.id.regist_map_btn: //post Map键值对
                HashMap<String, String> fieldMap = new HashMap<>();
                fieldMap.put("phone", phone);
                fieldMap.put("psw", psw);
                call = loginApiService.getLoginCall(fieldMap);
                doPost();
                break;
            case R.id.updateFile_btn: //上传文件
                //创建RequestBody对象
                // RequestBody requestBody = OkHttpUtils.getRequestBody(FILE_PATH);
                // call = loginApiService.uploadFileCall(requestBody);
                MultipartBody.Part part = OkHttpUtils.getMultipartBodyPart("abc.png", FILE_PATH);
                call = loginApiService.uploadFileCall(part);
                doPost();
                break;
            case R.id.updateMulti_btn: //分块上传
                HashMap<String, String> multiMap = new HashMap<>();
                multiMap.put("phone", phone);
                multiMap.put("psw", psw);
                List<String> fileNames = new ArrayList<>();
                fileNames.add(FILE_PATH);
                MultipartBody multipartBody = OkHttpUtils.getMultipartBody(multiMap, fileNames);
                call = loginApiService.uploadMultiFilesCall(multipartBody);
                doPost();
                break;
        }
    }

    private void doPost() {
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e("Tag", "result = " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("Tag", "error = " + t.getMessage());
            }
        });
    }



}
