package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13283i;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.ea */
/* compiled from: ObservableFromCallable */
public final class C13515ea<T> extends C13797m<T> implements Callable<T> {

    /* renamed from: a */
    final Callable<? extends T> f41107a;

    public C13515ea(Callable<? extends T> callable) {
        this.f41107a = callable;
    }

    public void subscribeActual(C13804t<? super T> s) {
        DeferredScalarDisposable<T> d = new C13283i<>(s);
        s.onSubscribe(d);
        if (!d.mo42328a()) {
            try {
                T value = this.f41107a.call();
                C13264b.m43226a(value, "Callable returned null");
                d.mo42327a(value);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                if (!d.mo42328a()) {
                    s.onError(e);
                } else {
                    C13774a.m43836b(e);
                }
            }
        }
    }

    public T call() throws Exception {
        T call = this.f41107a.call();
        C13264b.m43226a(call, "The callable returned a null value");
        return call;
    }
}
