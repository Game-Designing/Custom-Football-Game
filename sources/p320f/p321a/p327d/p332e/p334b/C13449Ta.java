package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.atomic.AtomicInteger;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13202d;
import p320f.p321a.p327d.p328a.C13225j;

/* renamed from: f.a.d.e.b.Ta */
/* compiled from: ObservableRetryBiPredicate */
public final class C13449Ta<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13202d<? super Integer, ? super Throwable> f40893b;

    /* renamed from: f.a.d.e.b.Ta$a */
    /* compiled from: ObservableRetryBiPredicate */
    static final class C13450a<T> extends AtomicInteger implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f40894a;

        /* renamed from: b */
        final C13225j f40895b;

        /* renamed from: c */
        final C13802r<? extends T> f40896c;

        /* renamed from: d */
        final C13202d<? super Integer, ? super Throwable> f40897d;

        /* renamed from: e */
        int f40898e;

        C13450a(C13804t<? super T> actual, C13202d<? super Integer, ? super Throwable> predicate, C13225j sa, C13802r<? extends T> source) {
            this.f40894a = actual;
            this.f40895b = sa;
            this.f40896c = source;
            this.f40897d = predicate;
        }

        public void onSubscribe(C13194b s) {
            this.f40895b.mo42288b(s);
        }

        public void onNext(T t) {
            this.f40894a.onNext(t);
        }

        public void onError(Throwable t) {
            try {
                C13202d<? super Integer, ? super Throwable> dVar = this.f40897d;
                int i = this.f40898e + 1;
                this.f40898e = i;
                if (!dVar.test(Integer.valueOf(i), t)) {
                    this.f40894a.onError(t);
                } else {
                    mo42479a();
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                this.f40894a.onError(new CompositeException(t, e));
            }
        }

        public void onComplete() {
            this.f40894a.onComplete();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42479a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                while (!this.f40895b.mo42286a()) {
                    this.f40896c.subscribe(this);
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                    }
                }
            }
        }
    }

    public C13449Ta(C13797m<T> source, C13202d<? super Integer, ? super Throwable> predicate) {
        super(source);
        this.f40893b = predicate;
    }

    public void subscribeActual(C13804t<? super T> s) {
        C13225j sa = new C13225j();
        s.onSubscribe(sa);
        new C13450a<>(s, this.f40893b, sa, this.f41005a).mo42479a();
    }
}
