package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.atomic.AtomicInteger;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p327d.p328a.C13225j;

/* renamed from: f.a.d.e.b.Ua */
/* compiled from: ObservableRetryPredicate */
public final class C13452Ua<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13214p<? super Throwable> f40900b;

    /* renamed from: c */
    final long f40901c;

    /* renamed from: f.a.d.e.b.Ua$a */
    /* compiled from: ObservableRetryPredicate */
    static final class C13453a<T> extends AtomicInteger implements C13804t<T> {

        /* renamed from: a */
        final C13804t<? super T> f40902a;

        /* renamed from: b */
        final C13225j f40903b;

        /* renamed from: c */
        final C13802r<? extends T> f40904c;

        /* renamed from: d */
        final C13214p<? super Throwable> f40905d;

        /* renamed from: e */
        long f40906e;

        C13453a(C13804t<? super T> actual, long count, C13214p<? super Throwable> predicate, C13225j sa, C13802r<? extends T> source) {
            this.f40902a = actual;
            this.f40903b = sa;
            this.f40904c = source;
            this.f40905d = predicate;
            this.f40906e = count;
        }

        public void onSubscribe(C13194b s) {
            this.f40903b.mo42288b(s);
        }

        public void onNext(T t) {
            this.f40902a.onNext(t);
        }

        public void onError(Throwable t) {
            long r = this.f40906e;
            if (r != Long.MAX_VALUE) {
                this.f40906e = r - 1;
            }
            if (r == 0) {
                this.f40902a.onError(t);
            } else {
                try {
                    if (!this.f40905d.test(t)) {
                        this.f40902a.onError(t);
                        return;
                    }
                    mo42480a();
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f40902a.onError(new CompositeException(t, e));
                }
            }
        }

        public void onComplete() {
            this.f40902a.onComplete();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42480a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                while (!this.f40903b.mo42286a()) {
                    this.f40904c.subscribe(this);
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                    }
                }
            }
        }
    }

    public C13452Ua(C13797m<T> source, long count, C13214p<? super Throwable> predicate) {
        super(source);
        this.f40900b = predicate;
        this.f40901c = count;
    }

    public void subscribeActual(C13804t<? super T> s) {
        C13225j sa = new C13225j();
        s.onSubscribe(sa);
        C13453a aVar = new C13453a(s, this.f40901c, this.f40900b, sa, this.f41005a);
        aVar.mo42480a();
    }
}
