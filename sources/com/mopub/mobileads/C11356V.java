package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;

/* renamed from: com.mopub.mobileads.V */
/* compiled from: MoPubRewardedAd */
class C11356V implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MoPubRewardedAd f34970a;

    /* renamed from: b */
    final /* synthetic */ MoPubRewardedAdListener f34971b;

    C11356V(MoPubRewardedAdListener this$1, MoPubRewardedAd moPubRewardedAd) {
        this.f34971b = this$1;
        this.f34970a = moPubRewardedAd;
    }

    public void run() {
        MoPubLog.log(AdLogEvent.EXPIRED, "time in seconds");
        this.f34971b.onInterstitialFailed(MoPubErrorCode.EXPIRED);
    }
}
