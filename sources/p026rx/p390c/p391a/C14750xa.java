package p026rx.p390c.p391a;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.xa */
/* compiled from: OperatorEagerConcatMap */
class C14750xa implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14746c f43877a;

    C14750xa(C14746c cVar) {
        this.f43877a = cVar;
    }

    public void call() {
        C14746c cVar = this.f43877a;
        cVar.f43868g = true;
        if (cVar.f43869h.getAndIncrement() == 0) {
            this.f43877a.mo45878a();
        }
    }
}
