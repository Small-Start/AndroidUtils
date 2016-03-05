package com.example.myhp.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by my hp on 12/26/2015.
 */
public class Simplebrowser extends Activity implements View.OnClickListener{
    WebView ourbrow;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.browser);
        ourbrow=(WebView)findViewById(R.id.wvbrowser);
        ourbrow.getSettings().setJavaScriptEnabled(true);
        ourbrow.getSettings().setLoadWithOverviewMode(true);
        ourbrow.getSettings().setUseWideViewPort(true);
        ourbrow.setWebViewClient(new WebViewClient());
        ourbrow.loadUrl("http://www.google.com");
        Button go,back,forward,refresh,clear;
        go=(Button)findViewById(R.id.go);
        back=(Button)findViewById(R.id.bback);
        forward=(Button)findViewById(R.id.bforward);
        refresh=(Button)findViewById(R.id.brefresh);
        clear=(Button)findViewById(R.id.bhistory);
        et=(EditText)findViewById(R.id.editurl);
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        refresh.setOnClickListener(this);
        clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.go:
                String website=et.getText().toString();
                ourbrow.loadUrl(website);
                InputMethodManager immgr=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                immgr.hideSoftInputFromWindow(et.getWindowToken(),0);
                break;
            case R.id.bback:
                if(ourbrow.canGoBack())
                    ourbrow.goBack();
                break;
            case R.id.bforward:
                if(ourbrow.canGoForward())
                    ourbrow.goForward();
                break;
            case R.id.brefresh:
                ourbrow.reload();
                break;
            case R.id.bhistory:
                ourbrow.clearHistory();
                break;
        }
    }
}
