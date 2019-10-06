package p320f.p321a;

import p320f.p321a.p325b.C13194b;

/* renamed from: f.a.i */
/* compiled from: MaybeObserver */
public interface C13787i<T> {
    void onComplete();

    void onError(Throwable th);

    void onSubscribe(C13194b bVar);

    void onSuccess(T t);
}
