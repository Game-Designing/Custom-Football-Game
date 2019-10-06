package p026rx;

import p026rx.C0126V.C0127a;
import p026rx.p390c.p395e.C14899t;

/* renamed from: rx.r */
/* compiled from: Completable */
class C14989r implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C0127a f44350a;

    /* renamed from: b */
    final /* synthetic */ C14503O f44351b;

    /* renamed from: c */
    final /* synthetic */ C14899t f44352c;

    /* renamed from: d */
    final /* synthetic */ C14990s f44353d;

    C14989r(C14990s sVar, C0127a aVar, C14503O o, C14899t tVar) {
        this.f44353d = sVar;
        this.f44350a = aVar;
        this.f44351b = o;
        this.f44352c = tVar;
    }

    public void onCompleted() {
        this.f44350a.mo3707a(new C14987p(this));
    }

    public void onError(Throwable e) {
        this.f44350a.mo3707a(new C14988q(this, e));
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f44352c.mo46107a(d);
    }
}
