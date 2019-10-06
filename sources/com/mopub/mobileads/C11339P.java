package com.mopub.mobileads;

import com.mopub.network.TrackingRequest.Listener;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.mobileads.P */
/* compiled from: MoPubConversionTracker */
class C11339P implements Listener {

    /* renamed from: a */
    final /* synthetic */ MoPubConversionTracker f34890a;

    C11339P(MoPubConversionTracker this$0) {
        this.f34890a = this$0;
    }

    public void onResponse(String url) {
        this.f34890a.f34835d.edit().putBoolean(this.f34890a.f34834c, true).putBoolean(this.f34890a.f34833b, false).apply();
    }

    public void onErrorResponse(VolleyError volleyError) {
    }
}
