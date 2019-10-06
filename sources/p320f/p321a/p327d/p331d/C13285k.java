package p320f.p321a.p327d.p331d;

import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.d.k */
/* compiled from: ForEachWhileObserver */
public final class C13285k<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

    /* renamed from: a */
    final C13214p<? super T> f40375a;

    /* renamed from: b */
    final C13204f<? super Throwable> f40376b;

    /* renamed from: c */
    final C13199a f40377c;

    /* renamed from: d */
    boolean f40378d;

    public C13285k(C13214p<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete) {
        this.f40375a = onNext;
        this.f40376b = onError;
        this.f40377c = onComplete;
    }

    public void onSubscribe(C13194b s) {
        C13218c.m43153c(this, s);
    }

    public void onNext(T t) {
        if (!this.f40378d) {
            try {
                if (!this.f40375a.test(t)) {
                    dispose();
                    onComplete();
                }
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                dispose();
                onError(ex);
            }
        }
    }

    public void onError(Throwable t) {
        if (this.f40378d) {
            C13774a.m43836b(t);
            return;
        }
        this.f40378d = true;
        try {
            this.f40376b.accept(t);
        } catch (Throwable ex) {
            C13980a.m44462b(ex);
            C13774a.m43836b((Throwable) new CompositeException(t, ex));
        }
    }

    public void onComplete() {
        if (!this.f40378d) {
            this.f40378d = true;
            try {
                this.f40377c.run();
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                C13774a.m43836b(ex);
            }
        }
    }

    public void dispose() {
        C13218c.m43150a((AtomicReference<C13194b>) this);
    }
}
