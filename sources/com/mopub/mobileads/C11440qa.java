package com.mopub.mobileads;

import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.mraid.MraidBridge.MraidWebView;
import com.mopub.mraid.MraidController.MraidWebViewCacheListener;

/* renamed from: com.mopub.mobileads.qa */
/* compiled from: MraidActivity */
class C11440qa implements MraidWebViewCacheListener {

    /* renamed from: a */
    final /* synthetic */ MraidActivity f35353a;

    C11440qa(MraidActivity this$0) {
        this.f35353a = this$0;
    }

    public void onReady(MraidWebView webView, ExternalViewabilitySessionManager viewabilityManager) {
        if (viewabilityManager != null) {
            this.f35353a.f34881f = viewabilityManager;
            return;
        }
        MraidActivity mraidActivity = this.f35353a;
        mraidActivity.f34881f = new ExternalViewabilitySessionManager(mraidActivity);
        MraidActivity mraidActivity2 = this.f35353a;
        mraidActivity2.f34881f.createDisplaySession(mraidActivity2, webView, true);
    }
}
