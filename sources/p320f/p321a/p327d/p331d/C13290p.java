package p320f.p321a.p327d.p331d;

import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13768d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.d.p */
/* compiled from: LambdaObserver */
public final class C13290p<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b, C13768d {

    /* renamed from: a */
    final C13204f<? super T> f40389a;

    /* renamed from: b */
    final C13204f<? super Throwable> f40390b;

    /* renamed from: c */
    final C13199a f40391c;

    /* renamed from: d */
    final C13204f<? super C13194b> f40392d;

    public C13290p(C13204f<? super T> onNext, C13204f<? super Throwable> onError, C13199a onComplete, C13204f<? super C13194b> onSubscribe) {
        this.f40389a = onNext;
        this.f40390b = onError;
        this.f40391c = onComplete;
        this.f40392d = onSubscribe;
    }

    public void onSubscribe(C13194b s) {
        if (C13218c.m43153c(this, s)) {
            try {
                this.f40392d.accept(this);
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                s.dispose();
                onError(ex);
            }
        }
    }

    public void onNext(T t) {
        if (!mo42341a()) {
            try {
                this.f40389a.accept(t);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                ((C13194b) get()).dispose();
                onError(e);
            }
        }
    }

    public void onError(Throwable t) {
        if (!mo42341a()) {
            lazySet(C13218c.DISPOSED);
            try {
                this.f40390b.accept(t);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13774a.m43836b((Throwable) new CompositeException(t, e));
            }
        }
    }

    public void onComplete() {
        if (!mo42341a()) {
            lazySet(C13218c.DISPOSED);
            try {
                this.f40391c.run();
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13774a.m43836b(e);
            }
        }
    }

    public void dispose() {
        C13218c.m43150a((AtomicReference<C13194b>) this);
    }

    /* renamed from: a */
    public boolean mo42341a() {
        return get() == C13218c.DISPOSED;
    }
}
