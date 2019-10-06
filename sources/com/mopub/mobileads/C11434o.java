package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.mobileads.o */
/* compiled from: AppLovinRewardedVideo */
class C11434o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinRewardedVideo f35347a;

    C11434o(AppLovinRewardedVideo this$0) {
        this.f35347a = this$0;
    }

    public void run() {
        try {
            MoPubRewardedVideoManager.onRewardedVideoLoadSuccess(this.f35347a.getClass(), this.f35347a.getAdNetworkId());
        } catch (Throwable th) {
            MoPubLog.m37083e("Unable to notify listener of successful ad load.", th);
        }
    }
}
