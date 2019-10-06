package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* renamed from: com.google.android.gms.internal.ads.xt */
final class C9826xt implements Runnable {

    /* renamed from: a */
    private ValueCallback<String> f23505a = new C9847yt(this);

    /* renamed from: b */
    final /* synthetic */ zzuo f23506b;

    /* renamed from: c */
    final /* synthetic */ WebView f23507c;

    /* renamed from: d */
    final /* synthetic */ boolean f23508d;

    /* renamed from: e */
    final /* synthetic */ zzuu f23509e;

    C9826xt(zzuu zzuu, zzuo zzuo, WebView webView, boolean z) {
        this.f23509e = zzuu;
        this.f23506b = zzuo;
        this.f23507c = webView;
        this.f23508d = z;
    }

    public final void run() {
        if (this.f23507c.getSettings().getJavaScriptEnabled()) {
            try {
                this.f23507c.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.f23505a);
            } catch (Throwable th) {
                this.f23505a.onReceiveValue("");
            }
        }
    }
}
