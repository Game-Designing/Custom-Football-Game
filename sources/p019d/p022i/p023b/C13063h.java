package p019d.p022i.p023b;

import com.jakewharton.rxrelay.RelaySubscriptionManager.RelayObserver;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.p027b.C0129b;
import p026rx.p027b.C14537m;
import p026rx.p029i.C14978f;

/* renamed from: d.i.b.h */
/* compiled from: RelaySubscriptionManager */
final class C13063h<T> extends AtomicReference<C13065b<T>> implements C0122a<T> {

    /* renamed from: a */
    volatile Object f40049a;

    /* renamed from: b */
    boolean f40050b = true;

    /* renamed from: c */
    C0129b<C13064a<T>> f40051c = C14537m.m46177a();

    /* renamed from: d */
    C0129b<C13064a<T>> f40052d = C14537m.m46177a();

    /* renamed from: d.i.b.h$a */
    /* compiled from: RelaySubscriptionManager */
    static final class C13064a<T> implements C0125T<T> {

        /* renamed from: a */
        final C0125T<? super T> f40053a;

        /* renamed from: b */
        boolean f40054b = true;

        /* renamed from: c */
        boolean f40055c;

        /* renamed from: d */
        List<Object> f40056d;

        /* renamed from: e */
        boolean f40057e;

        C13064a(C0125T<? super T> actual) {
            this.f40053a = actual;
        }

        public void onNext(T t) {
            this.f40053a.onNext(t);
        }

        public void onError(Throwable e) {
            throw new AssertionError();
        }

        public void onCompleted() {
            throw new AssertionError();
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1.f40057e = true;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo41963b(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r1.f40057e
                if (r0 != 0) goto L_0x0026
                monitor-enter(r1)
                r0 = 0
                r1.f40054b = r0     // Catch:{ all -> 0x0023 }
                boolean r0 = r1.f40055c     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x001e
                java.util.List<java.lang.Object> r0 = r1.f40056d     // Catch:{ all -> 0x0023 }
                if (r0 != 0) goto L_0x0017
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0023 }
                r0.<init>()     // Catch:{ all -> 0x0023 }
                r1.f40056d = r0     // Catch:{ all -> 0x0023 }
            L_0x0017:
                java.util.List<java.lang.Object> r0 = r1.f40056d     // Catch:{ all -> 0x0023 }
                r0.add(r2)     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                return
            L_0x001e:
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                r0 = 1
                r1.f40057e = r0
                goto L_0x0026
            L_0x0023:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                throw r0
            L_0x0026:
                rx.T<? super T> r0 = r1.f40053a
                p019d.p022i.p023b.C13061d.m42513a(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p019d.p022i.p023b.C13063h.C13064a.mo41963b(java.lang.Object):void");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            if (r2 == null) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
            m42522a(null, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo41962a(java.lang.Object r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.f40054b     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r1.f40055c     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x000a
                goto L_0x001a
            L_0x000a:
                r0 = 0
                r1.f40054b = r0     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0010
                r0 = 1
            L_0x0010:
                r1.f40055c = r0     // Catch:{ all -> 0x001c }
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0019
                r0 = 0
                r1.m42522a(r0, r2)
            L_0x0019:
                return
            L_0x001a:
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p019d.p022i.p023b.C13063h.C13064a.mo41962a(java.lang.Object):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r5.f40055c = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
            monitor-exit(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m42522a(java.util.List<java.lang.Object> r6, java.lang.Object r7) {
            /*
                r5 = this;
                r0 = 1
                r1 = 0
            L_0x0002:
                r2 = 0
                if (r6 == 0) goto L_0x0019
                java.util.Iterator r3 = r6.iterator()     // Catch:{ all -> 0x0017 }
            L_0x0009:
                boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0017 }
                if (r4 == 0) goto L_0x0019
                java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0017 }
                r5.m42523c(r4)     // Catch:{ all -> 0x0017 }
                goto L_0x0009
            L_0x0017:
                r3 = move-exception
                goto L_0x003c
            L_0x0019:
                if (r0 == 0) goto L_0x001f
                r0 = 0
                r5.m42523c(r7)     // Catch:{ all -> 0x0017 }
            L_0x001f:
                monitor-enter(r5)     // Catch:{ all -> 0x0017 }
                java.util.List<java.lang.Object> r3 = r5.f40056d     // Catch:{ all -> 0x0039 }
                r6 = r3
                r3 = 0
                r5.f40056d = r3     // Catch:{ all -> 0x0039 }
                if (r6 != 0) goto L_0x0037
                r5.f40055c = r2     // Catch:{ all -> 0x0039 }
                r1 = 1
                monitor-exit(r5)     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0036
                monitor-enter(r5)
                r5.f40055c = r2     // Catch:{ all -> 0x0033 }
                monitor-exit(r5)     // Catch:{ all -> 0x0033 }
                goto L_0x0036
            L_0x0033:
                r2 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0033 }
                throw r2
            L_0x0036:
                return
            L_0x0037:
                monitor-exit(r5)     // Catch:{ all -> 0x0039 }
                goto L_0x0002
            L_0x0039:
                r3 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0039 }
                throw r3     // Catch:{ all -> 0x0017 }
            L_0x003c:
                if (r1 != 0) goto L_0x0046
                monitor-enter(r5)
                r5.f40055c = r2     // Catch:{ all -> 0x0043 }
                monitor-exit(r5)     // Catch:{ all -> 0x0043 }
                goto L_0x0046
            L_0x0043:
                r2 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0043 }
                throw r2
            L_0x0046:
                goto L_0x0048
            L_0x0047:
                throw r3
            L_0x0048:
                goto L_0x0047
            */
            throw new UnsupportedOperationException("Method not decompiled: p019d.p022i.p023b.C13063h.C13064a.m42522a(java.util.List, java.lang.Object):void");
        }

        /* renamed from: c */
        private void m42523c(Object n) {
            if (n != null) {
                C13061d.m42513a(this.f40053a, n);
            }
        }
    }

    /* renamed from: d.i.b.h$b */
    /* compiled from: RelaySubscriptionManager */
    static final class C13065b<T> {

        /* renamed from: a */
        static final C13065b f40058a = new C13065b(new C13064a[0]);

        /* renamed from: b */
        final C13064a[] f40059b;

        C13065b(C13064a[] observers) {
            this.f40059b = observers;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C13065b mo41964a(C13064a o) {
            int n = this.f40059b.length;
            C13064a[] b = new C13064a[(n + 1)];
            System.arraycopy(this.f40059b, 0, b, 0, n);
            b[n] = o;
            return new C13065b(b);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public C13065b mo41965b(C13064a o) {
            C13064a[] a = this.f40059b;
            if (n == 1 && a[0] == o) {
                return f40058a;
            }
            if (n == 0) {
                return this;
            }
            C13064a[] b = new C13064a[(n - 1)];
            int j = 0;
            for (C13064a ai : a) {
                if (ai != o) {
                    if (j == n - 1) {
                        return this;
                    }
                    int j2 = j + 1;
                    b[j] = ai;
                    j = j2;
                }
            }
            if (j == 0) {
                return f40058a;
            }
            if (j < n - 1) {
                C13064a[] c = new C13064a[j];
                System.arraycopy(b, 0, c, 0, j);
                b = c;
            }
            return new C13065b(b);
        }
    }

    C13063h() {
        super(C13065b.f40058a);
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        RelayObserver<T> bo = new C13064a<>(child);
        m42514a(child, bo);
        this.f40051c.call(bo);
        if (!child.isUnsubscribed()) {
            m42515b((C13064a<T>) bo);
            if (child.isUnsubscribed()) {
                mo41957a((C13064a<T>) bo);
            }
        }
    }

    /* renamed from: a */
    private void m42514a(C14980ia<? super T> child, C13064a<T> bo) {
        child.add(C14978f.m46781a(new C13062g(this, bo)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo41960b(Object value) {
        this.f40049a = value;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo41956a() {
        return this.f40049a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C13064a<T>[] mo41961b() {
        return ((C13065b) get()).f40059b;
    }

    /* renamed from: b */
    private void m42515b(C13064a<T> o) {
        C13065b oldState;
        do {
            oldState = (C13065b) get();
        } while (!compareAndSet(oldState, oldState.mo41964a(o)));
        this.f40052d.call(o);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo41957a(C13064a<T> o) {
        C13065b oldState;
        C13065b newState;
        do {
            oldState = (C13065b) get();
            newState = oldState.mo41965b(o);
            if (newState == oldState) {
                return;
            }
        } while (!compareAndSet(oldState, newState));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C13064a<T>[] mo41959a(Object n) {
        mo41960b(n);
        return ((C13065b) get()).f40059b;
    }
}
