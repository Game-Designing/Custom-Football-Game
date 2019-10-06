package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.nativeads.NativeImageHelper.ImageListener;

/* renamed from: com.mopub.nativeads.k */
/* compiled from: GooglePlayServicesNative */
class C11614k implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ C11529a f36168a;

    C11614k(C11529a this$0) {
        this.f36168a = this$0;
    }

    public void onImagesCached() {
        if (this.f36168a.f35676q != null) {
            C11529a aVar = this.f36168a;
            aVar.m38146b(aVar.f35676q);
            this.f36168a.f35675p.onNativeAdLoaded(this.f36168a);
            MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, GooglePlayServicesNative.f35660a);
        }
    }

    public void onImagesFailedToCache(NativeErrorCode errorCode) {
        this.f36168a.f35675p.onNativeAdFailed(errorCode);
        MoPubLog.log(AdapterLogEvent.LOAD_FAILED, GooglePlayServicesNative.f35660a, Integer.valueOf(errorCode.getIntCode()), errorCode);
    }
}
