package com.happybaby.happybaby.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.happybaby.happybaby.R;

//webview 加载网页
public class WebviewActivity extends BaseActivity {

    private WebView mWebview;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initView();
        Intent intent = getIntent();
        String urlExtra = intent.getStringExtra("URL");
        mWebview.loadUrl(urlExtra);

        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebview.canGoBack()) {
                mWebview.goBack();
                finish();
            }
        }
        return true;
    }

    private void initView() {
        mWebview = (WebView) findViewById(R.id.webview);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    protected void onDestroy() {
        //释放资源
        super.onDestroy();
        mWebview.stopLoading();
        ((ViewGroup) mWebview.getParent()).removeView(mWebview);
        mWebview.removeAllViews();
        mWebview.clearCache(true);
        mWebview.clearHistory();
        mWebview.destroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
