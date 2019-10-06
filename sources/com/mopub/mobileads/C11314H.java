package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.H */
/* compiled from: IronSourceInterstitial */
class C11314H implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MoPubErrorCode f34780a;

    /* renamed from: b */
    final /* synthetic */ IronSourceInterstitial f34781b;

    C11314H(IronSourceInterstitial this$0, MoPubErrorCode moPubErrorCode) {
        this.f34781b = this$0;
        this.f34780a = moPubErrorCode;
    }

    public void run() {
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, Integer.valueOf(this.f34780a.getIntCode()), this.f34780a);
        if (IronSourceInterstitial.f34799e != null) {
            IronSourceInterstitial.f34799e.onInterstitialFailed(this.f34780a);
        }
    }
}
