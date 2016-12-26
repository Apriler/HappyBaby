package com.happybaby.happybaby.index_fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.happybaby.happybaby.R;
import com.happybaby.happybaby.contant.IndexUrlContants;

/**
 * 助养
 */
public class Index_ThirdFragment extends Fragment {


    private WebView mWebZhuyang;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_index__third, container, false);
        initView(view);
        //内部打开网页
        mWebZhuyang.setWebViewClient(new WebViewClient(){
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
        mWebZhuyang.loadUrl(IndexUrlContants.INDEX_BASE_ZHUYANG);



        return view;
    }

    private void initView(View view) {
        mWebZhuyang = (WebView) view.findViewById(R.id.web_zhuyang);
    }
}
