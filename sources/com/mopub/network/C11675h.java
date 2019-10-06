package com.mopub.network;

import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue.RequestFilter;

/* renamed from: com.mopub.network.h */
/* compiled from: MoPubRequestQueue */
class C11675h implements RequestFilter {

    /* renamed from: a */
    final /* synthetic */ Object f36397a;

    /* renamed from: b */
    final /* synthetic */ MoPubRequestQueue f36398b;

    C11675h(MoPubRequestQueue this$0, Object obj) {
        this.f36398b = this$0;
        this.f36397a = obj;
    }

    public boolean apply(Request<?> request) {
        return request.getTag() == this.f36397a;
    }
}
