package p026rx;

/* renamed from: rx.T */
/* compiled from: Observer */
public interface C0125T<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t);
}
