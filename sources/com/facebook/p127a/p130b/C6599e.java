package com.facebook.p127a.p130b;

/* renamed from: com.facebook.a.b.e */
/* compiled from: ActivityLifecycleTracker */
class C6599e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6600f f11981a;

    C6599e(C6600f this$0) {
        this.f11981a = this$0;
    }

    public void run() {
        if (C6602h.f11989e.get() <= 0) {
            C6618v.m13166a(this.f11981a.f11983b, C6602h.f11990f, C6602h.f11992h);
            C6617u.m13153a();
            C6602h.f11990f = null;
        }
        synchronized (C6602h.f11988d) {
            C6602h.f11987c = null;
        }
    }
}
