package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;

/* renamed from: f.a.d.e.b.Mb */
/* compiled from: ObserverResourceWrapper */
public final class C13408Mb<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

    /* renamed from: a */
    final C13804t<? super T> f40774a;

    /* renamed from: b */
    final AtomicReference<C13194b> f40775b = new AtomicReference<>();

    public C13408Mb(C13804t<? super T> actual) {
        this.f40774a = actual;
    }

    public void onSubscribe(C13194b s) {
        if (C13218c.m43153c(this.f40775b, s)) {
            this.f40774a.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        this.f40774a.onNext(t);
    }

    public void onError(Throwable t) {
        dispose();
        this.f40774a.onError(t);
    }

    public void onComplete() {
        dispose();
        this.f40774a.onComplete();
    }

    public void dispose() {
        C13218c.m43150a(this.f40775b);
        C13218c.m43150a((AtomicReference<C13194b>) this);
    }

    /* renamed from: a */
    public void mo42445a(C13194b resource) {
        C13218c.m43152b(this, resource);
    }
}
