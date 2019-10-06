package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.Callable;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b._a */
/* compiled from: ObservableScanSeed */
public final class C13483_a<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13201c<R, ? super T, R> f40998b;

    /* renamed from: c */
    final Callable<R> f40999c;

    /* renamed from: f.a.d.e.b._a$a */
    /* compiled from: ObservableScanSeed */
    static final class C13484a<T, R> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f41000a;

        /* renamed from: b */
        final C13201c<R, ? super T, R> f41001b;

        /* renamed from: c */
        R f41002c;

        /* renamed from: d */
        C13194b f41003d;

        /* renamed from: e */
        boolean f41004e;

        C13484a(C13804t<? super R> actual, C13201c<R, ? super T, R> accumulator, R value) {
            this.f41000a = actual;
            this.f41001b = accumulator;
            this.f41002c = value;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41003d, s)) {
                this.f41003d = s;
                this.f41000a.onSubscribe(this);
                this.f41000a.onNext(this.f41002c);
            }
        }

        public void dispose() {
            this.f41003d.dispose();
        }

        public void onNext(T t) {
            if (!this.f41004e) {
                try {
                    R u = this.f41001b.apply(this.f41002c, t);
                    C13264b.m43226a(u, "The accumulator returned a null value");
                    this.f41002c = u;
                    this.f41000a.onNext(u);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41003d.dispose();
                    onError(e);
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41004e) {
                C13774a.m43836b(t);
                return;
            }
            this.f41004e = true;
            this.f41000a.onError(t);
        }

        public void onComplete() {
            if (!this.f41004e) {
                this.f41004e = true;
                this.f41000a.onComplete();
            }
        }
    }

    public C13483_a(C13802r<T> source, Callable<R> seedSupplier, C13201c<R, ? super T, R> accumulator) {
        super(source);
        this.f40998b = accumulator;
        this.f40999c = seedSupplier;
    }

    public void subscribeActual(C13804t<? super R> t) {
        try {
            R r = this.f40999c.call();
            C13264b.m43226a(r, "The seed supplied is null");
            this.f41005a.subscribe(new C13484a(t, this.f40998b, r));
        } catch (Throwable e) {
            C13980a.m44462b(e);
            C13219d.m43157a(e, t);
        }
    }
}
