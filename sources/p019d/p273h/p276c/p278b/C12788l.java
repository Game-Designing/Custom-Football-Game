package p019d.p273h.p276c.p278b;

import android.os.Handler;
import android.os.HandlerThread;
import p019d.p273h.p276c.p280d.C12806h;

/* renamed from: d.h.c.b.l */
/* compiled from: SuperLooper */
public class C12788l extends Thread {

    /* renamed from: a */
    private static C12788l f39345a;

    /* renamed from: b */
    private C12789a f39346b = new C12789a(getClass().getSimpleName());

    /* renamed from: d.h.c.b.l$a */
    /* compiled from: SuperLooper */
    private class C12789a extends HandlerThread {

        /* renamed from: a */
        private Handler f39347a;

        C12789a(String name) {
            super(name);
            setUncaughtExceptionHandler(new C12806h());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo41379b() {
            this.f39347a = new Handler(getLooper());
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public Handler mo41378a() {
            return this.f39347a;
        }
    }

    private C12788l() {
        this.f39346b.start();
        this.f39346b.mo41379b();
    }

    /* renamed from: a */
    public static synchronized C12788l m41526a() {
        C12788l lVar;
        synchronized (C12788l.class) {
            if (f39345a == null) {
                f39345a = new C12788l();
            }
            lVar = f39345a;
        }
        return lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo41377a(java.lang.Runnable r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            d.h.c.b.l$a r0 = r1.f39346b     // Catch:{ all -> 0x0014 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            d.h.c.b.l$a r0 = r1.f39346b     // Catch:{ all -> 0x0014 }
            android.os.Handler r0 = r0.mo41378a()     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0012
            r0.post(r2)     // Catch:{ all -> 0x0014 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p273h.p276c.p278b.C12788l.mo41377a(java.lang.Runnable):void");
    }
}
