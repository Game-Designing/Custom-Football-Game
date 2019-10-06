package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.mb */
/* compiled from: ObservableSwitchMap */
public final class C13572mb<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13802r<? extends R>> f41304b;

    /* renamed from: c */
    final int f41305c;

    /* renamed from: d */
    final boolean f41306d;

    /* renamed from: f.a.d.e.b.mb$a */
    /* compiled from: ObservableSwitchMap */
    static final class C13573a<T, R> extends AtomicReference<C13194b> implements C13804t<R> {

        /* renamed from: a */
        final C13574b<T, R> f41307a;

        /* renamed from: b */
        final long f41308b;

        /* renamed from: c */
        final C13706c<R> f41309c;

        /* renamed from: d */
        volatile boolean f41310d;

        C13573a(C13574b<T, R> parent, long index, int bufferSize) {
            this.f41307a = parent;
            this.f41308b = index;
            this.f41309c = new C13706c<>(bufferSize);
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onNext(R t) {
            if (this.f41308b == this.f41307a.f41321k) {
                this.f41309c.offer(t);
                this.f41307a.mo42595b();
            }
        }

        public void onError(Throwable t) {
            this.f41307a.mo42594a(this, t);
        }

        public void onComplete() {
            if (this.f41308b == this.f41307a.f41321k) {
                this.f41310d = true;
                this.f41307a.mo42595b();
            }
        }

        /* renamed from: a */
        public void mo42592a() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    /* renamed from: f.a.d.e.b.mb$b */
    /* compiled from: ObservableSwitchMap */
    static final class C13574b<T, R> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        static final C13573a<Object, Object> f41311a = new C13573a<>(null, -1, 1);

        /* renamed from: b */
        final C13804t<? super R> f41312b;

        /* renamed from: c */
        final C13212n<? super T, ? extends C13802r<? extends R>> f41313c;

        /* renamed from: d */
        final int f41314d;

        /* renamed from: e */
        final boolean f41315e;

        /* renamed from: f */
        final C13741c f41316f;

        /* renamed from: g */
        volatile boolean f41317g;

        /* renamed from: h */
        volatile boolean f41318h;

        /* renamed from: i */
        C13194b f41319i;

        /* renamed from: j */
        final AtomicReference<C13573a<T, R>> f41320j = new AtomicReference<>();

        /* renamed from: k */
        volatile long f41321k;

        static {
            f41311a.mo42592a();
        }

        C13574b(C13804t<? super R> actual, C13212n<? super T, ? extends C13802r<? extends R>> mapper, int bufferSize, boolean delayErrors) {
            this.f41312b = actual;
            this.f41313c = mapper;
            this.f41314d = bufferSize;
            this.f41315e = delayErrors;
            this.f41316f = new C13741c();
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41319i, s)) {
                this.f41319i = s;
                this.f41312b.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            long c = this.f41321k + 1;
            this.f41321k = c;
            SwitchMapInnerObserver<T, R> inner = (C13573a) this.f41320j.get();
            if (inner != null) {
                inner.mo42592a();
            }
            try {
                Object apply = this.f41313c.apply(t);
                C13264b.m43226a(apply, "The ObservableSource returned is null");
                ObservableSource<? extends R> p = (C13802r) apply;
                SwitchMapInnerObserver<T, R> nextInner = new C13573a<>(this, c, this.f41314d);
                while (true) {
                    SwitchMapInnerObserver<T, R> inner2 = (C13573a) this.f41320j.get();
                    if (inner2 != f41311a) {
                        if (this.f41320j.compareAndSet(inner2, nextInner)) {
                            p.subscribe(nextInner);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                this.f41319i.dispose();
                onError(e);
            }
        }

        public void onError(Throwable t) {
            if (this.f41317g || !this.f41316f.mo42733a(t)) {
                C13774a.m43836b(t);
                return;
            }
            if (!this.f41315e) {
                mo42593a();
            }
            this.f41317g = true;
            mo42595b();
        }

        public void onComplete() {
            if (!this.f41317g) {
                this.f41317g = true;
                mo42595b();
            }
        }

        public void dispose() {
            if (!this.f41318h) {
                this.f41318h = true;
                this.f41319i.dispose();
                mo42593a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42593a() {
            SwitchMapInnerObserver<T, R> a = (C13573a) this.f41320j.get();
            SwitchMapInnerObserver<T, R> switchMapInnerObserver = f41311a;
            if (a != switchMapInnerObserver) {
                SwitchMapInnerObserver<T, R> a2 = (C13573a) this.f41320j.getAndSet(switchMapInnerObserver);
                if (a2 != f41311a && a2 != null) {
                    a2.mo42592a();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42595b() {
            if (getAndIncrement() == 0) {
                Observer<? super R> a = this.f41312b;
                int missing = 1;
                while (!this.f41318h) {
                    if (this.f41317g) {
                        boolean empty = this.f41320j.get() == null;
                        if (this.f41315e) {
                            if (empty) {
                                Throwable ex = (Throwable) this.f41316f.get();
                                if (ex != null) {
                                    a.onError(ex);
                                } else {
                                    a.onComplete();
                                }
                                return;
                            }
                        } else if (((Throwable) this.f41316f.get()) != null) {
                            a.onError(this.f41316f.mo42732a());
                            return;
                        } else if (empty) {
                            a.onComplete();
                            return;
                        }
                    }
                    SwitchMapInnerObserver<T, R> inner = (C13573a) this.f41320j.get();
                    if (inner != null) {
                        SpscLinkedArrayQueue<R> q = inner.f41309c;
                        if (inner.f41310d) {
                            boolean empty2 = q.isEmpty();
                            if (this.f41315e) {
                                if (empty2) {
                                    this.f41320j.compareAndSet(inner, null);
                                }
                            } else if (((Throwable) this.f41316f.get()) != null) {
                                a.onError(this.f41316f.mo42732a());
                                return;
                            } else if (empty2) {
                                this.f41320j.compareAndSet(inner, null);
                            }
                        }
                        boolean retry = false;
                        while (!this.f41318h) {
                            if (inner != this.f41320j.get()) {
                                retry = true;
                            } else if (this.f41315e || ((Throwable) this.f41316f.get()) == null) {
                                boolean d = inner.f41310d;
                                R v = q.poll();
                                boolean empty3 = v == null;
                                if (d && empty3) {
                                    this.f41320j.compareAndSet(inner, null);
                                    retry = true;
                                } else if (!empty3) {
                                    a.onNext(v);
                                }
                            } else {
                                a.onError(this.f41316f.mo42732a());
                                return;
                            }
                            if (retry) {
                                continue;
                            }
                        }
                        return;
                    }
                    missing = addAndGet(-missing);
                    if (missing == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42594a(C13573a<T, R> inner, Throwable ex) {
            if (inner.f41308b != this.f41321k || !this.f41316f.mo42733a(ex)) {
                C13774a.m43836b(ex);
                return;
            }
            if (!this.f41315e) {
                this.f41319i.dispose();
            }
            inner.f41310d = true;
            mo42595b();
        }
    }

    public C13572mb(C13802r<T> source, C13212n<? super T, ? extends C13802r<? extends R>> mapper, int bufferSize, boolean delayErrors) {
        super(source);
        this.f41304b = mapper;
        this.f41305c = bufferSize;
        this.f41306d = delayErrors;
    }

    public void subscribeActual(C13804t<? super R> t) {
        if (!C13475Ya.m43450a(this.f41005a, t, this.f41304b)) {
            this.f41005a.subscribe(new C13574b(t, this.f41304b, this.f41305c, this.f41306d));
        }
    }
}
