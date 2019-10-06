package p026rx.p390c.p395e;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p399e.C14920i;

/* renamed from: rx.c.e.n */
/* compiled from: ScalarSynchronousObservable */
class C14886n implements C0122a<R> {

    /* renamed from: a */
    final /* synthetic */ C0132p f44178a;

    /* renamed from: b */
    final /* synthetic */ C14887o f44179b;

    C14886n(C14887o oVar, C0132p pVar) {
        this.f44179b = oVar;
        this.f44178a = pVar;
    }

    /* renamed from: a */
    public void call(C14980ia<? super R> child) {
        C0120S s = (C0120S) this.f44178a.call(this.f44179b.f44181c);
        if (s instanceof C14887o) {
            child.setProducer(C14887o.m46611a(child, ((C14887o) s).f44181c));
        } else {
            s.mo3640b(C14920i.m46653a(child));
        }
    }
}
