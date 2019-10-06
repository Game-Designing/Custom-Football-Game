package p320f.p321a.p327d.p331d;

/* renamed from: f.a.d.d.e */
/* compiled from: BlockingFirstObserver */
public final class C13279e<T> extends C13278d<T> {
    public void onNext(T t) {
        if (this.f40359a == null) {
            this.f40359a = t;
            this.f40361c.dispose();
            countDown();
        }
    }

    public void onError(Throwable t) {
        if (this.f40359a == null) {
            this.f40360b = t;
        }
        countDown();
    }
}
