package p026rx.p390c.p393c;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.c.e */
/* compiled from: EventLoopsScheduler */
class C14785e implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C0128a f43989a;

    /* renamed from: b */
    final /* synthetic */ C14788a f43990b;

    C14785e(C14788a aVar, C0128a aVar2) {
        this.f43990b = aVar;
        this.f43989a = aVar2;
    }

    public void call() {
        if (!this.f43990b.isUnsubscribed()) {
            this.f43989a.call();
        }
    }
}
