package p026rx.p390c.p391a;

import p026rx.C14508U;

/* renamed from: rx.c.a.Pa */
/* compiled from: OperatorSubscribeOn */
class C14613Pa implements C14508U {

    /* renamed from: a */
    final /* synthetic */ C14508U f43521a;

    /* renamed from: b */
    final /* synthetic */ C14616a f43522b;

    C14613Pa(C14616a aVar, C14508U u) {
        this.f43522b = aVar;
        this.f43521a = u;
    }

    public void request(long n) {
        if (this.f43522b.f43536e != Thread.currentThread()) {
            C14616a aVar = this.f43522b;
            if (aVar.f43533b) {
                aVar.f43534c.mo3707a(new C14611Oa(this, n));
                return;
            }
        }
        this.f43521a.request(n);
    }
}
