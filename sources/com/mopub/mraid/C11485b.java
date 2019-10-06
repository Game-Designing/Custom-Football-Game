package com.mopub.mraid;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.mraid.MraidBridge.MraidWebView;
import com.mopub.mraid.MraidController.MraidWebViewCacheListener;

/* renamed from: com.mopub.mraid.b */
/* compiled from: MraidBanner */
class C11485b implements MraidWebViewCacheListener {

    /* renamed from: a */
    final /* synthetic */ Context f35561a;

    /* renamed from: b */
    final /* synthetic */ MraidBanner f35562b;

    C11485b(MraidBanner this$0, Context context) {
        this.f35562b = this$0;
        this.f35561a = context;
    }

    public void onReady(MraidWebView webView, ExternalViewabilitySessionManager viewabilityManager) {
        webView.getSettings().setJavaScriptEnabled(true);
        Context context = this.f35561a;
        if (context instanceof Activity) {
            this.f35562b.f35480e = new ExternalViewabilitySessionManager(context);
            this.f35562b.f35480e.createDisplaySession(this.f35561a, webView, this.f35562b.f35481f);
        }
    }
}
