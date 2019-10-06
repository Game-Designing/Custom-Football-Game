package com.mopub.mobileads;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.mopub.mobileads.Wa */
/* compiled from: VastVideoViewController */
class C11367Wa extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ C11302Ca f35171a;

    /* renamed from: b */
    final /* synthetic */ VastVideoViewController f35172b;

    C11367Wa(VastVideoViewController this$0, C11302Ca ca) {
        this.f35172b = this$0;
        this.f35171a = ca;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        this.f35171a.mo36950a(this.f35172b.mo36929b(), url, this.f35172b.f35081e.getDspCreativeId());
        return true;
    }
}
