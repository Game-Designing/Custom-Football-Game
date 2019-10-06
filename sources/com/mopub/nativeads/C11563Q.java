package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.VastManager;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;
import com.mopub.nativeads.NativeImageHelper.ImageListener;

/* renamed from: com.mopub.nativeads.Q */
/* compiled from: MoPubCustomEventVideoNative */
class C11563Q implements ImageListener {

    /* renamed from: a */
    final /* synthetic */ MoPubVideoNativeAd f36013a;

    C11563Q(MoPubVideoNativeAd this$0) {
        this.f36013a = this$0;
    }

    public void onImagesCached() {
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, MoPubCustomEventVideoNative.ADAPTER_NAME);
        if (!this.f36013a.isInvalidated()) {
            VastManager h = this.f36013a.f35850x;
            String vastVideo = this.f36013a.getVastVideo();
            MoPubVideoNativeAd moPubVideoNativeAd = this.f36013a;
            h.prepareVastVideoConfiguration(vastVideo, moPubVideoNativeAd, null, moPubVideoNativeAd.f35841o);
        }
    }

    public void onImagesFailedToCache(NativeErrorCode errorCode) {
        if (!this.f36013a.isInvalidated()) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, MoPubCustomEventVideoNative.ADAPTER_NAME, Integer.valueOf(errorCode.getIntCode()), errorCode);
            this.f36013a.f35846t.onNativeAdFailed(errorCode);
        }
    }
}
