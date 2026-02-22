package com.nextgen.developers;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private static final String WEBSITE_URL = "https://nextgen-developers.lovable.app";

    private WebView webView;
    private LinearLayout loadingOverlay;
    private LinearLayout errorOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        loadingOverlay = findViewById(R.id.loadingOverlay);
        errorOverlay = findViewById(R.id.errorOverlay);
        Button retryButton = findViewById(R.id.retryButton);
        ImageView logoMark = findViewById(R.id.logoMark);

        startLogoPulse(logoMark);

        retryButton.setOnClickListener(v -> loadWebsite());

        configureWebView();
        loadWebsite();
    }

    private void configureWebView() {
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                showLoading();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                showContent();
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                if (request.isForMainFrame()) {
                    showError();
                }
            }
        });
    }

    private void loadWebsite() {
        showLoading();
        errorOverlay.setVisibility(View.GONE);
        webView.loadUrl(WEBSITE_URL);
    }

    private void showLoading() {
        loadingOverlay.setVisibility(View.VISIBLE);
    }

    private void showContent() {
        loadingOverlay.setVisibility(View.GONE);
        errorOverlay.setVisibility(View.GONE);
    }

    private void showError() {
        loadingOverlay.setVisibility(View.GONE);
        errorOverlay.setVisibility(View.VISIBLE);
    }

    private void startLogoPulse(ImageView logoMark) {
        ObjectAnimator pulseX = ObjectAnimator.ofFloat(logoMark, "scaleX", 1f, 1.06f, 1f);
        pulseX.setDuration(2200);
        pulseX.setRepeatCount(ObjectAnimator.INFINITE);
        pulseX.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator pulseY = ObjectAnimator.ofFloat(logoMark, "scaleY", 1f, 1.06f, 1f);
        pulseY.setDuration(2200);
        pulseY.setRepeatCount(ObjectAnimator.INFINITE);
        pulseY.setInterpolator(new AccelerateDecelerateInterpolator());

        pulseX.start();
        pulseY.start();
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
