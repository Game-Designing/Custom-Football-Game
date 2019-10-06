package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import p019d.p143b.p150d.C7251a;

/* renamed from: com.mopub.mobileads.j */
/* compiled from: AppLovinBanner */
class C11415j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7251a f35302a;

    /* renamed from: b */
    final /* synthetic */ C11421l f35303b;

    C11415j(C11421l this$1, C7251a aVar) {
        this.f35303b = this$1;
        this.f35302a = aVar;
    }

    public void run() {
        this.f35303b.f35309a.mo18298a(this.f35302a);
        MoPubLog.m37080d("Successfully loaded banner ad");
        try {
            if (this.f35303b.f35310b != null) {
                this.f35303b.f35310b.onBannerLoaded(this.f35303b.f35309a);
            }
        } catch (Throwable th) {
            MoPubLog.m37083e("Unable to notify listener of successful ad load.", th);
        }
    }
}
