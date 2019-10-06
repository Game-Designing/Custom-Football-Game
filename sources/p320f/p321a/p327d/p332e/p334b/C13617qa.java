package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p337g.C13730o;

/* renamed from: f.a.d.e.b.qa */
/* compiled from: ObservableInterval */
public final class C13617qa extends C13797m<Long> {

    /* renamed from: a */
    final C13805u f41435a;

    /* renamed from: b */
    final long f41436b;

    /* renamed from: c */
    final long f41437c;

    /* renamed from: d */
    final TimeUnit f41438d;

    /* renamed from: f.a.d.e.b.qa$a */
    /* compiled from: ObservableInterval */
    static final class C13618a extends AtomicReference<C13194b> implements C13194b, Runnable {

        /* renamed from: a */
        final C13804t<? super Long> f41439a;

        /* renamed from: b */
        long f41440b;

        C13618a(C13804t<? super Long> actual) {
            this.f41439a = actual;
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        public void run() {
            if (get() != C13218c.DISPOSED) {
                C13804t<? super Long> tVar = this.f41439a;
                long j = this.f41440b;
                this.f41440b = 1 + j;
                tVar.onNext(Long.valueOf(j));
            }
        }

        /* renamed from: a */
        public void mo42624a(C13194b d) {
            C13218c.m43153c(this, d);
        }
    }

    public C13617qa(long initialDelay, long period, TimeUnit unit, C13805u scheduler) {
        this.f41436b = initialDelay;
        this.f41437c = period;
        this.f41438d = unit;
        this.f41435a = scheduler;
    }

    public void subscribeActual(C13804t<? super Long> s) {
        C13618a is = new C13618a(s);
        s.onSubscribe(is);
        C13805u sch = this.f41435a;
        if (sch instanceof C13730o) {
            C13808c worker = sch.mo42242a();
            is.mo42624a(worker);
            worker.mo43151a(is, this.f41436b, this.f41437c, this.f41438d);
            return;
        }
        is.mo42624a(sch.mo42692a(is, this.f41436b, this.f41437c, this.f41438d));
    }
}
