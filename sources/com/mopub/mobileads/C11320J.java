package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.J */
/* compiled from: IronSourceInterstitial */
class C11320J implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IronSourceInterstitial f34811a;

    C11320J(IronSourceInterstitial this$0) {
        this.f34811a = this$0;
    }

    public void run() {
        MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, IronSourceInterstitial.f34796b);
        if (IronSourceInterstitial.f34799e != null) {
            IronSourceInterstitial.f34799e.onInterstitialShown();
        }
    }
}
