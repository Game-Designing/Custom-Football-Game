package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.mobileads.p */
/* compiled from: AppLovinRewardedVideo */
class C11437p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f35349a;

    /* renamed from: b */
    final /* synthetic */ AppLovinRewardedVideo f35350b;

    C11437p(AppLovinRewardedVideo this$0, int i) {
        this.f35350b = this$0;
        this.f35349a = i;
    }

    public void run() {
        try {
            MoPubRewardedVideoManager.onRewardedVideoLoadFailure(this.f35350b.getClass(), this.f35350b.getAdNetworkId(), AppLovinRewardedVideo.m37285b(this.f35349a));
        } catch (Throwable th) {
            MoPubLog.m37083e("Unable to notify listener of failure to receive ad.", th);
        }
    }
}
