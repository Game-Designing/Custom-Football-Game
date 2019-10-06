package com.smaato.soma;

import android.os.Build.VERSION;
import android.webkit.WebView;

/* renamed from: com.smaato.soma.ta */
/* compiled from: ExpandedBannerActivity */
class C12512ta extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ WebView f38970a;

    /* renamed from: b */
    final /* synthetic */ ExpandedBannerActivity f38971b;

    C12512ta(ExpandedBannerActivity this$0, WebView webView) {
        this.f38971b = this$0;
        this.f38970a = webView;
    }

    public Void process() throws Exception {
        if (VERSION.SDK_INT < 18) {
            this.f38970a.clearView();
        } else {
            this.f38970a.loadUrl("about:blank");
        }
        this.f38970a.setWebChromeClient(null);
        return null;
    }
}
