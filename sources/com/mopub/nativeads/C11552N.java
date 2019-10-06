package com.mopub.nativeads;

import com.mopub.nativeads.NativeImageHelper.ImageListener;

/* renamed from: com.mopub.nativeads.N */
/* compiled from: MoPubCustomEventNative */
class C11552N implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ C11545a f35913a;

    C11552N(C11545a this$0) {
        this.f35913a = this$0;
    }

    public void onImagesCached() {
        if (!this.f35913a.isInvalidated()) {
            this.f35913a.f35821t.onNativeAdLoaded(this.f35913a);
        }
    }

    public void onImagesFailedToCache(NativeErrorCode errorCode) {
        if (!this.f35913a.isInvalidated()) {
            this.f35913a.f35821t.onNativeAdFailed(errorCode);
        }
    }
}
