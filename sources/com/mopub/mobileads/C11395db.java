package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.mobileads.db */
/* compiled from: VungleInterstitial */
class C11395db implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f35251a;

    /* renamed from: b */
    final /* synthetic */ C11363a f35252b;

    C11395db(C11363a this$1, boolean z) {
        this.f35252b = this$1;
        this.f35251a = z;
    }

    public void run() {
        if (this.f35251a) {
            VungleInterstitial.this.f35126e.onInterstitialClicked();
            MoPubLog.log(AdapterLogEvent.CLICKED, VungleInterstitial.f35123b);
        }
        VungleInterstitial.this.f35126e.onInterstitialDismissed();
    }
}
