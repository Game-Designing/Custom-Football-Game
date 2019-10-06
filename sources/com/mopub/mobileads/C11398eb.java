package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.eb */
/* compiled from: VungleInterstitial */
class C11398eb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C11363a f35255a;

    C11398eb(C11363a this$1) {
        this.f35255a = this$1;
    }

    public void run() {
        VungleInterstitial.this.f35126e.onInterstitialShown();
        MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, VungleInterstitial.f35123b);
    }
}
