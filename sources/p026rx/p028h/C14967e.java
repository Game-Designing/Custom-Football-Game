package p026rx.p028h;

import p026rx.p399e.C14915e;

/* renamed from: rx.h.e */
/* compiled from: SerializedSubject */
public class C14967e<T, R> extends C0135f<T, R> {

    /* renamed from: b */
    private final C14915e<T> f44301b;

    /* renamed from: c */
    private final C0135f<T, R> f44302c;

    public C14967e(C0135f<T, R> actual) {
        super(new C14966d(actual));
        this.f44302c = actual;
        this.f44301b = new C14915e<>(actual);
    }

    public void onCompleted() {
        this.f44301b.onCompleted();
    }

    public void onError(Throwable e) {
        this.f44301b.onError(e);
    }

    public void onNext(T t) {
        this.f44301b.onNext(t);
    }
}
