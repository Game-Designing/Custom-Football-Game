package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.ub */
/* compiled from: ObservableThrottleFirstTimed */
public final class C13647ub<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f41571b;

    /* renamed from: c */
    final TimeUnit f41572c;

    /* renamed from: d */
    final C13805u f41573d;

    /* renamed from: f.a.d.e.b.ub$a */
    /* compiled from: ObservableThrottleFirstTimed */
    static final class C13648a<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b, Runnable {

        /* renamed from: a */
        final C13804t<? super T> f41574a;

        /* renamed from: b */
        final long f41575b;

        /* renamed from: c */
        final TimeUnit f41576c;

        /* renamed from: d */
        final C13808c f41577d;

        /* renamed from: e */
        C13194b f41578e;

        /* renamed from: f */
        volatile boolean f41579f;

        /* renamed from: g */
        boolean f41580g;

        C13648a(C13804t<? super T> actual, long timeout, TimeUnit unit, C13808c worker) {
            this.f41574a = actual;
            this.f41575b = timeout;
            this.f41576c = unit;
            this.f41577d = worker;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41578e, s)) {
                this.f41578e = s;
                this.f41574a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41579f && !this.f41580g) {
                this.f41579f = true;
                this.f41574a.onNext(t);
                C13194b d = (C13194b) get();
                if (d != null) {
                    d.dispose();
                }
                C13218c.m43151a((AtomicReference<C13194b>) this, this.f41577d.mo42243a(this, this.f41575b, this.f41576c));
            }
        }

        public void run() {
            this.f41579f = false;
        }

        public void onError(Throwable t) {
            if (this.f41580g) {
                C13774a.m43836b(t);
                return;
            }
            this.f41580g = true;
            this.f41574a.onError(t);
            this.f41577d.dispose();
        }

        public void onComplete() {
            if (!this.f41580g) {
                this.f41580g = true;
                this.f41574a.onComplete();
                this.f41577d.dispose();
            }
        }

        public void dispose() {
            this.f41578e.dispose();
            this.f41577d.dispose();
        }
    }

    public C13647ub(C13802r<T> source, long timeout, TimeUnit unit, C13805u scheduler) {
        super(source);
        this.f41571b = timeout;
        this.f41572c = unit;
        this.f41573d = scheduler;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13802r<T> rVar = this.f41005a;
        C13648a aVar = new C13648a(new C13770f(t), this.f41571b, this.f41572c, this.f41573d.mo42242a());
        rVar.subscribe(aVar);
    }
}
