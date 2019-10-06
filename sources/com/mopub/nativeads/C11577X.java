package com.mopub.nativeads;

import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;

/* renamed from: com.mopub.nativeads.X */
/* compiled from: MoPubNative */
class C11577X implements MoPubNativeNetworkListener {
    C11577X() {
    }

    public void onNativeLoad(NativeAd nativeAd) {
        nativeAd.destroy();
    }

    public void onNativeFail(NativeErrorCode errorCode) {
    }
}
