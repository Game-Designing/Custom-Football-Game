package p320f.p321a.p327d.p331d;

/* renamed from: f.a.d.d.f */
/* compiled from: BlockingLastObserver */
public final class C13280f<T> extends C13278d<T> {
    public void onNext(T t) {
        this.f40359a = t;
    }

    public void onError(Throwable t) {
        this.f40359a = null;
        this.f40360b = t;
        countDown();
    }
}
