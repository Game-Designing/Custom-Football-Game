package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.mobileads.da */
/* compiled from: MoPubRewardedVideoManager */
class C11394da implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CustomEventRewardedAd f35249a;

    /* renamed from: b */
    final /* synthetic */ MoPubRewardedVideoManager f35250b;

    C11394da(MoPubRewardedVideoManager this$0, CustomEventRewardedAd customEventRewardedAd) {
        this.f35250b = this$0;
        this.f35249a = customEventRewardedAd;
    }

    public void run() {
        MoPubLog.log(SdkLogEvent.CUSTOM, "Custom Event failed to load rewarded ad in a timely fashion.");
        MoPubRewardedVideoManager.onRewardedVideoLoadFailure(this.f35249a.getClass(), this.f35249a.getAdNetworkId(), MoPubErrorCode.NETWORK_TIMEOUT);
        this.f35249a.mo36904b();
    }
}
