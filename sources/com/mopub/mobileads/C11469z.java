package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.mobileads.z */
/* compiled from: CustomEventInterstitialAdapter */
class C11469z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CustomEventInterstitialAdapter f35453a;

    C11469z(CustomEventInterstitialAdapter this$0) {
        this.f35453a = this$0;
    }

    public void run() {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("CustomEventInterstitialAdapter() failed with code ");
        sb.append(MoPubErrorCode.NETWORK_TIMEOUT.getIntCode());
        sb.append(" and message ");
        sb.append(MoPubErrorCode.NETWORK_TIMEOUT);
        MoPubLog.log(sdkLogEvent, sb.toString());
        this.f35453a.onInterstitialFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.f35453a.mo36980a();
    }
}
