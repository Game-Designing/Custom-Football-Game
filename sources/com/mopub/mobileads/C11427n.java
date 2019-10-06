package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.mobileads.n */
/* compiled from: AppLovinInterstitial */
class C11427n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f35317a;

    /* renamed from: b */
    final /* synthetic */ AppLovinInterstitial f35318b;

    C11427n(AppLovinInterstitial this$0, int i) {
        this.f35318b = this$0;
        this.f35317a = i;
    }

    public void run() {
        try {
            if (this.f35318b.f34680f != null) {
                this.f35318b.f34680f.onInterstitialFailed(AppLovinInterstitial.m37281b(this.f35317a));
            }
        } catch (Throwable th) {
            MoPubLog.m37083e("Unable to notify listener of failure to receive ad.", th);
        }
    }
}
