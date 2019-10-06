package p026rx.p390c.p391a;

import p026rx.C14980ia;

/* renamed from: rx.c.a.Ya */
/* compiled from: OperatorTakeUntil */
class C14635Ya extends C14980ia<E> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43589a;

    /* renamed from: b */
    final /* synthetic */ C14638Za f43590b;

    C14635Ya(C14638Za za, C14980ia iaVar) {
        this.f43590b = za;
        this.f43589a = iaVar;
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    public void onCompleted() {
        this.f43589a.onCompleted();
    }

    public void onError(Throwable e) {
        this.f43589a.onError(e);
    }

    public void onNext(E e) {
        onCompleted();
    }
}
