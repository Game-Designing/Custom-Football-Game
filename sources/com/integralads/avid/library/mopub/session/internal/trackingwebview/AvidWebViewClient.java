package com.integralads.avid.library.mopub.session.internal.trackingwebview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AvidWebViewClient extends WebViewClient {
    private AvidWebViewClientListener listener;

    public interface AvidWebViewClientListener {
        void webViewDidLoadData();
    }

    public AvidWebViewClientListener getListener() {
        return this.listener;
    }

    public void setListener(AvidWebViewClientListener listener2) {
        this.listener = listener2;
    }

    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        AvidWebViewClientListener avidWebViewClientListener = this.listener;
        if (avidWebViewClientListener != null) {
            avidWebViewClientListener.webViewDidLoadData();
        }
    }
}
