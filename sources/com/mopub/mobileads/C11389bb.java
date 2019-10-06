package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.bb */
/* compiled from: VungleInterstitial */
class C11389bb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ VungleInterstitial f35244a;

    C11389bb(VungleInterstitial this$0) {
        this.f35244a = this$0;
    }

    public void run() {
        this.f35244a.f35126e.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, VungleInterstitial.f35123b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
    }
}
