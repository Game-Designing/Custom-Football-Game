package p026rx.schedulers;

import p026rx.p027b.C0128a;

/* renamed from: rx.schedulers.b */
/* compiled from: TestScheduler */
class C14995b implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14993c f44367a;

    /* renamed from: b */
    final /* synthetic */ C14992b f44368b;

    C14995b(C14992b bVar, C14993c cVar) {
        this.f44368b = bVar;
        this.f44367a = cVar;
    }

    public void call() {
        TestScheduler.this.f44357b.remove(this.f44367a);
    }
}
