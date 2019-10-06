package p026rx.p390c.p391a;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.pa */
/* compiled from: OperatorDelay */
class C14704pa implements C0128a {

    /* renamed from: a */
    final /* synthetic */ Object f43761a;

    /* renamed from: b */
    final /* synthetic */ C14711qa f43762b;

    C14704pa(C14711qa qaVar, Object obj) {
        this.f43762b = qaVar;
        this.f43761a = obj;
    }

    public void call() {
        C14711qa qaVar = this.f43762b;
        if (!qaVar.f43785a) {
            qaVar.f43787c.onNext(this.f43761a);
        }
    }
}
