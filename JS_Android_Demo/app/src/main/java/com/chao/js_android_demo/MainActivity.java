package com.chao.js_android_demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private WebView mWebView;
    private Button mButton;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }
    //初始化
    private void setupViews() {
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings mWebSettings = mWebView.getSettings();
        //加上这句话才能使用javascript方法
        mWebSettings.setJavaScriptEnabled(true);
        //增加接口方法,让html页面调用

        //加载页面
        mWebView.loadUrl("file:///android_asset/demo.html");
        mButton = (Button) findViewById(R.id.button);
        //给button添加事件响应,执行JavaScript的fillContent()方法
        mButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                mWebView.loadUrl("javascript:fillContent()");
            }
        });
    }
}
