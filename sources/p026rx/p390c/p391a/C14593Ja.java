package p026rx.p390c.p391a;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.a.Ja */
/* compiled from: OperatorPublish */
class C14593Ja implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14590b f43471a;

    C14593Ja(C14590b bVar) {
        this.f43471a = bVar;
    }

    public void call() {
        this.f43471a.f43465f.getAndSet(C14590b.f43461b);
        C14590b bVar = this.f43471a;
        bVar.f43463d.compareAndSet(bVar, null);
    }
}
