package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.operators.observable.ObservableConcatMap.ConcatMapDelayErrorObserver;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p327d.p340j.C13747i;
import p320f.p321a.p342f.C13770f;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.u */
/* compiled from: ObservableConcatMap */
public final class C13640u<T, U> extends C13485a<T, U> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13802r<? extends U>> f41538b;

    /* renamed from: c */
    final int f41539c;

    /* renamed from: d */
    final C13747i f41540d;

    /* renamed from: f.a.d.e.b.u$a */
    /* compiled from: ObservableConcatMap */
    static final class C13641a<T, R> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super R> f41541a;

        /* renamed from: b */
        final C13212n<? super T, ? extends C13802r<? extends R>> f41542b;

        /* renamed from: c */
        final int f41543c;

        /* renamed from: d */
        final C13741c f41544d = new C13741c();

        /* renamed from: e */
        final C13642a<R> f41545e;

        /* renamed from: f */
        final boolean f41546f;

        /* renamed from: g */
        C13274i<T> f41547g;

        /* renamed from: h */
        C13194b f41548h;

        /* renamed from: i */
        volatile boolean f41549i;

        /* renamed from: j */
        volatile boolean f41550j;

        /* renamed from: k */
        volatile boolean f41551k;

        /* renamed from: l */
        int f41552l;

        /* renamed from: f.a.d.e.b.u$a$a */
        /* compiled from: ObservableConcatMap */
        static final class C13642a<R> extends AtomicReference<C13194b> implements C13804t<R> {

            /* renamed from: a */
            final C13804t<? super R> f41553a;

            /* renamed from: b */
            final C13641a<?, R> f41554b;

            C13642a(C13804t<? super R> actual, C13641a<?, R> parent) {
                this.f41553a = actual;
                this.f41554b = parent;
            }

            public void onSubscribe(C13194b d) {
                C13218c.m43151a((AtomicReference<C13194b>) this, d);
            }

            public void onNext(R value) {
                this.f41553a.onNext(value);
            }

            public void onError(Throwable e) {
                ConcatMapDelayErrorObserver<?, R> p = this.f41554b;
                if (p.f41544d.mo42733a(e)) {
                    if (!p.f41546f) {
                        p.f41548h.dispose();
                    }
                    p.f41549i = false;
                    p.mo42642a();
                    return;
                }
                C13774a.m43836b(e);
            }

            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> p = this.f41554b;
                p.f41549i = false;
                p.mo42642a();
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo42643a() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13641a(C13804t<? super R> actual, C13212n<? super T, ? extends C13802r<? extends R>> mapper, int bufferSize, boolean tillTheEnd) {
            this.f41541a = actual;
            this.f41542b = mapper;
            this.f41543c = bufferSize;
            this.f41546f = tillTheEnd;
            this.f41545e = new C13642a<>(actual, this);
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41548h, d)) {
                this.f41548h = d;
                if (d instanceof C13269d) {
                    QueueDisposable<T> qd = (C13269d) d;
                    int m = qd.mo42274a(3);
                    if (m == 1) {
                        this.f41552l = m;
                        this.f41547g = qd;
                        this.f41550j = true;
                        this.f41541a.onSubscribe(this);
                        mo42642a();
                        return;
                    } else if (m == 2) {
                        this.f41552l = m;
                        this.f41547g = qd;
                        this.f41541a.onSubscribe(this);
                        return;
                    }
                }
                this.f41547g = new C13706c(this.f41543c);
                this.f41541a.onSubscribe(this);
            }
        }

        public void onNext(T value) {
            if (this.f41552l == 0) {
                this.f41547g.offer(value);
            }
            mo42642a();
        }

        public void onError(Throwable e) {
            if (this.f41544d.mo42733a(e)) {
                this.f41550j = true;
                mo42642a();
                return;
            }
            C13774a.m43836b(e);
        }

        public void onComplete() {
            this.f41550j = true;
            mo42642a();
        }

        public void dispose() {
            this.f41551k = true;
            this.f41548h.dispose();
            this.f41545e.mo42643a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42642a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> actual = this.f41541a;
                SimpleQueue<T> queue = this.f41547g;
                C13741c error = this.f41544d;
                while (true) {
                    if (!this.f41549i) {
                        if (this.f41551k) {
                            queue.clear();
                            return;
                        } else if (this.f41546f || ((Throwable) error.get()) == null) {
                            boolean d = this.f41550j;
                            try {
                                T v = queue.poll();
                                boolean empty = v == null;
                                if (d && empty) {
                                    this.f41551k = true;
                                    Throwable ex = error.mo42732a();
                                    if (ex != null) {
                                        actual.onError(ex);
                                    } else {
                                        actual.onComplete();
                                    }
                                    return;
                                } else if (!empty) {
                                    try {
                                        Object apply = this.f41542b.apply(v);
                                        C13264b.m43226a(apply, "The mapper returned a null ObservableSource");
                                        C13802r rVar = (C13802r) apply;
                                        if (rVar instanceof Callable) {
                                            try {
                                                R w = ((Callable) rVar).call();
                                                if (w != null && !this.f41551k) {
                                                    actual.onNext(w);
                                                }
                                            } catch (Throwable ex2) {
                                                C13980a.m44462b(ex2);
                                                error.mo42733a(ex2);
                                            }
                                        } else {
                                            this.f41549i = true;
                                            rVar.subscribe(this.f41545e);
                                        }
                                    } catch (Throwable ex3) {
                                        C13980a.m44462b(ex3);
                                        this.f41551k = true;
                                        this.f41548h.dispose();
                                        queue.clear();
                                        error.mo42733a(ex3);
                                        actual.onError(error.mo42732a());
                                        return;
                                    }
                                }
                            } catch (Throwable ex4) {
                                C13980a.m44462b(ex4);
                                this.f41551k = true;
                                this.f41548h.dispose();
                                error.mo42733a(ex4);
                                actual.onError(error.mo42732a());
                                return;
                            }
                        } else {
                            queue.clear();
                            this.f41551k = true;
                            actual.onError(error.mo42732a());
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: f.a.d.e.b.u$b */
    /* compiled from: ObservableConcatMap */
    static final class C13643b<T, U> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super U> f41555a;

        /* renamed from: b */
        final C13212n<? super T, ? extends C13802r<? extends U>> f41556b;

        /* renamed from: c */
        final C13644a<U> f41557c;

        /* renamed from: d */
        final int f41558d;

        /* renamed from: e */
        C13274i<T> f41559e;

        /* renamed from: f */
        C13194b f41560f;

        /* renamed from: g */
        volatile boolean f41561g;

        /* renamed from: h */
        volatile boolean f41562h;

        /* renamed from: i */
        volatile boolean f41563i;

        /* renamed from: j */
        int f41564j;

        /* renamed from: f.a.d.e.b.u$b$a */
        /* compiled from: ObservableConcatMap */
        static final class C13644a<U> extends AtomicReference<C13194b> implements C13804t<U> {

            /* renamed from: a */
            final C13804t<? super U> f41565a;

            /* renamed from: b */
            final C13643b<?, ?> f41566b;

            C13644a(C13804t<? super U> actual, C13643b<?, ?> parent) {
                this.f41565a = actual;
                this.f41566b = parent;
            }

            public void onSubscribe(C13194b s) {
                C13218c.m43152b(this, s);
            }

            public void onNext(U t) {
                this.f41565a.onNext(t);
            }

            public void onError(Throwable t) {
                this.f41566b.dispose();
                this.f41565a.onError(t);
            }

            public void onComplete() {
                this.f41566b.mo42645b();
            }

            /* access modifiers changed from: 0000 */
            /* renamed from: a */
            public void mo42646a() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13643b(C13804t<? super U> actual, C13212n<? super T, ? extends C13802r<? extends U>> mapper, int bufferSize) {
            this.f41555a = actual;
            this.f41556b = mapper;
            this.f41558d = bufferSize;
            this.f41557c = new C13644a<>(actual, this);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41560f, s)) {
                this.f41560f = s;
                if (s instanceof C13269d) {
                    QueueDisposable<T> qd = (C13269d) s;
                    int m = qd.mo42274a(3);
                    if (m == 1) {
                        this.f41564j = m;
                        this.f41559e = qd;
                        this.f41563i = true;
                        this.f41555a.onSubscribe(this);
                        mo42644a();
                        return;
                    } else if (m == 2) {
                        this.f41564j = m;
                        this.f41559e = qd;
                        this.f41555a.onSubscribe(this);
                        return;
                    }
                }
                this.f41559e = new C13706c(this.f41558d);
                this.f41555a.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f41563i) {
                if (this.f41564j == 0) {
                    this.f41559e.offer(t);
                }
                mo42644a();
            }
        }

        public void onError(Throwable t) {
            if (this.f41563i) {
                C13774a.m43836b(t);
                return;
            }
            this.f41563i = true;
            dispose();
            this.f41555a.onError(t);
        }

        public void onComplete() {
            if (!this.f41563i) {
                this.f41563i = true;
                mo42644a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42645b() {
            this.f41561g = false;
            mo42644a();
        }

        public void dispose() {
            this.f41562h = true;
            this.f41557c.mo42646a();
            this.f41560f.dispose();
            if (getAndIncrement() == 0) {
                this.f41559e.clear();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42644a() {
            if (getAndIncrement() == 0) {
                while (!this.f41562h) {
                    if (!this.f41561g) {
                        boolean d = this.f41563i;
                        try {
                            T t = this.f41559e.poll();
                            boolean empty = t == null;
                            if (d && empty) {
                                this.f41562h = true;
                                this.f41555a.onComplete();
                                return;
                            } else if (!empty) {
                                try {
                                    Object apply = this.f41556b.apply(t);
                                    C13264b.m43226a(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource<? extends U> o = (C13802r) apply;
                                    this.f41561g = true;
                                    o.subscribe(this.f41557c);
                                } catch (Throwable ex) {
                                    C13980a.m44462b(ex);
                                    dispose();
                                    this.f41559e.clear();
                                    this.f41555a.onError(ex);
                                    return;
                                }
                            }
                        } catch (Throwable ex2) {
                            C13980a.m44462b(ex2);
                            dispose();
                            this.f41559e.clear();
                            this.f41555a.onError(ex2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.f41559e.clear();
            }
        }
    }

    public C13640u(C13802r<T> source, C13212n<? super T, ? extends C13802r<? extends U>> mapper, int bufferSize, C13747i delayErrors) {
        super(source);
        this.f41538b = mapper;
        this.f41540d = delayErrors;
        this.f41539c = Math.max(8, bufferSize);
    }

    public void subscribeActual(C13804t<? super U> s) {
        if (!C13475Ya.m43450a(this.f41005a, s, this.f41538b)) {
            C13747i iVar = this.f41540d;
            if (iVar == C13747i.IMMEDIATE) {
                this.f41005a.subscribe(new C13643b(new C13770f<>(s), this.f41538b, this.f41539c));
            } else {
                this.f41005a.subscribe(new C13641a(s, this.f41538b, this.f41539c, iVar == C13747i.END));
            }
        }
    }
}
