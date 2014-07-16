package com.mamiaokui.rubbishmessage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.webkit.WebView;

public class Main extends Activity
{
    /** Called when the activity is first created. */
    FrameLayout mView = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mView = (FrameLayout)findViewById(R.id.layout);
        mView.setBackgroundColor(Color.RED);
        WebView mWebView = new WebView(this);
        mView.addView(mWebView);
        mWebView.loadUrl("http://www.baidu.com/");
        mWebView.getSettings().setJavaScriptEnabled(true);
    }
}
