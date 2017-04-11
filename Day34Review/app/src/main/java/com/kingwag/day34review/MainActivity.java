package com.kingwag.day34review;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressBar pb;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.activity_main);
        pb = (ProgressBar) findViewById(R.id.pb);
        //初始化webview
        webView = (WebView) findViewById(R.id.webview);
        //加载网页
        webView.loadUrl("http://www.bilibili.com/");
        //取消滚动条
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        //初始化缩放比尺寸
        webView.setInitialScale(100);
        //设置支持JS
        webView.getSettings().setJavaScriptEnabled(true);
        //设置WebView可触摸放大缩小
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        //设置双击放大，缩小回原尺寸
        webView.getSettings().setUseWideViewPort(true);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pb.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pb.setVisibility(View.GONE);
            }
        });



    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (webView.canGoBack()){
                webView.goBack();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //停止加载
        webView.stopLoading();
        //将WebView从自身容器移除
        ((ViewGroup)webView.getParent()).removeView(webView);
        //将WebView自身子View移除
        webView.removeAllViews();
        //清除缓存
        webView.clearCache(true);
        //清除历史
        webView.clearHistory();
        //释放webview内存
        webView.destroy();
    }
}
