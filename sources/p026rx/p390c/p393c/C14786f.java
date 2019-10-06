package p026rx.p390c.p393c;

import p026rx.p027b.C0128a;

/* renamed from: rx.c.c.f */
/* compiled from: EventLoopsScheduler */
class C14786f implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C0128a f43991a;

    /* renamed from: b */
    final /* synthetic */ C14788a f43992b;

    C14786f(C14788a aVar, C0128a aVar2) {
        this.f43992b = aVar;
        this.f43991a = aVar2;
    }

    public void call() {
        if (!this.f43992b.isUnsubscribed()) {
            this.f43991a.call();
        }
    }
}
