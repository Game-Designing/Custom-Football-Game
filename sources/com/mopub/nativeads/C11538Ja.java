package com.mopub.nativeads;

import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.nativeads.Ja */
/* compiled from: ServerPositioningSource */
class C11538Ja implements ErrorListener {

    /* renamed from: a */
    final /* synthetic */ C11540Ka f35757a;

    C11538Ja(C11540Ka this$0) {
        this.f35757a = this$0;
    }

    public void onErrorResponse(VolleyError error) {
        if (!(error instanceof MoPubNetworkError) || ((MoPubNetworkError) error).getReason().equals(Reason.WARMING_UP)) {
            MoPubLog.log(SdkLogEvent.ERROR, "Failed to load positioning data", error);
            if (error.networkResponse == null && !DeviceUtils.isNetworkAvailable(this.f35757a.f35761b)) {
                MoPubLog.log(SdkLogEvent.CUSTOM, String.valueOf(MoPubErrorCode.NO_CONNECTION));
            }
        }
        this.f35757a.m38190a();
    }
}
