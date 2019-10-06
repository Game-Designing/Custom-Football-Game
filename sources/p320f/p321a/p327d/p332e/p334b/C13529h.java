package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.operators.observable.ObservableAmb.AmbInnerObserver;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.h */
/* compiled from: ObservableAmb */
public final class C13529h<T> extends C13797m<T> {

    /* renamed from: a */
    final C13802r<? extends T>[] f41144a;

    /* renamed from: b */
    final Iterable<? extends C13802r<? extends T>> f41145b;

    /* renamed from: f.a.d.e.b.h$a */
    /* compiled from: ObservableAmb */
    static final class C13530a<T> implements C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41146a;

        /* renamed from: b */
        final C13531b<T>[] f41147b;

        /* renamed from: c */
        final AtomicInteger f41148c = new AtomicInteger();

        C13530a(C13804t<? super T> actual, int count) {
            this.f41146a = actual;
            this.f41147b = new C13531b[count];
        }

        /* renamed from: a */
        public void mo42561a(C13802r<? extends T>[] sources) {
            AmbInnerObserver<T>[] as = this.f41147b;
            int len = as.length;
            for (int i = 0; i < len; i++) {
                as[i] = new C13531b<>(this, i + 1, this.f41146a);
            }
            this.f41148c.lazySet(0);
            this.f41146a.onSubscribe(this);
            for (int i2 = 0; i2 < len && this.f41148c.get() == 0; i2++) {
                sources[i2].subscribe(as[i2]);
            }
        }

        /* renamed from: a */
        public boolean mo42562a(int index) {
            int w = this.f41148c.get();
            boolean z = false;
            if (w != 0) {
                if (w == index) {
                    z = true;
                }
                return z;
            } else if (!this.f41148c.compareAndSet(0, index)) {
                return false;
            } else {
                AmbInnerObserver<T>[] a = this.f41147b;
                int n = a.length;
                for (int i = 0; i < n; i++) {
                    if (i + 1 != index) {
                        a[i].mo42563a();
                    }
                }
                return true;
            }
        }

        public void dispose() {
            if (this.f41148c.get() != -1) {
                this.f41148c.lazySet(-1);
                for (AmbInnerObserver<T> a : this.f41147b) {
                    a.mo42563a();
                }
            }
        }
    }

    /* renamed from: f.a.d.e.b.h$b */
    /* compiled from: ObservableAmb */
    static final class C13531b<T> extends AtomicReference<C13194b> implements C13804t<T> {

        /* renamed from: a */
        final C13530a<T> f41149a;

        /* renamed from: b */
        final int f41150b;

        /* renamed from: c */
        final C13804t<? super T> f41151c;

        /* renamed from: d */
        boolean f41152d;

        C13531b(C13530a<T> parent, int index, C13804t<? super T> actual) {
            this.f41149a = parent;
            this.f41150b = index;
            this.f41151c = actual;
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onNext(T t) {
            if (this.f41152d) {
                this.f41151c.onNext(t);
            } else if (this.f41149a.mo42562a(this.f41150b)) {
                this.f41152d = true;
                this.f41151c.onNext(t);
            } else {
                ((C13194b) get()).dispose();
            }
        }

        public void onError(Throwable t) {
            if (this.f41152d) {
                this.f41151c.onError(t);
            } else if (this.f41149a.mo42562a(this.f41150b)) {
                this.f41152d = true;
                this.f41151c.onError(t);
            } else {
                C13774a.m43836b(t);
            }
        }

        public void onComplete() {
            if (this.f41152d) {
                this.f41151c.onComplete();
            } else if (this.f41149a.mo42562a(this.f41150b)) {
                this.f41152d = true;
                this.f41151c.onComplete();
            }
        }

        /* renamed from: a */
        public void mo42563a() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13529h(C13802r<? extends T>[] sources, Iterable<? extends C13802r<? extends T>> sourcesIterable) {
        this.f41144a = sources;
        this.f41145b = sourcesIterable;
    }

    public void subscribeActual(C13804t<? super T> s) {
        C13802r<? extends T>[] rVarArr = this.f41144a;
        int count = 0;
        if (rVarArr == null) {
            rVarArr = new C13797m[8];
            try {
                Iterator it = this.f41145b.iterator();
                while (it.hasNext()) {
                    ObservableSource<? extends T> p = (C13802r) it.next();
                    if (p == null) {
                        C13219d.m43157a((Throwable) new NullPointerException("One of the sources is null"), s);
                        return;
                    }
                    if (count == rVarArr.length) {
                        C13802r<? extends T>[] rVarArr2 = new C13802r[((count >> 2) + count)];
                        System.arraycopy(rVarArr, 0, rVarArr2, 0, count);
                        rVarArr = rVarArr2;
                    }
                    int count2 = count + 1;
                    try {
                        rVarArr[count] = p;
                        count = count2;
                    } catch (Throwable th) {
                        e = th;
                        int i = count2;
                        C13980a.m44462b(e);
                        C13219d.m43157a(e, s);
                        return;
                    }
                }
            } catch (Throwable th2) {
                e = th2;
                C13980a.m44462b(e);
                C13219d.m43157a(e, s);
                return;
            }
        } else {
            count = rVarArr.length;
        }
        if (count == 0) {
            C13219d.m43156a(s);
        } else if (count == 1) {
            rVarArr[0].subscribe(s);
        } else {
            new C13530a<>(s, count).mo42561a(rVarArr);
        }
    }
}
