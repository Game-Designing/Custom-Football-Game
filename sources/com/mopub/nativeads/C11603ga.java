package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.PositioningSource.PositioningListener;

/* renamed from: com.mopub.nativeads.ga */
/* compiled from: MoPubStreamAdPlacer */
class C11603ga implements PositioningListener {

    /* renamed from: a */
    final /* synthetic */ MoPubStreamAdPlacer f36145a;

    C11603ga(MoPubStreamAdPlacer this$0) {
        this.f36145a = this$0;
    }

    public void onLoad(MoPubClientPositioning positioning) {
        this.f36145a.mo37962a(positioning);
    }

    public void onFailed() {
        MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
    }
}
