package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13283i;

/* renamed from: f.a.d.e.b.fa */
/* compiled from: ObservableFromFuture */
public final class C13520fa<T> extends C13797m<T> {

    /* renamed from: a */
    final Future<? extends T> f41120a;

    /* renamed from: b */
    final long f41121b;

    /* renamed from: c */
    final TimeUnit f41122c;

    public C13520fa(Future<? extends T> future, long timeout, TimeUnit unit) {
        this.f41120a = future;
        this.f41121b = timeout;
        this.f41122c = unit;
    }

    public void subscribeActual(C13804t<? super T> s) {
        DeferredScalarDisposable<T> d = new C13283i<>(s);
        s.onSubscribe(d);
        if (!d.mo42328a()) {
            try {
                T v = this.f41122c != null ? this.f41120a.get(this.f41121b, this.f41122c) : this.f41120a.get();
                C13264b.m43226a(v, "Future returned null");
                d.mo42327a(v);
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                if (!d.mo42328a()) {
                    s.onError(ex);
                }
            }
        }
    }
}
