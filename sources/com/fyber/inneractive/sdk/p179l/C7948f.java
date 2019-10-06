package com.fyber.inneractive.sdk.p179l;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.l.f */
final class C7948f extends WebViewClient {

    /* renamed from: a */
    C7926b f16228a;

    C7948f(C7926b bVar) {
        this.f16228a = bVar;
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(IAlog.m18018a((Object) this));
        sb.append("Error: code = ");
        sb.append(i);
        sb.append(" text = ");
        sb.append(str);
        sb.append(" WebView = ");
        sb.append(webView);
        IAlog.m18019a(sb.toString());
        super.onReceivedError(webView, i, str, str2);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        super.shouldOverrideUrlLoading(webView, str);
        if (this.f16228a.mo24738a(webView, str)) {
            return true;
        }
        return false;
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        StringBuilder sb = new StringBuilder("onPageStarted - url: ");
        sb.append(str);
        IAlog.m18019a(sb.toString());
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        StringBuilder sb = new StringBuilder("onPageFinished - url: ");
        sb.append(str);
        IAlog.m18019a(sb.toString());
    }

    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
        StringBuilder sb = new StringBuilder("Resources to load: ");
        sb.append(str);
        IAlog.m18019a(sb.toString());
        C7926b bVar = this.f16228a;
        if (bVar != null) {
            bVar.mo24742f(str);
        }
    }
}
