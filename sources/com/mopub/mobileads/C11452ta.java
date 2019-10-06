package com.mopub.mobileads;

import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.mraid.MraidBridge.MraidWebView;
import com.mopub.mraid.MraidController.MraidWebViewCacheListener;

/* renamed from: com.mopub.mobileads.ta */
/* compiled from: RewardedMraidActivity */
class C11452ta implements MraidWebViewCacheListener {

    /* renamed from: a */
    final /* synthetic */ RewardedMraidActivity f35420a;

    C11452ta(RewardedMraidActivity this$0) {
        this.f35420a = this$0;
    }

    public void onReady(MraidWebView webView, ExternalViewabilitySessionManager viewabilityManager) {
        if (viewabilityManager != null) {
            this.f35420a.f34881f = viewabilityManager;
            return;
        }
        RewardedMraidActivity rewardedMraidActivity = this.f35420a;
        rewardedMraidActivity.f34881f = new ExternalViewabilitySessionManager(rewardedMraidActivity);
        RewardedMraidActivity rewardedMraidActivity2 = this.f35420a;
        rewardedMraidActivity2.f34881f.createDisplaySession(rewardedMraidActivity2, webView, true);
    }
}
