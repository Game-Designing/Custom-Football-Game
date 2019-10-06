package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

public class SingleImpression {

    /* renamed from: a */
    private final String f36384a;

    /* renamed from: b */
    private final ImpressionData f36385b;

    public SingleImpression(String adUnitid, ImpressionData data) {
        this.f36384a = adUnitid;
        this.f36385b = data;
    }

    public void sendImpression() {
        String str = this.f36384a;
        if (str != null) {
            ImpressionsEmitter.m38536a(str, this.f36385b);
            return;
        }
        MoPubLog.log(SdkLogEvent.CUSTOM, "SingleImpression ad unit id may not be null.");
    }
}
