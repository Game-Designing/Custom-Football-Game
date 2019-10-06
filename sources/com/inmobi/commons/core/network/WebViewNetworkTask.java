package com.inmobi.commons.core.network;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewNetworkTask {

    /* renamed from: d */
    private static final String f32555d = WebViewNetworkTask.class.getSimpleName();

    /* renamed from: a */
    public C10676c f32556a;

    /* renamed from: b */
    public WebViewClient f32557b;

    /* renamed from: c */
    public NetworkTaskWebView f32558c;

    public class NetworkTaskWebView extends WebView {

        /* renamed from: a */
        public boolean f32559a;

        public NetworkTaskWebView(Context context) {
            super(context);
        }

        public void destroy() {
            this.f32559a = true;
            super.destroy();
        }
    }

    public WebViewNetworkTask(C10676c cVar, WebViewClient webViewClient) {
        this.f32557b = webViewClient;
        this.f32556a = cVar;
    }
}
