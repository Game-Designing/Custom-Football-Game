package p320f.p321a.p342f;

import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.f.e */
/* compiled from: SafeObserver */
public final class C13769e<T> implements C13804t<T>, C13194b {

    /* renamed from: a */
    final C13804t<? super T> f41887a;

    /* renamed from: b */
    C13194b f41888b;

    /* renamed from: c */
    boolean f41889c;

    public C13769e(C13804t<? super T> actual) {
        this.f41887a = actual;
    }

    public void onSubscribe(C13194b s) {
        if (C13218c.m43149a(this.f41888b, s)) {
            this.f41888b = s;
            try {
                this.f41887a.onSubscribe(this);
            } catch (Throwable e1) {
                C13980a.m44462b(e1);
                C13774a.m43836b((Throwable) new CompositeException(e, e1));
            }
        }
    }

    public void dispose() {
        this.f41888b.dispose();
    }

    public void onNext(T t) {
        if (!this.f41889c) {
            if (this.f41888b == null) {
                mo42788b();
            } else if (t == null) {
                Throwable ex = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                try {
                    this.f41888b.dispose();
                    onError(ex);
                } catch (Throwable e1) {
                    C13980a.m44462b(e1);
                    onError(new CompositeException(ex, e1));
                }
            } else {
                try {
                    this.f41887a.onNext(t);
                } catch (Throwable e12) {
                    C13980a.m44462b(e12);
                    onError(new CompositeException(e, e12));
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42788b() {
        this.f41889c = true;
        Throwable ex = new NullPointerException("Subscription not set!");
        try {
            this.f41887a.onSubscribe(C13219d.INSTANCE);
            try {
                this.f41887a.onError(ex);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13774a.m43836b((Throwable) new CompositeException(ex, e));
            }
        } catch (Throwable e2) {
            C13980a.m44462b(e2);
            C13774a.m43836b((Throwable) new CompositeException(ex, e2));
        }
    }

    public void onError(Throwable t) {
        if (this.f41889c) {
            C13774a.m43836b(t);
            return;
        }
        this.f41889c = true;
        if (this.f41888b == null) {
            Throwable npe = new NullPointerException("Subscription not set!");
            try {
                this.f41887a.onSubscribe(C13219d.INSTANCE);
                try {
                    this.f41887a.onError(new CompositeException(t, npe));
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    C13774a.m43836b((Throwable) new CompositeException(t, npe, e));
                }
            } catch (Throwable e2) {
                C13980a.m44462b(e2);
                C13774a.m43836b((Throwable) new CompositeException(t, npe, e2));
            }
        } else {
            if (t == null) {
                t = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f41887a.onError(t);
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                C13774a.m43836b((Throwable) new CompositeException(t, ex));
            }
        }
    }

    public void onComplete() {
        if (!this.f41889c) {
            this.f41889c = true;
            if (this.f41888b == null) {
                mo42787a();
                return;
            }
            try {
                this.f41887a.onComplete();
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13774a.m43836b(e);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42787a() {
        Throwable ex = new NullPointerException("Subscription not set!");
        try {
            this.f41887a.onSubscribe(C13219d.INSTANCE);
            try {
                this.f41887a.onError(ex);
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13774a.m43836b((Throwable) new CompositeException(ex, e));
            }
        } catch (Throwable e2) {
            C13980a.m44462b(e2);
            C13774a.m43836b((Throwable) new CompositeException(ex, e2));
        }
    }
}
