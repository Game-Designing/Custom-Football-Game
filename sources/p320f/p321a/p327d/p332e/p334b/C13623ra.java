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

/* renamed from: f.a.d.e.b.ra */
/* compiled from: ObservableIntervalRange */
public final class C13623ra extends C13797m<Long> {

    /* renamed from: a */
    final C13805u f41464a;

    /* renamed from: b */
    final long f41465b;

    /* renamed from: c */
    final long f41466c;

    /* renamed from: d */
    final long f41467d;

    /* renamed from: e */
    final long f41468e;

    /* renamed from: f */
    final TimeUnit f41469f;

    /* renamed from: f.a.d.e.b.ra$a */
    /* compiled from: ObservableIntervalRange */
    static final class C13624a extends AtomicReference<C13194b> implements C13194b, Runnable {

        /* renamed from: a */
        final C13804t<? super Long> f41470a;

        /* renamed from: b */
        final long f41471b;

        /* renamed from: c */
        long f41472c;

        C13624a(C13804t<? super Long> actual, long start, long end) {
            this.f41470a = actual;
            this.f41472c = start;
            this.f41471b = end;
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        /* renamed from: a */
        public boolean mo42628a() {
            return get() == C13218c.DISPOSED;
        }

        public void run() {
            if (!mo42628a()) {
                long c = this.f41472c;
                this.f41470a.onNext(Long.valueOf(c));
                if (c == this.f41471b) {
                    C13218c.m43150a((AtomicReference<C13194b>) this);
                    this.f41470a.onComplete();
                    return;
                }
                this.f41472c = 1 + c;
            }
        }

        /* renamed from: a */
        public void mo42627a(C13194b d) {
            C13218c.m43153c(this, d);
        }
    }

    public C13623ra(long start, long end, long initialDelay, long period, TimeUnit unit, C13805u scheduler) {
        this.f41467d = initialDelay;
        this.f41468e = period;
        this.f41469f = unit;
        this.f41464a = scheduler;
        this.f41465b = start;
        this.f41466c = end;
    }

    public void subscribeActual(C13804t<? super Long> s) {
        C13624a is = new C13624a(s, this.f41465b, this.f41466c);
        s.onSubscribe(is);
        C13805u sch = this.f41464a;
        if (sch instanceof C13730o) {
            C13808c worker = sch.mo42242a();
            is.mo42627a(worker);
            worker.mo43151a(is, this.f41467d, this.f41468e, this.f41469f);
            return;
        }
        is.mo42627a(sch.mo42692a(is, this.f41467d, this.f41468e, this.f41469f));
    }
}
