package com.mamiaokui.rubbishmessage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.FrameLayout;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.util.Log;
import android.os.Handler;
import android.os.Message;

public class Main extends Activity
{
    /** Called when the activity is first created. */
    FrameLayout mView = null;
    WebView mWebView = null;

    public Handler mHandler = new Handler() {
            public void handleMessage (Message msg) {
                Log.e("mamk", "inject last");
                mWebView.loadUrl("javascript:var ele = document.getElementById(\"sendMobileCode\"); var ele1 = ele.getElementsByTagName(\"span\")[0];ele1.click();");
            }
        };;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mView = (FrameLayout)findViewById(R.id.layout);
        mView.setBackgroundColor(Color.RED);
        mWebView = new WebView(this);
        mView.addView(mWebView);
        mWebView.loadUrl("http://my.tv.sohu.com/user/reg/reginfo.do?bru=http%3A//my.tv.sohu.com/");
        mWebView.getSettings().setJavaScriptEnabled(true);
        
        mWebView.setWebViewClient(new WebViewClient() {
                public void onPageFinished(WebView view, String url) {
                    view.loadUrl("javascript:var ele = document.getElementById(\"regByPhone\"); ele.click(); ");
                    view.loadUrl("javascript:var ele = document.getElementById(\"mobileTxt\"); ele.setRangeText(\"13602433062\"); ");
                    mHandler.sendEmptyMessageDelayed(0, 3000);
                }
            }
            );

    }

}
