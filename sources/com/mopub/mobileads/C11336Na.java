package com.mopub.mobileads;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.mopub.mobileads.Na */
/* compiled from: VastVideoViewController */
class C11336Na extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ VastCompanionAdConfig f34885a;

    /* renamed from: b */
    final /* synthetic */ Context f34886b;

    /* renamed from: c */
    final /* synthetic */ VastVideoViewController f34887c;

    C11336Na(VastVideoViewController this$0, VastCompanionAdConfig vastCompanionAdConfig, Context context) {
        this.f34887c = this$0;
        this.f34885a = vastCompanionAdConfig;
        this.f34886b = context;
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        this.f34885a.mo37210a(this.f34886b, 1, url, this.f34887c.f35081e.getDspCreativeId());
        return true;
    }
}
