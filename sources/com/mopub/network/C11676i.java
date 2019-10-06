package com.mopub.network;

import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue.RequestFilter;

/* renamed from: com.mopub.network.i */
/* compiled from: MoPubRequestQueue */
class C11676i implements RequestFilter {

    /* renamed from: a */
    final /* synthetic */ Request f36399a;

    /* renamed from: b */
    final /* synthetic */ MoPubRequestQueue f36400b;

    C11676i(MoPubRequestQueue this$0, Request request) {
        this.f36400b = this$0;
        this.f36399a = request;
    }

    public boolean apply(Request<?> _request) {
        return this.f36399a == _request;
    }
}
