package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.L */
/* compiled from: IronSourceInterstitial */
class C11326L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IronSourceInterstitial f34824a;

    C11326L(IronSourceInterstitial this$0) {
        this.f34824a = this$0;
    }

    public void run() {
        MoPubLog.log(AdapterLogEvent.CLICKED, IronSourceInterstitial.f34796b);
        if (IronSourceInterstitial.f34799e != null) {
            IronSourceInterstitial.f34799e.onInterstitialClicked();
        }
    }
}
