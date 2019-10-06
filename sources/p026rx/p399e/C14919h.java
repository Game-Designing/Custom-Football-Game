package p026rx.p399e;

import p026rx.C14980ia;

/* renamed from: rx.e.h */
/* compiled from: Subscribers */
class C14919h extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f44239a;

    C14919h(C14980ia x0, C14980ia iaVar) {
        this.f44239a = iaVar;
        super(x0);
    }

    public void onCompleted() {
        this.f44239a.onCompleted();
    }

    public void onError(Throwable e) {
        this.f44239a.onError(e);
    }

    public void onNext(T t) {
        this.f44239a.onNext(t);
    }
}
