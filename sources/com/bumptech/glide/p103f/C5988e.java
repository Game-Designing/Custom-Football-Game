package com.bumptech.glide.p103f;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.load.C6031a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.p103f.p104a.C5975h;
import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p103f.p105b.C5983b;
import com.bumptech.glide.p107h.C6026k;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.bumptech.glide.f.e */
/* compiled from: RequestFutureTarget */
public class C5988e<R> implements C5980b<R>, C5990f<R>, Runnable {

    /* renamed from: a */
    private static final C5989a f10551a = new C5989a();

    /* renamed from: b */
    private final Handler f10552b;

    /* renamed from: c */
    private final int f10553c;

    /* renamed from: d */
    private final int f10554d;

    /* renamed from: e */
    private final boolean f10555e;

    /* renamed from: f */
    private final C5989a f10556f;

    /* renamed from: g */
    private R f10557g;

    /* renamed from: h */
    private C5986c f10558h;

    /* renamed from: i */
    private boolean f10559i;

    /* renamed from: j */
    private boolean f10560j;

    /* renamed from: k */
    private boolean f10561k;

    /* renamed from: l */
    private GlideException f10562l;

    /* renamed from: com.bumptech.glide.f.e$a */
    /* compiled from: RequestFutureTarget */
    static class C5989a {
        C5989a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo18721a(Object toWaitOn, long timeoutMillis) throws InterruptedException {
            toWaitOn.wait(timeoutMillis);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo18720a(Object toNotify) {
            toNotify.notifyAll();
        }
    }

    public C5988e(Handler mainHandler, int width, int height) {
        this(mainHandler, width, height, true, f10551a);
    }

    C5988e(Handler mainHandler, int width, int height, boolean assertBackgroundThread, C5989a waiter) {
        this.f10552b = mainHandler;
        this.f10553c = width;
        this.f10554d = height;
        this.f10555e = assertBackgroundThread;
        this.f10556f = waiter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean cancel(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.isDone()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x000a
            r0 = 0
            monitor-exit(r2)
            return r0
        L_0x000a:
            r0 = 1
            r2.f10559i = r0     // Catch:{ all -> 0x0019 }
            com.bumptech.glide.f.e$a r1 = r2.f10556f     // Catch:{ all -> 0x0019 }
            r1.mo18720a(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0017
            r2.m11094a()     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r2)
            return r0
        L_0x0019:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.p103f.C5988e.cancel(boolean):boolean");
    }

    public synchronized boolean isCancelled() {
        return this.f10559i;
    }

    public synchronized boolean isDone() {
        return this.f10559i || this.f10560j || this.f10561k;
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return m11093a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public R get(long time, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return m11093a(Long.valueOf(timeUnit.toMillis(time)));
    }

    public void getSize(C5975h cb) {
        cb.mo18703a(this.f10553c, this.f10554d);
    }

    public void removeCallback(C5975h cb) {
    }

    public void setRequest(C5986c request) {
        this.f10558h = request;
    }

    public C5986c getRequest() {
        return this.f10558h;
    }

    public void onLoadCleared(Drawable placeholder) {
    }

    public void onLoadStarted(Drawable placeholder) {
    }

    public synchronized void onLoadFailed(Drawable errorDrawable) {
    }

    public synchronized void onResourceReady(R r, C5983b<? super R> bVar) {
    }

    /* renamed from: a */
    private synchronized R m11093a(Long timeoutMillis) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f10555e && !isDone()) {
            C6026k.m11281a();
        }
        if (this.f10559i) {
            throw new CancellationException();
        } else if (this.f10561k) {
            throw new ExecutionException(this.f10562l);
        } else if (this.f10560j) {
            return this.f10557g;
        } else {
            if (timeoutMillis == null) {
                this.f10556f.mo18721a(this, 0);
            } else if (timeoutMillis.longValue() > 0) {
                long now = System.currentTimeMillis();
                long deadline = timeoutMillis.longValue() + now;
                while (!isDone() && now < deadline) {
                    this.f10556f.mo18721a(this, deadline - now);
                    now = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            } else if (this.f10561k) {
                throw new ExecutionException(this.f10562l);
            } else if (this.f10559i) {
                throw new CancellationException();
            } else if (this.f10560j) {
                return this.f10557g;
            } else {
                throw new TimeoutException();
            }
        }
    }

    public void run() {
        C5986c cVar = this.f10558h;
        if (cVar != null) {
            cVar.clear();
            this.f10558h = null;
        }
    }

    /* renamed from: a */
    private void m11094a() {
        this.f10552b.post(this);
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    /* renamed from: a */
    public synchronized boolean mo18712a(GlideException e, Object model, C5976i<R> iVar, boolean isFirstResource) {
        this.f10561k = true;
        this.f10562l = e;
        this.f10556f.mo18720a(this);
        return false;
    }

    /* renamed from: a */
    public synchronized boolean mo18713a(R resource, Object model, C5976i<R> iVar, C6031a dataSource, boolean isFirstResource) {
        this.f10560j = true;
        this.f10557g = resource;
        this.f10556f.mo18720a(this);
        return false;
    }
}
