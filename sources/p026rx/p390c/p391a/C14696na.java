package p026rx.p390c.p391a;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.na */
/* compiled from: OperatorDelay */
class C14696na implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14711qa f43727a;

    C14696na(C14711qa qaVar) {
        this.f43727a = qaVar;
    }

    public void call() {
        C14711qa qaVar = this.f43727a;
        if (!qaVar.f43785a) {
            qaVar.f43785a = true;
            qaVar.f43787c.onCompleted();
        }
    }
}
