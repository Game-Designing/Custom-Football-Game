package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservableDebounceTimed.DebounceEmitter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.E */
/* compiled from: ObservableDebounceTimed */
public final class C13335E<T> extends C13485a<T, T> {

    /* renamed from: b */
    final long f40523b;

    /* renamed from: c */
    final TimeUnit f40524c;

    /* renamed from: d */
    final C13805u f40525d;

    /* renamed from: f.a.d.e.b.E$a */
    /* compiled from: ObservableDebounceTimed */
    static final class C13336a<T> extends AtomicReference<C13194b> implements Runnable, C13194b {

        /* renamed from: a */
        final T f40526a;

        /* renamed from: b */
        final long f40527b;

        /* renamed from: c */
        final C13337b<T> f40528c;

        /* renamed from: d */
        final AtomicBoolean f40529d = new AtomicBoolean();

        C13336a(T value, long idx, C13337b<T> parent) {
            this.f40526a = value;
            this.f40527b = idx;
            this.f40528c = parent;
        }

        public void run() {
            if (this.f40529d.compareAndSet(false, true)) {
                this.f40528c.mo42390a(this.f40527b, this.f40526a, this);
            }
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }

        /* renamed from: a */
        public void mo42388a(C13194b d) {
            C13218c.m43151a((AtomicReference<C13194b>) this, d);
        }
    }

    /* renamed from: f.a.d.e.b.E$b */
    /* compiled from: ObservableDebounceTimed */
    static final class C13337b<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40530a;

        /* renamed from: b */
        final long f40531b;

        /* renamed from: c */
        final TimeUnit f40532c;

        /* renamed from: d */
        final C13808c f40533d;

        /* renamed from: e */
        C13194b f40534e;

        /* renamed from: f */
        final AtomicReference<C13194b> f40535f = new AtomicReference<>();

        /* renamed from: g */
        volatile long f40536g;

        /* renamed from: h */
        boolean f40537h;

        C13337b(C13804t<? super T> actual, long timeout, TimeUnit unit, C13808c worker) {
            this.f40530a = actual;
            this.f40531b = timeout;
            this.f40532c = unit;
            this.f40533d = worker;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40534e, s)) {
                this.f40534e = s;
                this.f40530a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f40537h) {
                long idx = this.f40536g + 1;
                this.f40536g = idx;
                C13194b d = (C13194b) this.f40535f.get();
                if (d != null) {
                    d.dispose();
                }
                DebounceEmitter<T> de = new C13336a<>(t, idx, this);
                if (this.f40535f.compareAndSet(d, de)) {
                    de.mo42388a(this.f40533d.mo42243a(de, this.f40531b, this.f40532c));
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f40537h) {
                C13774a.m43836b(t);
                return;
            }
            this.f40537h = true;
            this.f40530a.onError(t);
            this.f40533d.dispose();
        }

        public void onComplete() {
            if (!this.f40537h) {
                this.f40537h = true;
                C13194b d = (C13194b) this.f40535f.get();
                if (d != C13218c.DISPOSED) {
                    DebounceEmitter<T> de = (C13336a) d;
                    if (de != null) {
                        de.run();
                    }
                    this.f40530a.onComplete();
                    this.f40533d.dispose();
                }
            }
        }

        public void dispose() {
            this.f40534e.dispose();
            this.f40533d.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42390a(long idx, T t, C13336a<T> emitter) {
            if (idx == this.f40536g) {
                this.f40530a.onNext(t);
                emitter.dispose();
            }
        }
    }

    public C13335E(C13802r<T> source, long timeout, TimeUnit unit, C13805u scheduler) {
        super(source);
        this.f40523b = timeout;
        this.f40524c = unit;
        this.f40525d = scheduler;
    }

    public void subscribeActual(C13804t<? super T> t) {
        C13802r<T> rVar = this.f41005a;
        C13337b bVar = new C13337b(new C13770f(t), this.f40523b, this.f40524c, this.f40525d.mo42242a());
        rVar.subscribe(bVar);
    }
}
