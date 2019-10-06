package p320f.p321a.p327d.p337g;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13217b;

/* renamed from: f.a.d.g.k */
/* compiled from: ScheduledRunnable */
public final class C13724k extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, C13194b {

    /* renamed from: a */
    static final Object f41806a = new Object();

    /* renamed from: b */
    static final Object f41807b = new Object();

    /* renamed from: c */
    static final Object f41808c = new Object();

    /* renamed from: d */
    static final Object f41809d = new Object();

    /* renamed from: e */
    final Runnable f41810e;

    public C13724k(Runnable actual, C13217b parent) {
        super(3);
        this.f41810e = actual;
        lazySet(0, parent);
    }

    public Object call() {
        run();
        return null;
    }

    public void run() {
        Object o;
        Object o2;
        lazySet(2, Thread.currentThread());
        try {
            this.f41810e.run();
        } catch (Throwable th) {
            lazySet(2, null);
            Object o3 = get(0);
            if (!(o3 == f41806a || !compareAndSet(0, o3, f41809d) || o3 == null)) {
                ((C13217b) o3).mo42253c(this);
            }
            do {
                o2 = get(1);
                if (o2 == f41807b || o2 == f41808c) {
                    throw th;
                }
            } while (!compareAndSet(1, o2, f41809d));
            throw th;
        }
        lazySet(2, null);
        Object o4 = get(0);
        if (!(o4 == f41806a || !compareAndSet(0, o4, f41809d) || o4 == null)) {
            ((C13217b) o4).mo42253c(this);
        }
        do {
            o = get(1);
            if (o == f41807b || o == f41808c) {
                return;
            }
        } while (!compareAndSet(1, o, f41809d));
    }

    /* renamed from: a */
    public void mo42717a(Future<?> f) {
        Object o;
        do {
            o = get(1);
            if (o != f41809d) {
                if (o == f41807b) {
                    f.cancel(false);
                    return;
                } else if (o == f41808c) {
                    f.cancel(true);
                    return;
                }
            } else {
                return;
            }
        } while (!compareAndSet(1, o, f));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispose() {
        /*
            r5 = this;
        L_0x0000:
            r0 = 1
            java.lang.Object r1 = r5.get(r0)
            java.lang.Object r2 = f41809d
            r3 = 0
            if (r1 == r2) goto L_0x0038
            java.lang.Object r2 = f41807b
            if (r1 == r2) goto L_0x0038
            java.lang.Object r2 = f41808c
            if (r1 != r2) goto L_0x0013
            goto L_0x0038
        L_0x0013:
            r2 = 2
            java.lang.Object r2 = r5.get(r2)
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            if (r2 == r4) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 == 0) goto L_0x0026
            java.lang.Object r4 = f41808c
            goto L_0x0028
        L_0x0026:
            java.lang.Object r4 = f41807b
        L_0x0028:
            boolean r0 = r5.compareAndSet(r0, r1, r4)
            if (r0 == 0) goto L_0x0037
            if (r1 == 0) goto L_0x0038
            r0 = r1
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0
            r0.cancel(r2)
            goto L_0x0038
        L_0x0037:
            goto L_0x0000
        L_0x0038:
            java.lang.Object r0 = r5.get(r3)
            java.lang.Object r1 = f41809d
            if (r0 == r1) goto L_0x0055
            java.lang.Object r1 = f41806a
            if (r0 == r1) goto L_0x0055
            if (r0 != 0) goto L_0x0047
            goto L_0x0055
        L_0x0047:
            boolean r1 = r5.compareAndSet(r3, r0, r1)
            if (r1 == 0) goto L_0x0054
            r1 = r0
            f.a.d.a.b r1 = (p320f.p321a.p327d.p328a.C13217b) r1
            r1.mo42253c(r5)
            return
        L_0x0054:
            goto L_0x0038
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p337g.C13724k.dispose():void");
    }
}
