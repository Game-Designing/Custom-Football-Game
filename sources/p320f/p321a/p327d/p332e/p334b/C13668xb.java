package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13224i;
import p320f.p321a.p327d.p331d.C13286l;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.xb */
/* compiled from: ObservableTimeoutTimed */
public final class C13668xb<T> extends C13485a<T, T> {

    /* renamed from: b */
    static final C13194b f41653b = new C13669a();

    /* renamed from: c */
    final long f41654c;

    /* renamed from: d */
    final TimeUnit f41655d;

    /* renamed from: e */
    final C13805u f41656e;

    /* renamed from: f */
    final C13802r<? extends T> f41657f;

    /* renamed from: f.a.d.e.b.xb$a */
    /* compiled from: ObservableTimeoutTimed */
    static final class C13669a implements C13194b {
        C13669a() {
        }

        public void dispose() {
        }
    }

    /* renamed from: f.a.d.e.b.xb$b */
    /* compiled from: ObservableTimeoutTimed */
    static final class C13670b<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41658a;

        /* renamed from: b */
        final long f41659b;

        /* renamed from: c */
        final TimeUnit f41660c;

        /* renamed from: d */
        final C13808c f41661d;

        /* renamed from: e */
        C13194b f41662e;

        /* renamed from: f */
        volatile long f41663f;

        /* renamed from: g */
        volatile boolean f41664g;

        /* renamed from: f.a.d.e.b.xb$b$a */
        /* compiled from: ObservableTimeoutTimed */
        final class C13671a implements Runnable {

            /* renamed from: a */
            private final long f41665a;

            C13671a(long idx) {
                this.f41665a = idx;
            }

            public void run() {
                if (this.f41665a == C13670b.this.f41663f) {
                    C13670b bVar = C13670b.this;
                    bVar.f41664g = true;
                    bVar.f41662e.dispose();
                    C13218c.m43150a((AtomicReference<C13194b>) C13670b.this);
                    C13670b.this.f41658a.onError(new TimeoutException());
                    C13670b.this.f41661d.dispose();
                }
            }
        }

        C13670b(C13804t<? super T> actual, long timeout, TimeUnit unit, C13808c worker) {
            this.f41658a = actual;
            this.f41659b = timeout;
            this.f41660c = unit;
            this.f41661d = worker;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41662e, s)) {
                this.f41662e = s;
                this.f41658a.onSubscribe(this);
                mo42654a(0);
            }
        }

        public void onNext(T t) {
            if (!this.f41664g) {
                long idx = this.f41663f + 1;
                this.f41663f = idx;
                this.f41658a.onNext(t);
                mo42654a(idx);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42654a(long idx) {
            C13194b d = (C13194b) get();
            if (d != null) {
                d.dispose();
            }
            if (compareAndSet(d, C13668xb.f41653b)) {
                C13218c.m43151a((AtomicReference<C13194b>) this, this.f41661d.mo42243a(new C13671a(idx), this.f41659b, this.f41660c));
            }
        }

        public void onError(Throwable t) {
            if (this.f41664g) {
                C13774a.m43836b(t);
                return;
            }
            this.f41664g = true;
            this.f41658a.onError(t);
            dispose();
        }

        public void onComplete() {
            if (!this.f41664g) {
                this.f41664g = true;
                this.f41658a.onComplete();
                dispose();
            }
        }

        public void dispose() {
            this.f41662e.dispose();
            this.f41661d.dispose();
        }
    }

    /* renamed from: f.a.d.e.b.xb$c */
    /* compiled from: ObservableTimeoutTimed */
    static final class C13672c<T> extends AtomicReference<C13194b> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f41667a;

        /* renamed from: b */
        final long f41668b;

        /* renamed from: c */
        final TimeUnit f41669c;

        /* renamed from: d */
        final C13808c f41670d;

        /* renamed from: e */
        final C13802r<? extends T> f41671e;

        /* renamed from: f */
        C13194b f41672f;

        /* renamed from: g */
        final C13224i<T> f41673g;

        /* renamed from: h */
        volatile long f41674h;

        /* renamed from: i */
        volatile boolean f41675i;

        /* renamed from: f.a.d.e.b.xb$c$a */
        /* compiled from: ObservableTimeoutTimed */
        final class C13673a implements Runnable {

            /* renamed from: a */
            private final long f41676a;

            C13673a(long idx) {
                this.f41676a = idx;
            }

            public void run() {
                if (this.f41676a == C13672c.this.f41674h) {
                    C13672c cVar = C13672c.this;
                    cVar.f41675i = true;
                    cVar.f41672f.dispose();
                    C13218c.m43150a((AtomicReference<C13194b>) C13672c.this);
                    C13672c.this.mo42656a();
                    C13672c.this.f41670d.dispose();
                }
            }
        }

        C13672c(C13804t<? super T> actual, long timeout, TimeUnit unit, C13808c worker, C13802r<? extends T> other) {
            this.f41667a = actual;
            this.f41668b = timeout;
            this.f41669c = unit;
            this.f41670d = worker;
            this.f41671e = other;
            this.f41673g = new C13224i<>(actual, this, 8);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41672f, s)) {
                this.f41672f = s;
                if (this.f41673g.mo42285b(s)) {
                    this.f41667a.onSubscribe(this.f41673g);
                    mo42657a(0);
                }
            }
        }

        public void onNext(T t) {
            if (!this.f41675i) {
                long idx = this.f41674h + 1;
                this.f41674h = idx;
                if (this.f41673g.mo42283a(t, this.f41672f)) {
                    mo42657a(idx);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42657a(long idx) {
            C13194b d = (C13194b) get();
            if (d != null) {
                d.dispose();
            }
            if (compareAndSet(d, C13668xb.f41653b)) {
                C13218c.m43151a((AtomicReference<C13194b>) this, this.f41670d.mo42243a(new C13673a(idx), this.f41668b, this.f41669c));
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42656a() {
            this.f41671e.subscribe(new C13286l(this.f41673g));
        }

        public void onError(Throwable t) {
            if (this.f41675i) {
                C13774a.m43836b(t);
                return;
            }
            this.f41675i = true;
            this.f41673g.mo42282a(t, this.f41672f);
            this.f41670d.dispose();
        }

        public void onComplete() {
            if (!this.f41675i) {
                this.f41675i = true;
                this.f41673g.mo42281a(this.f41672f);
                this.f41670d.dispose();
            }
        }

        public void dispose() {
            this.f41672f.dispose();
            this.f41670d.dispose();
        }
    }

    public C13668xb(C13802r<T> source, long timeout, TimeUnit unit, C13805u scheduler, C13802r<? extends T> other) {
        super(source);
        this.f41654c = timeout;
        this.f41655d = unit;
        this.f41656e = scheduler;
        this.f41657f = other;
    }

    public void subscribeActual(C13804t<? super T> t) {
        if (this.f41657f == null) {
            C13802r<T> rVar = this.f41005a;
            C13670b bVar = new C13670b(new C13770f(t), this.f41654c, this.f41655d, this.f41656e.mo42242a());
            rVar.subscribe(bVar);
            return;
        }
        C13802r<T> rVar2 = this.f41005a;
        C13672c cVar = new C13672c(t, this.f41654c, this.f41655d, this.f41656e.mo42242a(), this.f41657f);
        rVar2.subscribe(cVar);
    }
}
