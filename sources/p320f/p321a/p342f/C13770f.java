package p320f.p321a.p342f;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p340j.C13738a;
import p320f.p321a.p327d.p340j.C13753n;

/* renamed from: f.a.f.f */
/* compiled from: SerializedObserver */
public final class C13770f<T> implements C13804t<T>, C13194b {

    /* renamed from: a */
    final C13804t<? super T> f41890a;

    /* renamed from: b */
    final boolean f41891b;

    /* renamed from: c */
    C13194b f41892c;

    /* renamed from: d */
    boolean f41893d;

    /* renamed from: e */
    C13738a<Object> f41894e;

    /* renamed from: f */
    volatile boolean f41895f;

    public C13770f(C13804t<? super T> actual) {
        this(actual, false);
    }

    public C13770f(C13804t<? super T> actual, boolean delayError) {
        this.f41890a = actual;
        this.f41891b = delayError;
    }

    public void onSubscribe(C13194b s) {
        if (C13218c.m43149a(this.f41892c, s)) {
            this.f41892c = s;
            this.f41890a.onSubscribe(this);
        }
    }

    public void dispose() {
        this.f41892c.dispose();
    }

    public void onNext(T t) {
        if (!this.f41895f) {
            if (t == null) {
                this.f41892c.dispose();
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            synchronized (this) {
                if (!this.f41895f) {
                    if (this.f41893d) {
                        C13738a<Object> aVar = this.f41894e;
                        if (aVar == null) {
                            aVar = new C13738a<>(4);
                            this.f41894e = aVar;
                        }
                        C13753n.m43785g(t);
                        aVar.mo42728a(t);
                        return;
                    }
                    this.f41893d = true;
                    this.f41890a.onNext(t);
                    mo42789a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        if (r0 == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        p320f.p321a.p343g.C13774a.m43836b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        r3.f41890a.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.f41895f
            if (r0 == 0) goto L_0x0008
            p320f.p321a.p343g.C13774a.m43836b(r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.f41895f     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0039
        L_0x000f:
            boolean r0 = r3.f41893d     // Catch:{ all -> 0x0046 }
            r1 = 1
            if (r0 == 0) goto L_0x0034
            r3.f41895f = r1     // Catch:{ all -> 0x0046 }
            f.a.d.j.a<java.lang.Object> r0 = r3.f41894e     // Catch:{ all -> 0x0046 }
            if (r0 != 0) goto L_0x0023
            f.a.d.j.a r1 = new f.a.d.j.a     // Catch:{ all -> 0x0046 }
            r2 = 4
            r1.<init>(r2)     // Catch:{ all -> 0x0046 }
            r0 = r1
            r3.f41894e = r0     // Catch:{ all -> 0x0046 }
        L_0x0023:
            java.lang.Object r1 = p320f.p321a.p327d.p340j.C13753n.m43776a(r4)     // Catch:{ all -> 0x0046 }
            boolean r2 = r3.f41891b     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x002f
            r0.mo42728a(r1)     // Catch:{ all -> 0x0046 }
            goto L_0x0032
        L_0x002f:
            r0.mo42730b(r1)     // Catch:{ all -> 0x0046 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            return
        L_0x0034:
            r3.f41895f = r1     // Catch:{ all -> 0x0046 }
            r3.f41893d = r1     // Catch:{ all -> 0x0046 }
            r0 = 0
        L_0x0039:
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            if (r0 == 0) goto L_0x0040
            p320f.p321a.p343g.C13774a.m43836b(r4)
            return
        L_0x0040:
            f.a.t<? super T> r1 = r3.f41890a
            r1.onError(r4)
            return
        L_0x0046:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0046 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p342f.C13770f.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f41895f) {
            synchronized (this) {
                if (!this.f41895f) {
                    if (this.f41893d) {
                        C13738a<Object> aVar = this.f41894e;
                        if (aVar == null) {
                            aVar = new C13738a<>(4);
                            this.f41894e = aVar;
                        }
                        aVar.mo42728a(C13753n.m43782e());
                        return;
                    }
                    this.f41895f = true;
                    this.f41893d = true;
                    this.f41890a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42789a() {
        AppendOnlyLinkedArrayList<Object> q;
        do {
            synchronized (this) {
                q = this.f41894e;
                if (q == null) {
                    this.f41893d = false;
                    return;
                }
                this.f41894e = null;
            }
        } while (!q.mo42729a(this.f41890a));
    }
}
