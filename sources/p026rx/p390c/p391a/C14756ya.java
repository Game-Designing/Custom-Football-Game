package p026rx.p390c.p391a;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S;
import p026rx.C0120S.C0123b;
import p026rx.C0137ja;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.CompositeException;
import p026rx.exceptions.MissingBackpressureException;
import p026rx.exceptions.OnErrorThrowable;
import p026rx.p029i.C0136c;
import p026rx.p390c.p395e.C14880h;
import p026rx.p390c.p395e.C14887o;
import p026rx.p390c.p395e.p396a.C14828e;
import p026rx.p390c.p395e.p396a.C14829f;
import p026rx.p390c.p395e.p396a.C14831h;
import p026rx.p390c.p395e.p397b.C14839G;
import p026rx.p390c.p395e.p397b.C14849j;
import p026rx.p390c.p395e.p397b.C14859t;
import rx.internal.operators.OperatorMerge.InnerSubscriber;
import rx.internal.operators.OperatorMerge.MergeProducer;
import rx.internal.operators.OperatorMerge.MergeSubscriber;

/* renamed from: rx.c.a.ya */
/* compiled from: OperatorMerge */
public final class C14756ya<T> implements C0123b<T, C0120S<? extends T>> {

    /* renamed from: a */
    final boolean f43894a;

    /* renamed from: b */
    final int f43895b;

    /* renamed from: rx.c.a.ya$a */
    /* compiled from: OperatorMerge */
    static final class C14757a {

        /* renamed from: a */
        static final C14756ya<Object> f43896a = new C14756ya<>(true, MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: rx.c.a.ya$b */
    /* compiled from: OperatorMerge */
    static final class C14758b {

        /* renamed from: a */
        static final C14756ya<Object> f43897a = new C14756ya<>(false, MoPubClientPositioning.NO_REPEAT);
    }

    /* renamed from: rx.c.a.ya$c */
    /* compiled from: OperatorMerge */
    static final class C14759c<T> extends C14980ia<T> {

        /* renamed from: a */
        static final int f43898a = (C14880h.f44165a / 4);

        /* renamed from: b */
        final C14761e<T> f43899b;

        /* renamed from: c */
        final long f43900c;

        /* renamed from: d */
        volatile boolean f43901d;

        /* renamed from: e */
        volatile C14880h f43902e;

        /* renamed from: f */
        int f43903f;

        public C14759c(C14761e<T> parent, long id) {
            this.f43899b = parent;
            this.f43900c = id;
        }

        public void onStart() {
            int i = C14880h.f44165a;
            this.f43903f = i;
            request((long) i);
        }

        public void onNext(T t) {
            this.f43899b.mo45902b(this, t);
        }

        public void onError(Throwable e) {
            this.f43901d = true;
            this.f43899b.mo45906f().offer(e);
            this.f43899b.mo45899b();
        }

        public void onCompleted() {
            this.f43901d = true;
            this.f43899b.mo45899b();
        }

        /* renamed from: a */
        public void mo45889a(long n) {
            int r = this.f43903f - ((int) n);
            if (r > f43898a) {
                this.f43903f = r;
                return;
            }
            int i = C14880h.f44165a;
            this.f43903f = i;
            int k = i - r;
            if (k > 0) {
                request((long) k);
            }
        }
    }

    /* renamed from: rx.c.a.ya$d */
    /* compiled from: OperatorMerge */
    static final class C14760d<T> extends AtomicLong implements C14508U {

        /* renamed from: a */
        final C14761e<T> f43904a;

        public C14760d(C14761e<T> subscriber) {
            this.f43904a = subscriber;
        }

        public void request(long n) {
            if (n > 0) {
                if (get() != Long.MAX_VALUE) {
                    C14640a.m46283a((AtomicLong) this, n);
                    this.f43904a.mo45899b();
                }
            } else if (n < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }

        /* renamed from: a */
        public long mo45890a(int n) {
            return addAndGet((long) (-n));
        }
    }

    /* renamed from: rx.c.a.ya$e */
    /* compiled from: OperatorMerge */
    static final class C14761e<T> extends C14980ia<C0120S<? extends T>> {

        /* renamed from: a */
        static final C14759c<?>[] f43905a = new C14759c[0];

        /* renamed from: b */
        final C14980ia<? super T> f43906b;

        /* renamed from: c */
        final boolean f43907c;

        /* renamed from: d */
        final int f43908d;

        /* renamed from: e */
        volatile Queue<Object> f43909e;

        /* renamed from: f */
        volatile ConcurrentLinkedQueue<Throwable> f43910f;

        /* renamed from: g */
        volatile boolean f43911g;

        /* renamed from: h */
        boolean f43912h;

        /* renamed from: i */
        boolean f43913i;

        /* renamed from: j */
        final Object f43914j = new Object();

        /* renamed from: k */
        volatile C14759c<?>[] f43915k = f43905a;

        /* renamed from: l */
        long f43916l;

        /* renamed from: m */
        long f43917m;

        /* renamed from: n */
        int f43918n;

        /* renamed from: o */
        final int f43919o;

        /* renamed from: p */
        int f43920p;
        C14760d<T> producer;
        volatile C0136c subscriptions;

        public C14761e(C14980ia<? super T> child, boolean delayErrors, int maxConcurrent) {
            this.f43906b = child;
            this.f43907c = delayErrors;
            this.f43908d = maxConcurrent;
            if (maxConcurrent == Integer.MAX_VALUE) {
                this.f43919o = MoPubClientPositioning.NO_REPEAT;
                request(Long.MAX_VALUE);
                return;
            }
            this.f43919o = Math.max(1, maxConcurrent >> 1);
            request((long) maxConcurrent);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: f */
        public Queue<Throwable> mo45906f() {
            ConcurrentLinkedQueue<Throwable> q = this.f43910f;
            if (q == null) {
                synchronized (this) {
                    q = this.f43910f;
                    if (q == null) {
                        q = new ConcurrentLinkedQueue<>();
                        this.f43910f = q;
                    }
                }
            }
            return q;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: e */
        public C0136c mo45905e() {
            C0136c c = this.subscriptions;
            if (c == null) {
                boolean shouldAdd = false;
                synchronized (this) {
                    c = this.subscriptions;
                    if (c == null) {
                        c = new C0136c();
                        this.subscriptions = c;
                        shouldAdd = true;
                    }
                }
                if (shouldAdd) {
                    add(c);
                }
            }
            return c;
        }

        /* renamed from: a */
        public void onNext(C0120S<? extends T> t) {
            if (t != null) {
                if (t == C0120S.m651c()) {
                    mo45903c();
                } else if (t instanceof C14887o) {
                    mo45900b((T) ((C14887o) t).mo46096o());
                } else {
                    long j = this.f43916l;
                    this.f43916l = 1 + j;
                    InnerSubscriber<T> inner = new C14759c<>(this, j);
                    mo45895a((C14759c<T>) inner);
                    t.mo3640b((C14980ia<? super T>) inner);
                    mo45899b();
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo45903c() {
            int produced = this.f43920p + 1;
            if (produced == this.f43919o) {
                this.f43920p = 0;
                mo45891a((long) produced);
                return;
            }
            this.f43920p = produced;
        }

        /* renamed from: g */
        private void m46399g() {
            List<Throwable> list = new ArrayList<>(this.f43910f);
            if (list.size() == 1) {
                this.f43906b.onError((Throwable) list.get(0));
            } else {
                this.f43906b.onError(new CompositeException((Collection<? extends Throwable>) list));
            }
        }

        public void onError(Throwable e) {
            mo45906f().offer(e);
            this.f43911g = true;
            mo45899b();
        }

        public void onCompleted() {
            this.f43911g = true;
            mo45899b();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45895a(C14759c<T> inner) {
            mo45905e().mo3713a((C0137ja) inner);
            synchronized (this.f43914j) {
                InnerSubscriber<?>[] a = this.f43915k;
                int n = a.length;
                InnerSubscriber<?>[] b = new C14759c[(n + 1)];
                System.arraycopy(a, 0, b, 0, n);
                b[n] = inner;
                this.f43915k = b;
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45901b(C14759c<T> inner) {
            C14880h q = inner.f43902e;
            if (q != null) {
                q.mo46089g();
            }
            this.subscriptions.mo3714b(inner);
            synchronized (this.f43914j) {
                InnerSubscriber<?>[] a = this.f43915k;
                int n = a.length;
                int j = -1;
                int i = 0;
                while (true) {
                    if (i >= n) {
                        break;
                    } else if (inner.equals(a[i])) {
                        j = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (j >= 0) {
                    if (n == 1) {
                        this.f43915k = f43905a;
                        return;
                    }
                    InnerSubscriber<?>[] b = new C14759c[(n - 1)];
                    System.arraycopy(a, 0, b, 0, j);
                    System.arraycopy(a, j + 1, b, j, (n - j) - 1);
                    this.f43915k = b;
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45902b(C14759c<T> subscriber, T value) {
            boolean success = false;
            long r = this.producer.get();
            if (r != 0) {
                synchronized (this) {
                    r = this.producer.get();
                    if (!this.f43912h && r != 0) {
                        this.f43912h = true;
                        success = true;
                    }
                }
            }
            if (success) {
                C14880h subscriberQueue = subscriber.f43902e;
                if (subscriberQueue == null || subscriberQueue.mo46085c()) {
                    mo45897a(subscriber, value, r);
                    return;
                }
                mo45896a(subscriber, value);
                mo45904d();
                return;
            }
            mo45896a(subscriber, value);
            mo45899b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo45896a(C14759c<T> subscriber, T value) {
            C14880h q = subscriber.f43902e;
            if (q == null) {
                q = C14880h.m46599b();
                subscriber.add(q);
                subscriber.f43902e = q;
            }
            try {
                q.mo46084c(C14689m.m46326d(value));
            } catch (MissingBackpressureException ex) {
                subscriber.unsubscribe();
                subscriber.onError(ex);
            } catch (IllegalStateException ex2) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.unsubscribe();
                    subscriber.onError(ex2);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0048, code lost:
            if (1 != 0) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x004a, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            r6.f43912h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x004d, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0052, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0056, code lost:
            if (1 != 0) goto L_0x0060;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0058, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            r6.f43912h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x005b, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0060, code lost:
            mo45904d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0063, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0067, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0068, code lost:
            r2 = r0;
            r0 = true;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45897a(p026rx.p390c.p391a.C14756ya.C14759c<T> r7, T r8, long r9) {
            /*
                r6 = this;
                r0 = 0
                r1 = 0
                rx.ia<? super T> r2 = r6.f43906b     // Catch:{ Throwable -> 0x000a }
                r2.onNext(r8)     // Catch:{ Throwable -> 0x000a }
                goto L_0x002b
            L_0x0008:
                r2 = move-exception
                goto L_0x006b
            L_0x000a:
                r2 = move-exception
                boolean r3 = r6.f43907c     // Catch:{ all -> 0x0008 }
                if (r3 != 0) goto L_0x0024
                p026rx.exceptions.C14927a.m46678c(r2)     // Catch:{ all -> 0x0008 }
                r0 = 1
                r7.unsubscribe()     // Catch:{ all -> 0x0008 }
                r7.onError(r2)     // Catch:{ all -> 0x0008 }
                if (r0 != 0) goto L_0x0023
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x0020 }
                monitor-exit(r6)     // Catch:{ all -> 0x0020 }
                goto L_0x0023
            L_0x0020:
                r1 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0020 }
                throw r1
            L_0x0023:
                return
            L_0x0024:
                java.util.Queue r3 = r6.mo45906f()     // Catch:{ all -> 0x0008 }
                r3.offer(r2)     // Catch:{ all -> 0x0008 }
            L_0x002b:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r4 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r4 == 0) goto L_0x003a
                rx.c.a.ya$d<T> r2 = r6.producer     // Catch:{ all -> 0x0008 }
                r3 = 1
                r2.mo45890a(r3)     // Catch:{ all -> 0x0008 }
            L_0x003a:
                r2 = 1
                r7.mo45889a(r2)     // Catch:{ all -> 0x0008 }
                monitor-enter(r6)     // Catch:{ all -> 0x0008 }
                r2 = 1
                boolean r0 = r6.f43913i     // Catch:{ all -> 0x0064 }
                if (r0 != 0) goto L_0x0053
                r6.f43912h = r1     // Catch:{ all -> 0x0064 }
                monitor-exit(r6)     // Catch:{ all -> 0x0064 }
                if (r2 != 0) goto L_0x0052
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x004f }
                monitor-exit(r6)     // Catch:{ all -> 0x004f }
                goto L_0x0052
            L_0x004f:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x004f }
                throw r0
            L_0x0052:
                return
            L_0x0053:
                r6.f43913i = r1     // Catch:{ all -> 0x0064 }
                monitor-exit(r6)     // Catch:{ all -> 0x0064 }
                if (r2 != 0) goto L_0x0060
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x005d }
                monitor-exit(r6)     // Catch:{ all -> 0x005d }
                goto L_0x0060
            L_0x005d:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x005d }
                throw r0
            L_0x0060:
                r6.mo45904d()
                return
            L_0x0064:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0064 }
                throw r0     // Catch:{ all -> 0x0067 }
            L_0x0067:
                r0 = move-exception
                r5 = r2
                r2 = r0
                r0 = r5
            L_0x006b:
                if (r0 != 0) goto L_0x0075
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x0072 }
                monitor-exit(r6)     // Catch:{ all -> 0x0072 }
                goto L_0x0075
            L_0x0072:
                r1 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0072 }
                throw r1
            L_0x0075:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14756ya.C14761e.mo45897a(rx.c.a.ya$c, java.lang.Object, long):void");
        }

        /* renamed from: a */
        public void mo45891a(long n) {
            request(n);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45900b(T value) {
            boolean success = false;
            long r = this.producer.get();
            if (r != 0) {
                synchronized (this) {
                    r = this.producer.get();
                    if (!this.f43912h && r != 0) {
                        this.f43912h = true;
                        success = true;
                    }
                }
            }
            if (success) {
                Queue<Object> mainQueue = this.f43909e;
                if (mainQueue == null || mainQueue.isEmpty()) {
                    mo45893a(value, r);
                    return;
                }
                mo45892a(value);
                mo45904d();
                return;
            }
            mo45892a(value);
            mo45899b();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void mo45892a(T value) {
            Queue<Object> q = this.f43909e;
            if (q == null) {
                int mc = this.f43908d;
                if (mc == Integer.MAX_VALUE) {
                    q = new C14831h<>(C14880h.f44165a);
                } else if (!C14849j.m46568a(mc)) {
                    q = new C14829f<>(mc);
                } else if (C14839G.m46555a()) {
                    q = new C14859t<>(mc);
                } else {
                    q = new C14828e<>(mc);
                }
                this.f43909e = q;
            }
            if (!q.offer(C14689m.m46326d(value))) {
                unsubscribe();
                onError(OnErrorThrowable.m46666a(new MissingBackpressureException(), value));
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0053, code lost:
            if (1 != 0) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0055, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r6.f43912h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0058, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x005d, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x0061, code lost:
            if (1 != 0) goto L_0x006b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0063, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            r6.f43912h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0066, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x006b, code lost:
            mo45904d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x006e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0072, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0073, code lost:
            r0 = true;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45893a(T r7, long r8) {
            /*
                r6 = this;
                r0 = 0
                r1 = 0
                rx.ia<? super T> r2 = r6.f43906b     // Catch:{ Throwable -> 0x000a }
                r2.onNext(r7)     // Catch:{ Throwable -> 0x000a }
                goto L_0x002b
            L_0x0008:
                r2 = move-exception
                goto L_0x0074
            L_0x000a:
                r2 = move-exception
                boolean r3 = r6.f43907c     // Catch:{ all -> 0x0008 }
                if (r3 != 0) goto L_0x0024
                p026rx.exceptions.C14927a.m46678c(r2)     // Catch:{ all -> 0x0008 }
                r0 = 1
                r6.unsubscribe()     // Catch:{ all -> 0x0008 }
                r6.onError(r2)     // Catch:{ all -> 0x0008 }
                if (r0 != 0) goto L_0x0023
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x0020 }
                monitor-exit(r6)     // Catch:{ all -> 0x0020 }
                goto L_0x0023
            L_0x0020:
                r1 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0020 }
                throw r1
            L_0x0023:
                return
            L_0x0024:
                java.util.Queue r3 = r6.mo45906f()     // Catch:{ all -> 0x0008 }
                r3.offer(r2)     // Catch:{ all -> 0x0008 }
            L_0x002b:
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                r4 = 1
                int r5 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r5 == 0) goto L_0x003a
                rx.c.a.ya$d<T> r2 = r6.producer     // Catch:{ all -> 0x0008 }
                r2.mo45890a(r4)     // Catch:{ all -> 0x0008 }
            L_0x003a:
                int r2 = r6.f43920p     // Catch:{ all -> 0x0008 }
                int r2 = r2 + r4
                int r3 = r6.f43919o     // Catch:{ all -> 0x0008 }
                if (r2 != r3) goto L_0x0048
                r6.f43920p = r1     // Catch:{ all -> 0x0008 }
                long r3 = (long) r2     // Catch:{ all -> 0x0008 }
                r6.mo45891a(r3)     // Catch:{ all -> 0x0008 }
                goto L_0x004a
            L_0x0048:
                r6.f43920p = r2     // Catch:{ all -> 0x0008 }
            L_0x004a:
                monitor-enter(r6)     // Catch:{ all -> 0x0008 }
                r3 = 1
                boolean r0 = r6.f43913i     // Catch:{ all -> 0x006f }
                if (r0 != 0) goto L_0x005e
                r6.f43912h = r1     // Catch:{ all -> 0x006f }
                monitor-exit(r6)     // Catch:{ all -> 0x006f }
                if (r3 != 0) goto L_0x005d
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x005a }
                monitor-exit(r6)     // Catch:{ all -> 0x005a }
                goto L_0x005d
            L_0x005a:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x005a }
                throw r0
            L_0x005d:
                return
            L_0x005e:
                r6.f43913i = r1     // Catch:{ all -> 0x006f }
                monitor-exit(r6)     // Catch:{ all -> 0x006f }
                if (r3 != 0) goto L_0x006b
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x0068 }
                monitor-exit(r6)     // Catch:{ all -> 0x0068 }
                goto L_0x006b
            L_0x0068:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0068 }
                throw r0
            L_0x006b:
                r6.mo45904d()
                return
            L_0x006f:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x006f }
                throw r0     // Catch:{ all -> 0x0072 }
            L_0x0072:
                r2 = move-exception
                r0 = r3
            L_0x0074:
                if (r0 != 0) goto L_0x007e
                monitor-enter(r6)
                r6.f43912h = r1     // Catch:{ all -> 0x007b }
                monitor-exit(r6)     // Catch:{ all -> 0x007b }
                goto L_0x007e
            L_0x007b:
                r1 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x007b }
                throw r1
            L_0x007e:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14756ya.C14761e.mo45893a(java.lang.Object, long):void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo45899b() {
            synchronized (this) {
                if (this.f43912h) {
                    this.f43913i = true;
                    return;
                }
                this.f43912h = true;
                mo45904d();
            }
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:270:0x0295, code lost:
            if (1 != 0) goto L_0x02a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:271:0x0297, code lost:
            monitor-enter(r30);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:274:?, code lost:
            r1.f43912h = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:275:0x029b, code lost:
            monitor-exit(r30);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:280:0x02a0, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:285:0x02a5, code lost:
            r2 = r21;
            r4 = r29;
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x00c4, code lost:
            if (r5.isEmpty() != false) goto L_0x00c6;
         */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x0139 A[Catch:{ all -> 0x0280 }] */
        /* JADX WARNING: Removed duplicated region for block: B:296:0x02b8  */
        /* JADX WARNING: Removed duplicated region for block: B:325:0x0258 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x00de  */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo45904d() {
            /*
                r30 = this;
                r1 = r30
                r2 = 0
                r3 = 0
                rx.ia<? super T> r0 = r1.f43906b     // Catch:{ all -> 0x02b3 }
                r4 = r0
            L_0x0007:
                boolean r0 = r30.mo45898a()     // Catch:{ all -> 0x02b3 }
                if (r0 == 0) goto L_0x0019
                r2 = 1
                if (r2 != 0) goto L_0x0018
                monitor-enter(r30)
                r1.f43912h = r3     // Catch:{ all -> 0x0015 }
                monitor-exit(r30)     // Catch:{ all -> 0x0015 }
                goto L_0x0018
            L_0x0015:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x0015 }
                throw r0
            L_0x0018:
                return
            L_0x0019:
                java.util.Queue<java.lang.Object> r0 = r1.f43909e     // Catch:{ all -> 0x02b3 }
                r5 = r0
                rx.c.a.ya$d<T> r0 = r1.producer     // Catch:{ all -> 0x02b3 }
                long r6 = r0.get()     // Catch:{ all -> 0x02b3 }
                r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r0 != 0) goto L_0x002d
                r0 = 1
                goto L_0x002e
            L_0x002d:
                r0 = 0
            L_0x002e:
                r8 = r0
                r0 = 0
                r9 = 1
                r11 = 0
                if (r5 == 0) goto L_0x00b0
            L_0x0036:
                r13 = 0
                r14 = 0
                r15 = r0
            L_0x0039:
                int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r0 <= 0) goto L_0x0092
                java.lang.Object r0 = r5.poll()     // Catch:{ all -> 0x008d }
                r14 = r0
                boolean r0 = r30.mo45898a()     // Catch:{ all -> 0x008d }
                if (r0 == 0) goto L_0x0054
                r2 = 1
                if (r2 != 0) goto L_0x0053
                monitor-enter(r30)
                r1.f43912h = r3     // Catch:{ all -> 0x0050 }
                monitor-exit(r30)     // Catch:{ all -> 0x0050 }
                goto L_0x0053
            L_0x0050:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x0050 }
                throw r0
            L_0x0053:
                return
            L_0x0054:
                if (r14 != 0) goto L_0x0057
                goto L_0x0092
            L_0x0057:
                java.lang.Object r0 = p026rx.p390c.p391a.C14689m.m46324b(r14)     // Catch:{ all -> 0x008d }
                r16 = r0
                r11 = r16
                r4.onNext(r11)     // Catch:{ Throwable -> 0x0063 }
                goto L_0x0085
            L_0x0063:
                r0 = move-exception
                r12 = r0
                boolean r0 = r1.f43907c     // Catch:{ all -> 0x008d }
                if (r0 != 0) goto L_0x007e
                p026rx.exceptions.C14927a.m46678c(r12)     // Catch:{ all -> 0x008d }
                r2 = 1
                r30.unsubscribe()     // Catch:{ all -> 0x008d }
                r4.onError(r12)     // Catch:{ all -> 0x008d }
                if (r2 != 0) goto L_0x007d
                monitor-enter(r30)
                r1.f43912h = r3     // Catch:{ all -> 0x007a }
                monitor-exit(r30)     // Catch:{ all -> 0x007a }
                goto L_0x007d
            L_0x007a:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x007a }
                throw r0
            L_0x007d:
                return
            L_0x007e:
                java.util.Queue r0 = r30.mo45906f()     // Catch:{ all -> 0x008d }
                r0.offer(r12)     // Catch:{ all -> 0x008d }
            L_0x0085:
                int r15 = r15 + 1
                int r13 = r13 + 1
                long r6 = r6 - r9
                r11 = 0
                goto L_0x0039
            L_0x008d:
                r0 = move-exception
                r21 = r2
                goto L_0x02b6
            L_0x0092:
                if (r13 <= 0) goto L_0x00a3
                if (r8 == 0) goto L_0x009c
                r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                goto L_0x00a3
            L_0x009c:
                rx.c.a.ya$d<T> r0 = r1.producer     // Catch:{ all -> 0x008d }
                long r11 = r0.mo45890a(r13)     // Catch:{ all -> 0x008d }
                r6 = r11
            L_0x00a3:
                r11 = 0
                int r0 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
                if (r0 == 0) goto L_0x00b1
                if (r14 != 0) goto L_0x00ac
                goto L_0x00b1
            L_0x00ac:
                r0 = r15
                r11 = 0
                goto L_0x0036
            L_0x00b0:
                r15 = r0
            L_0x00b1:
                boolean r0 = r1.f43911g     // Catch:{ all -> 0x02b3 }
                r11 = r0
                java.util.Queue<java.lang.Object> r0 = r1.f43909e     // Catch:{ all -> 0x02b3 }
                r5 = r0
                rx.c.a.ya$c<?>[] r0 = r1.f43915k     // Catch:{ all -> 0x02b3 }
                r12 = r0
                int r0 = r12.length     // Catch:{ all -> 0x02b3 }
                r13 = r0
                if (r11 == 0) goto L_0x00e7
                if (r5 == 0) goto L_0x00c6
                boolean r0 = r5.isEmpty()     // Catch:{ all -> 0x008d }
                if (r0 == 0) goto L_0x00e7
            L_0x00c6:
                if (r13 != 0) goto L_0x00e7
                java.util.concurrent.ConcurrentLinkedQueue<java.lang.Throwable> r0 = r1.f43910f     // Catch:{ all -> 0x008d }
                r9 = r0
                if (r9 == 0) goto L_0x00d8
                boolean r0 = r9.isEmpty()     // Catch:{ all -> 0x008d }
                if (r0 == 0) goto L_0x00d4
                goto L_0x00d8
            L_0x00d4:
                r30.m46399g()     // Catch:{ all -> 0x008d }
                goto L_0x00db
            L_0x00d8:
                r4.onCompleted()     // Catch:{ all -> 0x008d }
            L_0x00db:
                r2 = 1
                if (r2 != 0) goto L_0x00e6
                monitor-enter(r30)
                r1.f43912h = r3     // Catch:{ all -> 0x00e3 }
                monitor-exit(r30)     // Catch:{ all -> 0x00e3 }
                goto L_0x00e6
            L_0x00e3:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x00e3 }
                throw r0
            L_0x00e6:
                return
            L_0x00e7:
                r0 = 0
                if (r13 <= 0) goto L_0x026d
                long r9 = r1.f43917m     // Catch:{ all -> 0x02b3 }
                int r14 = r1.f43918n     // Catch:{ all -> 0x02b3 }
                if (r13 <= r14) goto L_0x0101
                r3 = r12[r14]     // Catch:{ all -> 0x02b3 }
                r21 = r2
                long r2 = r3.f43900c     // Catch:{ all -> 0x0280 }
                int r22 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
                if (r22 == 0) goto L_0x00fb
                goto L_0x0103
            L_0x00fb:
                r22 = r0
                r23 = r6
                r7 = r5
                goto L_0x0134
            L_0x0101:
                r21 = r2
            L_0x0103:
                if (r13 > r14) goto L_0x0106
                r14 = 0
            L_0x0106:
                r2 = r14
                r3 = 0
            L_0x0108:
                if (r3 >= r13) goto L_0x0126
                r22 = r0
                r0 = r12[r2]     // Catch:{ all -> 0x0280 }
                r23 = r6
                r7 = r5
                long r5 = r0.f43900c     // Catch:{ all -> 0x0280 }
                int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x0118
                goto L_0x012b
            L_0x0118:
                int r2 = r2 + 1
                if (r2 != r13) goto L_0x011e
                r0 = 0
                r2 = r0
            L_0x011e:
                int r3 = r3 + 1
                r5 = r7
                r0 = r22
                r6 = r23
                goto L_0x0108
            L_0x0126:
                r22 = r0
                r23 = r6
                r7 = r5
            L_0x012b:
                r14 = r2
                r1.f43918n = r2     // Catch:{ all -> 0x0280 }
                r0 = r12[r2]     // Catch:{ all -> 0x0280 }
                long r5 = r0.f43900c     // Catch:{ all -> 0x0280 }
                r1.f43917m = r5     // Catch:{ all -> 0x0280 }
            L_0x0134:
                r0 = r14
                r2 = 0
                r3 = r0
            L_0x0137:
                if (r2 >= r13) goto L_0x0258
                boolean r0 = r30.mo45898a()     // Catch:{ all -> 0x0280 }
                if (r0 == 0) goto L_0x014c
                r5 = 1
                if (r5 != 0) goto L_0x014b
                monitor-enter(r30)
                r6 = 0
                r1.f43912h = r6     // Catch:{ all -> 0x0148 }
                monitor-exit(r30)     // Catch:{ all -> 0x0148 }
                goto L_0x014b
            L_0x0148:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x0148 }
                throw r0
            L_0x014b:
                return
            L_0x014c:
                r0 = r12[r3]     // Catch:{ all -> 0x0280 }
                r5 = r0
                r0 = 0
            L_0x0150:
                r6 = 0
                r25 = r0
            L_0x0153:
                r17 = 0
                int r0 = (r23 > r17 ? 1 : (r23 == r17 ? 0 : -1))
                if (r0 <= 0) goto L_0x01d4
                boolean r0 = r30.mo45898a()     // Catch:{ all -> 0x0280 }
                if (r0 == 0) goto L_0x0171
                r17 = 1
                if (r17 != 0) goto L_0x016e
                monitor-enter(r30)
                r26 = r7
                r7 = 0
                r1.f43912h = r7     // Catch:{ all -> 0x016b }
                monitor-exit(r30)     // Catch:{ all -> 0x016b }
                goto L_0x0170
            L_0x016b:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x016b }
                throw r0
            L_0x016e:
                r26 = r7
            L_0x0170:
                return
            L_0x0171:
                r26 = r7
                rx.c.e.h r0 = r5.f43902e     // Catch:{ all -> 0x0280 }
                r7 = r0
                if (r7 != 0) goto L_0x017d
                r29 = r4
                r19 = 1
                goto L_0x01da
            L_0x017d:
                java.lang.Object r0 = r7.mo46088f()     // Catch:{ all -> 0x0280 }
                r25 = r0
                if (r25 != 0) goto L_0x018a
                r29 = r4
                r19 = 1
                goto L_0x01da
            L_0x018a:
                java.lang.Object r0 = p026rx.p390c.p391a.C14689m.m46324b(r25)     // Catch:{ all -> 0x0280 }
                r27 = r0
                r28 = r7
                r7 = r27
                r4.onNext(r7)     // Catch:{ Throwable -> 0x01a2 }
                r19 = 1
                long r23 = r23 - r19
                int r6 = r6 + 1
                r7 = r26
                goto L_0x0153
            L_0x01a2:
                r0 = move-exception
                r17 = r0
                r18 = r17
                r17 = 1
                p026rx.exceptions.C14927a.m46678c(r18)     // Catch:{ all -> 0x01cf }
                r27 = r7
                r7 = r18
                r4.onError(r7)     // Catch:{ all -> 0x01c7 }
                r30.unsubscribe()     // Catch:{ all -> 0x01cf }
                if (r17 != 0) goto L_0x01c4
                monitor-enter(r30)
                r29 = r4
                r4 = 0
                r1.f43912h = r4     // Catch:{ all -> 0x01c1 }
                monitor-exit(r30)     // Catch:{ all -> 0x01c1 }
                goto L_0x01c6
            L_0x01c1:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x01c1 }
                throw r0
            L_0x01c4:
                r29 = r4
            L_0x01c6:
                return
            L_0x01c7:
                r0 = move-exception
                r29 = r4
                r4 = r0
                r30.unsubscribe()     // Catch:{ all -> 0x01cf }
                throw r4     // Catch:{ all -> 0x01cf }
            L_0x01cf:
                r0 = move-exception
                r21 = r17
                goto L_0x02b6
            L_0x01d4:
                r29 = r4
                r26 = r7
                r19 = 1
            L_0x01da:
                if (r6 <= 0) goto L_0x01f2
                if (r8 != 0) goto L_0x01e7
                rx.c.a.ya$d<T> r0 = r1.producer     // Catch:{ all -> 0x0280 }
                long r27 = r0.mo45890a(r6)     // Catch:{ all -> 0x0280 }
                r23 = r27
                goto L_0x01ec
            L_0x01e7:
                r23 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            L_0x01ec:
                r4 = r8
                long r7 = (long) r6     // Catch:{ all -> 0x0280 }
                r5.mo45889a(r7)     // Catch:{ all -> 0x0280 }
                goto L_0x01f3
            L_0x01f2:
                r4 = r8
            L_0x01f3:
                r7 = 0
                int r0 = (r23 > r7 ? 1 : (r23 == r7 ? 0 : -1))
                if (r0 == 0) goto L_0x0205
                if (r25 != 0) goto L_0x01fc
                goto L_0x0205
            L_0x01fc:
                r8 = r4
                r0 = r25
                r7 = r26
                r4 = r29
                goto L_0x0150
            L_0x0205:
                boolean r0 = r5.f43901d     // Catch:{ all -> 0x0280 }
                r6 = r0
                rx.c.e.h r0 = r5.f43902e     // Catch:{ all -> 0x0280 }
                r7 = r0
                if (r6 == 0) goto L_0x023b
                if (r7 == 0) goto L_0x0219
                boolean r0 = r7.mo46085c()     // Catch:{ all -> 0x0280 }
                if (r0 == 0) goto L_0x0216
                goto L_0x0219
            L_0x0216:
                r27 = r4
                goto L_0x023d
            L_0x0219:
                r1.mo45901b(r5)     // Catch:{ all -> 0x0280 }
                boolean r0 = r30.mo45898a()     // Catch:{ all -> 0x0280 }
                if (r0 == 0) goto L_0x0233
                r8 = 1
                if (r8 != 0) goto L_0x0230
                monitor-enter(r30)
                r27 = r4
                r4 = 0
                r1.f43912h = r4     // Catch:{ all -> 0x022d }
                monitor-exit(r30)     // Catch:{ all -> 0x022d }
                goto L_0x0232
            L_0x022d:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x022d }
                throw r0
            L_0x0230:
                r27 = r4
            L_0x0232:
                return
            L_0x0233:
                r27 = r4
                int r15 = r15 + 1
                r0 = 1
                r22 = r0
                goto L_0x023d
            L_0x023b:
                r27 = r4
            L_0x023d:
                r17 = 0
                int r0 = (r23 > r17 ? 1 : (r23 == r17 ? 0 : -1))
                if (r0 != 0) goto L_0x0248
                r0 = r22
                r6 = r23
                goto L_0x0262
            L_0x0248:
                int r3 = r3 + 1
                if (r3 != r13) goto L_0x024e
                r0 = 0
                r3 = r0
            L_0x024e:
                int r2 = r2 + 1
                r7 = r26
                r8 = r27
                r4 = r29
                goto L_0x0137
            L_0x0258:
                r29 = r4
                r26 = r7
                r27 = r8
                r0 = r22
                r6 = r23
            L_0x0262:
                r1.f43918n = r3     // Catch:{ all -> 0x0280 }
                r2 = r12[r3]     // Catch:{ all -> 0x0280 }
                long r4 = r2.f43900c     // Catch:{ all -> 0x0280 }
                r1.f43917m = r4     // Catch:{ all -> 0x0280 }
                r22 = r0
                goto L_0x0279
            L_0x026d:
                r22 = r0
                r21 = r2
                r29 = r4
                r26 = r5
                r23 = r6
                r27 = r8
            L_0x0279:
                if (r15 <= 0) goto L_0x0282
                long r2 = (long) r15     // Catch:{ all -> 0x0280 }
                r1.request(r2)     // Catch:{ all -> 0x0280 }
                goto L_0x0282
            L_0x0280:
                r0 = move-exception
                goto L_0x02b6
            L_0x0282:
                if (r22 == 0) goto L_0x028b
                r2 = r21
                r4 = r29
                r3 = 0
                goto L_0x0007
            L_0x028b:
                monitor-enter(r30)     // Catch:{ all -> 0x0280 }
                boolean r0 = r1.f43913i     // Catch:{ all -> 0x02ac }
                if (r0 != 0) goto L_0x02a1
                r2 = 1
                r3 = 0
                r1.f43912h = r3     // Catch:{ all -> 0x02b1 }
                monitor-exit(r30)     // Catch:{ all -> 0x02b1 }
                if (r2 != 0) goto L_0x02a0
                monitor-enter(r30)
                r3 = 0
                r1.f43912h = r3     // Catch:{ all -> 0x029d }
                monitor-exit(r30)     // Catch:{ all -> 0x029d }
                goto L_0x02a0
            L_0x029d:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x029d }
                throw r0
            L_0x02a0:
                return
            L_0x02a1:
                r2 = 0
                r1.f43913i = r2     // Catch:{ all -> 0x02ac }
                monitor-exit(r30)     // Catch:{ all -> 0x02ac }
                r2 = r21
                r4 = r29
                r3 = 0
                goto L_0x0007
            L_0x02ac:
                r0 = move-exception
                r2 = r21
            L_0x02af:
                monitor-exit(r30)     // Catch:{ all -> 0x02b1 }
                throw r0     // Catch:{ all -> 0x008d }
            L_0x02b1:
                r0 = move-exception
                goto L_0x02af
            L_0x02b3:
                r0 = move-exception
                r21 = r2
            L_0x02b6:
                if (r21 != 0) goto L_0x02c1
                monitor-enter(r30)
                r2 = 0
                r1.f43912h = r2     // Catch:{ all -> 0x02be }
                monitor-exit(r30)     // Catch:{ all -> 0x02be }
                goto L_0x02c1
            L_0x02be:
                r0 = move-exception
                monitor-exit(r30)     // Catch:{ all -> 0x02be }
                throw r0
            L_0x02c1:
                goto L_0x02c3
            L_0x02c2:
                throw r0
            L_0x02c3:
                goto L_0x02c2
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p390c.p391a.C14756ya.C14761e.mo45904d():void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo45898a() {
            if (this.f43906b.isUnsubscribed()) {
                return true;
            }
            Queue<Throwable> e = this.f43910f;
            if (this.f43907c || e == null || e.isEmpty()) {
                return false;
            }
            try {
                m46399g();
                return true;
            } finally {
                unsubscribe();
            }
        }
    }

    /* renamed from: a */
    public static <T> C14756ya<T> m46395a(boolean delayErrors) {
        if (delayErrors) {
            return C14757a.f43896a;
        }
        return C14758b.f43897a;
    }

    C14756ya(boolean delayErrors, int maxConcurrent) {
        this.f43894a = delayErrors;
        this.f43895b = maxConcurrent;
    }

    /* renamed from: a */
    public C14980ia<C0120S<? extends T>> call(C14980ia<? super T> child) {
        MergeSubscriber<T> subscriber = new C14761e<>(child, this.f43894a, this.f43895b);
        MergeProducer<T> producer = new C14760d<>(subscriber);
        subscriber.producer = producer;
        child.add(subscriber);
        child.setProducer(producer);
        return subscriber;
    }
}
