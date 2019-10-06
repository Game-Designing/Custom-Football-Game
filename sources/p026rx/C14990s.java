package p026rx;

import p026rx.C0117M.C0118a;
import p026rx.C0126V.C0127a;
import p026rx.p390c.p395e.C14899t;

/* renamed from: rx.s */
/* compiled from: Completable */
class C14990s implements C0118a {

    /* renamed from: a */
    final /* synthetic */ C0126V f44354a;

    /* renamed from: b */
    final /* synthetic */ C0117M f44355b;

    C14990s(C0117M m, C0126V v) {
        this.f44355b = m;
        this.f44354a = v;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        C14899t ad = new C14899t();
        C0127a w = this.f44354a.createWorker();
        ad.mo46107a((C0137ja) w);
        s.mo45688a(ad);
        this.f44355b.mo3599b((C14503O) new C14989r(this, w, s, ad));
    }
}
