package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private String url = "https://www.naver.com"; //https:// 도 입력해야 함!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass()); //처음에 에러가 뜬다. WebViewClientClass라는 이너 클래스를 작성하여 해결.
    }

    //안드로이드의 뒤로가기 버튼을 눌렀을 때, 웹 뷰상에서 이전 페이지로 넘어가는 기능 구현.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //뒤로가기 버튼이 눌렸고, 웹뷰에서 이전페이지로 갈 수 있다면.
        if(( keyCode==KeyEvent.KEYCODE_BACK ) && webView.canGoBack()){
            webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { //현재 페이지의 url을 읽어오는 메소드.
            view.loadUrl(url);
            return true;
        }
    }
}