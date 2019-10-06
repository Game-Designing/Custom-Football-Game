package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.mobileads.m */
/* compiled from: AppLovinInterstitial */
class C11424m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitial f35314a;

    C11424m(AppLovinInterstitial this$0) {
        this.f35314a = this$0;
    }

    public void run() {
        try {
            if (this.f35314a.f34680f != null) {
                this.f35314a.f34680f.onInterstitialLoaded();
            }
        } catch (Throwable th) {
            MoPubLog.m37083e("Unable to notify listener of successful ad load.", th);
        }
    }
}
