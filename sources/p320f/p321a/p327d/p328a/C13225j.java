package p320f.p321a.p327d.p328a;

import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.p325b.C13194b;

/* renamed from: f.a.d.a.j */
/* compiled from: SequentialDisposable */
public final class C13225j extends AtomicReference<C13194b> implements C13194b {
    public C13225j() {
    }

    public C13225j(C13194b initial) {
        lazySet(initial);
    }

    /* renamed from: b */
    public boolean mo42288b(C13194b next) {
        return C13218c.m43152b(this, next);
    }

    /* renamed from: a */
    public boolean mo42287a(C13194b next) {
        return C13218c.m43151a((AtomicReference<C13194b>) this, next);
    }

    public void dispose() {
        C13218c.m43150a((AtomicReference<C13194b>) this);
    }

    /* renamed from: a */
    public boolean mo42286a() {
        return C13218c.m43148a((C13194b) get());
    }
}
