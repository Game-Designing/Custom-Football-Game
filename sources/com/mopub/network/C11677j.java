package com.mopub.network;

import com.mopub.volley.Request;

/* renamed from: com.mopub.network.j */
/* compiled from: MoPubRequestQueue */
class C11677j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ MoPubRequestQueue f36401a;

    /* renamed from: b */
    final /* synthetic */ Request f36402b;

    /* renamed from: c */
    final /* synthetic */ C11665a f36403c;

    C11677j(C11665a this$1, MoPubRequestQueue moPubRequestQueue, Request request) {
        this.f36403c = this$1;
        this.f36401a = moPubRequestQueue;
        this.f36402b = request;
    }

    public void run() {
        MoPubRequestQueue.this.f36358l.remove(this.f36402b);
        MoPubRequestQueue.this.add(this.f36402b);
    }
}
