package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableOnErrorNext.OnErrorNextObserver;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13225j;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Fa */
/* compiled from: ObservableOnErrorNext */
public final class C13344Fa<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super Throwable, ? extends C13802r<? extends T>> f40564b;

    /* renamed from: c */
    final boolean f40565c;

    /* renamed from: f.a.d.e.b.Fa$a */
    /* compiled from: ObservableOnErrorNext */
    static final class C13345a<T> implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f40566a;

        /* renamed from: b */
        final C13212n<? super Throwable, ? extends C13802r<? extends T>> f40567b;

        /* renamed from: c */
        final boolean f40568c;

        /* renamed from: d */
        final C13225j f40569d = new C13225j();

        /* renamed from: e */
        boolean f40570e;

        /* renamed from: f */
        boolean f40571f;

        C13345a(C13804t<? super T> actual, C13212n<? super Throwable, ? extends C13802r<? extends T>> nextSupplier, boolean allowFatal) {
            this.f40566a = actual;
            this.f40567b = nextSupplier;
            this.f40568c = allowFatal;
        }

        public void onSubscribe(C13194b s) {
            this.f40569d.mo42287a(s);
        }

        public void onNext(T t) {
            if (!this.f40571f) {
                this.f40566a.onNext(t);
            }
        }

        public void onError(Throwable t) {
            if (!this.f40570e) {
                this.f40570e = true;
                if (!this.f40568c || (t instanceof Exception)) {
                    try {
                        C13802r rVar = (C13802r) this.f40567b.apply(t);
                        if (rVar == null) {
                            NullPointerException npe = new NullPointerException("Observable is null");
                            npe.initCause(t);
                            this.f40566a.onError(npe);
                            return;
                        }
                        rVar.subscribe(this);
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        this.f40566a.onError(new CompositeException(t, e));
                    }
                } else {
                    this.f40566a.onError(t);
                }
            } else if (this.f40571f) {
                C13774a.m43836b(t);
            } else {
                this.f40566a.onError(t);
            }
        }

        public void onComplete() {
            if (!this.f40571f) {
                this.f40571f = true;
                this.f40570e = true;
                this.f40566a.onComplete();
            }
        }
    }

    public C13344Fa(C13802r<T> source, C13212n<? super Throwable, ? extends C13802r<? extends T>> nextSupplier, boolean allowFatal) {
        super(source);
        this.f40564b = nextSupplier;
        this.f40565c = allowFatal;
    }

    public void subscribeActual(C13804t<? super T> t) {
        OnErrorNextObserver<T> parent = new C13345a<>(t, this.f40564b, this.f40565c);
        t.onSubscribe(parent.f40569d);
        this.f41005a.subscribe(parent);
    }
}
