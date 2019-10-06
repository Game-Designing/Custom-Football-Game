package p026rx;

import p026rx.C0117M.C0118a;
import p026rx.C0126V.C0127a;

/* renamed from: rx.D */
/* compiled from: Completable */
class C14493D implements C0118a {

    /* renamed from: a */
    final /* synthetic */ C0126V f43291a;

    /* renamed from: b */
    final /* synthetic */ C0117M f43292b;

    C14493D(C0117M m, C0126V v) {
        this.f43292b = m;
        this.f43291a = v;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        C0127a w = this.f43291a.createWorker();
        w.mo3707a(new C14492C(this, s, w));
    }
}
