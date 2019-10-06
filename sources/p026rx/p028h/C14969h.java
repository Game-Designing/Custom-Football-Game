package p026rx.p028h;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.p027b.C0129b;
import p026rx.p027b.C14537m;
import p026rx.p029i.C14978f;
import p026rx.p390c.p391a.C14689m;
import rx.subjects.SubjectSubscriptionManager.SubjectObserver;

/* renamed from: rx.h.h */
/* compiled from: SubjectSubscriptionManager */
final class C14969h<T> extends AtomicReference<C14970a<T>> implements C0122a<T> {

    /* renamed from: a */
    volatile Object f44305a;

    /* renamed from: b */
    boolean f44306b = true;

    /* renamed from: c */
    C0129b<C14971b<T>> f44307c = C14537m.m46177a();

    /* renamed from: d */
    C0129b<C14971b<T>> f44308d = C14537m.m46177a();

    /* renamed from: e */
    C0129b<C14971b<T>> f44309e = C14537m.m46177a();

    /* renamed from: rx.h.h$a */
    /* compiled from: SubjectSubscriptionManager */
    protected static final class C14970a<T> {

        /* renamed from: a */
        static final C14971b[] f44310a = new C14971b[0];

        /* renamed from: b */
        static final C14970a f44311b = new C14970a(true, f44310a);

        /* renamed from: c */
        static final C14970a f44312c = new C14970a(false, f44310a);

        /* renamed from: d */
        final boolean f44313d;

        /* renamed from: e */
        final C14971b[] f44314e;

        public C14970a(boolean terminated, C14971b[] observers) {
            this.f44313d = terminated;
            this.f44314e = observers;
        }

        /* renamed from: a */
        public C14970a mo46189a(C14971b o) {
            int n = this.f44314e.length;
            C14971b[] b = new C14971b[(n + 1)];
            System.arraycopy(this.f44314e, 0, b, 0, n);
            b[n] = o;
            return new C14970a(this.f44313d, b);
        }

        /* renamed from: b */
        public C14970a mo46190b(C14971b o) {
            C14971b[] a = this.f44314e;
            if (n == 1 && a[0] == o) {
                return f44312c;
            }
            if (n == 0) {
                return this;
            }
            C14971b[] b = new C14971b[(n - 1)];
            int j = 0;
            for (C14971b ai : a) {
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
                return f44312c;
            }
            if (j < n - 1) {
                C14971b[] c = new C14971b[j];
                System.arraycopy(b, 0, c, 0, j);
                b = c;
            }
            return new C14970a(this.f44313d, b);
        }
    }

    /* renamed from: rx.h.h$b */
    /* compiled from: SubjectSubscriptionManager */
    protected static final class C14971b<T> implements C0125T<T> {

        /* renamed from: a */
        final C14980ia<? super T> f44315a;

        /* renamed from: b */
        boolean f44316b = true;

        /* renamed from: c */
        boolean f44317c;

        /* renamed from: d */
        List<Object> f44318d;

        /* renamed from: e */
        boolean f44319e;

        public C14971b(C14980ia<? super T> actual) {
            this.f44315a = actual;
        }

        public void onNext(T t) {
            this.f44315a.onNext(t);
        }

        public void onError(Throwable e) {
            this.f44315a.onError(e);
        }

        public void onCompleted() {
            this.f44315a.onCompleted();
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
            r1.f44319e = true;
         */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo46194c(java.lang.Object r2) {
            /*
                r1 = this;
                boolean r0 = r1.f44319e
                if (r0 != 0) goto L_0x0026
                monitor-enter(r1)
                r0 = 0
                r1.f44316b = r0     // Catch:{ all -> 0x0023 }
                boolean r0 = r1.f44317c     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x001e
                java.util.List<java.lang.Object> r0 = r1.f44318d     // Catch:{ all -> 0x0023 }
                if (r0 != 0) goto L_0x0017
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0023 }
                r0.<init>()     // Catch:{ all -> 0x0023 }
                r1.f44318d = r0     // Catch:{ all -> 0x0023 }
            L_0x0017:
                java.util.List<java.lang.Object> r0 = r1.f44318d     // Catch:{ all -> 0x0023 }
                r0.add(r2)     // Catch:{ all -> 0x0023 }
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                return
            L_0x001e:
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                r0 = 1
                r1.f44319e = r0
                goto L_0x0026
            L_0x0023:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0023 }
                throw r0
            L_0x0026:
                rx.ia<? super T> r0 = r1.f44315a
                p026rx.p390c.p391a.C14689m.m46323a(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p028h.C14969h.C14971b.mo46194c(java.lang.Object):void");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0013, code lost:
            if (r2 == null) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
            mo46192a(null, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
            return;
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void mo46193b(java.lang.Object r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                boolean r0 = r1.f44316b     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r1.f44317c     // Catch:{ all -> 0x001c }
                if (r0 == 0) goto L_0x000a
                goto L_0x001a
            L_0x000a:
                r0 = 0
                r1.f44316b = r0     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0010
                r0 = 1
            L_0x0010:
                r1.f44317c = r0     // Catch:{ all -> 0x001c }
                monitor-exit(r1)     // Catch:{ all -> 0x001c }
                if (r2 == 0) goto L_0x0019
                r0 = 0
                r1.mo46192a(r0, r2)
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
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p028h.C14969h.C14971b.mo46193b(java.lang.Object):void");
        }

        /* access modifiers changed from: 0000 */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
            if (1 != 0) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
            monitor-enter(r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r5.f44317c = false;
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
        public void mo46192a(java.util.List<java.lang.Object> r6, java.lang.Object r7) {
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
                r5.mo46191a(r4)     // Catch:{ all -> 0x0017 }
                goto L_0x0009
            L_0x0017:
                r3 = move-exception
                goto L_0x003c
            L_0x0019:
                if (r0 == 0) goto L_0x001f
                r0 = 0
                r5.mo46191a(r7)     // Catch:{ all -> 0x0017 }
            L_0x001f:
                monitor-enter(r5)     // Catch:{ all -> 0x0017 }
                java.util.List<java.lang.Object> r3 = r5.f44318d     // Catch:{ all -> 0x0039 }
                r6 = r3
                r3 = 0
                r5.f44318d = r3     // Catch:{ all -> 0x0039 }
                if (r6 != 0) goto L_0x0037
                r5.f44317c = r2     // Catch:{ all -> 0x0039 }
                r1 = 1
                monitor-exit(r5)     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0036
                monitor-enter(r5)
                r5.f44317c = r2     // Catch:{ all -> 0x0033 }
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
                r5.f44317c = r2     // Catch:{ all -> 0x0043 }
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
            throw new UnsupportedOperationException("Method not decompiled: p026rx.p028h.C14969h.C14971b.mo46192a(java.util.List, java.lang.Object):void");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo46191a(Object n) {
            if (n != null) {
                C14689m.m46323a(this.f44315a, n);
            }
        }
    }

    public C14969h() {
        super(C14970a.f44312c);
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        SubjectObserver<T> bo = new C14971b<>(child);
        mo46183a(child, bo);
        this.f44307c.call(bo);
        if (!child.isUnsubscribed() && mo46184a((C14971b<T>) bo) && child.isUnsubscribed()) {
            mo46187b((C14971b<T>) bo);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo46183a(C14980ia<? super T> child, C14971b<T> bo) {
        child.add(C14978f.m46781a(new C14968g(this, bo)));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo46186b(Object value) {
        this.f44305a = value;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo46181a() {
        return this.f44305a;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo46184a(C14971b<T> o) {
        C14970a oldState;
        do {
            oldState = (C14970a) get();
            if (oldState.f44313d) {
                this.f44309e.call(o);
                return false;
            }
        } while (!compareAndSet(oldState, oldState.mo46189a(o)));
        this.f44308d.call(o);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo46187b(C14971b<T> o) {
        C14970a oldState;
        C14970a newState;
        do {
            oldState = (C14970a) get();
            if (!oldState.f44313d) {
                newState = oldState.mo46190b(o);
                if (newState == oldState) {
                    break;
                }
            } else {
                return;
            }
        } while (!compareAndSet(oldState, newState));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C14971b<T>[] mo46185a(Object n) {
        mo46186b(n);
        return ((C14970a) get()).f44314e;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C14971b<T>[] mo46188c(Object n) {
        mo46186b(n);
        this.f44306b = false;
        if (((C14970a) get()).f44313d) {
            return C14970a.f44310a;
        }
        return ((C14970a) getAndSet(C14970a.f44311b)).f44314e;
    }
}
