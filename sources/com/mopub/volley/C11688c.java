package com.mopub.volley;

/* renamed from: com.mopub.volley.c */
/* compiled from: Request */
class C11688c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f36468a;

    /* renamed from: b */
    final /* synthetic */ long f36469b;

    /* renamed from: c */
    final /* synthetic */ Request f36470c;

    C11688c(Request this$0, String str, long j) {
        this.f36470c = this$0;
        this.f36468a = str;
        this.f36469b = j;
    }

    public void run() {
        this.f36470c.f36432a.add(this.f36468a, this.f36469b);
        this.f36470c.f36432a.finish(this.f36470c.toString());
    }
}
