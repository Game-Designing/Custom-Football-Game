package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

/* renamed from: com.mopub.mobileads.k */
/* compiled from: AppLovinBanner */
class C11418k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f35306a;

    /* renamed from: b */
    final /* synthetic */ C11421l f35307b;

    C11418k(C11421l this$1, int i) {
        this.f35307b = this$1;
        this.f35306a = i;
    }

    public void run() {
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load banner ad with code: ");
        sb.append(this.f35306a);
        MoPubLog.m37080d(sb.toString());
        try {
            if (this.f35307b.f35310b != null) {
                this.f35307b.f35310b.onBannerFailed(AppLovinBanner.m37273b(this.f35306a));
            }
        } catch (Throwable th) {
            MoPubLog.m37083e("Unable to notify listener of failure to receive ad.", th);
        }
    }
}
