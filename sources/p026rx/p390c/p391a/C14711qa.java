package p026rx.p390c.p391a;

import p026rx.C0126V.C0127a;
import p026rx.C14980ia;

/* renamed from: rx.c.a.qa */
/* compiled from: OperatorDelay */
class C14711qa extends C14980ia<T> {

    /* renamed from: a */
    boolean f43785a;

    /* renamed from: b */
    final /* synthetic */ C0127a f43786b;

    /* renamed from: c */
    final /* synthetic */ C14980ia f43787c;

    /* renamed from: d */
    final /* synthetic */ C14714ra f43788d;

    C14711qa(C14714ra raVar, C14980ia x0, C0127a aVar, C14980ia iaVar) {
        this.f43788d = raVar;
        this.f43786b = aVar;
        this.f43787c = iaVar;
        super(x0);
    }

    public void onCompleted() {
        C0127a aVar = this.f43786b;
        C14696na naVar = new C14696na(this);
        C14714ra raVar = this.f43788d;
        aVar.mo3709a(naVar, raVar.f43792a, raVar.f43793b);
    }

    public void onError(Throwable e) {
        this.f43786b.mo3707a(new C14701oa(this, e));
    }

    public void onNext(T t) {
        C0127a aVar = this.f43786b;
        C14704pa paVar = new C14704pa(this, t);
        C14714ra raVar = this.f43788d;
        aVar.mo3709a(paVar, raVar.f43792a, raVar.f43793b);
    }
}
