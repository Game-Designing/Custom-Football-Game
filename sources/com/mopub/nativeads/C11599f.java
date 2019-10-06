package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.MoPubErrorCode;

/* renamed from: com.mopub.nativeads.f */
/* compiled from: CustomEventNativeAdapter */
class C11599f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C11605h f36138a;

    C11599f(C11605h this$0) {
        this.f36138a = this$0;
    }

    public void run() {
        if (!this.f36138a.f36153e) {
            SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append("CustomEventNativeAdapter() failed with code ");
            sb.append(MoPubErrorCode.NETWORK_TIMEOUT.getIntCode());
            sb.append(" and message ");
            sb.append(MoPubErrorCode.NETWORK_TIMEOUT);
            MoPubLog.log(sdkLogEvent, sb.toString());
            this.f36138a.mo38163a();
            this.f36138a.f36152d.onNativeAdFailed(NativeErrorCode.NETWORK_TIMEOUT);
        }
    }
}
