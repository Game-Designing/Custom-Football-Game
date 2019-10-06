package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Za */
/* compiled from: ObservableScan */
public final class C13481Za<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13201c<T, T, T> f40992b;

    /* renamed from: f.a.d.e.b.Za$a */
    /* compiled from: ObservableScan */
    static final class C13482a<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40993a;

        /* renamed from: b */
        final C13201c<T, T, T> f40994b;

        /* renamed from: c */
        C13194b f40995c;

        /* renamed from: d */
        T f40996d;

        /* renamed from: e */
        boolean f40997e;

        C13482a(C13804t<? super T> actual, C13201c<T, T, T> accumulator) {
            this.f40993a = actual;
            this.f40994b = accumulator;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40995c, s)) {
                this.f40995c = s;
                this.f40993a.onSubscribe(this);
            }
        }

        public void dispose() {
            this.f40995c.dispose();
        }

        public void onNext(T t) {
            if (!this.f40997e) {
                Observer<? super T> a = this.f40993a;
                T v = this.f40996d;
                if (v == null) {
                    this.f40996d = t;
                    a.onNext(t);
                } else {
                    try {
                        T u = this.f40994b.apply(v, t);
                        C13264b.m43226a(u, "The value returned by the accumulator is null");
                        this.f40996d = u;
                        a.onNext(u);
                    } catch (Throwable e) {
                        C13980a.m44462b(e);
                        this.f40995c.dispose();
                        onError(e);
                    }
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f40997e) {
                C13774a.m43836b(t);
                return;
            }
            this.f40997e = true;
            this.f40993a.onError(t);
        }

        public void onComplete() {
            if (!this.f40997e) {
                this.f40997e = true;
                this.f40993a.onComplete();
            }
        }
    }

    public C13481Za(C13802r<T> source, C13201c<T, T, T> accumulator) {
        super(source);
        this.f40992b = accumulator;
    }

    public void subscribeActual(C13804t<? super T> t) {
        this.f41005a.subscribe(new C13482a(t, this.f40992b));
    }
}
