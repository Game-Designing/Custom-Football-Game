package p026rx.p390c.p395e;

import p026rx.C0125T;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;

/* renamed from: rx.c.e.a */
/* compiled from: ActionObserver */
public final class C14823a<T> implements C0125T<T> {

    /* renamed from: a */
    final C0129b<? super T> f44079a;

    /* renamed from: b */
    final C0129b<? super Throwable> f44080b;

    /* renamed from: c */
    final C0128a f44081c;

    public C14823a(C0129b<? super T> onNext, C0129b<? super Throwable> onError, C0128a onCompleted) {
        this.f44079a = onNext;
        this.f44080b = onError;
        this.f44081c = onCompleted;
    }

    public void onNext(T t) {
        this.f44079a.call(t);
    }

    public void onError(Throwable e) {
        this.f44080b.call(e);
    }

    public void onCompleted() {
        this.f44081c.call();
    }
}
