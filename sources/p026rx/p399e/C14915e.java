package p026rx.p399e;

import p026rx.C0125T;
import p026rx.exceptions.C14927a;
import p026rx.p390c.p391a.C14689m;

/* renamed from: rx.e.e */
/* compiled from: SerializedObserver */
public class C14915e<T> implements C0125T<T> {

    /* renamed from: a */
    private final C0125T<? super T> f44231a;

    /* renamed from: b */
    private boolean f44232b;

    /* renamed from: c */
    private volatile boolean f44233c;

    /* renamed from: d */
    private C14916a f44234d;

    /* renamed from: rx.e.e$a */
    /* compiled from: SerializedObserver */
    static final class C14916a {

        /* renamed from: a */
        Object[] f44235a;

        /* renamed from: b */
        int f44236b;

        C14916a() {
        }

        /* renamed from: a */
        public void mo46121a(Object o) {
            int s = this.f44236b;
            Object[] a = this.f44235a;
            if (a == null) {
                a = new Object[16];
                this.f44235a = a;
            } else if (s == a.length) {
                Object[] array2 = new Object[((s >> 2) + s)];
                System.arraycopy(a, 0, array2, 0, s);
                a = array2;
                this.f44235a = a;
            }
            a[s] = o;
            this.f44236b = s + 1;
        }
    }

    public C14915e(C0125T<? super T> s) {
        this.f44231a = s;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r8.f44231a.onNext(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        monitor-enter(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        r1 = r8.f44234d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        if (r1 != null) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r8.f44232b = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0037, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r8.f44234d = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x003c, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x003d, code lost:
        r2 = r1.f44235a;
        r3 = r2.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0041, code lost:
        if (r4 >= r3) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0043, code lost:
        r5 = r2[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0045, code lost:
        if (r5 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x004e, code lost:
        if (p026rx.p390c.p391a.C14689m.m46323a(r8.f44231a, r5) == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0050, code lost:
        r8.f44233c = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0052, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0053, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0057, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0058, code lost:
        r8.f44233c = true;
        p026rx.exceptions.C14927a.m46678c(r6);
        r8.f44231a.onError(p026rx.exceptions.OnErrorThrowable.m46666a(r6, r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0066, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0068, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x006a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        monitor-exit(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x006c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x006d, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x006f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0070, code lost:
        r8.f44233c = true;
        p026rx.exceptions.C14927a.m46673a(r1, r8.f44231a, (java.lang.Object) r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0077, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r9) {
        /*
            r8 = this;
            boolean r0 = r8.f44233c
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r8)
            boolean r0 = r8.f44233c     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r8)     // Catch:{ all -> 0x0078 }
            return
        L_0x000c:
            boolean r0 = r8.f44232b     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0025
            rx.e.e$a r0 = r8.f44234d     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x001c
            rx.e.e$a r1 = new rx.e.e$a     // Catch:{ all -> 0x0078 }
            r1.<init>()     // Catch:{ all -> 0x0078 }
            r0 = r1
            r8.f44234d = r0     // Catch:{ all -> 0x0078 }
        L_0x001c:
            java.lang.Object r1 = p026rx.p390c.p391a.C14689m.m46326d(r9)     // Catch:{ all -> 0x0078 }
            r0.mo46121a(r1)     // Catch:{ all -> 0x0078 }
            monitor-exit(r8)     // Catch:{ all -> 0x0078 }
            return
        L_0x0025:
            r0 = 1
            r8.f44232b = r0     // Catch:{ all -> 0x0078 }
            monitor-exit(r8)     // Catch:{ all -> 0x0078 }
            rx.T<? super T> r1 = r8.f44231a     // Catch:{ Throwable -> 0x006f }
            r1.onNext(r9)     // Catch:{ Throwable -> 0x006f }
            r1 = r8
        L_0x002f:
            monitor-enter(r8)
            rx.e.e$a r1 = r8.f44234d     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x0039
            r0 = 0
            r8.f44232b = r0     // Catch:{ all -> 0x006d }
            monitor-exit(r8)     // Catch:{ all -> 0x006d }
            return
        L_0x0039:
            r2 = 0
            r8.f44234d = r2     // Catch:{ all -> 0x0068 }
            monitor-exit(r8)     // Catch:{ all -> 0x0068 }
            java.lang.Object[] r2 = r1.f44235a
            int r3 = r2.length
            r4 = 0
        L_0x0041:
            if (r4 >= r3) goto L_0x0067
            r5 = r2[r4]
            if (r5 != 0) goto L_0x0048
            goto L_0x0067
        L_0x0048:
            rx.T<? super T> r6 = r8.f44231a     // Catch:{ Throwable -> 0x0057 }
            boolean r6 = p026rx.p390c.p391a.C14689m.m46323a(r6, r5)     // Catch:{ Throwable -> 0x0057 }
            if (r6 == 0) goto L_0x0053
            r8.f44233c = r0     // Catch:{ Throwable -> 0x0057 }
            return
        L_0x0053:
            int r4 = r4 + 1
            goto L_0x0041
        L_0x0057:
            r6 = move-exception
            r8.f44233c = r0
            p026rx.exceptions.C14927a.m46678c(r6)
            rx.T<? super T> r0 = r8.f44231a
            java.lang.Throwable r7 = p026rx.exceptions.OnErrorThrowable.m46666a(r6, r9)
            r0.onError(r7)
            return
        L_0x0067:
            goto L_0x002f
        L_0x0068:
            r0 = move-exception
            goto L_0x006b
        L_0x006a:
            r0 = move-exception
        L_0x006b:
            monitor-exit(r8)     // Catch:{ all -> 0x006d }
            throw r0
        L_0x006d:
            r0 = move-exception
            goto L_0x006b
        L_0x006f:
            r1 = move-exception
            r8.f44233c = r0
            rx.T<? super T> r0 = r8.f44231a
            p026rx.exceptions.C14927a.m46673a(r1, r0, r9)
            return
        L_0x0078:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0078 }
            goto L_0x007c
        L_0x007b:
            throw r0
        L_0x007c:
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: p026rx.p399e.C14915e.onNext(java.lang.Object):void");
    }

    public void onError(Throwable e) {
        C14927a.m46678c(e);
        if (!this.f44233c) {
            synchronized (this) {
                if (!this.f44233c) {
                    this.f44233c = true;
                    if (this.f44232b) {
                        C14916a list = this.f44234d;
                        if (list == null) {
                            list = new C14916a();
                            this.f44234d = list;
                        }
                        list.mo46121a(C14689m.m46321a(e));
                        return;
                    }
                    this.f44232b = true;
                    this.f44231a.onError(e);
                }
            }
        }
    }

    public void onCompleted() {
        if (!this.f44233c) {
            synchronized (this) {
                if (!this.f44233c) {
                    this.f44233c = true;
                    if (this.f44232b) {
                        C14916a list = this.f44234d;
                        if (list == null) {
                            list = new C14916a();
                            this.f44234d = list;
                        }
                        list.mo46121a(C14689m.m46320a());
                        return;
                    }
                    this.f44232b = true;
                    this.f44231a.onCompleted();
                }
            }
        }
    }
}
