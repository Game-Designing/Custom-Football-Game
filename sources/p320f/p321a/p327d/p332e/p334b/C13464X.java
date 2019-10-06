package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.operators.observable.ObservableFlatMap.InnerObserver;
import java.util.ArrayDeque;
import java.util.Queue;
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
import p320f.p321a.p327d.p330c.C13273h;
import p320f.p321a.p327d.p330c.C13274i;
import p320f.p321a.p327d.p336f.C13705b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.X */
/* compiled from: ObservableFlatMap */
public final class C13464X<T, U> extends C13485a<T, U> {

    /* renamed from: b */
    final C13212n<? super T, ? extends C13802r<? extends U>> f40931b;

    /* renamed from: c */
    final boolean f40932c;

    /* renamed from: d */
    final int f40933d;

    /* renamed from: e */
    final int f40934e;

    /* renamed from: f.a.d.e.b.X$a */
    /* compiled from: ObservableFlatMap */
    static final class C13465a<T, U> extends AtomicReference<C13194b> implements C13804t<U> {

        /* renamed from: a */
        final long f40935a;

        /* renamed from: b */
        final C13466b<T, U> f40936b;

        /* renamed from: c */
        volatile boolean f40937c;

        /* renamed from: d */
        volatile C13274i<U> f40938d;

        /* renamed from: e */
        int f40939e;

        C13465a(C13466b<T, U> parent, long id) {
            this.f40935a = id;
            this.f40936b = parent;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43153c(this, s) && (s instanceof C13269d)) {
                QueueDisposable<U> qd = (C13269d) s;
                int m = qd.mo42274a(7);
                if (m == 1) {
                    this.f40939e = m;
                    this.f40938d = qd;
                    this.f40937c = true;
                    this.f40936b.mo42499c();
                } else if (m == 2) {
                    this.f40939e = m;
                    this.f40938d = qd;
                }
            }
        }

        public void onNext(U t) {
            if (this.f40939e == 0) {
                this.f40936b.mo42493a(t, this);
            } else {
                this.f40936b.mo42499c();
            }
        }

        public void onError(Throwable t) {
            if (this.f40936b.f40949j.mo42733a(t)) {
                C13466b<T, U> bVar = this.f40936b;
                if (!bVar.f40944e) {
                    bVar.mo42498b();
                }
                this.f40937c = true;
                this.f40936b.mo42499c();
                return;
            }
            C13774a.m43836b(t);
        }

        public void onComplete() {
            this.f40937c = true;
            this.f40936b.mo42499c();
        }

        /* renamed from: a */
        public void mo42491a() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    /* renamed from: f.a.d.e.b.X$b */
    /* compiled from: ObservableFlatMap */
    static final class C13466b<T, U> extends AtomicInteger implements C13194b, C13804t<T> {

        /* renamed from: a */
        static final C13465a<?, ?>[] f40940a = new C13465a[0];

        /* renamed from: b */
        static final C13465a<?, ?>[] f40941b = new C13465a[0];

        /* renamed from: c */
        final C13804t<? super U> f40942c;

        /* renamed from: d */
        final C13212n<? super T, ? extends C13802r<? extends U>> f40943d;

        /* renamed from: e */
        final boolean f40944e;

        /* renamed from: f */
        final int f40945f;

        /* renamed from: g */
        final int f40946g;

        /* renamed from: h */
        volatile C13273h<U> f40947h;

        /* renamed from: i */
        volatile boolean f40948i;

        /* renamed from: j */
        final C13741c f40949j = new C13741c();

        /* renamed from: k */
        volatile boolean f40950k;

        /* renamed from: l */
        final AtomicReference<C13465a<?, ?>[]> f40951l;

        /* renamed from: m */
        C13194b f40952m;

        /* renamed from: n */
        long f40953n;

        /* renamed from: o */
        long f40954o;

        /* renamed from: p */
        int f40955p;

        /* renamed from: q */
        Queue<C13802r<? extends U>> f40956q;

        /* renamed from: r */
        int f40957r;

        C13466b(C13804t<? super U> actual, C13212n<? super T, ? extends C13802r<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
            this.f40942c = actual;
            this.f40943d = mapper;
            this.f40944e = delayErrors;
            this.f40945f = maxConcurrency;
            this.f40946g = bufferSize;
            if (maxConcurrency != Integer.MAX_VALUE) {
                this.f40956q = new ArrayDeque(maxConcurrency);
            }
            this.f40951l = new AtomicReference<>(f40940a);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f40952m, s)) {
                this.f40952m = s;
                this.f40942c.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.f40948i) {
                try {
                    Object apply = this.f40943d.apply(t);
                    C13264b.m43226a(apply, "The mapper returned a null ObservableSource");
                    ObservableSource<? extends U> p = (C13802r) apply;
                    if (this.f40945f != Integer.MAX_VALUE) {
                        synchronized (this) {
                            if (this.f40957r == this.f40945f) {
                                this.f40956q.offer(p);
                                return;
                            }
                            this.f40957r++;
                        }
                    }
                    mo42492a((C13802r<? extends U>) p);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f40952m.dispose();
                    onError(e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42492a(C13802r<? extends U> p) {
            while (p instanceof Callable) {
                mo42494a((Callable) p);
                if (this.f40945f != Integer.MAX_VALUE) {
                    synchronized (this) {
                        p = (C13802r) this.f40956q.poll();
                        if (p == null) {
                            this.f40957r--;
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
            long j = this.f40953n;
            this.f40953n = 1 + j;
            InnerObserver<T, U> inner = new C13465a<>(this, j);
            if (mo42496a((C13465a<T, U>) inner)) {
                p.subscribe(inner);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42496a(C13465a<T, U> inner) {
            InnerObserver<?, ?>[] a;
            InnerObserver<?, ?>[] b;
            do {
                a = (C13465a[]) this.f40951l.get();
                if (a == f40941b) {
                    inner.mo42491a();
                    return false;
                }
                int n = a.length;
                b = new C13465a[(n + 1)];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = inner;
            } while (!this.f40951l.compareAndSet(a, b));
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42497b(C13465a<T, U> inner) {
            InnerObserver<?, ?>[] a;
            InnerObserver<?, ?>[] b;
            do {
                a = (C13465a[]) this.f40951l.get();
                int n = a.length;
                if (n != 0) {
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= n) {
                            break;
                        } else if (a[i] == inner) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (n == 1) {
                            b = f40940a;
                        } else {
                            InnerObserver<?, ?>[] b2 = new C13465a[(n - 1)];
                            System.arraycopy(a, 0, b2, 0, j);
                            System.arraycopy(a, j + 1, b2, j, (n - j) - 1);
                            b = b2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f40951l.compareAndSet(a, b));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42494a(Callable<? extends U> value) {
            try {
                U u = value.call();
                if (u != null) {
                    if (get() != 0 || !compareAndSet(0, 1)) {
                        C13273h<U> hVar = this.f40947h;
                        if (hVar == null) {
                            int i = this.f40945f;
                            if (i == Integer.MAX_VALUE) {
                                hVar = new C13706c<>(this.f40946g);
                            } else {
                                hVar = new C13705b<>(i);
                            }
                            this.f40947h = hVar;
                        }
                        if (!hVar.offer(u)) {
                            onError(new IllegalStateException("Scalar queue full?!"));
                            return;
                        } else if (getAndIncrement() != 0) {
                            return;
                        }
                    } else {
                        this.f40942c.onNext(u);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    }
                    mo42500d();
                }
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                this.f40949j.mo42733a(ex);
                mo42499c();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42493a(U value, C13465a<T, U> inner) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                C13274i<U> iVar = inner.f40938d;
                if (iVar == null) {
                    iVar = new C13706c<>(this.f40946g);
                    inner.f40938d = iVar;
                }
                iVar.offer(value);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.f40942c.onNext(value);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            mo42500d();
        }

        public void onError(Throwable t) {
            if (this.f40948i) {
                C13774a.m43836b(t);
                return;
            }
            if (this.f40949j.mo42733a(t)) {
                this.f40948i = true;
                mo42499c();
            } else {
                C13774a.m43836b(t);
            }
        }

        public void onComplete() {
            if (!this.f40948i) {
                this.f40948i = true;
                mo42499c();
            }
        }

        public void dispose() {
            if (!this.f40950k) {
                this.f40950k = true;
                if (mo42498b()) {
                    Throwable ex = this.f40949j.mo42732a();
                    if (ex != null && ex != C13748j.f41857a) {
                        C13774a.m43836b(ex);
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo42499c() {
            if (getAndIncrement() == 0) {
                mo42500d();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a9, code lost:
            if (r0 != null) goto L_0x0095;
         */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo42500d() {
            /*
                r17 = this;
                r1 = r17
                f.a.t<? super U> r2 = r1.f40942c
                r0 = 1
                r3 = r0
            L_0x0006:
                boolean r0 = r17.mo42495a()
                if (r0 == 0) goto L_0x000d
                return
            L_0x000d:
                f.a.d.c.h<U> r0 = r1.f40947h
                if (r0 == 0) goto L_0x0027
            L_0x0011:
                boolean r4 = r17.mo42495a()
                if (r4 == 0) goto L_0x0018
                return
            L_0x0018:
                java.lang.Object r4 = r0.poll()
                if (r4 != 0) goto L_0x0023
                if (r4 != 0) goto L_0x0022
                goto L_0x0027
            L_0x0022:
                goto L_0x0011
            L_0x0023:
                r2.onNext(r4)
                goto L_0x0011
            L_0x0027:
                boolean r4 = r1.f40948i
                f.a.d.c.h<U> r5 = r1.f40947h
                java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.X$a<?, ?>[]> r0 = r1.f40951l
                java.lang.Object r0 = r0.get()
                r6 = r0
                f.a.d.e.b.X$a[] r6 = (p320f.p321a.p327d.p332e.p334b.C13464X.C13465a[]) r6
                int r7 = r6.length
                if (r4 == 0) goto L_0x0055
                if (r5 == 0) goto L_0x003f
                boolean r0 = r5.isEmpty()
                if (r0 == 0) goto L_0x0055
            L_0x003f:
                if (r7 != 0) goto L_0x0055
                f.a.d.j.c r0 = r1.f40949j
                java.lang.Throwable r0 = r0.mo42732a()
                java.lang.Throwable r8 = p320f.p321a.p327d.p340j.C13748j.f41857a
                if (r0 == r8) goto L_0x0054
                if (r0 != 0) goto L_0x0051
                r2.onComplete()
                goto L_0x0054
            L_0x0051:
                r2.onError(r0)
            L_0x0054:
                return
            L_0x0055:
                r0 = 0
                if (r7 == 0) goto L_0x010b
                long r8 = r1.f40954o
                int r10 = r1.f40955p
                if (r7 <= r10) goto L_0x0066
                r11 = r6[r10]
                long r11 = r11.f40935a
                int r13 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r13 == 0) goto L_0x0087
            L_0x0066:
                if (r7 > r10) goto L_0x0069
                r10 = 0
            L_0x0069:
                r11 = r10
                r12 = 0
            L_0x006b:
                if (r12 >= r7) goto L_0x007e
                r13 = r6[r11]
                long r13 = r13.f40935a
                int r15 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
                if (r15 != 0) goto L_0x0076
                goto L_0x007e
            L_0x0076:
                int r11 = r11 + 1
                if (r11 != r7) goto L_0x007b
                r11 = 0
            L_0x007b:
                int r12 = r12 + 1
                goto L_0x006b
            L_0x007e:
                r10 = r11
                r1.f40955p = r11
                r12 = r6[r11]
                long r12 = r12.f40935a
                r1.f40954o = r12
            L_0x0087:
                r11 = r10
                r12 = 0
                r13 = r0
            L_0x008a:
                if (r12 >= r7) goto L_0x0100
                boolean r0 = r17.mo42495a()
                if (r0 == 0) goto L_0x0093
                return
            L_0x0093:
                r14 = r6[r11]
            L_0x0095:
                boolean r0 = r17.mo42495a()
                if (r0 == 0) goto L_0x009c
                return
            L_0x009c:
                f.a.d.c.i<U> r15 = r14.f40938d
                if (r15 != 0) goto L_0x00a1
                goto L_0x00ac
            L_0x00a1:
                java.lang.Object r0 = r15.poll()     // Catch:{ Throwable -> 0x00db }
                if (r0 != 0) goto L_0x00d1
                if (r0 != 0) goto L_0x00d0
            L_0x00ac:
                boolean r0 = r14.f40937c
                f.a.d.c.i<U> r15 = r14.f40938d
                if (r0 == 0) goto L_0x00c5
                if (r15 == 0) goto L_0x00ba
                boolean r16 = r15.isEmpty()
                if (r16 == 0) goto L_0x00c5
            L_0x00ba:
                r1.mo42497b(r14)
                boolean r16 = r17.mo42495a()
                if (r16 == 0) goto L_0x00c4
                return
            L_0x00c4:
                r13 = 1
            L_0x00c5:
                int r11 = r11 + 1
                if (r11 != r7) goto L_0x00cd
                r11 = 0
                r16 = r2
                goto L_0x00fb
            L_0x00cd:
                r16 = r2
                goto L_0x00fb
            L_0x00d0:
                goto L_0x0095
            L_0x00d1:
                r2.onNext(r0)
                boolean r16 = r17.mo42495a()
                if (r16 == 0) goto L_0x00a1
                return
            L_0x00db:
                r0 = move-exception
                r16 = r0
                r0 = r16
                p024io.reactivex.exceptions.C13980a.m44462b(r0)
                r14.mo42491a()
                r16 = r2
                f.a.d.j.c r2 = r1.f40949j
                r2.mo42733a(r0)
                boolean r2 = r17.mo42495a()
                if (r2 == 0) goto L_0x00f4
                return
            L_0x00f4:
                r1.mo42497b(r14)
                r2 = 1
                int r12 = r12 + 1
                r13 = r2
            L_0x00fb:
                int r12 = r12 + 1
                r2 = r16
                goto L_0x008a
            L_0x0100:
                r16 = r2
                r1.f40955p = r11
                r0 = r6[r11]
                long r14 = r0.f40935a
                r1.f40954o = r14
                goto L_0x010e
            L_0x010b:
                r16 = r2
                r13 = r0
            L_0x010e:
                if (r13 == 0) goto L_0x0136
                int r0 = r1.f40945f
                r2 = 2147483647(0x7fffffff, float:NaN)
                if (r0 == r2) goto L_0x0132
                monitor-enter(r17)
                java.util.Queue<f.a.r<? extends U>> r0 = r1.f40956q     // Catch:{ all -> 0x012f }
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x012f }
                f.a.r r0 = (p320f.p321a.C13802r) r0     // Catch:{ all -> 0x012f }
                if (r0 != 0) goto L_0x012a
                int r2 = r1.f40957r     // Catch:{ all -> 0x012f }
                int r2 = r2 + -1
                r1.f40957r = r2     // Catch:{ all -> 0x012f }
                monitor-exit(r17)     // Catch:{ all -> 0x012f }
                goto L_0x0132
            L_0x012a:
                monitor-exit(r17)     // Catch:{ all -> 0x012f }
                r1.mo42492a(r0)
                goto L_0x0132
            L_0x012f:
                r0 = move-exception
                monitor-exit(r17)     // Catch:{ all -> 0x012f }
                throw r0
            L_0x0132:
                r2 = r16
                goto L_0x0006
            L_0x0136:
                int r0 = -r3
                int r3 = r1.addAndGet(r0)
                if (r3 != 0) goto L_0x013f
                return
            L_0x013f:
                r2 = r16
                goto L_0x0006
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13464X.C13466b.mo42500d():void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42495a() {
            if (this.f40950k) {
                return true;
            }
            Throwable e = (Throwable) this.f40949j.get();
            if (this.f40944e || e == null) {
                return false;
            }
            mo42498b();
            Throwable e2 = this.f40949j.mo42732a();
            if (e2 != C13748j.f41857a) {
                this.f40942c.onError(e2);
            }
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public boolean mo42498b() {
            this.f40952m.dispose();
            InnerObserver<?, ?>[] a = (C13465a[]) this.f40951l.get();
            InnerObserver<?, ?>[] innerObserverArr = f40941b;
            if (a != innerObserverArr) {
                InnerObserver<?, ?>[] a2 = (C13465a[]) this.f40951l.getAndSet(innerObserverArr);
                if (a2 != f40941b) {
                    for (InnerObserver<?, ?> inner : a2) {
                        inner.mo42491a();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public C13464X(C13802r<T> source, C13212n<? super T, ? extends C13802r<? extends U>> mapper, boolean delayErrors, int maxConcurrency, int bufferSize) {
        super(source);
        this.f40931b = mapper;
        this.f40932c = delayErrors;
        this.f40933d = maxConcurrency;
        this.f40934e = bufferSize;
    }

    public void subscribeActual(C13804t<? super U> t) {
        if (!C13475Ya.m43450a(this.f41005a, t, this.f40931b)) {
            C13802r<T> rVar = this.f41005a;
            C13466b bVar = new C13466b(t, this.f40931b, this.f40932c, this.f40933d, this.f40934e);
            rVar.subscribe(bVar);
        }
    }
}
