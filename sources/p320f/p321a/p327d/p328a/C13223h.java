package p320f.p321a.p327d.p328a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p024io.reactivex.exceptions.C13980a;
import p024io.reactivex.exceptions.CompositeException;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p340j.C13748j;

/* renamed from: f.a.d.a.h */
/* compiled from: ListCompositeDisposable */
public final class C13223h implements C13194b, C13217b {

    /* renamed from: a */
    List<C13194b> f40303a;

    /* renamed from: b */
    volatile boolean f40304b;

    public void dispose() {
        if (!this.f40304b) {
            synchronized (this) {
                if (!this.f40304b) {
                    this.f40304b = true;
                    List<C13194b> list = this.f40303a;
                    this.f40303a = null;
                    mo42279a(list);
                }
            }
        }
    }

    /* renamed from: b */
    public boolean mo42252b(C13194b d) {
        C13264b.m43226a(d, "d is null");
        if (!this.f40304b) {
            synchronized (this) {
                if (!this.f40304b) {
                    List<C13194b> list = this.f40303a;
                    if (list == null) {
                        list = new LinkedList<>();
                        this.f40303a = list;
                    }
                    list.add(d);
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
            boolean r0 = r3.f40304b
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r3)
            boolean r0 = r3.f40304b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r3)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<f.a.b.b> r0 = r3.f40303a     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r2 = r0.remove(r4)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p328a.C13223h.mo42253c(f.a.b.b):boolean");
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42279a(List<C13194b> set) {
        if (set != null) {
            List<Throwable> errors = null;
            for (C13194b o : set) {
                try {
                    o.dispose();
                } catch (Throwable ex) {
                    C13980a.m44462b(ex);
                    if (errors == null) {
                        errors = new ArrayList<>();
                    }
                    errors.add(ex);
                }
            }
            if (errors == null) {
                return;
            }
            if (errors.size() == 1) {
                throw C13748j.m43761a((Throwable) errors.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) errors);
        }
    }
}
