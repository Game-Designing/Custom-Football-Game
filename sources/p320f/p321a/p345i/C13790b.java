package p320f.p321a.p345i;

import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p340j.C13738a;
import p320f.p321a.p327d.p340j.C13738a.C13739a;
import p320f.p321a.p327d.p340j.C13753n;

/* renamed from: f.a.i.b */
/* compiled from: SerializedSubject */
final class C13790b<T> extends C13791c<T> implements C13739a<Object> {

    /* renamed from: a */
    final C13791c<T> f41941a;

    /* renamed from: b */
    boolean f41942b;

    /* renamed from: c */
    C13738a<Object> f41943c;

    /* renamed from: d */
    volatile boolean f41944d;

    C13790b(C13791c<T> actual) {
        this.f41941a = actual;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41941a.subscribe(observer);
    }

    public void onSubscribe(C13194b s) {
        boolean cancel;
        if (!this.f41944d) {
            synchronized (this) {
                if (this.f41944d) {
                    cancel = true;
                } else if (this.f41942b) {
                    C13738a<Object> aVar = this.f41943c;
                    if (aVar == null) {
                        aVar = new C13738a<>(4);
                        this.f41943c = aVar;
                    }
                    aVar.mo42728a(C13753n.m43775a(s));
                    return;
                } else {
                    this.f41942b = true;
                    cancel = false;
                }
            }
        } else {
            cancel = true;
        }
        if (cancel) {
            s.dispose();
        } else {
            this.f41941a.onSubscribe(s);
            mo42807b();
        }
    }

    public void onNext(T t) {
        if (!this.f41944d) {
            synchronized (this) {
                if (!this.f41944d) {
                    if (this.f41942b) {
                        C13738a<Object> aVar = this.f41943c;
                        if (aVar == null) {
                            aVar = new C13738a<>(4);
                            this.f41943c = aVar;
                        }
                        C13753n.m43785g(t);
                        aVar.mo42728a(t);
                        return;
                    }
                    this.f41942b = true;
                    this.f41941a.onNext(t);
                    mo42807b();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        if (r0 == false) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0033, code lost:
        p320f.p321a.p343g.C13774a.m43836b(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
        r3.f41941a.onError(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.f41944d
            if (r0 == 0) goto L_0x0008
            p320f.p321a.p343g.C13774a.m43836b(r4)
            return
        L_0x0008:
            monitor-enter(r3)
            boolean r0 = r3.f41944d     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x000f
            r0 = 1
            goto L_0x0030
        L_0x000f:
            r0 = 1
            r3.f41944d = r0     // Catch:{ all -> 0x003d }
            boolean r1 = r3.f41942b     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x002c
            f.a.d.j.a<java.lang.Object> r0 = r3.f41943c     // Catch:{ all -> 0x003d }
            if (r0 != 0) goto L_0x0023
            f.a.d.j.a r1 = new f.a.d.j.a     // Catch:{ all -> 0x003d }
            r2 = 4
            r1.<init>(r2)     // Catch:{ all -> 0x003d }
            r0 = r1
            r3.f41943c = r0     // Catch:{ all -> 0x003d }
        L_0x0023:
            java.lang.Object r1 = p320f.p321a.p327d.p340j.C13753n.m43776a(r4)     // Catch:{ all -> 0x003d }
            r0.mo42730b(r1)     // Catch:{ all -> 0x003d }
            monitor-exit(r3)     // Catch:{ all -> 0x003d }
            return
        L_0x002c:
            r1 = 0
            r3.f41942b = r0     // Catch:{ all -> 0x003d }
            r0 = r1
        L_0x0030:
            monitor-exit(r3)     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0037
            p320f.p321a.p343g.C13774a.m43836b(r4)
            return
        L_0x0037:
            f.a.i.c<T> r1 = r3.f41941a
            r1.onError(r4)
            return
        L_0x003d:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x003d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p345i.C13790b.onError(java.lang.Throwable):void");
    }

    public void onComplete() {
        if (!this.f41944d) {
            synchronized (this) {
                if (!this.f41944d) {
                    this.f41944d = true;
                    if (this.f41942b) {
                        C13738a<Object> aVar = this.f41943c;
                        if (aVar == null) {
                            aVar = new C13738a<>(4);
                            this.f41943c = aVar;
                        }
                        aVar.mo42728a(C13753n.m43782e());
                        return;
                    }
                    this.f41942b = true;
                    this.f41941a.onComplete();
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42807b() {
        AppendOnlyLinkedArrayList<Object> q;
        while (true) {
            synchronized (this) {
                q = this.f41943c;
                if (q == null) {
                    this.f41942b = false;
                    return;
                }
                this.f41943c = null;
            }
            q.mo42727a((C13739a<? super T>) this);
        }
        while (true) {
        }
    }

    public boolean test(Object o) {
        return C13753n.m43779b(o, this.f41941a);
    }
}
