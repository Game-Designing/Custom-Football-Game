package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.gb */
/* compiled from: VungleInterstitial */
class C11404gb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C11363a f35270a;

    C11404gb(C11363a this$1) {
        this.f35270a = this$1;
    }

    public void run() {
        VungleInterstitial.this.f35126e.onInterstitialLoaded();
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, VungleInterstitial.f35123b);
    }
}
