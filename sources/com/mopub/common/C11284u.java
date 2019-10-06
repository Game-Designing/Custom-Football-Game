package com.mopub.common;

import android.os.Build.VERSION;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* renamed from: com.mopub.common.u */
/* compiled from: MoPubBrowser */
class C11284u extends WebChromeClient {

    /* renamed from: a */
    final /* synthetic */ MoPubBrowser f34580a;

    C11284u(MoPubBrowser this$0) {
        this.f34580a = this$0;
    }

    public void onProgressChanged(WebView webView, int progress) {
        if (progress == 100) {
            this.f34580a.setTitle(webView.getUrl());
        } else {
            this.f34580a.setTitle("Loading...");
        }
        if (this.f34580a.f34346f && VERSION.SDK_INT < 24) {
            this.f34580a.setProgress(progress * 100);
        }
    }
}
