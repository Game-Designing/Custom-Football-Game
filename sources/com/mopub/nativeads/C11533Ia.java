package com.mopub.nativeads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.volley.Response.Listener;

/* renamed from: com.mopub.nativeads.Ia */
/* compiled from: ServerPositioningSource */
class C11533Ia implements Listener<MoPubClientPositioning> {

    /* renamed from: a */
    final /* synthetic */ C11540Ka f35681a;

    C11533Ia(C11540Ka this$0) {
        this.f35681a = this$0;
    }

    public void onResponse(MoPubClientPositioning clientPositioning) {
        this.f35681a.m38193a(clientPositioning);
    }
}
