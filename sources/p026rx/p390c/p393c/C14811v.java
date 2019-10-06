package p026rx.p390c.p393c;

import p026rx.C0117M;
import p026rx.C0117M.C0118a;
import p026rx.C0126V.C0127a;
import p026rx.p027b.C0132p;

/* renamed from: rx.c.c.v */
/* compiled from: SchedulerWhen */
class C14811v implements C0132p<C14818d, C0117M> {

    /* renamed from: a */
    final /* synthetic */ C0127a f44057a;

    /* renamed from: b */
    final /* synthetic */ C14814y f44058b;

    C14811v(C14814y yVar, C0127a aVar) {
        this.f44058b = yVar;
        this.f44057a = aVar;
    }

    /* renamed from: a */
    public C0117M call(C14818d action) {
        return C0117M.m585a((C0118a) new C14810u(this, action));
    }
}
