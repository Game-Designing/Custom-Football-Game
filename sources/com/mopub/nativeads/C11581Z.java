package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.nativeads.CustomEventNative.CustomEventNativeListener;
import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import com.mopub.network.AdResponse;

/* renamed from: com.mopub.nativeads.Z */
/* compiled from: MoPubNative */
class C11581Z implements CustomEventNativeListener {

    /* renamed from: a */
    final /* synthetic */ AdResponse f36105a;

    /* renamed from: b */
    final /* synthetic */ MoPubNative f36106b;

    C11581Z(MoPubNative this$0, AdResponse adResponse) {
        this.f36106b = this$0;
        this.f36105a = adResponse;
    }

    public void onNativeAdLoaded(BaseNativeAd nativeAd) {
        MoPubLog.log(AdLogEvent.LOAD_SUCCESS, new Object[0]);
        this.f36106b.f35875g = null;
        Context context = this.f36106b.mo37931a();
        if (context != null) {
            MoPubAdRenderer renderer = this.f36106b.f35878j.getRendererForAd(nativeAd);
            if (renderer == null) {
                onNativeAdFailed(NativeErrorCode.NATIVE_RENDERER_CONFIGURATION_ERROR);
                return;
            }
            if (this.f36106b.f35874f != null) {
                this.f36106b.f35874f.creativeDownloadSuccess();
            }
            MoPubNativeNetworkListener c = this.f36106b.f35872d;
            NativeAd nativeAd2 = new NativeAd(context, this.f36105a, this.f36106b.f35871c, nativeAd, renderer);
            c.onNativeLoad(nativeAd2);
        }
    }

    public void onNativeAdFailed(NativeErrorCode errorCode) {
        MoPubLog.log(AdLogEvent.LOAD_FAILED, Integer.valueOf(errorCode.getIntCode()), errorCode.toString());
        this.f36106b.f35875g = null;
        this.f36106b.mo37933a("", errorCode);
    }
}
