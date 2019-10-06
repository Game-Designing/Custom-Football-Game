package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;

/* renamed from: com.mopub.mobileads.S */
/* compiled from: MoPubInterstitial */
class C11347S implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MoPubInterstitial f34936a;

    C11347S(MoPubInterstitial this$0) {
        this.f34936a = this$0;
    }

    public void run() {
        MoPubLog.log(AdLogEvent.CUSTOM, "Expiring unused Interstitial ad.");
        this.f34936a.mo37063a(C11331a.IDLE, true);
        if (!C11331a.SHOWING.equals(this.f34936a.f34844g) && !C11331a.DESTROYED.equals(this.f34936a.f34844g)) {
            this.f34936a.f34838a.mo37081a(MoPubErrorCode.EXPIRED);
        }
    }
}
