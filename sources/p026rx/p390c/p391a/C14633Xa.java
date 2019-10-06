package p026rx.p390c.p391a;

import p026rx.C14980ia;

/* renamed from: rx.c.a.Xa */
/* compiled from: OperatorTakeUntil */
class C14633Xa extends C14980ia<T> {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43586a;

    /* renamed from: b */
    final /* synthetic */ C14638Za f43587b;

    C14633Xa(C14638Za za, C14980ia x0, boolean x1, C14980ia iaVar) {
        this.f43587b = za;
        this.f43586a = iaVar;
        super(x0, x1);
    }

    public void onNext(T t) {
        this.f43586a.onNext(t);
    }

    public void onError(Throwable e) {
        try {
            this.f43586a.onError(e);
        } finally {
            this.f43586a.unsubscribe();
        }
    }

    public void onCompleted() {
        try {
            this.f43586a.onCompleted();
        } finally {
            this.f43586a.unsubscribe();
        }
    }
}
