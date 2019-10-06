package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe.FlatMapMaybeObserver.InnerObserver;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13787i;
import p320f.p321a.C13794j;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13193a;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.aa */
/* compiled from: ObservableFlatMapMaybe */
public final class C13486aa<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13794j<? extends R>> f41006b;

    /* renamed from: c */
    final boolean f41007c;

    /* renamed from: f.a.d.e.b.aa$a */
    /* compiled from: ObservableFlatMapMaybe */
    static final class C13487a<T, R> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f41008a;

        /* renamed from: b */
        final boolean f41009b;

        /* renamed from: c */
        final C13193a f41010c = new C13193a();

        /* renamed from: d */
        final AtomicInteger f41011d = new AtomicInteger(1);

        /* renamed from: e */
        final C13741c f41012e = new C13741c();

        /* renamed from: f */
        final C13212n<? super T, ? extends C13794j<? extends R>> f41013f;

        /* renamed from: g */
        final AtomicReference<C13706c<R>> f41014g = new AtomicReference<>();

        /* renamed from: h */
        C13194b f41015h;

        /* renamed from: i */
        volatile boolean f41016i;

        /* renamed from: f.a.d.e.b.aa$a$a */
        /* compiled from: ObservableFlatMapMaybe */
        final class C13488a extends AtomicReference<C13194b> implements C13787i<R>, C13194b {
            C13488a() {
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43153c(this, d);
            }

            public void onSuccess(R value) {
                C13487a.this.mo42515a(this, value);
            }

            public void onError(Throwable e) {
                C13487a.this.mo42516a(this, e);
            }

            public void onComplete() {
                C13487a.this.mo42514a(this);
            }

            public void dispose() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13487a(C13804t<? super R> actual, C13212n<? super T, ? extends C13794j<? extends R>> mapper, boolean delayErrors) {
            this.f41008a = actual;
            this.f41013f = mapper;
            this.f41009b = delayErrors;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41015h, d)) {
                this.f41015h = d;
                this.f41008a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.f41013f.apply(t);
                C13264b.m43226a(apply, "The mapper returned a null MaybeSource");
                MaybeSource<? extends R> ms = (C13794j) apply;
                this.f41011d.getAndIncrement();
                InnerObserver inner = new C13488a<>();
                if (!this.f41016i && this.f41010c.mo42252b(inner)) {
                    ms.mo42790a(inner);
                }
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                this.f41015h.dispose();
                onError(ex);
            }
        }

        public void onError(Throwable t) {
            this.f41011d.decrementAndGet();
            if (this.f41012e.mo42733a(t)) {
                if (!this.f41009b) {
                    this.f41010c.dispose();
                }
                mo42517b();
                return;
            }
            C13774a.m43836b(t);
        }

        public void onComplete() {
            this.f41011d.decrementAndGet();
            mo42517b();
        }

        public void dispose() {
            this.f41016i = true;
            this.f41015h.dispose();
            this.f41010c.dispose();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42515a(C13488a inner, R value) {
            this.f41010c.mo42253c(inner);
            if (get() == 0) {
                boolean d = true;
                if (compareAndSet(0, 1)) {
                    this.f41008a.onNext(value);
                    if (this.f41011d.decrementAndGet() != 0) {
                        d = false;
                    }
                    SpscLinkedArrayQueue<R> q = (C13706c) this.f41014g.get();
                    if (!d || (q != null && !q.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        mo42518c();
                    }
                    Throwable ex = this.f41012e.mo42732a();
                    if (ex != null) {
                        this.f41008a.onError(ex);
                    } else {
                        this.f41008a.onComplete();
                    }
                    return;
                }
            }
            SpscLinkedArrayQueue<R> q2 = mo42519d();
            synchronized (q2) {
                q2.offer(value);
            }
            this.f41011d.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            mo42518c();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public C13706c<R> mo42519d() {
            C13706c cVar;
            do {
                SpscLinkedArrayQueue<R> current = (C13706c) this.f41014g.get();
                if (current != null) {
                    return current;
                }
                cVar = new C13706c(C13797m.bufferSize());
            } while (!this.f41014g.compareAndSet(null, cVar));
            return cVar;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42516a(C13488a inner, Throwable e) {
            this.f41010c.mo42253c(inner);
            if (this.f41012e.mo42733a(e)) {
                if (!this.f41009b) {
                    this.f41015h.dispose();
                    this.f41010c.dispose();
                }
                this.f41011d.decrementAndGet();
                mo42517b();
                return;
            }
            C13774a.m43836b(e);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42514a(C13488a inner) {
            this.f41010c.mo42253c(inner);
            if (get() == 0) {
                boolean d = true;
                if (compareAndSet(0, 1)) {
                    if (this.f41011d.decrementAndGet() != 0) {
                        d = false;
                    }
                    SpscLinkedArrayQueue<R> q = (C13706c) this.f41014g.get();
                    if (d && (q == null || q.isEmpty())) {
                        Throwable ex = this.f41012e.mo42732a();
                        if (ex != null) {
                            this.f41008a.onError(ex);
                        } else {
                            this.f41008a.onComplete();
                        }
                        return;
                    } else if (decrementAndGet() != 0) {
                        mo42518c();
                    } else {
                        return;
                    }
                }
            }
            this.f41011d.decrementAndGet();
            mo42517b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42517b() {
            if (getAndIncrement() == 0) {
                mo42518c();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42513a() {
            SpscLinkedArrayQueue<R> q = (C13706c) this.f41014g.get();
            if (q != null) {
                q.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42518c() {
            int missed = 1;
            Observer<? super R> a = this.f41008a;
            AtomicInteger n = this.f41011d;
            AtomicReference<C13706c<R>> atomicReference = this.f41014g;
            while (!this.f41016i) {
                if (this.f41009b || ((Throwable) this.f41012e.get()) == null) {
                    boolean empty = true;
                    boolean d = n.get() == 0;
                    SpscLinkedArrayQueue<R> q = (C13706c) atomicReference.get();
                    R v = q != null ? q.poll() : null;
                    if (v != null) {
                        empty = false;
                    }
                    if (d && empty) {
                        Throwable ex = this.f41012e.mo42732a();
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
                    Throwable ex2 = this.f41012e.mo42732a();
                    mo42513a();
                    a.onError(ex2);
                    return;
                }
            }
            mo42513a();
        }
    }

    public C13486aa(C13802r<T> source, C13212n<? super T, ? extends C13794j<? extends R>> mapper, boolean delayError) {
        super(source);
        this.f41006b = mapper;
        this.f41007c = delayError;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> s) {
        this.f41005a.subscribe(new C13487a(s, this.f41006b, this.f41007c));
    }
}
