package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* renamed from: com.airbnb.lottie.F */
/* compiled from: LottieTask */
public class C5667F<T> {

    /* renamed from: a */
    public static Executor f9624a = Executors.newCachedThreadPool();

    /* renamed from: b */
    private Thread f9625b;

    /* renamed from: c */
    private final Set<C5854z<T>> f9626c;

    /* renamed from: d */
    private final Set<C5854z<Throwable>> f9627d;

    /* renamed from: e */
    private final Handler f9628e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final FutureTask<C5664C<T>> f9629f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile C5664C<T> f9630g;

    public C5667F(Callable<C5664C<T>> runnable) {
        this(runnable, false);
    }

    C5667F(Callable<C5664C<T>> runnable, boolean runNow) {
        this.f9626c = new LinkedHashSet(1);
        this.f9627d = new LinkedHashSet(1);
        this.f9628e = new Handler(Looper.getMainLooper());
        this.f9630g = null;
        this.f9629f = new FutureTask<>(runnable);
        if (runNow) {
            try {
                m9992a((C5664C) runnable.call());
            } catch (Throwable e) {
                m9992a(new C5664C<>(e));
            }
        } else {
            f9624a.execute(this.f9629f);
            m9999b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9992a(C5664C<T> result) {
        if (this.f9630g == null) {
            this.f9630g = result;
            m9991a();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    /* renamed from: b */
    public synchronized C5667F<T> mo17873b(C5854z<T> listener) {
        if (!(this.f9630g == null || this.f9630g.mo17867b() == null)) {
            listener.mo18133a(this.f9630g.mo17867b());
        }
        this.f9626c.add(listener);
        m9999b();
        return this;
    }

    /* renamed from: d */
    public synchronized C5667F<T> mo17875d(C5854z<T> listener) {
        this.f9626c.remove(listener);
        m10000c();
        return this;
    }

    /* renamed from: a */
    public synchronized C5667F<T> mo17872a(C5854z<Throwable> listener) {
        if (!(this.f9630g == null || this.f9630g.mo17866a() == null)) {
            listener.mo18133a(this.f9630g.mo17866a());
        }
        this.f9627d.add(listener);
        m9999b();
        return this;
    }

    /* renamed from: c */
    public synchronized C5667F<T> mo17874c(C5854z<Throwable> listener) {
        this.f9627d.remove(listener);
        m10000c();
        return this;
    }

    /* renamed from: a */
    private void m9991a() {
        this.f9628e.post(new C5665D(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9996a(T value) {
        for (LottieListener<T> l : new ArrayList<>(this.f9626c)) {
            l.mo18133a(value);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9997a(Throwable e) {
        List<LottieListener<Throwable>> listenersCopy = new ArrayList<>(this.f9627d);
        if (listenersCopy.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", e);
            return;
        }
        for (LottieListener<Throwable> l : listenersCopy) {
            l.mo18133a(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m9999b() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.m10002d()     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            com.airbnb.lottie.C<T> r0 = r2.f9630g     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.airbnb.lottie.E r0 = new com.airbnb.lottie.E     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "LottieTaskObserver"
            r0.<init>(r2, r1)     // Catch:{ all -> 0x0023 }
            r2.f9625b = r0     // Catch:{ all -> 0x0023 }
            java.lang.Thread r0 = r2.f9625b     // Catch:{ all -> 0x0023 }
            r0.start()     // Catch:{ all -> 0x0023 }
            java.lang.String r0 = "Starting TaskObserver thread"
            com.airbnb.lottie.C5718c.m10177b(r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.C5667F.m9999b():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void m10000c() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.m10002d()     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r1)
            return
        L_0x0009:
            java.util.Set<com.airbnb.lottie.z<T>> r0 = r1.f9626c     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0015
            com.airbnb.lottie.C<T> r0 = r1.f9630g     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
        L_0x0015:
            java.lang.Thread r0 = r1.f9625b     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            r0 = 0
            r1.f9625b = r0     // Catch:{ all -> 0x0024 }
            java.lang.String r0 = "Stopping TaskObserver thread"
            com.airbnb.lottie.C5718c.m10177b(r0)     // Catch:{ all -> 0x0024 }
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.C5667F.m10000c():void");
    }

    /* renamed from: d */
    private boolean m10002d() {
        Thread thread = this.f9625b;
        return thread != null && thread.isAlive();
    }
}
