package p026rx.p390c.p391a;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.p027b.C0132p;
import p026rx.p029i.C14978f;
import p026rx.p390c.p395e.p396a.C14828e;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14859t;
import rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber;

/* renamed from: rx.c.a.wa */
/* compiled from: OperatorEagerConcatMap */
public final class C14743wa<T, R> implements C0123b<R, T> {

    /* renamed from: a */
    final C0132p<? super T, ? extends C0120S<? extends R>> f43854a;

    /* renamed from: b */
    final int f43855b;

    /* renamed from: c */
    private final int f43856c;

    /* renamed from: rx.c.a.wa$a */
    /* compiled from: OperatorEagerConcatMap */
    static final class C14744a<T> extends C14980ia<T> {

        /* renamed from: a */
        final C14746c<?, T> f43857a;

        /* renamed from: b */
        final Queue<Object> f43858b;

        /* renamed from: c */
        volatile boolean f43859c;

        /* renamed from: d */
        Throwable f43860d;

        public C14744a(C14746c<?, T> parent, int bufferSize) {
            Queue<Object> q;
            this.f43857a = parent;
            if (C14839G.m46555a()) {
                q = new C14859t<>(bufferSize);
            } else {
                q = new C14828e<>(bufferSize);
            }
            this.f43858b = q;
            request((long) bufferSize);
        }

        public void onNext(T t) {
            this.f43858b.offer(C14689m.m46326d(t));
            this.f43857a.mo45879b();
        }

        public void onError(Throwable e) {
            this.f43860d = e;
            this.f43859c = true;
            this.f43857a.mo45879b();
        }

        public void onCompleted() {
            this.f43859c = true;
            this.f43857a.mo45879b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45877a(long n) {
            request(n);
        }
    }

    /* renamed from: rx.c.a.wa$b */
    /* compiled from: OperatorEagerConcatMap */
    static final class C14745b extends AtomicLong implements C14508U {

        /* renamed from: a */
        final C14746c<?, ?> f43861a;

        public C14745b(C14746c<?, ?> parent) {
            this.f43861a = parent;
        }

        public void request(long n) {
            if (n < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= 0 required but it was ");
                sb.append(n);
                throw new IllegalStateException(sb.toString());
            } else if (n > 0) {
                C14640a.m46283a((AtomicLong) this, n);
                this.f43861a.mo45879b();
            }
        }
    }

    /* renamed from: rx.c.a.wa$c */
    /* compiled from: OperatorEagerConcatMap */
    static final class C14746c<T, R> extends C14980ia<T> {

        /* renamed from: a */
        final C0132p<? super T, ? extends C0120S<? extends R>> f43862a;

        /* renamed from: b */
        final int f43863b;

        /* renamed from: c */
        final C14980ia<? super R> f43864c;

        /* renamed from: d */
        final Queue<C14744a<R>> f43865d = new LinkedList();

        /* renamed from: e */
        volatile boolean f43866e;

        /* renamed from: f */
        Throwable f43867f;

        /* renamed from: g */
        volatile boolean f43868g;

        /* renamed from: h */
        final AtomicInteger f43869h = new AtomicInteger();

        /* renamed from: i */
        private C14745b f43870i;

        public C14746c(C0132p<? super T, ? extends C0120S<? extends R>> mapper, int bufferSize, int maxConcurrent, C14980ia<? super R> actual) {
            this.f43862a = mapper;
            this.f43863b = bufferSize;
            this.f43864c = actual;
            request(maxConcurrent == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) maxConcurrent);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45880c() {
            this.f43870i = new C14745b(this);
            add(C14978f.m46781a(new C14750xa(this)));
            this.f43864c.add(this);
            this.f43864c.setProducer(this.f43870i);
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
            if (r0.hasNext() == false) goto L_0x0026;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
            ((p026rx.C0137ja) r0.next()).unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            r0 = r1.iterator();
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45878a() {
            /*
                r4 = this;
                java.util.Queue<rx.c.a.wa$a<R>> r0 = r4.f43865d
                monitor-enter(r0)
                r1 = 0
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x0027 }
                java.util.Queue<rx.c.a.wa$a<R>> r3 = r4.f43865d     // Catch:{ all -> 0x0027 }
                r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                r1 = r2
                java.util.Queue<rx.c.a.wa$a<R>> r2 = r4.f43865d     // Catch:{ all -> 0x002a }
                r2.clear()     // Catch:{ all -> 0x002a }
                monitor-exit(r0)     // Catch:{ all -> 0x002a }
                java.util.Iterator r0 = r1.iterator()
            L_0x0016:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L_0x0026
                java.lang.Object r2 = r0.next()
                rx.ja r2 = (p026rx.C0137ja) r2
                r2.unsubscribe()
                goto L_0x0016
            L_0x0026:
                return
            L_0x0027:
                r2 = move-exception
            L_0x0028:
                monitor-exit(r0)     // Catch:{ all -> 0x002a }
                throw r2
            L_0x002a:
                r2 = move-exception
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14743wa.C14746c.mo45878a():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
            if (r4.f43868g == false) goto L_0x002b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r1.mo3640b((p026rx.C14980ia<? super T>) r2);
            mo45879b();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r5) {
            /*
                r4 = this;
                r0 = 0
                rx.b.p<? super T, ? extends rx.S<? extends R>> r1 = r4.f43862a     // Catch:{ Throwable -> 0x0035 }
                java.lang.Object r1 = r1.call(r5)     // Catch:{ Throwable -> 0x0035 }
                rx.S r1 = (p026rx.C0120S) r1     // Catch:{ Throwable -> 0x0035 }
                boolean r0 = r4.f43868g
                if (r0 == 0) goto L_0x000f
                return
            L_0x000f:
                rx.c.a.wa$a r0 = new rx.c.a.wa$a
                int r2 = r4.f43863b
                r0.<init>(r4, r2)
                r2 = r0
                java.util.Queue<rx.c.a.wa$a<R>> r3 = r4.f43865d
                monitor-enter(r3)
                boolean r0 = r4.f43868g     // Catch:{ all -> 0x0032 }
                if (r0 == 0) goto L_0x0020
                monitor-exit(r3)     // Catch:{ all -> 0x0032 }
                return
            L_0x0020:
                java.util.Queue<rx.c.a.wa$a<R>> r0 = r4.f43865d     // Catch:{ all -> 0x0032 }
                r0.add(r2)     // Catch:{ all -> 0x0032 }
                monitor-exit(r3)     // Catch:{ all -> 0x0032 }
                boolean r0 = r4.f43868g
                if (r0 == 0) goto L_0x002b
                return
            L_0x002b:
                r1.mo3640b(r2)
                r4.mo45879b()
                return
            L_0x0032:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0032 }
                throw r0
            L_0x0035:
                r1 = move-exception
                rx.ia<? super R> r2 = r4.f43864c
                p026rx.exceptions.C14927a.m46673a(r1, r2, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14743wa.C14746c.onNext(java.lang.Object):void");
        }

        public void onError(Throwable e) {
            this.f43867f = e;
            this.f43866e = true;
            mo45879b();
        }

        public void onCompleted() {
            this.f43866e = true;
            mo45879b();
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
            if (r5 != null) goto L_0x002e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
            r8 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
            if (r6 == false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
            r9 = r1.f43867f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
            if (r9 == null) goto L_0x003c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            mo45878a();
            r3.onError(r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
            if (r8 == false) goto L_0x0042;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003e, code lost:
            r3.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
            if (r8 != false) goto L_0x00cf;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0044, code lost:
            r9 = r2.get();
            r11 = 0;
            r13 = r5.f43858b;
            r14 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004d, code lost:
            r6 = r5.f43859c;
            r15 = r13.peek();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
            if (r15 != null) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
            r16 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0058, code lost:
            r16 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005a, code lost:
            r8 = r16;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
            if (r6 == false) goto L_0x0092;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005e, code lost:
            r7 = r5.f43860d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0060, code lost:
            if (r7 == null) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
            mo45878a();
            r3.onError(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0068, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0069, code lost:
            if (r8 == false) goto L_0x008b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x006b, code lost:
            r1 = r19;
            r17 = r6;
            r6 = r1.f43865d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0071, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            r1.f43865d.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0077, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0078, code lost:
            r5.unsubscribe();
            r14 = true;
            r18 = r7;
            r1.request(1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0084, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0085, code lost:
            r18 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0088, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0089, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x008b, code lost:
            r1 = r19;
            r17 = r6;
            r18 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0092, code lost:
            r1 = r19;
            r17 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x0096, code lost:
            if (r8 == false) goto L_0x0099;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x009b, code lost:
            if (r9 != r11) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a2, code lost:
            if (r11 == 0) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ab, code lost:
            if (r9 == Long.MAX_VALUE) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ad, code lost:
            p026rx.p390c.p391a.C14640a.m46285b(r2, r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x00b0, code lost:
            if (r14 != false) goto L_0x00b5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b2, code lost:
            r5.mo45877a(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x00b5, code lost:
            if (r14 == false) goto L_0x00d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b9, code lost:
            r13.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            r3.onNext(p026rx.p390c.p391a.C14689m.m46324b(r15));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x00c3, code lost:
            r11 = r11 + 1;
            r6 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ca, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00cb, code lost:
            p026rx.exceptions.C14927a.m46673a(r0, (p026rx.C0125T<?>) r3, r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ce, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00cf, code lost:
            r17 = r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00d1, code lost:
            r4 = r1.f43869h.addAndGet(-r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x00d8, code lost:
            if (r4 != 0) goto L_0x0013;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x00da, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x0013, code lost:
            continue;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45879b() {
            /*
                r19 = this;
                r1 = r19
                java.util.concurrent.atomic.AtomicInteger r0 = r1.f43869h
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L_0x000b
                return
            L_0x000b:
                r0 = 1
                rx.c.a.wa$b r2 = r1.f43870i
                rx.ia<? super R> r3 = r1.f43864c
                r4 = 0
                r5 = r4
                r4 = r0
            L_0x0013:
                boolean r0 = r1.f43868g
                if (r0 == 0) goto L_0x001b
                r19.mo45878a()
                return
            L_0x001b:
                boolean r6 = r1.f43866e
                java.util.Queue<rx.c.a.wa$a<R>> r7 = r1.f43865d
                monitor-enter(r7)
                java.util.Queue<rx.c.a.wa$a<R>> r0 = r1.f43865d     // Catch:{ all -> 0x00dd }
                java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x00dd }
                rx.c.a.wa$a r0 = (p026rx.p390c.p391a.C14743wa.C14744a) r0     // Catch:{ all -> 0x00dd }
                r5 = r0
                monitor-exit(r7)     // Catch:{ all -> 0x00e0 }
                if (r5 != 0) goto L_0x002e
                r8 = 1
                goto L_0x002f
            L_0x002e:
                r8 = 0
            L_0x002f:
                if (r6 == 0) goto L_0x0042
                java.lang.Throwable r9 = r1.f43867f
                if (r9 == 0) goto L_0x003c
                r19.mo45878a()
                r3.onError(r9)
                return
            L_0x003c:
                if (r8 == 0) goto L_0x0042
                r3.onCompleted()
                return
            L_0x0042:
                if (r8 != 0) goto L_0x00cf
                long r9 = r2.get()
                r11 = 0
                java.util.Queue<java.lang.Object> r13 = r5.f43858b
                r14 = 0
            L_0x004d:
                boolean r6 = r5.f43859c
                java.lang.Object r15 = r13.peek()
                if (r15 != 0) goto L_0x0058
                r16 = 1
                goto L_0x005a
            L_0x0058:
                r16 = 0
            L_0x005a:
                r8 = r16
                if (r6 == 0) goto L_0x0092
                java.lang.Throwable r7 = r5.f43860d
                if (r7 == 0) goto L_0x0069
                r19.mo45878a()
                r3.onError(r7)
                return
            L_0x0069:
                if (r8 == 0) goto L_0x008b
                r1 = r19
                r17 = r6
                java.util.Queue<rx.c.a.wa$a<R>> r6 = r1.f43865d
                monitor-enter(r6)
                java.util.Queue<rx.c.a.wa$a<R>> r0 = r1.f43865d     // Catch:{ all -> 0x0084 }
                r0.poll()     // Catch:{ all -> 0x0084 }
                monitor-exit(r6)     // Catch:{ all -> 0x0084 }
                r5.unsubscribe()
                r14 = 1
                r18 = r7
                r6 = 1
                r1.request(r6)
                goto L_0x009e
            L_0x0084:
                r0 = move-exception
                r18 = r7
            L_0x0087:
                monitor-exit(r6)     // Catch:{ all -> 0x0089 }
                throw r0
            L_0x0089:
                r0 = move-exception
                goto L_0x0087
            L_0x008b:
                r1 = r19
                r17 = r6
                r18 = r7
                goto L_0x0096
            L_0x0092:
                r1 = r19
                r17 = r6
            L_0x0096:
                if (r8 == 0) goto L_0x0099
                goto L_0x009e
            L_0x0099:
                int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r0 != 0) goto L_0x00b9
            L_0x009e:
                r6 = 0
                int r0 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x00b5
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
                if (r0 == 0) goto L_0x00b0
                p026rx.p390c.p391a.C14640a.m46285b(r2, r11)
            L_0x00b0:
                if (r14 != 0) goto L_0x00b5
                r5.mo45877a(r11)
            L_0x00b5:
                if (r14 == 0) goto L_0x00d1
                goto L_0x0013
            L_0x00b9:
                r13.poll()
                java.lang.Object r0 = p026rx.p390c.p391a.C14689m.m46324b(r15)     // Catch:{ Throwable -> 0x00ca }
                r3.onNext(r0)     // Catch:{ Throwable -> 0x00ca }
                r6 = 1
                long r11 = r11 + r6
                r6 = r17
                goto L_0x004d
            L_0x00ca:
                r0 = move-exception
                p026rx.exceptions.C14927a.m46673a(r0, r3, r15)
                return
            L_0x00cf:
                r17 = r6
            L_0x00d1:
                java.util.concurrent.atomic.AtomicInteger r0 = r1.f43869h
                int r6 = -r4
                int r4 = r0.addAndGet(r6)
                if (r4 != 0) goto L_0x00db
                return
            L_0x00db:
                goto L_0x0013
            L_0x00dd:
                r0 = move-exception
            L_0x00de:
                monitor-exit(r7)     // Catch:{ all -> 0x00e0 }
                throw r0
            L_0x00e0:
                r0 = move-exception
                goto L_0x00de
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14743wa.C14746c.mo45879b():void");
        }
    }

    public C14743wa(C0132p<? super T, ? extends C0120S<? extends R>> mapper, int bufferSize, int maxConcurrent) {
        this.f43854a = mapper;
        this.f43855b = bufferSize;
        this.f43856c = maxConcurrent;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super R> t) {
        EagerOuterSubscriber<T, R> outer = new C14746c<>(this.f43854a, this.f43855b, this.f43856c, t);
        outer.mo45880c();
        return outer;
    }
}
