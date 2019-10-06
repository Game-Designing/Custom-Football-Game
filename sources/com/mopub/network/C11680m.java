package com.mopub.network;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.network.TrackingRequest.Listener;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.network.m */
/* compiled from: TrackingRequest */
class C11680m implements Listener {

    /* renamed from: a */
    final /* synthetic */ Listener f36405a;

    /* renamed from: b */
    final /* synthetic */ String f36406b;

    C11680m(Listener listener, String str) {
        this.f36405a = listener;
        this.f36406b = str;
    }

    public void onResponse(String url) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Successfully hit tracking endpoint: ");
        sb.append(url);
        MoPubLog.log(sdkLogEvent, sb.toString());
        Listener listener = this.f36405a;
        if (listener != null) {
            listener.onResponse(url);
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        SdkLogEvent sdkLogEvent = SdkLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to hit tracking endpoint: ");
        sb.append(this.f36406b);
        MoPubLog.log(sdkLogEvent, sb.toString());
        Listener listener = this.f36405a;
        if (listener != null) {
            listener.onErrorResponse(volleyError);
        }
    }
}
