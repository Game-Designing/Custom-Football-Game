package p320f.p321a.p327d.p332e.p334b;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.Wa */
/* compiled from: ObservableSampleTimed */
public final class C13460Wa<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f40920b;

    /* renamed from: c */
    final TimeUnit f40921c;

    /* renamed from: d */
    final C13805u f40922d;

    /* renamed from: e */
    final boolean f40923e;

    /* renamed from: f.a.d.e.b.Wa$a */
    /* compiled from: ObservableSampleTimed */
    static final class C13461a<T> extends C13463c<T> {

        /* renamed from: g */
        final AtomicInteger f40924g = new AtomicInteger(1);

        C13461a(C13804t<? super T> actual, long period, TimeUnit unit, C13805u scheduler) {
            super(actual, period, unit, scheduler);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42486b() {
            mo42490c();
            if (this.f40924g.decrementAndGet() == 0) {
                this.f40925a.onComplete();
            }
        }

        public void run() {
            if (this.f40924g.incrementAndGet() == 2) {
                mo42490c();
                if (this.f40924g.decrementAndGet() == 0) {
                    this.f40925a.onComplete();
                }
            }
        }
    }

    /* renamed from: f.a.d.e.b.Wa$b */
    /* compiled from: ObservableSampleTimed */
    static final class C13462b<T> extends C13463c<T> {
        C13462b(C13804t<? super T> actual, long period, TimeUnit unit, C13805u scheduler) {
            super(actual, period, unit, scheduler);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42486b() {
            this.f40925a.onComplete();
        }

        public void run() {
            mo42490c();
        }
    }

    /* renamed from: f.a.d.e.b.Wa$c */
    /* compiled from: ObservableSampleTimed */
    static abstract class C13463c<T> extends AtomicReference<T> implements C13804t<T>, C13194b, Runnable {

        /* renamed from: a */
        final C13804t<? super T> f40925a;

        /* renamed from: b */
        final long f40926b;

        /* renamed from: c */
        final TimeUnit f40927c;

        /* renamed from: d */
        final C13805u f40928d;

        /* renamed from: e */
        final AtomicReference<C13194b> f40929e = new AtomicReference<>();

        /* renamed from: f */
        C13194b f40930f;

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public abstract void mo42486b();

        C13463c(C13804t<? super T> actual, long period, TimeUnit unit, C13805u scheduler) {
            this.f40925a = actual;
            this.f40926b = period;
            this.f40927c = unit;
            this.f40928d = scheduler;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40930f, s)) {
                this.f40930f = s;
                this.f40925a.onSubscribe(this);
                C13805u uVar = this.f40928d;
                long j = this.f40926b;
                C13218c.m43151a(this.f40929e, uVar.mo42692a(this, j, j, this.f40927c));
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable t) {
            mo42489a();
            this.f40925a.onError(t);
        }

        public void onComplete() {
            mo42489a();
            mo42486b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42489a() {
            C13218c.m43150a(this.f40929e);
        }

        public void dispose() {
            mo42489a();
            this.f40930f.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42490c() {
            T value = getAndSet(null);
            if (value != null) {
                this.f40925a.onNext(value);
            }
        }
    }

    public C13460Wa(C13802r<T> source, long period, TimeUnit unit, C13805u scheduler, boolean emitLast) {
        super(source);
        this.f40920b = period;
        this.f40921c = unit;
        this.f40922d = scheduler;
        this.f40923e = emitLast;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13770f fVar = new C13770f(t);
        if (this.f40923e) {
            C13802r<T> rVar = this.f41005a;
            C13461a aVar = new C13461a(fVar, this.f40920b, this.f40921c, this.f40922d);
            rVar.subscribe(aVar);
            return;
        }
        C13802r<T> rVar2 = this.f41005a;
        C13462b bVar = new C13462b(fVar, this.f40920b, this.f40921c, this.f40922d);
        rVar2.subscribe(bVar);
    }
}
