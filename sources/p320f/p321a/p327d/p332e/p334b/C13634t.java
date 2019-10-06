package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableCombineLatest.CombinerObserver;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13741c;

/* renamed from: f.a.d.e.b.t */
/* compiled from: ObservableCombineLatest */
public final class C13634t<T, R> extends C13797m<R> {

    /* renamed from: a */
    final C13802r<? extends T>[] f41514a;

    /* renamed from: b */
    final Iterable<? extends C13802r<? extends T>> f41515b;

    /* renamed from: c */
    final C13212n<? super Object[], ? extends R> f41516c;

    /* renamed from: d */
    final int f41517d;

    /* renamed from: e */
    final boolean f41518e;

    /* renamed from: f.a.d.e.b.t$a */
    /* compiled from: ObservableCombineLatest */
    static final class C13635a<T, R> extends AtomicReference<C13194b> implements C13804t<T> {

        /* renamed from: a */
        final C13636b<T, R> f41519a;

        /* renamed from: b */
        final int f41520b;

        C13635a(C13636b<T, R> parent, int index) {
            this.f41519a = parent;
            this.f41520b = index;
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onNext(T t) {
            this.f41519a.mo42637a(this.f41520b, t);
        }

        public void onError(Throwable t) {
            this.f41519a.mo42638a(this.f41520b, t);
        }

        public void onComplete() {
            this.f41519a.mo42636a(this.f41520b);
        }

        /* renamed from: a */
        public void mo42634a() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    /* renamed from: f.a.d.e.b.t$b */
    /* compiled from: ObservableCombineLatest */
    static final class C13636b<T, R> extends AtomicInteger implements C13194b {

        /* renamed from: a */
        final C13804t<? super R> f41521a;

        /* renamed from: b */
        final C13212n<? super Object[], ? extends R> f41522b;

        /* renamed from: c */
        final C13635a<T, R>[] f41523c;

        /* renamed from: d */
        Object[] f41524d;

        /* renamed from: e */
        final C13706c<Object[]> f41525e;

        /* renamed from: f */
        final boolean f41526f;

        /* renamed from: g */
        volatile boolean f41527g;

        /* renamed from: h */
        volatile boolean f41528h;

        /* renamed from: i */
        final C13741c f41529i = new C13741c();

        /* renamed from: j */
        int f41530j;

        /* renamed from: k */
        int f41531k;

        C13636b(C13804t<? super R> actual, C13212n<? super Object[], ? extends R> combiner, int count, int bufferSize, boolean delayError) {
            this.f41521a = actual;
            this.f41522b = combiner;
            this.f41526f = delayError;
            this.f41524d = new Object[count];
            CombinerObserver<T, R>[] as = new C13635a[count];
            for (int i = 0; i < count; i++) {
                as[i] = new C13635a<>(this, i);
            }
            this.f41523c = as;
            this.f41525e = new C13706c<>(bufferSize);
        }

        /* renamed from: a */
        public void mo42640a(C13802r<? extends T>[] sources) {
            Observer<T>[] as = this.f41523c;
            int len = as.length;
            this.f41521a.onSubscribe(this);
            for (int i = 0; i < len && !this.f41528h && !this.f41527g; i++) {
                sources[i].subscribe(as[i]);
            }
        }

        public void dispose() {
            if (!this.f41527g) {
                this.f41527g = true;
                mo42635a();
                if (getAndIncrement() == 0) {
                    mo42639a(this.f41525e);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42635a() {
            for (CombinerObserver<T, R> s : this.f41523c) {
                s.mo42634a();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42639a(C13706c<?> q) {
            synchronized (this) {
                this.f41524d = null;
            }
            q.clear();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42641b() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object[]> q = this.f41525e;
                Observer<? super R> a = this.f41521a;
                boolean delayError = this.f41526f;
                int missed = 1;
                while (!this.f41527g) {
                    if (delayError || this.f41529i.get() == null) {
                        boolean d = this.f41528h;
                        Object[] s = (Object[]) q.poll();
                        boolean empty = s == null;
                        if (d && empty) {
                            mo42639a((C13706c<?>) q);
                            Throwable ex = this.f41529i.mo42732a();
                            if (ex == null) {
                                a.onComplete();
                            } else {
                                a.onError(ex);
                            }
                            return;
                        } else if (empty) {
                            missed = addAndGet(-missed);
                            if (missed == 0) {
                                return;
                            }
                        } else {
                            try {
                                R v = this.f41522b.apply(s);
                                C13264b.m43226a(v, "The combiner returned a null value");
                                a.onNext(v);
                            } catch (Throwable ex2) {
                                C13980a.m44462b(ex2);
                                this.f41529i.mo42733a(ex2);
                                mo42635a();
                                mo42639a((C13706c<?>) q);
                                a.onError(this.f41529i.mo42732a());
                                return;
                            }
                        }
                    } else {
                        mo42635a();
                        mo42639a((C13706c<?>) q);
                        a.onError(this.f41529i.mo42732a());
                        return;
                    }
                }
                mo42639a((C13706c<?>) q);
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (r0 == false) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            mo42641b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo42637a(int r7, T r8) {
            /*
                r6 = this;
                r0 = 0
                monitor-enter(r6)
                java.lang.Object[] r1 = r6.f41524d     // Catch:{ all -> 0x0028 }
                if (r1 != 0) goto L_0x0008
                monitor-exit(r6)     // Catch:{ all -> 0x0028 }
                return
            L_0x0008:
                r2 = r1[r7]     // Catch:{ all -> 0x0028 }
                int r3 = r6.f41530j     // Catch:{ all -> 0x0028 }
                if (r2 != 0) goto L_0x0012
                int r3 = r3 + 1
                r6.f41530j = r3     // Catch:{ all -> 0x0028 }
            L_0x0012:
                r1[r7] = r8     // Catch:{ all -> 0x0028 }
                int r4 = r1.length     // Catch:{ all -> 0x0028 }
                if (r3 != r4) goto L_0x0021
                f.a.d.f.c<java.lang.Object[]> r4 = r6.f41525e     // Catch:{ all -> 0x0028 }
                java.lang.Object r5 = r1.clone()     // Catch:{ all -> 0x0028 }
                r4.offer(r5)     // Catch:{ all -> 0x0028 }
                r0 = 1
            L_0x0021:
                monitor-exit(r6)     // Catch:{ all -> 0x0028 }
                if (r0 == 0) goto L_0x0027
                r6.mo42641b()
            L_0x0027:
                return
            L_0x0028:
                r1 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13634t.C13636b.mo42637a(int, java.lang.Object):void");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
            if (r2 == r1.length) goto L_0x0027;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo42638a(int r6, java.lang.Throwable r7) {
            /*
                r5 = this;
                f.a.d.j.c r0 = r5.f41529i
                boolean r0 = r0.mo42733a(r7)
                if (r0 == 0) goto L_0x0037
                r0 = 1
                boolean r1 = r5.f41526f
                if (r1 == 0) goto L_0x002e
                monitor-enter(r5)
                java.lang.Object[] r1 = r5.f41524d     // Catch:{ all -> 0x002b }
                if (r1 != 0) goto L_0x0014
                monitor-exit(r5)     // Catch:{ all -> 0x002b }
                return
            L_0x0014:
                r2 = r1[r6]     // Catch:{ all -> 0x002b }
                r3 = 1
                if (r2 != 0) goto L_0x001b
                r2 = 1
                goto L_0x001c
            L_0x001b:
                r2 = 0
            L_0x001c:
                r0 = r2
                if (r0 != 0) goto L_0x0027
                int r2 = r5.f41531k     // Catch:{ all -> 0x002b }
                int r2 = r2 + r3
                r5.f41531k = r2     // Catch:{ all -> 0x002b }
                int r4 = r1.length     // Catch:{ all -> 0x002b }
                if (r2 != r4) goto L_0x0029
            L_0x0027:
                r5.f41528h = r3     // Catch:{ all -> 0x002b }
            L_0x0029:
                monitor-exit(r5)     // Catch:{ all -> 0x002b }
                goto L_0x002e
            L_0x002b:
                r1 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x002b }
                throw r1
            L_0x002e:
                if (r0 == 0) goto L_0x0033
                r5.mo42635a()
            L_0x0033:
                r5.mo42641b()
                goto L_0x003a
            L_0x0037:
                p320f.p321a.p343g.C13774a.m43836b(r7)
            L_0x003a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13634t.C13636b.mo42638a(int, java.lang.Throwable):void");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
            if (r2 == r1.length) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
            if (r0 == false) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0020, code lost:
            mo42635a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
            mo42641b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0026, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo42636a(int r6) {
            /*
                r5 = this;
                r0 = 0
                monitor-enter(r5)
                java.lang.Object[] r1 = r5.f41524d     // Catch:{ all -> 0x0027 }
                if (r1 != 0) goto L_0x0008
                monitor-exit(r5)     // Catch:{ all -> 0x0027 }
                return
            L_0x0008:
                r2 = r1[r6]     // Catch:{ all -> 0x0027 }
                r3 = 1
                if (r2 != 0) goto L_0x000f
                r2 = 1
                goto L_0x0010
            L_0x000f:
                r2 = 0
            L_0x0010:
                r0 = r2
                if (r0 != 0) goto L_0x001b
                int r2 = r5.f41531k     // Catch:{ all -> 0x0027 }
                int r2 = r2 + r3
                r5.f41531k = r2     // Catch:{ all -> 0x0027 }
                int r4 = r1.length     // Catch:{ all -> 0x0027 }
                if (r2 != r4) goto L_0x001d
            L_0x001b:
                r5.f41528h = r3     // Catch:{ all -> 0x0027 }
            L_0x001d:
                monitor-exit(r5)     // Catch:{ all -> 0x0027 }
                if (r0 == 0) goto L_0x0023
                r5.mo42635a()
            L_0x0023:
                r5.mo42641b()
                return
            L_0x0027:
                r1 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0027 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13634t.C13636b.mo42636a(int):void");
        }
    }

    public C13634t(C13802r<? extends T>[] sources, Iterable<? extends C13802r<? extends T>> sourcesIterable, C13212n<? super Object[], ? extends R> combiner, int bufferSize, boolean delayError) {
        this.f41514a = sources;
        this.f41515b = sourcesIterable;
        this.f41516c = combiner;
        this.f41517d = bufferSize;
        this.f41518e = delayError;
    }

    public void subscribeActual(C13804t<? super R> s) {
        C13802r<? extends T>[] rVarArr = this.f41514a;
        int count = 0;
        if (rVarArr == null) {
            rVarArr = new C13797m[8];
            Iterator it = this.f41515b.iterator();
            while (it.hasNext()) {
                ObservableSource<? extends T> p = (C13802r) it.next();
                if (count == rVarArr.length) {
                    C13802r<? extends T>[] rVarArr2 = new C13802r[((count >> 2) + count)];
                    System.arraycopy(rVarArr, 0, rVarArr2, 0, count);
                    rVarArr = rVarArr2;
                }
                int count2 = count + 1;
                rVarArr[count] = p;
                count = count2;
            }
        } else {
            count = rVarArr.length;
        }
        if (count == 0) {
            C13219d.m43156a(s);
            return;
        }
        C13636b bVar = new C13636b(s, this.f41516c, count, this.f41517d, this.f41518e);
        bVar.mo42640a(rVarArr);
    }
}
