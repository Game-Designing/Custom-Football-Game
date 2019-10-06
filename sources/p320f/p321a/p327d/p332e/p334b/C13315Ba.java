package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe.MergeWithObserver;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13787i;
import p320f.p321a.C13794j;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Ba */
/* compiled from: ObservableMergeWithMaybe */
public final class C13315Ba<T> extends C13485a<T, T> {

    /* renamed from: b */
    final C13794j<? extends T> f40452b;

    /* renamed from: f.a.d.e.b.Ba$a */
    /* compiled from: ObservableMergeWithMaybe */
    static final class C13316a<T> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40453a;

        /* renamed from: b */
        final AtomicReference<C13194b> f40454b = new AtomicReference<>();

        /* renamed from: c */
        final C13317a<T> f40455c = new C13317a<>(this);

        /* renamed from: d */
        final C13741c f40456d = new C13741c();

        /* renamed from: e */
        volatile C13273h<T> f40457e;

        /* renamed from: f */
        T f40458f;

        /* renamed from: g */
        volatile boolean f40459g;

        /* renamed from: h */
        volatile boolean f40460h;

        /* renamed from: i */
        volatile int f40461i;

        /* renamed from: f.a.d.e.b.Ba$a$a */
        /* compiled from: ObservableMergeWithMaybe */
        static final class C13317a<T> extends AtomicReference<C13194b> implements C13787i<T> {

            /* renamed from: a */
            final C13316a<T> f40462a;

            C13317a(C13316a<T> parent) {
                this.f40462a = parent;
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onSuccess(T t) {
                this.f40462a.mo42367a(t);
            }

            public void onError(Throwable e) {
                this.f40462a.mo42368a(e);
            }

            public void onComplete() {
                this.f40462a.mo42371d();
            }
        }

        C13316a(C13804t<? super T> actual) {
            this.f40453a = actual;
        }

        public void onSubscribe(C13194b d) {
            C13218c.m43153c(this.f40454b, d);
        }

        public void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.f40453a.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                mo42370c().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            mo42369b();
        }

        public void onError(Throwable ex) {
            if (this.f40456d.mo42733a(ex)) {
                C13218c.m43150a(this.f40454b);
                mo42366a();
                return;
            }
            C13774a.m43836b(ex);
        }

        public void onComplete() {
            this.f40460h = true;
            mo42366a();
        }

        public void dispose() {
            this.f40459g = true;
            C13218c.m43150a(this.f40454b);
            C13218c.m43150a((AtomicReference<C13194b>) this.f40455c);
            if (getAndIncrement() == 0) {
                this.f40457e = null;
                this.f40458f = null;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42367a(T value) {
            if (compareAndSet(0, 1)) {
                this.f40453a.onNext(value);
                this.f40461i = 2;
            } else {
                this.f40458f = value;
                this.f40461i = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            mo42369b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42368a(Throwable ex) {
            if (this.f40456d.mo42733a(ex)) {
                C13218c.m43150a(this.f40454b);
                mo42366a();
                return;
            }
            C13774a.m43836b(ex);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42371d() {
            this.f40461i = 2;
            mo42366a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public C13273h<T> mo42370c() {
            SimplePlainQueue<T> q = this.f40457e;
            if (q != null) {
                return q;
            }
            C13706c cVar = new C13706c(C13797m.bufferSize());
            this.f40457e = cVar;
            return cVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42366a() {
            if (getAndIncrement() == 0) {
                mo42369b();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42369b() {
            Observer<? super T> actual = this.f40453a;
            int missed = 1;
            while (!this.f40459g) {
                if (this.f40456d.get() != null) {
                    this.f40458f = null;
                    this.f40457e = null;
                    actual.onError(this.f40456d.mo42732a());
                    return;
                }
                int os = this.f40461i;
                boolean empty = true;
                if (os == 1) {
                    T v = this.f40458f;
                    this.f40458f = null;
                    this.f40461i = 2;
                    os = 2;
                    actual.onNext(v);
                }
                boolean d = this.f40460h;
                SimplePlainQueue<T> q = this.f40457e;
                Object poll = q != null ? q.poll() : null;
                if (poll != null) {
                    empty = false;
                }
                if (d && empty && os == 2) {
                    this.f40457e = null;
                    actual.onComplete();
                    return;
                } else if (empty) {
                    missed = addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else {
                    actual.onNext(poll);
                }
            }
            this.f40458f = null;
            this.f40457e = null;
        }
    }

    public C13315Ba(C13797m<T> source, C13794j<? extends T> other) {
        super(source);
        this.f40452b = other;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        MergeWithObserver<T> parent = new C13316a<>(observer);
        observer.onSubscribe(parent);
        this.f41005a.subscribe(parent);
        this.f40452b.mo42790a(parent.f40455c);
    }
}
