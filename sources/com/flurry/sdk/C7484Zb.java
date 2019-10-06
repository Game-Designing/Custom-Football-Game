package com.flurry.sdk;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.flurry.sdk.Zb */
class C7484Zb extends ThreadPoolExecutor {

    /* renamed from: a */
    final /* synthetic */ C7502cc f14731a;

    C7484Zb(C7502cc ccVar, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        this.f14731a = ccVar;
        super(0, 5, 5000, timeUnit, blockingQueue);
    }

    /* access modifiers changed from: protected */
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        C7376Ed a = C7502cc.m16604a(runnable);
        if (a != null) {
            new C7476Xb(this, a).run();
        }
    }

    /* access modifiers changed from: protected */
    public final void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        C7376Ed a = C7502cc.m16604a(runnable);
        if (a != null) {
            synchronized (this.f14731a.f14777d) {
                this.f14731a.f14777d.remove(a);
            }
            this.f14731a.m16606a(a);
            new C7480Yb(this, a).run();
        }
    }

    /* access modifiers changed from: protected */
    public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
        C7472Wb wb = new C7472Wb(runnable, v);
        synchronized (this.f14731a.f14777d) {
            this.f14731a.f14777d.put((C7376Ed) runnable, wb);
        }
        return wb;
    }

    /* access modifiers changed from: protected */
    public final <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
        throw new UnsupportedOperationException("Callable not supported");
    }
}
