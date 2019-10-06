package p320f.p321a.p327d.p332e.p334b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13805u.C13808c;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p331d.C13291q;
import p320f.p321a.p327d.p336f.C13703a;
import p320f.p321a.p327d.p340j.C13759r;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.p */
/* compiled from: ObservableBufferTimed */
public final class C13589p<T, U extends Collection<? super T>> extends C13485a<T, U> {

    /* renamed from: b */
    final long f41354b;

    /* renamed from: c */
    final long f41355c;

    /* renamed from: d */
    final TimeUnit f41356d;

    /* renamed from: e */
    final C13805u f41357e;

    /* renamed from: f */
    final Callable<U> f41358f;

    /* renamed from: g */
    final int f41359g;

    /* renamed from: h */
    final boolean f41360h;

    /* renamed from: f.a.d.e.b.p$a */
    /* compiled from: ObservableBufferTimed */
    static final class C13590a<T, U extends Collection<? super T>> extends C13291q<T, U, U> implements Runnable, C13194b {

        /* renamed from: g */
        final Callable<U> f41361g;

        /* renamed from: h */
        final long f41362h;

        /* renamed from: i */
        final TimeUnit f41363i;

        /* renamed from: j */
        final int f41364j;

        /* renamed from: k */
        final boolean f41365k;

        /* renamed from: l */
        final C13808c f41366l;

        /* renamed from: m */
        U f41367m;

        /* renamed from: n */
        C13194b f41368n;

        /* renamed from: o */
        C13194b f41369o;

        /* renamed from: p */
        long f41370p;

        /* renamed from: q */
        long f41371q;

        C13590a(C13804t<? super U> actual, Callable<U> bufferSupplier, long timespan, TimeUnit unit, int maxSize, boolean restartOnMaxSize, C13808c w) {
            super(actual, new C13703a());
            this.f41361g = bufferSupplier;
            this.f41362h = timespan;
            this.f41363i = unit;
            this.f41364j = maxSize;
            this.f41365k = restartOnMaxSize;
            this.f41366l = w;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41369o, s)) {
                this.f41369o = s;
                try {
                    U call = this.f41361g.call();
                    C13264b.m43226a(call, "The buffer supplied is null");
                    this.f41367m = (Collection) call;
                    this.f40393b.onSubscribe(this);
                    C13808c cVar = this.f41366l;
                    long j = this.f41362h;
                    this.f41368n = cVar.mo43151a(this, j, j, this.f41363i);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    s.dispose();
                    C13219d.m43157a(e, this.f40393b);
                    this.f41366l.dispose();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
            if (r9.f41365k == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            r9.f41368n.dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
            mo42346b(r0, false, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            r1 = r9.f41361g.call();
            p320f.p321a.p327d.p329b.C13264b.m43226a(r1, "The buffer supplied is null");
            r1 = (java.util.Collection) r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
            monitor-enter(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r9.f41367m = r1;
            r9.f41371q++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
            monitor-exit(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (r9.f41365k == false) goto L_0x0055;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            r2 = r9.f41366l;
            r6 = r9.f41362h;
            r9.f41368n = r2.mo43151a(r9, r6, r6, r9.f41363i);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
            p024io.reactivex.exceptions.C13980a.m44462b(r1);
            r9.f40393b.onError(r1);
            dispose();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r10) {
            /*
                r9 = this;
                monitor-enter(r9)
                U r0 = r9.f41367m     // Catch:{ all -> 0x0066 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r9)     // Catch:{ all -> 0x0066 }
                return
            L_0x0007:
                r0.add(r10)     // Catch:{ all -> 0x0066 }
                int r1 = r0.size()     // Catch:{ all -> 0x0066 }
                int r2 = r9.f41364j     // Catch:{ all -> 0x0066 }
                if (r1 >= r2) goto L_0x0014
                monitor-exit(r9)     // Catch:{ all -> 0x0066 }
                return
            L_0x0014:
                r1 = 0
                r9.f41367m = r1     // Catch:{ all -> 0x0066 }
                long r1 = r9.f41370p     // Catch:{ all -> 0x0066 }
                r3 = 1
                long r1 = r1 + r3
                r9.f41370p = r1     // Catch:{ all -> 0x0066 }
                monitor-exit(r9)     // Catch:{ all -> 0x0066 }
                boolean r1 = r9.f41365k
                if (r1 == 0) goto L_0x0028
                f.a.b.b r1 = r9.f41368n
                r1.dispose()
            L_0x0028:
                r1 = 0
                r9.mo42346b(r0, r1, r9)
                java.util.concurrent.Callable<U> r1 = r9.f41361g     // Catch:{ Throwable -> 0x0059 }
                java.lang.Object r1 = r1.call()     // Catch:{ Throwable -> 0x0059 }
                java.lang.String r2 = "The buffer supplied is null"
                p320f.p321a.p327d.p329b.C13264b.m43226a(r1, r2)     // Catch:{ Throwable -> 0x0059 }
                java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ Throwable -> 0x0059 }
                monitor-enter(r9)
                r9.f41367m = r1     // Catch:{ all -> 0x0056 }
                long r5 = r9.f41371q     // Catch:{ all -> 0x0056 }
                long r5 = r5 + r3
                r9.f41371q = r5     // Catch:{ all -> 0x0056 }
                monitor-exit(r9)     // Catch:{ all -> 0x0056 }
                boolean r0 = r9.f41365k
                if (r0 == 0) goto L_0x0055
                f.a.u$c r2 = r9.f41366l
                long r6 = r9.f41362h
                java.util.concurrent.TimeUnit r8 = r9.f41363i
                r3 = r9
                r4 = r6
                f.a.b.b r0 = r2.mo43151a(r3, r4, r6, r8)
                r9.f41368n = r0
            L_0x0055:
                return
            L_0x0056:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0056 }
                throw r0
            L_0x0059:
                r1 = move-exception
                p024io.reactivex.exceptions.C13980a.m44462b(r1)
                f.a.t<? super V> r2 = r9.f40393b
                r2.onError(r1)
                r9.dispose()
                return
            L_0x0066:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0066 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13589p.C13590a.onNext(java.lang.Object):void");
        }

        public void onError(Throwable t) {
            synchronized (this) {
                this.f41367m = null;
            }
            this.f40393b.onError(t);
            this.f41366l.dispose();
        }

        public void onComplete() {
            U b;
            this.f41366l.dispose();
            synchronized (this) {
                b = this.f41367m;
                this.f41367m = null;
            }
            this.f40394c.offer(b);
            this.f40396e = true;
            if (mo42347b()) {
                C13759r.m43798a(this.f40394c, this.f40393b, false, this, this);
            }
        }

        /* renamed from: a */
        public void mo42343a(C13804t<? super U> a, U v) {
            a.onNext(v);
        }

        public void dispose() {
            if (!this.f40395d) {
                this.f40395d = true;
                this.f41369o.dispose();
                this.f41366l.dispose();
                synchronized (this) {
                    this.f41367m = null;
                }
            }
        }

        public void run() {
            try {
                U call = this.f41361g.call();
                C13264b.m43226a(call, "The bufferSupplier returned a null buffer");
                U next = (Collection) call;
                synchronized (this) {
                    U current = this.f41367m;
                    if (current != null) {
                        if (this.f41370p == this.f41371q) {
                            this.f41367m = next;
                            mo42346b(current, false, this);
                        }
                    }
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                dispose();
                this.f40393b.onError(e);
            }
        }
    }

    /* renamed from: f.a.d.e.b.p$b */
    /* compiled from: ObservableBufferTimed */
    static final class C13591b<T, U extends Collection<? super T>> extends C13291q<T, U, U> implements Runnable, C13194b {

        /* renamed from: g */
        final Callable<U> f41372g;

        /* renamed from: h */
        final long f41373h;

        /* renamed from: i */
        final TimeUnit f41374i;

        /* renamed from: j */
        final C13805u f41375j;

        /* renamed from: k */
        C13194b f41376k;

        /* renamed from: l */
        U f41377l;

        /* renamed from: m */
        final AtomicReference<C13194b> f41378m = new AtomicReference<>();

        C13591b(C13804t<? super U> actual, Callable<U> bufferSupplier, long timespan, TimeUnit unit, C13805u scheduler) {
            super(actual, new C13703a());
            this.f41372g = bufferSupplier;
            this.f41373h = timespan;
            this.f41374i = unit;
            this.f41375j = scheduler;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41376k, s)) {
                this.f41376k = s;
                try {
                    U call = this.f41372g.call();
                    C13264b.m43226a(call, "The buffer supplied is null");
                    this.f41377l = (Collection) call;
                    this.f40393b.onSubscribe(this);
                    if (!this.f40395d) {
                        C13805u uVar = this.f41375j;
                        long j = this.f41373h;
                        C13194b d = uVar.mo42692a(this, j, j, this.f41374i);
                        if (!this.f41378m.compareAndSet(null, d)) {
                            d.dispose();
                        }
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    dispose();
                    C13219d.m43157a(e, this.f40393b);
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                U b = this.f41377l;
                if (b != null) {
                    b.add(t);
                }
            }
        }

        public void onError(Throwable t) {
            synchronized (this) {
                this.f41377l = null;
            }
            this.f40393b.onError(t);
            C13218c.m43150a(this.f41378m);
        }

        public void onComplete() {
            U b;
            synchronized (this) {
                b = this.f41377l;
                this.f41377l = null;
            }
            if (b != null) {
                this.f40394c.offer(b);
                this.f40396e = true;
                if (mo42347b()) {
                    C13759r.m43798a(this.f40394c, this.f40393b, false, null, this);
                }
            }
            C13218c.m43150a(this.f41378m);
        }

        public void dispose() {
            C13218c.m43150a(this.f41378m);
            this.f41376k.dispose();
        }

        public void run() {
            U current;
            try {
                U call = this.f41372g.call();
                C13264b.m43226a(call, "The bufferSupplier returned a null buffer");
                U next = (Collection) call;
                synchronized (this) {
                    current = this.f41377l;
                    if (current != null) {
                        this.f41377l = next;
                    }
                }
                if (current == null) {
                    C13218c.m43150a(this.f41378m);
                } else {
                    mo42344a(current, false, this);
                }
            } catch (Throwable e) {
                C13980a.m44462b(e);
                this.f40393b.onError(e);
                dispose();
            }
        }

        /* renamed from: a */
        public void mo42343a(C13804t<? super U> tVar, U v) {
            this.f40393b.onNext(v);
        }
    }

    /* renamed from: f.a.d.e.b.p$c */
    /* compiled from: ObservableBufferTimed */
    static final class C13592c<T, U extends Collection<? super T>> extends C13291q<T, U, U> implements Runnable, C13194b {

        /* renamed from: g */
        final Callable<U> f41379g;

        /* renamed from: h */
        final long f41380h;

        /* renamed from: i */
        final long f41381i;

        /* renamed from: j */
        final TimeUnit f41382j;

        /* renamed from: k */
        final C13808c f41383k;

        /* renamed from: l */
        final List<U> f41384l = new LinkedList();

        /* renamed from: m */
        C13194b f41385m;

        /* renamed from: f.a.d.e.b.p$c$a */
        /* compiled from: ObservableBufferTimed */
        final class C13593a implements Runnable {

            /* renamed from: a */
            private final U f41386a;

            C13593a(U b) {
                this.f41386a = b;
            }

            public void run() {
                synchronized (C13592c.this) {
                    C13592c.this.f41384l.remove(this.f41386a);
                }
                C13592c cVar = C13592c.this;
                cVar.mo42346b(this.f41386a, false, cVar.f41383k);
            }
        }

        /* renamed from: f.a.d.e.b.p$c$b */
        /* compiled from: ObservableBufferTimed */
        final class C13594b implements Runnable {

            /* renamed from: a */
            private final U f41388a;

            C13594b(U buffer) {
                this.f41388a = buffer;
            }

            public void run() {
                synchronized (C13592c.this) {
                    C13592c.this.f41384l.remove(this.f41388a);
                }
                C13592c cVar = C13592c.this;
                cVar.mo42346b(this.f41388a, false, cVar.f41383k);
            }
        }

        C13592c(C13804t<? super U> actual, Callable<U> bufferSupplier, long timespan, long timeskip, TimeUnit unit, C13808c w) {
            super(actual, new C13703a());
            this.f41379g = bufferSupplier;
            this.f41380h = timespan;
            this.f41381i = timeskip;
            this.f41382j = unit;
            this.f41383k = w;
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41385m, s)) {
                this.f41385m = s;
                try {
                    U call = this.f41379g.call();
                    C13264b.m43226a(call, "The buffer supplied is null");
                    U b = (Collection) call;
                    this.f41384l.add(b);
                    this.f40393b.onSubscribe(this);
                    C13808c cVar = this.f41383k;
                    long j = this.f41381i;
                    cVar.mo43151a(this, j, j, this.f41382j);
                    this.f41383k.mo42243a(new C13594b(b), this.f41380h, this.f41382j);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    s.dispose();
                    C13219d.m43157a(e, this.f40393b);
                    this.f41383k.dispose();
                }
            }
        }

        public void onNext(T t) {
            synchronized (this) {
                for (U b : this.f41384l) {
                    b.add(t);
                }
            }
        }

        public void onError(Throwable t) {
            this.f40396e = true;
            mo42606d();
            this.f40393b.onError(t);
            this.f41383k.dispose();
        }

        public void onComplete() {
            List<U> bs;
            synchronized (this) {
                bs = new ArrayList<>(this.f41384l);
                this.f41384l.clear();
            }
            for (U b : bs) {
                this.f40394c.offer(b);
            }
            this.f40396e = true;
            if (mo42347b()) {
                C13759r.m43798a(this.f40394c, this.f40393b, false, this.f41383k, this);
            }
        }

        public void dispose() {
            if (!this.f40395d) {
                this.f40395d = true;
                mo42606d();
                this.f41385m.dispose();
                this.f41383k.dispose();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: d */
        public void mo42606d() {
            synchronized (this) {
                this.f41384l.clear();
            }
        }

        public void run() {
            if (!this.f40395d) {
                try {
                    U call = this.f41379g.call();
                    C13264b.m43226a(call, "The bufferSupplier returned a null buffer");
                    U b = (Collection) call;
                    synchronized (this) {
                        if (!this.f40395d) {
                            this.f41384l.add(b);
                            this.f41383k.mo42243a(new C13593a(b), this.f41380h, this.f41382j);
                        }
                    }
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f40393b.onError(e);
                    dispose();
                }
            }
        }

        /* renamed from: a */
        public void mo42343a(C13804t<? super U> a, U v) {
            a.onNext(v);
        }
    }

    public C13589p(C13802r<T> source, long timespan, long timeskip, TimeUnit unit, C13805u scheduler, Callable<U> bufferSupplier, int maxSize, boolean restartTimerOnMaxSize) {
        super(source);
        this.f41354b = timespan;
        this.f41355c = timeskip;
        this.f41356d = unit;
        this.f41357e = scheduler;
        this.f41358f = bufferSupplier;
        this.f41359g = maxSize;
        this.f41360h = restartTimerOnMaxSize;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super U> t) {
        if (this.f41354b == this.f41355c && this.f41359g == Integer.MAX_VALUE) {
            C13802r<T> rVar = this.f41005a;
            C13591b bVar = new C13591b(new C13770f(t), this.f41358f, this.f41354b, this.f41356d, this.f41357e);
            rVar.subscribe(bVar);
            return;
        }
        C13808c w = this.f41357e.mo42242a();
        if (this.f41354b == this.f41355c) {
            C13802r<T> rVar2 = this.f41005a;
            C13590a aVar = new C13590a(new C13770f(t), this.f41358f, this.f41354b, this.f41356d, this.f41359g, this.f41360h, w);
            rVar2.subscribe(aVar);
            return;
        }
        C13802r<T> rVar3 = this.f41005a;
        C13592c cVar = new C13592c(new C13770f(t), this.f41358f, this.f41354b, this.f41355c, this.f41356d, w);
        rVar3.subscribe(cVar);
    }
}
