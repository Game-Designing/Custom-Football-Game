package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableScalarXMap.ScalarDisposable;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p330c.C13272g;
import p320f.p321a.p327d.p332e.p334b.C13475Ya.C13476a;

/* renamed from: f.a.d.e.b.ta */
/* compiled from: ObservableJust */
public final class C13637ta<T> extends C13797m<T> implements C13272g<T> {

    /* renamed from: a */
    private final T f41532a;

    public C13637ta(T value) {
        this.f41532a = value;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> s) {
        ScalarDisposable<T> sd = new C13476a<>(s, this.f41532a);
        s.onSubscribe(sd);
        sd.run();
    }

    public T call() {
        return this.f41532a;
    }
}
