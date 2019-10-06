package p026rx.schedulers;

import p026rx.p027b.C0128a;

/* renamed from: rx.schedulers.a */
/* compiled from: TestScheduler */
class C14994a implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14993c f44365a;

    /* renamed from: b */
    final /* synthetic */ C14992b f44366b;

    C14994a(C14992b bVar, C14993c cVar) {
        this.f44366b = bVar;
        this.f44365a = cVar;
    }

    public void call() {
        TestScheduler.this.f44357b.remove(this.f44365a);
    }
}
