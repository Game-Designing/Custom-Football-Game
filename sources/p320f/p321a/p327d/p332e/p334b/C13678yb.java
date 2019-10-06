package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;

/* renamed from: f.a.d.e.b.yb */
/* compiled from: ObservableTimer */
public final class C13678yb extends C13797m<Long> {

    /* renamed from: a */
    final C13805u f41690a;

    /* renamed from: b */
    final long f41691b;

    /* renamed from: c */
    final TimeUnit f41692c;

    /* renamed from: f.a.d.e.b.yb$a */
    /* compiled from: ObservableTimer */
    static final class C13679a extends AtomicReference<C13194b> implements C13194b, Runnable {

        /* renamed from: a */
        final C13804t<? super Long> f41693a;

        C13679a(C13804t<? super Long> actual) {
            this.f41693a = actual;
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        /* renamed from: a */
        public boolean mo42660a() {
            return get() == C13218c.DISPOSED;
        }

        public void run() {
            if (!mo42660a()) {
                this.f41693a.onNext(Long.valueOf(0));
                lazySet(C13219d.INSTANCE);
                this.f41693a.onComplete();
            }
        }

        /* renamed from: a */
        public void mo42659a(C13194b d) {
            C13218c.m43154d(this, d);
        }
    }

    public C13678yb(long delay, TimeUnit unit, C13805u scheduler) {
        this.f41691b = delay;
        this.f41692c = unit;
        this.f41690a = scheduler;
    }

    public void subscribeActual(C13804t<? super Long> s) {
        C13679a ios = new C13679a(s);
        s.onSubscribe(ios);
        ios.mo42659a(this.f41690a.mo42241a(ios, this.f41691b, this.f41692c));
    }
}
