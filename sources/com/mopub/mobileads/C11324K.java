package com.mopub.mobileads;

/* renamed from: com.mopub.mobileads.K */
/* compiled from: IronSourceInterstitial */
class C11324K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IronSourceInterstitial f34821a;

    C11324K(IronSourceInterstitial this$0) {
        this.f34821a = this$0;
    }

    public void run() {
        if (IronSourceInterstitial.f34799e != null) {
            IronSourceInterstitial.f34799e.onInterstitialDismissed();
        }
    }
}
