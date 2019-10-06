package p026rx.p390c.p395e;

import p026rx.C14980ia;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;

/* renamed from: rx.c.e.b */
/* compiled from: ActionSubscriber */
public final class C14832b<T> extends C14980ia<T> {

    /* renamed from: a */
    final C0129b<? super T> f44116a;

    /* renamed from: b */
    final C0129b<Throwable> f44117b;

    /* renamed from: c */
    final C0128a f44118c;

    public C14832b(C0129b<? super T> onNext, C0129b<Throwable> onError, C0128a onCompleted) {
        this.f44116a = onNext;
        this.f44117b = onError;
        this.f44118c = onCompleted;
    }

    public void onNext(T t) {
        this.f44116a.call(t);
    }

    public void onError(Throwable e) {
        this.f44117b.call(e);
    }

    public void onCompleted() {
        this.f44118c.call();
    }
}
