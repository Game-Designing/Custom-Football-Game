package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

/* renamed from: com.mopub.mobileads.x */
/* compiled from: CustomEventBannerAdapter */
class C11465x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CustomEventBannerAdapter f35449a;

    C11465x(CustomEventBannerAdapter this$0) {
        this.f35449a = this$0;
    }

    public void run() {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("CustomEventBannerAdapter failed with code ");
        sb.append(MoPubErrorCode.NETWORK_TIMEOUT.getIntCode());
        sb.append(" and message ");
        sb.append(MoPubErrorCode.NETWORK_TIMEOUT);
        MoPubLog.log(sdkLogEvent, sb.toString());
        this.f35449a.onBannerFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        this.f35449a.invalidate();
    }
}
