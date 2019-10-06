package com.mopub.mobileads;

/* renamed from: com.mopub.mobileads.ja */
/* compiled from: MoPubRewardedVideoManager */
class C11416ja implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f35304a;

    /* renamed from: b */
    final /* synthetic */ MoPubErrorCode f35305b;

    C11416ja(String str, MoPubErrorCode moPubErrorCode) {
        this.f35304a = str;
        this.f35305b = moPubErrorCode;
    }

    public void run() {
        MoPubRewardedVideoManager.m37474c(this.f35304a, this.f35305b);
    }
}
