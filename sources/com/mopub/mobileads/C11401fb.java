package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.fb */
/* compiled from: VungleInterstitial */
class C11401fb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C11363a f35268a;

    C11401fb(C11363a this$1) {
        this.f35268a = this$1;
    }

    public void run() {
        VungleInterstitial.this.f35126e.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, VungleInterstitial.f35123b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
    }
}
