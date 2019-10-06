package p026rx.p390c.p393c;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.c.d */
/* compiled from: CachedThreadScheduler */
class C14784d implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C0128a f43987a;

    /* renamed from: b */
    final /* synthetic */ C14782b f43988b;

    C14784d(C14782b bVar, C0128a aVar) {
        this.f43988b = bVar;
        this.f43987a = aVar;
    }

    public void call() {
        if (!this.f43988b.isUnsubscribed()) {
            this.f43987a.call();
        }
    }
}
