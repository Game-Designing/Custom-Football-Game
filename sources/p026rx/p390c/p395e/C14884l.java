package p026rx.p390c.p395e;

import p026rx.C0126V.C0127a;
import p026rx.p027b.C0128a;

/* renamed from: rx.c.e.l */
/* compiled from: ScalarSynchronousObservable */
class C14884l implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C0128a f44173a;

    /* renamed from: b */
    final /* synthetic */ C0127a f44174b;

    /* renamed from: c */
    final /* synthetic */ C14885m f44175c;

    C14884l(C14885m mVar, C0128a aVar, C0127a aVar2) {
        this.f44175c = mVar;
        this.f44173a = aVar;
        this.f44174b = aVar2;
    }

    public void call() {
        try {
            this.f44173a.call();
        } finally {
            this.f44174b.unsubscribe();
        }
    }
}
