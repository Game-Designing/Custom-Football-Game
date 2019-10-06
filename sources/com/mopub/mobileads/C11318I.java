package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.I */
/* compiled from: IronSourceInterstitial */
class C11318I implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IronSourceInterstitial f34793a;

    C11318I(IronSourceInterstitial this$0) {
        this.f34793a = this$0;
    }

    public void run() {
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, IronSourceInterstitial.f34796b);
        if (IronSourceInterstitial.f34799e != null) {
            IronSourceInterstitial.f34799e.onInterstitialLoaded();
        }
    }
}
