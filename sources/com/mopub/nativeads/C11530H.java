package com.mopub.nativeads;

/* renamed from: com.mopub.nativeads.H */
/* compiled from: MoPubAdAdapter */
class C11530H implements MoPubNativeAdLoadedListener {

    /* renamed from: a */
    final /* synthetic */ MoPubAdAdapter f35677a;

    C11530H(MoPubAdAdapter this$0) {
        this.f35677a = this$0;
    }

    public void onAdLoaded(int position) {
        this.f35677a.mo37882a(position);
    }

    public void onAdRemoved(int position) {
        this.f35677a.mo37884b(position);
    }
}
