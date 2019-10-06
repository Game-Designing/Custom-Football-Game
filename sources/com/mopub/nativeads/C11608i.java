package com.mopub.nativeads;

import com.google.android.gms.ads.AdListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;

/* renamed from: com.mopub.nativeads.i */
/* compiled from: GooglePlayServicesNative */
class C11608i extends AdListener {

    /* renamed from: a */
    final /* synthetic */ C11529a f36158a;

    C11608i(C11529a this$0) {
        this.f36158a = this$0;
    }

    public void onAdClicked() {
        super.onAdClicked();
        this.f36158a.mo37749c();
        MoPubLog.log(AdapterLogEvent.CLICKED, GooglePlayServicesNative.f35660a);
    }

    public void onAdImpression() {
        super.onAdImpression();
        this.f36158a.mo37750d();
        MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, GooglePlayServicesNative.f35660a);
    }

    public void onAdFailedToLoad(int errorCode) {
        super.onAdFailedToLoad(errorCode);
        if (errorCode == 0) {
            this.f36158a.f35675p.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_CONFIGURATION_ERROR);
        } else if (errorCode == 1) {
            this.f36158a.f35675p.onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_REQUEST);
        } else if (errorCode == 2) {
            this.f36158a.f35675p.onNativeAdFailed(NativeErrorCode.CONNECTION_ERROR);
        } else if (errorCode != 3) {
            this.f36158a.f35675p.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
        } else {
            this.f36158a.f35675p.onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
        }
    }
}
