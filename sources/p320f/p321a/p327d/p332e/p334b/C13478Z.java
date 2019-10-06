package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable.FlatMapCompletableMainObserver.InnerObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13192b;
import p320f.p321a.C13198c;
import p320f.p321a.C13215d;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13266a;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Z */
/* compiled from: ObservableFlatMapCompletableCompletable */
public final class C13478Z<T> extends C13192b implements C13266a<T> {

    /* renamed from: a */
    final C13802r<T> f40981a;

    /* renamed from: b */
    final C13212n<? super T, ? extends C13215d> f40982b;

    /* renamed from: c */
    final boolean f40983c;

    /* renamed from: f.a.d.e.b.Z$a */
    /* compiled from: ObservableFlatMapCompletableCompletable */
    static final class C13479a<T> extends AtomicInteger implements C13194b, C13804t<T> {

        /* renamed from: a */
        final C13198c f40984a;

        /* renamed from: b */
        final C13741c f40985b = new C13741c();

        /* renamed from: c */
        final C13212n<? super T, ? extends C13215d> f40986c;

        /* renamed from: d */
        final boolean f40987d;

        /* renamed from: e */
        final C13193a f40988e = new C13193a();

        /* renamed from: f */
        C13194b f40989f;

        /* renamed from: g */
        volatile boolean f40990g;

        /* renamed from: f.a.d.e.b.Z$a$a */
        /* compiled from: ObservableFlatMapCompletableCompletable */
        final class C13480a extends AtomicReference<C13194b> implements C13198c, C13194b {
            C13480a() {
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onComplete() {
                C13479a.this.mo42511a(this);
            }

            public void onError(Throwable e) {
                C13479a.this.mo42512a(this, e);
            }

            public void dispose() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13479a(C13198c observer, C13212n<? super T, ? extends C13215d> mapper, boolean delayErrors) {
            this.f40984a = observer;
            this.f40986c = mapper;
            this.f40987d = delayErrors;
            lazySet(1);
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f40989f, d)) {
                this.f40989f = d;
                this.f40984a.onSubscribe(this);
            }
        }

        public void onNext(T value) {
            try {
                Object apply = this.f40986c.apply(value);
                C13264b.m43226a(apply, "The mapper returned a null CompletableSource");
                C13215d cs = (C13215d) apply;
                getAndIncrement();
                InnerObserver inner = new C13480a<>();
                if (!this.f40990g && this.f40988e.mo42252b(inner)) {
                    cs.mo42246a(inner);
                }
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                this.f40989f.dispose();
                onError(ex);
            }
        }

        public void onError(Throwable e) {
            if (!this.f40985b.mo42733a(e)) {
                C13774a.m43836b(e);
            } else if (!this.f40987d) {
                dispose();
                if (getAndSet(0) > 0) {
                    this.f40984a.onError(this.f40985b.mo42732a());
                }
            } else if (decrementAndGet() == 0) {
                this.f40984a.onError(this.f40985b.mo42732a());
            }
        }

        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable ex = this.f40985b.mo42732a();
                if (ex != null) {
                    this.f40984a.onError(ex);
                } else {
                    this.f40984a.onComplete();
                }
            }
        }

        public void dispose() {
            this.f40990g = true;
            this.f40989f.dispose();
            this.f40988e.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42511a(C13480a inner) {
            this.f40988e.mo42253c(inner);
            onComplete();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42512a(C13480a inner, Throwable e) {
            this.f40988e.mo42253c(inner);
            onError(e);
        }
    }

    public C13478Z(C13802r<T> source, C13212n<? super T, ? extends C13215d> mapper, boolean delayErrors) {
        this.f40981a = source;
        this.f40982b = mapper;
        this.f40983c = delayErrors;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo42247b(C13198c observer) {
        this.f40981a.subscribe(new C13479a(observer, this.f40982b, this.f40983c));
    }

    /* renamed from: a */
    public C13797m<T> mo42316a() {
        return C13774a.m43821a((C13797m<T>) new C13472Y<T>(this.f40981a, this.f40982b, this.f40983c));
    }
}
