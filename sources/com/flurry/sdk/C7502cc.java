package com.flurry.sdk;

import com.flurry.sdk.C7376Ed;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.flurry.sdk.cc */
public class C7502cc<T extends C7376Ed> {

    /* renamed from: a */
    private static final String f14774a = C7502cc.class.getSimpleName();

    /* renamed from: b */
    private final C7426Nb<Object, T> f14775b = new C7426Nb<>();

    /* renamed from: c */
    private final HashMap<T, Object> f14776c = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final HashMap<T, Future<?>> f14777d = new HashMap<>();

    /* renamed from: e */
    private final ThreadPoolExecutor f14778e;

    /* renamed from: a */
    static /* synthetic */ C7376Ed m16604a(Runnable runnable) {
        if (runnable instanceof C7472Wb) {
            return (C7376Ed) ((C7472Wb) runnable).mo23915a();
        }
        if (runnable instanceof C7376Ed) {
            return (C7376Ed) runnable;
        }
        String str = f14774a;
        StringBuilder sb = new StringBuilder("Unknown runnable class: ");
        sb.append(runnable.getClass().getName());
        C7513ec.m16639a(6, str, sb.toString());
        return null;
    }

    public C7502cc(String str, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        this.f14778e = new C7484Zb(this, timeUnit, blockingQueue);
        this.f14778e.setRejectedExecutionHandler(new C7492ac(this));
        this.f14778e.setThreadFactory(new C7614vd(str));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m16606a(T t) {
        m16609b(this.f14776c.get(t), t);
    }

    /* renamed from: b */
    private synchronized void m16609b(Object obj, T t) {
        this.f14775b.mo23869b(obj, t);
        this.f14776c.remove(t);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void mo23939a(java.lang.Object r1, T r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            if (r1 == 0) goto L_0x0013
            if (r2 != 0) goto L_0x0006
            goto L_0x0013
        L_0x0006:
            r0.m16610c(r1, r2)     // Catch:{ all -> 0x0010 }
            java.util.concurrent.ThreadPoolExecutor r1 = r0.f14778e     // Catch:{ all -> 0x0010 }
            r1.submit(r2)     // Catch:{ all -> 0x0010 }
            monitor-exit(r0)
            return
        L_0x0010:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        L_0x0013:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7502cc.mo23939a(java.lang.Object, com.flurry.sdk.Ed):void");
    }

    /* renamed from: c */
    private synchronized void m16610c(Object obj, T t) {
        this.f14775b.mo23866a(obj, t);
        this.f14776c.put(t, obj);
    }

    /* renamed from: a */
    public final synchronized void mo23938a(Object obj) {
        if (obj != null) {
            HashSet<C7376Ed> hashSet = new HashSet<>();
            hashSet.addAll(this.f14775b.mo23863a(obj));
            for (C7376Ed b : hashSet) {
                m16608b(b);
            }
        }
    }

    /* renamed from: b */
    private synchronized void m16608b(T t) {
        Future future;
        if (t != null) {
            synchronized (this.f14777d) {
                future = (Future) this.f14777d.remove(t);
            }
            m16606a(t);
            if (future != null) {
                future.cancel(true);
            }
            new C7497bc(this, t).run();
        }
    }
}
