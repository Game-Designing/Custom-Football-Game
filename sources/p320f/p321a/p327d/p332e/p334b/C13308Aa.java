package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable.MergeWithObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13198c;
import p320f.p321a.C13215d;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p327d.p340j.C13750k;

/* renamed from: f.a.d.e.b.Aa */
/* compiled from: ObservableMergeWithCompletable */
public final class C13308Aa<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13215d f40435b;

    /* renamed from: f.a.d.e.b.Aa$a */
    /* compiled from: ObservableMergeWithCompletable */
    static final class C13309a<T> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40436a;

        /* renamed from: b */
        final AtomicReference<C13194b> f40437b = new AtomicReference<>();

        /* renamed from: c */
        final C13310a f40438c = new C13310a(this);

        /* renamed from: d */
        final C13741c f40439d = new C13741c();

        /* renamed from: e */
        volatile boolean f40440e;

        /* renamed from: f */
        volatile boolean f40441f;

        /* renamed from: f.a.d.e.b.Aa$a$a */
        /* compiled from: ObservableMergeWithCompletable */
        static final class C13310a extends AtomicReference<C13194b> implements C13198c {

            /* renamed from: a */
            final C13309a<?> f40442a;

            C13310a(C13309a<?> parent) {
                this.f40442a = parent;
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onError(Throwable e) {
                this.f40442a.mo42364a(e);
            }

            public void onComplete() {
                this.f40442a.mo42363a();
            }
        }

        C13309a(C13804t<? super T> actual) {
            this.f40436a = actual;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this.f40437b, d);
        }

        public void onNext(T t) {
            C13750k.m43764a(this.f40436a, t, (AtomicInteger) this, this.f40439d);
        }

        public void onError(Throwable ex) {
            C13218c.m43150a(this.f40437b);
            C13750k.m43765a(this.f40436a, ex, (AtomicInteger) this, this.f40439d);
        }

        public void onComplete() {
            this.f40440e = true;
            if (this.f40441f) {
                C13750k.m43766a(this.f40436a, (AtomicInteger) this, this.f40439d);
            }
        }

        public void dispose() {
            C13218c.m43150a(this.f40437b);
            C13218c.m43150a((AtomicReference<C13194b>) this.f40438c);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42364a(Throwable ex) {
            C13218c.m43150a(this.f40437b);
            C13750k.m43765a(this.f40436a, ex, (AtomicInteger) this, this.f40439d);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42363a() {
            this.f40441f = true;
            if (this.f40440e) {
                C13750k.m43766a(this.f40436a, (AtomicInteger) this, this.f40439d);
            }
        }
    }

    public C13308Aa(C13797m<T> source, C13215d other) {
        super(source);
        this.f40435b = other;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        MergeWithObserver<T> parent = new C13309a<>(observer);
        observer.onSubscribe(parent);
        this.f41005a.subscribe(parent);
        this.f40435b.mo42246a(parent.f40438c);
    }
}
