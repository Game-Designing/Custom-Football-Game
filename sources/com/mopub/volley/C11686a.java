package com.mopub.volley;

/* renamed from: com.mopub.volley.a */
/* compiled from: CacheDispatcher */
class C11686a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Request f36464a;

    /* renamed from: b */
    final /* synthetic */ CacheDispatcher f36465b;

    C11686a(CacheDispatcher this$0, Request request) {
        this.f36465b = this$0;
        this.f36464a = request;
    }

    public void run() {
        try {
            this.f36465b.f36410c.put(this.f36464a);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
