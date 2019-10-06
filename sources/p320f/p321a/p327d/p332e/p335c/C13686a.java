package p320f.p321a.p327d.p332e.p335c;

import io.reactivex.internal.operators.single.SingleCreate.Emitter;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13810v;
import p320f.p321a.C13811w;
import p320f.p321a.C13812x;
import p320f.p321a.C13813y;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.c.a */
/* compiled from: SingleCreate */
public final class C13686a<T> extends C13810v<T> {

    /* renamed from: a */
    final C13813y<T> f41704a;

    /* renamed from: f.a.d.e.c.a$a */
    /* compiled from: SingleCreate */
    static final class C13687a<T> extends AtomicReference<C13194b> implements C13811w<T>, C13194b {

        /* renamed from: a */
        final C13812x<? super T> f41705a;

        C13687a(C13812x<? super T> actual) {
            this.f41705a = actual;
        }

        public void onSuccess(T value) {
            Object obj = get();
            C13218c cVar = C13218c.DISPOSED;
            if (obj != cVar) {
                C13194b d = (C13194b) getAndSet(cVar);
                if (d != C13218c.DISPOSED) {
                    if (value == null) {
                        try {
                            this.f41705a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                        } catch (Throwable th) {
                            if (d != null) {
                                d.dispose();
                            }
                            throw th;
                        }
                    } else {
                        this.f41705a.onSuccess(value);
                    }
                    if (d != null) {
                        d.dispose();
                    }
                }
            }
        }

        /* renamed from: a */
        public void mo42662a(Throwable t) {
            if (!mo42663b(t)) {
                C13774a.m43836b(t);
            }
        }

        /* renamed from: b */
        public boolean mo42663b(Throwable t) {
            if (t == null) {
                t = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Object obj = get();
            C13218c cVar = C13218c.DISPOSED;
            if (obj != cVar) {
                C13194b d = (C13194b) getAndSet(cVar);
                if (d != C13218c.DISPOSED) {
                    try {
                        this.f41705a.onError(t);
                        return true;
                    } finally {
                        if (d != null) {
                            d.dispose();
                        }
                    }
                }
            }
            return false;
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13686a(C13813y<T> source) {
        this.f41704a = source;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42365b(C13812x<? super T> s) {
        Emitter<T> parent = new C13687a<>(s);
        s.onSubscribe(parent);
        try {
            this.f41704a.mo18351a(parent);
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            parent.mo42662a(ex);
        }
    }
}
