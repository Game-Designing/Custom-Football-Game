package p026rx.p390c.p391a;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.oa */
/* compiled from: OperatorDelay */
class C14701oa implements C0128a {

    /* renamed from: a */
    final /* synthetic */ Throwable f43752a;

    /* renamed from: b */
    final /* synthetic */ C14711qa f43753b;

    C14701oa(C14711qa qaVar, Throwable th) {
        this.f43753b = qaVar;
        this.f43752a = th;
    }

    public void call() {
        C14711qa qaVar = this.f43753b;
        if (!qaVar.f43785a) {
            qaVar.f43785a = true;
            qaVar.f43787c.onError(this.f43752a);
            this.f43753b.f43786b.unsubscribe();
        }
    }
}
