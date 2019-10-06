package p320f.p321a.p325b;

import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.b.d */
/* compiled from: ReferenceDisposable */
abstract class C13196d<T> extends AtomicReference<T> implements C13194b {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo42254a(T t);

    C13196d(T value) {
        C13264b.m43226a(value, "value is null");
        super(value);
    }

    public final void dispose() {
        if (get() != null) {
            T value = getAndSet(null);
            if (value != null) {
                mo42254a(value);
            }
        }
    }

    /* renamed from: a */
    public final boolean mo42255a() {
        return get() == null;
    }
}
