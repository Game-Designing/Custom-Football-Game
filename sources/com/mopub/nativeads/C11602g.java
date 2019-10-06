package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;

/* renamed from: com.mopub.nativeads.g */
/* compiled from: CustomEventNativeAdapter */
class C11602g implements CustomEventNativeListener {

    /* renamed from: a */
    final /* synthetic */ C11605h f36144a;

    C11602g(C11605h this$0) {
        this.f36144a = this$0;
    }

    public void onNativeAdLoaded(BaseNativeAd nativeAd) {
        if (!this.f36144a.f36153e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "onNativeAdLoaded");
            this.f36144a.m38426c();
            this.f36144a.f36152d.onNativeAdLoaded(nativeAd);
        }
    }

    public void onNativeAdFailed(NativeErrorCode errorCode) {
        if (!this.f36144a.f36153e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("onNativeAdFailed with code ");
            sb.append(errorCode.getIntCode());
            sb.append(" and message ");
            sb.append(errorCode);
            MoPubLog.log(sdkLogEvent, sb.toString());
            this.f36144a.m38426c();
            this.f36144a.f36152d.onNativeAdFailed(errorCode);
        }
    }
}
