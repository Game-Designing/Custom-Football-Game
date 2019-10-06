package p320f.p321a;

import p320f.p321a.p325b.C13194b;

/* renamed from: f.a.t */
/* compiled from: Observer */
public interface C13804t<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t);

    void onSubscribe(C13194b bVar);
}
