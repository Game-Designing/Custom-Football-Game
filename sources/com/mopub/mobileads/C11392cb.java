package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.cb */
/* compiled from: VungleInterstitial */
class C11392cb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ VungleInterstitial f35247a;

    C11392cb(VungleInterstitial this$0) {
        this.f35247a = this$0;
    }

    public void run() {
        this.f35247a.f35126e.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, VungleInterstitial.f35123b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
    }
}
