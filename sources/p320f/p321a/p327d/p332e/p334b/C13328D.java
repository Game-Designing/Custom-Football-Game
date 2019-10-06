package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservableDebounce.DebounceObserver.DebounceInnerObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p342f.C13767c;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.D */
/* compiled from: ObservableDebounce */
public final class C13328D<T, U> extends C13485a<T, T> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13802r<U>> f40490b;

    /* renamed from: f.a.d.e.b.D$a */
    /* compiled from: ObservableDebounce */
    static final class C13329a<T, U> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40491a;

        /* renamed from: b */
        final C13212n<? super T, ? extends C13802r<U>> f40492b;

        /* renamed from: c */
        C13194b f40493c;

        /* renamed from: d */
        final AtomicReference<C13194b> f40494d = new AtomicReference<>();

        /* renamed from: e */
        volatile long f40495e;

        /* renamed from: f */
        boolean f40496f;

        /* renamed from: f.a.d.e.b.D$a$a */
        /* compiled from: ObservableDebounce */
        static final class C13330a<T, U> extends C13767c<U> {

            /* renamed from: b */
            final C13329a<T, U> f40497b;

            /* renamed from: c */
            final long f40498c;

            /* renamed from: d */
            final T f40499d;

            /* renamed from: e */
            boolean f40500e;

            /* renamed from: f */
            final AtomicBoolean f40501f = new AtomicBoolean();

            C13330a(C13329a<T, U> parent, long index, T value) {
                this.f40497b = parent;
                this.f40498c = index;
                this.f40499d = value;
            }

            public void onNext(U u) {
                if (!this.f40500e) {
                    this.f40500e = true;
                    dispose();
                    mo42385b();
                }
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: b */
            public void mo42385b() {
                if (this.f40501f.compareAndSet(false, true)) {
                    this.f40497b.mo42384a(this.f40498c, this.f40499d);
                }
            }

            public void onError(Throwable t) {
                if (this.f40500e) {
                    C13774a.m43836b(t);
                    return;
                }
                this.f40500e = true;
                this.f40497b.onError(t);
            }

            public void onComplete() {
                if (!this.f40500e) {
                    this.f40500e = true;
                    mo42385b();
                }
            }
        }

        C13329a(C13804t<? super T> actual, C13212n<? super T, ? extends C13802r<U>> debounceSelector) {
            this.f40491a = actual;
            this.f40492b = debounceSelector;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40493c, s)) {
                this.f40493c = s;
                this.f40491a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f40496f) {
                long idx = this.f40495e + 1;
                this.f40495e = idx;
                C13194b d = (C13194b) this.f40494d.get();
                if (d != null) {
                    d.dispose();
                }
                try {
                    Object apply = this.f40492b.apply(t);
                    C13264b.m43226a(apply, "The ObservableSource supplied is null");
                    ObservableSource<U> p = (C13802r) apply;
                    DebounceInnerObserver<T, U> dis = new C13330a<>(this, idx, t);
                    if (this.f40494d.compareAndSet(d, dis)) {
                        p.subscribe(dis);
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    dispose();
                    this.f40491a.onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            C13218c.m43150a(this.f40494d);
            this.f40491a.onError(t);
        }

        public void onComplete() {
            if (!this.f40496f) {
                this.f40496f = true;
                C13194b d = (C13194b) this.f40494d.get();
                if (d != C13218c.DISPOSED) {
                    ((C13330a) d).mo42385b();
                    C13218c.m43150a(this.f40494d);
                    this.f40491a.onComplete();
                }
            }
        }

        public void dispose() {
            this.f40493c.dispose();
            C13218c.m43150a(this.f40494d);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42384a(long idx, T value) {
            if (idx == this.f40495e) {
                this.f40491a.onNext(value);
            }
        }
    }

    public C13328D(C13802r<T> source, C13212n<? super T, ? extends C13802r<U>> debounceSelector) {
        super(source);
        this.f40490b = debounceSelector;
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13329a(new C13770f(t), this.f40490b));
    }
}
