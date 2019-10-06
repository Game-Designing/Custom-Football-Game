package com.facebook.p127a.p130b;

/* renamed from: com.facebook.a.b.c */
/* compiled from: ActivityLifecycleTracker */
class C6597c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ long f11977a;

    /* renamed from: b */
    final /* synthetic */ String f11978b;

    C6597c(long j, String str) {
        this.f11977a = j;
        this.f11978b = str;
    }

    public void run() {
        if (C6602h.f11990f == null) {
            C6602h.f11990f = new C6617u(Long.valueOf(this.f11977a), null);
            C6618v.m13167a(this.f11978b, (C6619w) null, C6602h.f11992h);
        } else if (C6602h.f11990f.mo19809e() != null) {
            long suspendTime = this.f11977a - C6602h.f11990f.mo19809e().longValue();
            if (suspendTime > ((long) (C6602h.m13106r() * 1000))) {
                C6618v.m13166a(this.f11978b, C6602h.f11990f, C6602h.f11992h);
                C6618v.m13167a(this.f11978b, (C6619w) null, C6602h.f11992h);
                C6602h.f11990f = new C6617u(Long.valueOf(this.f11977a), null);
            } else if (suspendTime > 1000) {
                C6602h.f11990f.mo19812i();
            }
        }
        C6602h.f11990f.mo19805a(Long.valueOf(this.f11977a));
        C6602h.f11990f.mo19813j();
    }
}
