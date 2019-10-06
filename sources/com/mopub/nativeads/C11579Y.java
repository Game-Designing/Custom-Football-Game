package com.mopub.nativeads;

import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.volley.VolleyError;

/* renamed from: com.mopub.nativeads.Y */
/* compiled from: MoPubNative */
class C11579Y implements Listener {

    /* renamed from: a */
    final /* synthetic */ MoPubNative f36102a;

    C11579Y(MoPubNative this$0) {
        this.f36102a = this$0;
    }

    public void onSuccess(AdResponse response) {
        this.f36102a.m38270a(response);
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.f36102a.mo37932a(volleyError);
    }
}
