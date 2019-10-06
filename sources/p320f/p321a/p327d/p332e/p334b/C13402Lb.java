package p320f.p321a.p327d.p332e.p334b;

import java.util.Iterator;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Lb */
/* compiled from: ObservableZipIterable */
public final class C13402Lb<T, U, V> extends C13797m<V> {

    /* renamed from: a */
    final C13797m<? extends T> f40757a;

    /* renamed from: b */
    final Iterable<U> f40758b;

    /* renamed from: c */
    final C13201c<? super T, ? super U, ? extends V> f40759c;

    /* renamed from: f.a.d.e.b.Lb$a */
    /* compiled from: ObservableZipIterable */
    static final class C13403a<T, U, V> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super V> f40760a;

        /* renamed from: b */
        final Iterator<U> f40761b;

        /* renamed from: c */
        final C13201c<? super T, ? super U, ? extends V> f40762c;

        /* renamed from: d */
        C13194b f40763d;

        /* renamed from: e */
        boolean f40764e;

        C13403a(C13804t<? super V> actual, Iterator<U> iterator, C13201c<? super T, ? super U, ? extends V> zipper) {
            this.f40760a = actual;
            this.f40761b = iterator;
            this.f40762c = zipper;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40763d, s)) {
                this.f40763d = s;
                this.f40760a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40763d.dispose();
        }

        public void onNext(T t) {
            if (!this.f40764e) {
                try {
                    U u = this.f40761b.next();
                    C13264b.m43226a(u, "The iterator returned a null value");
                    try {
                        V v = this.f40762c.apply(t, u);
                        C13264b.m43226a(v, "The zipper function returned a null value");
                        this.f40760a.onNext(v);
                        try {
                            if (!this.f40761b.hasNext()) {
                                this.f40764e = true;
                                this.f40763d.dispose();
                                this.f40760a.onComplete();
                            }
                        } catch (Throwable e) {
                            C13980a.m44462b(e);
                            mo42444a(e);
                        }
                    } catch (Throwable e2) {
                        C13980a.m44462b(e2);
                        mo42444a(e2);
                    }
                } catch (Throwable e3) {
                    C13980a.m44462b(e3);
                    mo42444a(e3);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42444a(Throwable e) {
            this.f40764e = true;
            this.f40763d.dispose();
            this.f40760a.onError(e);
        }

        public void onError(Throwable t) {
            if (this.f40764e) {
                C13774a.m43836b(t);
                return;
            }
            this.f40764e = true;
            this.f40760a.onError(t);
        }

        public void onComplete() {
            if (!this.f40764e) {
                this.f40764e = true;
                this.f40760a.onComplete();
            }
        }
    }

    public C13402Lb(C13797m<? extends T> source, Iterable<U> other, C13201c<? super T, ? super U, ? extends V> zipper) {
        this.f40757a = source;
        this.f40758b = other;
        this.f40759c = zipper;
    }

    public void subscribeActual(C13804t<? super V> t) {
        try {
            Iterator<U> it = this.f40758b.iterator();
            C13264b.m43226a(it, "The iterator returned by other is null");
            Iterator<U> it2 = it;
            try {
                if (!it2.hasNext()) {
                    C13219d.m43156a(t);
                } else {
                    this.f40757a.subscribe((C13804t<? super T>) new C13403a<Object>(t, it2, this.f40759c));
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                C13219d.m43157a(e, t);
            }
        } catch (Throwable e2) {
            C13980a.m44462b(e2);
            C13219d.m43157a(e2, t);
        }
    }
}
