package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle.FlatMapSingleObserver.InnerObserver;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13812x;
import p320f.p321a.C13814z;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.ba */
/* compiled from: ObservableFlatMapSingle */
public final class C13494ba<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13814z<? extends R>> f41043b;

    /* renamed from: c */
    final boolean f41044c;

    /* renamed from: f.a.d.e.b.ba$a */
    /* compiled from: ObservableFlatMapSingle */
    static final class C13495a<T, R> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f41045a;

        /* renamed from: b */
        final boolean f41046b;

        /* renamed from: c */
        final C13193a f41047c = new C13193a();

        /* renamed from: d */
        final AtomicInteger f41048d = new AtomicInteger(1);

        /* renamed from: e */
        final C13741c f41049e = new C13741c();

        /* renamed from: f */
        final C13212n<? super T, ? extends C13814z<? extends R>> f41050f;

        /* renamed from: g */
        final AtomicReference<C13706c<R>> f41051g = new AtomicReference<>();

        /* renamed from: h */
        C13194b f41052h;

        /* renamed from: i */
        volatile boolean f41053i;

        /* renamed from: f.a.d.e.b.ba$a$a */
        /* compiled from: ObservableFlatMapSingle */
        final class C13496a extends AtomicReference<C13194b> implements C13812x<R>, C13194b {
            C13496a() {
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onSuccess(R value) {
                C13495a.this.mo42530a(this, value);
            }

            public void onError(Throwable e) {
                C13495a.this.mo42531a(this, e);
            }

            public void dispose() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13495a(C13804t<? super R> actual, C13212n<? super T, ? extends C13814z<? extends R>> mapper, boolean delayErrors) {
            this.f41045a = actual;
            this.f41050f = mapper;
            this.f41046b = delayErrors;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41052h, d)) {
                this.f41052h = d;
                this.f41045a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.f41050f.apply(t);
                C13264b.m43226a(apply, "The mapper returned a null SingleSource");
                SingleSource<? extends R> ms = (C13814z) apply;
                this.f41048d.getAndIncrement();
                InnerObserver inner = new C13496a<>();
                if (!this.f41053i && this.f41047c.mo42252b(inner)) {
                    ms.mo43156a(inner);
                }
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                this.f41052h.dispose();
                onError(ex);
            }
        }

        public void onError(Throwable t) {
            this.f41048d.decrementAndGet();
            if (this.f41049e.mo42733a(t)) {
                if (!this.f41046b) {
                    this.f41047c.dispose();
                }
                mo42532b();
                return;
            }
            C13774a.m43836b(t);
        }

        public void onComplete() {
            this.f41048d.decrementAndGet();
            mo42532b();
        }

        public void dispose() {
            this.f41053i = true;
            this.f41052h.dispose();
            this.f41047c.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42530a(C13496a inner, R value) {
            this.f41047c.mo42253c(inner);
            if (get() == 0) {
                boolean d = true;
                if (compareAndSet(0, 1)) {
                    this.f41045a.onNext(value);
                    if (this.f41048d.decrementAndGet() != 0) {
                        d = false;
                    }
                    SpscLinkedArrayQueue<R> q = (C13706c) this.f41051g.get();
                    if (!d || (q != null && !q.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        mo42533c();
                    }
                    Throwable ex = this.f41049e.mo42732a();
                    if (ex != null) {
                        this.f41045a.onError(ex);
                    } else {
                        this.f41045a.onComplete();
                    }
                    return;
                }
            }
            SpscLinkedArrayQueue<R> q2 = mo42534d();
            synchronized (q2) {
                q2.offer(value);
            }
            this.f41048d.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            mo42533c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public C13706c<R> mo42534d() {
            C13706c cVar;
            do {
                SpscLinkedArrayQueue<R> current = (C13706c) this.f41051g.get();
                if (current != null) {
                    return current;
                }
                cVar = new C13706c(C13797m.bufferSize());
            } while (!this.f41051g.compareAndSet(null, cVar));
            return cVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42531a(C13496a inner, Throwable e) {
            this.f41047c.mo42253c(inner);
            if (this.f41049e.mo42733a(e)) {
                if (!this.f41046b) {
                    this.f41052h.dispose();
                    this.f41047c.dispose();
                }
                this.f41048d.decrementAndGet();
                mo42532b();
                return;
            }
            C13774a.m43836b(e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42532b() {
            if (getAndIncrement() == 0) {
                mo42533c();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42529a() {
            SpscLinkedArrayQueue<R> q = (C13706c) this.f41051g.get();
            if (q != null) {
                q.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42533c() {
            int missed = 1;
            Observer<? super R> a = this.f41045a;
            AtomicInteger n = this.f41048d;
            AtomicReference<C13706c<R>> atomicReference = this.f41051g;
            while (!this.f41053i) {
                if (this.f41046b || ((Throwable) this.f41049e.get()) == null) {
                    boolean empty = true;
                    boolean d = n.get() == 0;
                    SpscLinkedArrayQueue<R> q = (C13706c) atomicReference.get();
                    R v = q != null ? q.poll() : null;
                    if (v != null) {
                        empty = false;
                    }
                    if (d && empty) {
                        Throwable ex = this.f41049e.mo42732a();
                        if (ex != null) {
                            a.onError(ex);
                        } else {
                            a.onComplete();
                        }
                        return;
                    } else if (empty) {
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        a.onNext(v);
                    }
                } else {
                    Throwable ex2 = this.f41049e.mo42732a();
                    mo42529a();
                    a.onError(ex2);
                    return;
                }
            }
            mo42529a();
        }
    }

    public C13494ba(C13802r<T> source, C13212n<? super T, ? extends C13814z<? extends R>> mapper, boolean delayError) {
        super(source);
        this.f41043b = mapper;
        this.f41044c = delayError;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> s) {
        this.f41005a.subscribe(new C13495a(s, this.f41043b, this.f41044c));
    }
}
