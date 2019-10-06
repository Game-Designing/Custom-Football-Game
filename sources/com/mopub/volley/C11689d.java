package com.mopub.volley;

import com.mopub.volley.RequestQueue.RequestFilter;

/* renamed from: com.mopub.volley.d */
/* compiled from: RequestQueue */
class C11689d implements RequestFilter {

    /* renamed from: a */
    final /* synthetic */ Object f36471a;

    /* renamed from: b */
    final /* synthetic */ RequestQueue f36472b;

    C11689d(RequestQueue this$0, Object obj) {
        this.f36472b = this$0;
        this.f36471a = obj;
    }

    public boolean apply(Request<?> request) {
        return request.getTag() == this.f36471a;
    }
}
