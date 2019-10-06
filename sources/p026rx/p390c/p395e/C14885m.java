package p026rx.p390c.p395e;

import p026rx.C0126V;
import p026rx.C0126V.C0127a;
import p026rx.C0137ja;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0132p;

/* renamed from: rx.c.e.m */
/* compiled from: ScalarSynchronousObservable */
class C14885m implements C0132p<C0128a, C0137ja> {

    /* renamed from: a */
    final /* synthetic */ C0126V f44176a;

    /* renamed from: b */
    final /* synthetic */ C14887o f44177b;

    C14885m(C14887o oVar, C0126V v) {
        this.f44177b = oVar;
        this.f44176a = v;
    }

    /* renamed from: a */
    public C0137ja call(C0128a a) {
        C0127a w = this.f44176a.createWorker();
        w.mo3707a(new C14884l(this, a, w));
        return w;
    }
}
