package p320f.p321a.p325b;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.List;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.p327d.p328a.C13217b;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p327d.p340j.C13757p;

/* renamed from: f.a.b.a */
/* compiled from: CompositeDisposable */
public final class C13193a implements C13194b, C13217b {

    /* renamed from: a */
    C13757p<C13194b> f40295a;

    /* renamed from: b */
    volatile boolean f40296b;

    public void dispose() {
        if (!this.f40296b) {
            synchronized (this) {
                if (!this.f40296b) {
                    this.f40296b = true;
                    OpenHashSet<Disposable> set = this.f40295a;
                    this.f40295a = null;
                    mo42248a((C13757p<C13194b>) set);
                }
            }
        }
    }

    /* renamed from: a */
    public boolean mo42249a() {
        return this.f40296b;
    }

    /* renamed from: b */
    public boolean mo42252b(C13194b d) {
        C13264b.m43226a(d, "d is null");
        if (!this.f40296b) {
            synchronized (this) {
                if (!this.f40296b) {
                    C13757p<C13194b> pVar = this.f40295a;
                    if (pVar == null) {
                        pVar = new C13757p<>();
                        this.f40295a = pVar;
                    }
                    pVar.mo42747a(d);
                    return true;
                }
            }
        }
        d.dispose();
        return false;
    }

    /* renamed from: a */
    public boolean mo42250a(C13194b d) {
        if (!mo42253c(d)) {
            return false;
        }
        d.dispose();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo42253c(p320f.p321a.p325b.C13194b r4) {
        /*
            r3 = this;
            java.lang.String r0 = "Disposable item is null"
            p320f.p321a.p327d.p329b.C13264b.m43226a(r4, r0)
            boolean r0 = r3.f40296b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r3)
            boolean r0 = r3.f40296b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            f.a.d.j.p<f.a.b.b> r0 = r3.f40295a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r2 = r0.mo42750b(r4)     // Catch:{ all -> 0x0022 }
            if (r2 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            r0 = 1
            return r0
        L_0x0020:
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p325b.C13193a.mo42253c(f.a.b.b):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return r1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo42251b() {
        /*
            r2 = this;
            boolean r0 = r2.f40296b
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.f40296b     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x000d:
            f.a.d.j.p<f.a.b.b> r0 = r2.f40295a     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            int r1 = r0.mo42751c()     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p325b.C13193a.mo42251b():int");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42248a(C13757p<C13194b> set) {
        Object[] array;
        if (set != null) {
            List list = null;
            for (Object o : set.mo42748a()) {
                if (o instanceof C13194b) {
                    try {
                        ((C13194b) o).dispose();
                    } catch (Throwable ex) {
                        C13980a.m44462b(ex);
                        if (list == null) {
                            list = new ArrayList();
                        }
                        list.add(ex);
                    }
                }
            }
            if (list == null) {
                return;
            }
            if (list.size() == 1) {
                throw C13748j.m43761a((Throwable) list.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) list);
        }
    }
}
