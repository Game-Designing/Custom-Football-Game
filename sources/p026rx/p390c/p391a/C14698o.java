package p026rx.p390c.p391a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.CompositeException;
import p026rx.p027b.C14545u;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.p396a.C14830g;
import p026rx.p400f.C14948s;
import rx.Observable;
import rx.Subscriber;
import rx.internal.operators.OnSubscribeCombineLatest.CombinerSubscriber;

/* renamed from: rx.c.a.o */
/* compiled from: OnSubscribeCombineLatest */
public final class C14698o<T, R> implements C0122a<R> {

    /* renamed from: a */
    final C0120S<? extends T>[] f43730a;

    /* renamed from: b */
    final Iterable<? extends C0120S<? extends T>> f43731b;

    /* renamed from: c */
    final C14545u<? extends R> f43732c;

    /* renamed from: d */
    final int f43733d;

    /* renamed from: e */
    final boolean f43734e;

    /* renamed from: rx.c.a.o$a */
    /* compiled from: OnSubscribeCombineLatest */
    static final class C14699a<T, R> extends C14980ia<T> {

        /* renamed from: a */
        final C14700b<T, R> f43735a;

        /* renamed from: b */
        final int f43736b;

        /* renamed from: c */
        boolean f43737c;

        public C14699a(C14700b<T, R> parent, int index) {
            this.f43735a = parent;
            this.f43736b = index;
            request((long) parent.f43742e);
        }

        public void onNext(T t) {
            if (!this.f43737c) {
                this.f43735a.mo45840a(C14689m.m46326d(t), this.f43736b);
            }
        }

        public void onError(Throwable t) {
            if (this.f43737c) {
                C14948s.m46719b(t);
                return;
            }
            this.f43735a.mo45841a(t);
            this.f43737c = true;
            this.f43735a.mo45840a(null, this.f43736b);
        }

        public void onCompleted() {
            if (!this.f43737c) {
                this.f43737c = true;
                this.f43735a.mo45840a(null, this.f43736b);
            }
        }

        /* renamed from: a */
        public void mo45838a(long n) {
            request(n);
        }
    }

    /* renamed from: rx.c.a.o$b */
    /* compiled from: OnSubscribeCombineLatest */
    static final class C14700b<T, R> extends AtomicInteger implements C14508U, C0137ja {

        /* renamed from: a */
        static final Object f43738a = new Object();

        /* renamed from: b */
        final C14980ia<? super R> f43739b;

        /* renamed from: c */
        final C14545u<? extends R> f43740c;

        /* renamed from: d */
        final C14699a<T, R>[] f43741d;

        /* renamed from: e */
        final int f43742e;

        /* renamed from: f */
        final Object[] f43743f;

        /* renamed from: g */
        final C14830g<Object> f43744g;

        /* renamed from: h */
        final boolean f43745h;

        /* renamed from: i */
        volatile boolean f43746i;

        /* renamed from: j */
        volatile boolean f43747j;

        /* renamed from: k */
        final AtomicLong f43748k = new AtomicLong();

        /* renamed from: l */
        final AtomicReference<Throwable> f43749l = new AtomicReference<>();

        /* renamed from: m */
        int f43750m;

        /* renamed from: n */
        int f43751n;

        public C14700b(C14980ia<? super R> actual, C14545u<? extends R> combiner, int count, int bufferSize, boolean delayError) {
            this.f43739b = actual;
            this.f43740c = combiner;
            this.f43742e = bufferSize;
            this.f43745h = delayError;
            this.f43743f = new Object[count];
            Arrays.fill(this.f43743f, f43738a);
            this.f43741d = new C14699a[count];
            this.f43744g = new C14830g<>(bufferSize);
        }

        /* renamed from: a */
        public void mo45843a(C0120S<? extends T>[] sources) {
            Subscriber<T>[] as = this.f43741d;
            int len = as.length;
            for (int i = 0; i < len; i++) {
                as[i] = new C14699a<>(this, i);
            }
            lazySet(0);
            this.f43739b.add(this);
            this.f43739b.setProducer(this);
            for (int i2 = 0; i2 < len && !this.f43746i; i2++) {
                sources[i2].mo3627a((C14980ia<? super T>) as[i2]);
            }
        }

        public void request(long n) {
            if (n < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= required but it was ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            } else if (n != 0) {
                C14640a.m46283a(this.f43748k, n);
                mo45839a();
            }
        }

        public void unsubscribe() {
            if (!this.f43746i) {
                this.f43746i = true;
                if (getAndIncrement() == 0) {
                    mo45842a((Queue<?>) this.f43744g);
                }
            }
        }

        public boolean isUnsubscribed() {
            return this.f43746i;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45842a(Queue<?> q) {
            q.clear();
            for (CombinerSubscriber<T, R> s : this.f43741d) {
                s.unsubscribe();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0034, code lost:
            if (r3 == f43738a) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0066, code lost:
            if (r7 != false) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0068, code lost:
            if (r11 == null) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006a, code lost:
            r0.mo45838a(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0070, code lost:
            mo45839a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0073, code lost:
            return;
         */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0063 A[Catch:{ all -> 0x0074 }] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45840a(java.lang.Object r11, int r12) {
            /*
                r10 = this;
                rx.c.a.o$a<T, R>[] r0 = r10.f43741d
                r0 = r0[r12]
                monitor-enter(r10)
                r1 = 0
                java.lang.Object[] r2 = r10.f43743f     // Catch:{ all -> 0x0080 }
                int r2 = r2.length     // Catch:{ all -> 0x0080 }
                java.lang.Object[] r3 = r10.f43743f     // Catch:{ all -> 0x007c }
                r3 = r3[r12]     // Catch:{ all -> 0x007c }
                int r4 = r10.f43750m     // Catch:{ all -> 0x007c }
                java.lang.Object r5 = f43738a     // Catch:{ all -> 0x007a }
                if (r3 != r5) goto L_0x0017
                int r4 = r4 + 1
                r10.f43750m = r4     // Catch:{ all -> 0x007a }
            L_0x0017:
                int r5 = r10.f43751n     // Catch:{ all -> 0x007a }
                if (r11 != 0) goto L_0x0020
                int r5 = r5 + 1
                r10.f43751n = r5     // Catch:{ all -> 0x0078 }
                goto L_0x0028
            L_0x0020:
                java.lang.Object[] r6 = r10.f43743f     // Catch:{ all -> 0x0078 }
                java.lang.Object r7 = p026rx.p390c.p391a.C14689m.m46324b(r11)     // Catch:{ all -> 0x0078 }
                r6[r12] = r7     // Catch:{ all -> 0x0078 }
            L_0x0028:
                r6 = 1
                if (r4 != r2) goto L_0x002d
                r7 = 1
                goto L_0x002e
            L_0x002d:
                r7 = 0
            L_0x002e:
                if (r5 == r2) goto L_0x003b
                if (r11 != 0) goto L_0x003c
                java.lang.Object r8 = f43738a     // Catch:{ all -> 0x0037 }
                if (r3 != r8) goto L_0x003c
                goto L_0x003b
            L_0x0037:
                r3 = move-exception
                r6 = r1
                r1 = r7
                goto L_0x0085
            L_0x003b:
                r1 = 1
            L_0x003c:
                if (r1 != 0) goto L_0x0063
                if (r11 == 0) goto L_0x004e
                if (r7 == 0) goto L_0x004e
                rx.c.e.a.g<java.lang.Object> r6 = r10.f43744g     // Catch:{ all -> 0x0074 }
                java.lang.Object[] r8 = r10.f43743f     // Catch:{ all -> 0x0074 }
                java.lang.Object r8 = r8.clone()     // Catch:{ all -> 0x0074 }
                r6.mo45996a(r0, r8)     // Catch:{ all -> 0x0074 }
                goto L_0x0065
            L_0x004e:
                if (r11 != 0) goto L_0x0065
                java.util.concurrent.atomic.AtomicReference<java.lang.Throwable> r8 = r10.f43749l     // Catch:{ all -> 0x0074 }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x0074 }
                if (r8 == 0) goto L_0x0065
                java.lang.Object r8 = f43738a     // Catch:{ all -> 0x0074 }
                if (r3 == r8) goto L_0x0060
                boolean r8 = r10.f43745h     // Catch:{ all -> 0x0074 }
                if (r8 != 0) goto L_0x0065
            L_0x0060:
                r10.f43747j = r6     // Catch:{ all -> 0x0074 }
                goto L_0x0065
            L_0x0063:
                r10.f43747j = r6     // Catch:{ all -> 0x0074 }
            L_0x0065:
                monitor-exit(r10)     // Catch:{ all -> 0x0074 }
                if (r7 != 0) goto L_0x0070
                if (r11 == 0) goto L_0x0070
                r8 = 1
                r0.mo45838a(r8)
                return
            L_0x0070:
                r10.mo45839a()
                return
            L_0x0074:
                r3 = move-exception
                r6 = r1
                r1 = r7
                goto L_0x0085
            L_0x0078:
                r3 = move-exception
                goto L_0x0084
            L_0x007a:
                r3 = move-exception
                goto L_0x007e
            L_0x007c:
                r3 = move-exception
                r4 = r1
            L_0x007e:
                r5 = r1
                goto L_0x0084
            L_0x0080:
                r3 = move-exception
                r4 = r1
                r5 = r1
                r2 = r1
            L_0x0084:
                r6 = r1
            L_0x0085:
                monitor-exit(r10)     // Catch:{ all -> 0x0087 }
                throw r3
            L_0x0087:
                r3 = move-exception
                goto L_0x0085
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14698o.C14700b.mo45840a(java.lang.Object, int):void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45839a() {
            int missed;
            if (getAndIncrement() == 0) {
                C14830g<Object> gVar = this.f43744g;
                C14980ia<? super R> iaVar = this.f43739b;
                boolean delayError = this.f43745h;
                AtomicLong localRequested = this.f43748k;
                int missed2 = 1;
                Object obj = null;
                while (true) {
                    if (!mo45844a(this.f43747j, gVar.isEmpty(), iaVar, gVar, delayError)) {
                        long requestAmount = localRequested.get();
                        Object obj2 = obj;
                        long emitted = 0;
                        while (true) {
                            if (emitted == requestAmount) {
                                missed = missed2;
                                break;
                            }
                            boolean d = this.f43747j;
                            C14699a aVar = (C14699a) gVar.peek();
                            boolean empty = aVar == null;
                            missed = missed2;
                            C14699a aVar2 = aVar;
                            boolean z = d;
                            long emitted2 = emitted;
                            if (!mo45844a(d, empty, iaVar, gVar, delayError)) {
                                if (empty) {
                                    emitted = emitted2;
                                    break;
                                }
                                gVar.poll();
                                Object[] array = (Object[]) gVar.poll();
                                if (array == null) {
                                    this.f43746i = true;
                                    mo45842a((Queue<?>) gVar);
                                    iaVar.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                                    return;
                                }
                                try {
                                    obj2 = this.f43740c.call(array);
                                    iaVar.onNext(obj2);
                                    aVar2.mo45838a(1);
                                    emitted = emitted2 + 1;
                                    missed2 = missed;
                                } catch (Throwable ex) {
                                    C14699a aVar3 = aVar2;
                                    long j = emitted2;
                                    Object obj3 = obj2;
                                    this.f43746i = true;
                                    mo45842a((Queue<?>) gVar);
                                    iaVar.onError(ex);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!(emitted == 0 || requestAmount == Long.MAX_VALUE)) {
                            C14640a.m46285b(localRequested, emitted);
                        }
                        missed2 = addAndGet(-missed);
                        if (missed2 != 0) {
                            obj = obj2;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45844a(boolean mainDone, boolean queueEmpty, C14980ia<?> childSubscriber, Queue<?> q, boolean delayError) {
            if (this.f43746i) {
                mo45842a(q);
                return true;
            }
            if (mainDone) {
                if (!delayError) {
                    Throwable e = (Throwable) this.f43749l.get();
                    if (e != null) {
                        mo45842a(q);
                        childSubscriber.onError(e);
                        return true;
                    } else if (queueEmpty) {
                        childSubscriber.onCompleted();
                        return true;
                    }
                } else if (queueEmpty) {
                    Throwable e2 = (Throwable) this.f43749l.get();
                    if (e2 != null) {
                        childSubscriber.onError(e2);
                    } else {
                        childSubscriber.onCompleted();
                    }
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45841a(Throwable e) {
            Throwable curr;
            Throwable next;
            AtomicReference<Throwable> localError = this.f43749l;
            do {
                curr = (Throwable) localError.get();
                if (curr == null) {
                    next = e;
                } else if (curr instanceof CompositeException) {
                    List<Throwable> es = new ArrayList<>(((CompositeException) curr).mo46124a());
                    es.add(e);
                    next = new CompositeException((Collection<? extends Throwable>) es);
                } else {
                    next = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{curr, e}));
                }
            } while (!localError.compareAndSet(curr, next));
        }
    }

    public C14698o(Iterable<? extends C0120S<? extends T>> sourcesIterable, C14545u<? extends R> combiner) {
        this(null, sourcesIterable, combiner, C14880h.f44165a, false);
    }

    public C14698o(C0120S<? extends T>[] sources, Iterable<? extends C0120S<? extends T>> sourcesIterable, C14545u<? extends R> combiner, int bufferSize, boolean delayError) {
        this.f43730a = sources;
        this.f43731b = sourcesIterable;
        this.f43732c = combiner;
        this.f43733d = bufferSize;
        this.f43734e = delayError;
    }

    /* renamed from: a */
    public void call(C14980ia<? super R> s) {
        C0120S<? extends T>[] sArr = this.f43730a;
        int count = 0;
        if (sArr == null) {
            Iterable<? extends C0120S<? extends T>> iterable = this.f43731b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                sArr = (C0120S[]) list.toArray(new C0120S[list.size()]);
                count = sArr.length;
            } else {
                sArr = new C0120S[8];
                Iterator i$ = iterable.iterator();
                while (i$.hasNext()) {
                    Observable<? extends T> p = (C0120S) i$.next();
                    if (count == sArr.length) {
                        C0120S<? extends T>[] sArr2 = new C0120S[((count >> 2) + count)];
                        System.arraycopy(sArr, 0, sArr2, 0, count);
                        sArr = sArr2;
                    }
                    int count2 = count + 1;
                    sArr[count] = p;
                    count = count2;
                }
            }
        } else {
            count = sArr.length;
        }
        if (count == 0) {
            s.onCompleted();
            return;
        }
        C14700b bVar = new C14700b(s, this.f43732c, count, this.f43733d, this.f43734e);
        bVar.mo45843a(sArr);
    }
}
