package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.hb */
/* compiled from: VungleInterstitial */
class C11407hb implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C11363a f35274a;

    C11407hb(C11363a this$1) {
        this.f35274a = this$1;
    }

    public void run() {
        VungleInterstitial.this.f35126e.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, VungleInterstitial.f35123b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
    }
}
