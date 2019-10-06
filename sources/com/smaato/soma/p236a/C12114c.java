package com.smaato.soma.p236a;

import android.webkit.WebView;
import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.a.c */
/* compiled from: AbstractBannerPackage */
class C12114c extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ WebView f38002a;

    /* renamed from: b */
    final /* synthetic */ C12125n f38003b;

    C12114c(C12125n this$0, WebView webView) {
        this.f38003b = this$0;
        this.f38002a = webView;
    }

    public Void process() throws Exception {
        this.f38002a.loadUrl("about:blank");
        this.f38002a.removeAllViews();
        this.f38002a.clearHistory();
        return null;
    }
}
