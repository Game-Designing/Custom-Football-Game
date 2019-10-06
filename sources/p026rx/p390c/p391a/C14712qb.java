package p026rx.p390c.p391a;

import p026rx.C14980ia;

/* renamed from: rx.c.a.qb */
/* compiled from: OperatorUnsubscribeOn */
class C14712qb extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43789a;

    /* renamed from: b */
    final /* synthetic */ C14729tb f43790b;

    C14712qb(C14729tb tbVar, C14980ia iaVar) {
        this.f43790b = tbVar;
        this.f43789a = iaVar;
    }

    public void onCompleted() {
        this.f43789a.onCompleted();
    }

    public void onError(Throwable e) {
        this.f43789a.onError(e);
    }

    public void onNext(T t) {
        this.f43789a.onNext(t);
    }
}
