package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.InnerQueuedObserver;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p330c.C13269d;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p331d.C13288n;
import p320f.p321a.p327d.p331d.C13289o;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p327d.p340j.C13747i;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.w */
/* compiled from: ObservableConcatMapEager */
public final class C13656w<T, R> extends C13485a<T, R> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13802r<? extends R>> f41609b;

    /* renamed from: c */
    final C13747i f41610c;

    /* renamed from: d */
    final int f41611d;

    /* renamed from: e */
    final int f41612e;

    /* renamed from: f.a.d.e.b.w$a */
    /* compiled from: ObservableConcatMapEager */
    static final class C13657a<T, R> extends AtomicInteger implements C13804t<T>, C13194b, C13289o<R> {

        /* renamed from: a */
        final C13804t<? super R> f41613a;

        /* renamed from: b */
        final C13212n<? super T, ? extends C13802r<? extends R>> f41614b;

        /* renamed from: c */
        final int f41615c;

        /* renamed from: d */
        final int f41616d;

        /* renamed from: e */
        final C13747i f41617e;

        /* renamed from: f */
        final C13741c f41618f = new C13741c();

        /* renamed from: g */
        final ArrayDeque<C13288n<R>> f41619g = new ArrayDeque<>();

        /* renamed from: h */
        C13274i<T> f41620h;

        /* renamed from: i */
        C13194b f41621i;

        /* renamed from: j */
        volatile boolean f41622j;

        /* renamed from: k */
        int f41623k;

        /* renamed from: l */
        volatile boolean f41624l;

        /* renamed from: m */
        C13288n<R> f41625m;

        /* renamed from: n */
        int f41626n;

        C13657a(C13804t<? super R> actual, C13212n<? super T, ? extends C13802r<? extends R>> mapper, int maxConcurrency, int prefetch, C13747i errorMode) {
            this.f41613a = actual;
            this.f41614b = mapper;
            this.f41615c = maxConcurrency;
            this.f41616d = prefetch;
            this.f41617e = errorMode;
        }

        public void onSubscribe(C13194b d) {
            if (C13218c.m43149a(this.f41621i, d)) {
                this.f41621i = d;
                if (d instanceof C13269d) {
                    QueueDisposable<T> qd = (C13269d) d;
                    int m = qd.mo42274a(3);
                    if (m == 1) {
                        this.f41623k = m;
                        this.f41620h = qd;
                        this.f41622j = true;
                        this.f41613a.onSubscribe(this);
                        mo42337a();
                        return;
                    } else if (m == 2) {
                        this.f41623k = m;
                        this.f41620h = qd;
                        this.f41613a.onSubscribe(this);
                        return;
                    }
                }
                this.f41620h = new C13706c(this.f41616d);
                this.f41613a.onSubscribe(this);
            }
        }

        public void onNext(T value) {
            if (this.f41623k == 0) {
                this.f41620h.offer(value);
            }
            mo42337a();
        }

        public void onError(Throwable e) {
            if (this.f41618f.mo42733a(e)) {
                this.f41622j = true;
                mo42337a();
                return;
            }
            C13774a.m43836b(e);
        }

        public void onComplete() {
            this.f41622j = true;
            mo42337a();
        }

        public void dispose() {
            this.f41624l = true;
            if (getAndIncrement() == 0) {
                this.f41620h.clear();
                mo42651b();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42651b() {
            InnerQueuedObserver<R> inner = this.f41625m;
            if (inner != null) {
                inner.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> inner2 = (C13288n) this.f41619g.poll();
                if (inner2 != null) {
                    inner2.dispose();
                } else {
                    return;
                }
            }
        }

        /* renamed from: a */
        public void mo42339a(C13288n<R> inner, R value) {
            inner.mo42335b().offer(value);
            mo42337a();
        }

        /* renamed from: a */
        public void mo42340a(C13288n<R> inner, Throwable e) {
            if (this.f41618f.mo42733a(e)) {
                if (this.f41617e == C13747i.IMMEDIATE) {
                    this.f41621i.dispose();
                }
                inner.mo42336c();
                mo42337a();
                return;
            }
            C13774a.m43836b(e);
        }

        /* renamed from: a */
        public void mo42338a(C13288n<R> inner) {
            inner.mo42336c();
            mo42337a();
        }

        /* renamed from: a */
        public void mo42337a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                SimpleQueue<T> q = this.f41620h;
                ArrayDeque<C13288n<R>> arrayDeque = this.f41619g;
                Observer<? super R> a = this.f41613a;
                C13747i errorMode = this.f41617e;
                while (true) {
                    int ac = this.f41626n;
                    while (true) {
                        if (ac == this.f41615c) {
                            break;
                        } else if (this.f41624l) {
                            q.clear();
                            mo42651b();
                            return;
                        } else if (errorMode != C13747i.IMMEDIATE || ((Throwable) this.f41618f.get()) == null) {
                            try {
                                T v = q.poll();
                                if (v == null) {
                                    break;
                                }
                                Object apply = this.f41614b.apply(v);
                                C13264b.m43226a(apply, "The mapper returned a null ObservableSource");
                                ObservableSource<? extends R> source = (C13802r) apply;
                                InnerQueuedObserver<R> inner = new C13288n<>(this, this.f41616d);
                                arrayDeque.offer(inner);
                                source.subscribe(inner);
                                ac++;
                            } catch (Throwable ex) {
                                C13980a.m44462b(ex);
                                this.f41621i.dispose();
                                q.clear();
                                mo42651b();
                                this.f41618f.mo42733a(ex);
                                a.onError(this.f41618f.mo42732a());
                                return;
                            }
                        } else {
                            q.clear();
                            mo42651b();
                            a.onError(this.f41618f.mo42732a());
                            return;
                        }
                    }
                    this.f41626n = ac;
                    if (this.f41624l) {
                        q.clear();
                        mo42651b();
                        return;
                    } else if (errorMode != C13747i.IMMEDIATE || ((Throwable) this.f41618f.get()) == null) {
                        InnerQueuedObserver<R> active = this.f41625m;
                        if (active == null) {
                            if (errorMode != C13747i.BOUNDARY || ((Throwable) this.f41618f.get()) == null) {
                                boolean d = this.f41622j;
                                active = (C13288n) arrayDeque.poll();
                                boolean empty = active == null;
                                if (d && empty) {
                                    if (((Throwable) this.f41618f.get()) != null) {
                                        q.clear();
                                        mo42651b();
                                        a.onError(this.f41618f.mo42732a());
                                    } else {
                                        a.onComplete();
                                    }
                                    return;
                                } else if (!empty) {
                                    this.f41625m = active;
                                }
                            } else {
                                q.clear();
                                mo42651b();
                                a.onError(this.f41618f.mo42732a());
                                return;
                            }
                        }
                        if (active != null) {
                            SimpleQueue<R> aq = active.mo42335b();
                            while (!this.f41624l) {
                                boolean d2 = active.mo42334a();
                                if (errorMode != C13747i.IMMEDIATE || ((Throwable) this.f41618f.get()) == null) {
                                    try {
                                        R w = aq.poll();
                                        boolean empty2 = w == null;
                                        if (d2 && empty2) {
                                            this.f41625m = null;
                                            this.f41626n--;
                                        } else if (!empty2) {
                                            a.onNext(w);
                                        }
                                    } catch (Throwable ex2) {
                                        C13980a.m44462b(ex2);
                                        this.f41618f.mo42733a(ex2);
                                        this.f41625m = null;
                                        this.f41626n--;
                                    }
                                } else {
                                    q.clear();
                                    mo42651b();
                                    a.onError(this.f41618f.mo42732a());
                                    return;
                                }
                            }
                            q.clear();
                            mo42651b();
                            return;
                        }
                        missed = addAndGet(-missed);
                        if (missed == 0) {
                            return;
                        }
                    } else {
                        q.clear();
                        mo42651b();
                        a.onError(this.f41618f.mo42732a());
                        return;
                    }
                }
            }
        }
    }

    public C13656w(C13802r<T> source, C13212n<? super T, ? extends C13802r<? extends R>> mapper, C13747i errorMode, int maxConcurrency, int prefetch) {
        super(source);
        this.f41609b = mapper;
        this.f41610c = errorMode;
        this.f41611d = maxConcurrency;
        this.f41612e = prefetch;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super R> observer) {
        C13802r<T> rVar = this.f41005a;
        C13657a aVar = new C13657a(observer, this.f41609b, this.f41611d, this.f41612e, this.f41610c);
        rVar.subscribe(aVar);
    }
}
