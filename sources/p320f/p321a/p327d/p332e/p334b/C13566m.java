package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferBoundaryObserver.BufferOpenObserver;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary.BufferCloseObserver;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
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

/* renamed from: f.a.d.e.b.m */
/* compiled from: ObservableBufferBoundary */
public final class C13566m<T, U extends Collection<? super T>, Open, Close> extends C13485a<T, U> {

    /* renamed from: b */
    final Callable<U> f41284b;

    /* renamed from: c */
    final C13802r<? extends Open> f41285c;

    /* renamed from: d */
    final C13212n<? super Open, ? extends C13802r<? extends Close>> f41286d;

    /* renamed from: f.a.d.e.b.m$a */
    /* compiled from: ObservableBufferBoundary */
    static final class C13567a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        final C13804t<? super C> f41287a;

        /* renamed from: b */
        final Callable<C> f41288b;

        /* renamed from: c */
        final C13802r<? extends Open> f41289c;

        /* renamed from: d */
        final C13212n<? super Open, ? extends C13802r<? extends Close>> f41290d;

        /* renamed from: e */
        final C13193a f41291e = new C13193a();

        /* renamed from: f */
        final AtomicReference<C13194b> f41292f = new AtomicReference<>();

        /* renamed from: g */
        final C13741c f41293g = new C13741c();

        /* renamed from: h */
        volatile boolean f41294h;

        /* renamed from: i */
        final C13706c<C> f41295i = new C13706c<>(C13797m.bufferSize());

        /* renamed from: j */
        volatile boolean f41296j;

        /* renamed from: k */
        long f41297k;

        /* renamed from: l */
        Map<Long, C> f41298l = new LinkedHashMap();

        /* renamed from: f.a.d.e.b.m$a$a */
        /* compiled from: ObservableBufferBoundary */
        static final class C13568a<Open> extends AtomicReference<C13194b> implements C13804t<Open>, C13194b {

            /* renamed from: a */
            final C13567a<?, ?, Open, ?> f41299a;

            C13568a(C13567a<?, ?, Open, ?> parent) {
                this.f41299a = parent;
            }

            public void onSubscribe(C13194b s) {
                C13218c.m43153c(this, s);
            }

            public void onNext(Open t) {
                this.f41299a.mo42591a(t);
            }

            public void onError(Throwable t) {
                lazySet(C13218c.DISPOSED);
                this.f41299a.mo42588a((C13194b) this, t);
            }

            public void onComplete() {
                lazySet(C13218c.DISPOSED);
                this.f41299a.mo42589a(this);
            }

            public void dispose() {
                C13218c.m43150a((AtomicReference<C13194b>) this);
            }
        }

        C13567a(C13804t<? super C> actual, C13802r<? extends Open> bufferOpen, C13212n<? super Open, ? extends C13802r<? extends Close>> bufferClose, Callable<C> bufferSupplier) {
            this.f41287a = actual;
            this.f41288b = bufferSupplier;
            this.f41289c = bufferOpen;
            this.f41290d = bufferClose;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43153c(this.f41292f, s)) {
                BufferOpenObserver<Open> open = new C13568a<>(this);
                this.f41291e.mo42252b(open);
                this.f41289c.subscribe(open);
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                Map<Long, C> bufs = this.f41298l;
                if (bufs != null) {
                    for (C b : bufs.values()) {
                        b.add(t);
                    }
                }
            }
        }

        public void onError(Throwable t) {
            if (this.f41293g.mo42733a(t)) {
                this.f41291e.dispose();
                synchronized (this) {
                    this.f41298l = null;
                }
                this.f41294h = true;
                mo42587a();
                return;
            }
            C13774a.m43836b(t);
        }

        public void onComplete() {
            this.f41291e.dispose();
            synchronized (this) {
                Map<Long, C> bufs = this.f41298l;
                if (bufs != null) {
                    for (C b : bufs.values()) {
                        this.f41295i.offer(b);
                    }
                    this.f41298l = null;
                    this.f41294h = true;
                    mo42587a();
                }
            }
        }

        public void dispose() {
            if (C13218c.m43150a(this.f41292f)) {
                this.f41296j = true;
                this.f41291e.dispose();
                synchronized (this) {
                    this.f41298l = null;
                }
                if (getAndIncrement() != 0) {
                    this.f41295i.clear();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42591a(Open token) {
            try {
                C call = this.f41288b.call();
                C13264b.m43226a(call, "The bufferSupplier returned a null Collection");
                C buf = (Collection) call;
                Object apply = this.f41290d.apply(token);
                C13264b.m43226a(apply, "The bufferClose returned a null ObservableSource");
                ObservableSource<? extends Close> p = (C13802r) apply;
                long idx = this.f41297k;
                this.f41297k = 1 + idx;
                synchronized (this) {
                    Map<Long, C> bufs = this.f41298l;
                    if (bufs != null) {
                        bufs.put(Long.valueOf(idx), buf);
                        BufferCloseObserver<T, C> bc = new C13569b<>(this, idx);
                        this.f41291e.mo42252b(bc);
                        p.subscribe(bc);
                    }
                }
            } catch (Throwable ex) {
                C13980a.m44462b(ex);
                C13218c.m43150a(this.f41292f);
                onError(ex);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42589a(C13568a<Open> os) {
            this.f41291e.mo42253c(os);
            if (this.f41291e.mo42251b() == 0) {
                C13218c.m43150a(this.f41292f);
                this.f41294h = true;
                mo42587a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (r0 == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
            r5.f41294h = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
            mo42587a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo42590a(p320f.p321a.p327d.p332e.p334b.C13566m.C13569b<T, C> r6, long r7) {
            /*
                r5 = this;
                f.a.b.a r0 = r5.f41291e
                r0.mo42253c(r6)
                r0 = 0
                f.a.b.a r1 = r5.f41291e
                int r1 = r1.mo42251b()
                if (r1 != 0) goto L_0x0014
                r0 = 1
                java.util.concurrent.atomic.AtomicReference<f.a.b.b> r1 = r5.f41292f
                p320f.p321a.p327d.p328a.C13218c.m43150a(r1)
            L_0x0014:
                monitor-enter(r5)
                java.util.Map<java.lang.Long, C> r1 = r5.f41298l     // Catch:{ all -> 0x0035 }
                if (r1 != 0) goto L_0x001b
                monitor-exit(r5)     // Catch:{ all -> 0x0035 }
                return
            L_0x001b:
                f.a.d.f.c<C> r2 = r5.f41295i     // Catch:{ all -> 0x0035 }
                java.util.Map<java.lang.Long, C> r3 = r5.f41298l     // Catch:{ all -> 0x0035 }
                java.lang.Long r4 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0035 }
                java.lang.Object r3 = r3.remove(r4)     // Catch:{ all -> 0x0035 }
                r2.offer(r3)     // Catch:{ all -> 0x0035 }
                monitor-exit(r5)     // Catch:{ all -> 0x0035 }
                if (r0 == 0) goto L_0x0031
                r1 = 1
                r5.f41294h = r1
            L_0x0031:
                r5.mo42587a()
                return
            L_0x0035:
                r1 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0035 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13566m.C13567a.mo42590a(f.a.d.e.b.m$b, long):void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42588a(C13194b observer, Throwable ex) {
            C13218c.m43150a(this.f41292f);
            this.f41291e.mo42253c(observer);
            onError(ex);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42587a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                Observer<? super C> a = this.f41287a;
                SpscLinkedArrayQueue<C> q = this.f41295i;
                while (!this.f41296j) {
                    boolean d = this.f41294h;
                    if (!d || this.f41293g.get() == null) {
                        C v = (Collection) q.poll();
                        boolean empty = v == null;
                        if (d && empty) {
                            a.onComplete();
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
                        q.clear();
                        a.onError(this.f41293g.mo42732a());
                        return;
                    }
                }
                q.clear();
            }
        }
    }

    /* renamed from: f.a.d.e.b.m$b */
    /* compiled from: ObservableBufferBoundary */
    static final class C13569b<T, C extends Collection<? super T>> extends AtomicReference<C13194b> implements C13804t<Object>, C13194b {

        /* renamed from: a */
        final C13567a<T, C, ?, ?> f41300a;

        /* renamed from: b */
        final long f41301b;

        C13569b(C13567a<T, C, ?, ?> parent, long index) {
            this.f41300a = parent;
            this.f41301b = index;
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onNext(Object t) {
            C13194b s = (C13194b) get();
            C13218c cVar = C13218c.DISPOSED;
            if (s != cVar) {
                lazySet(cVar);
                s.dispose();
                this.f41300a.mo42590a(this, this.f41301b);
            }
        }

        public void onError(Throwable t) {
            Object obj = get();
            C13218c cVar = C13218c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f41300a.mo42588a((C13194b) this, t);
                return;
            }
            C13774a.m43836b(t);
        }

        public void onComplete() {
            Object obj = get();
            C13218c cVar = C13218c.DISPOSED;
            if (obj != cVar) {
                lazySet(cVar);
                this.f41300a.mo42590a(this, this.f41301b);
            }
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13566m(C13802r<T> source, C13802r<? extends Open> bufferOpen, C13212n<? super Open, ? extends C13802r<? extends Close>> bufferClose, Callable<U> bufferSupplier) {
        super(source);
        this.f41285c = bufferOpen;
        this.f41286d = bufferClose;
        this.f41284b = bufferSupplier;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super U> t) {
        BufferBoundaryObserver<T, U, Open, Close> parent = new C13567a<>(t, this.f41285c, this.f41286d, this.f41284b);
        t.onSubscribe(parent);
        this.f41005a.subscribe(parent);
    }
}
