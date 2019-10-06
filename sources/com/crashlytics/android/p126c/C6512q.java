package com.crashlytics.android.p126c;

import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import p024io.fabric.sdk.android.C13920f;

/* renamed from: com.crashlytics.android.c.q */
/* compiled from: CrashlyticsBackgroundWorker */
class C6512q {

    /* renamed from: a */
    private final ExecutorService f11695a;

    public C6512q(ExecutorService executorService) {
        this.f11695a = executorService;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public <T> T mo19602b(Callable<T> callable) {
        String str = "CrashlyticsCore";
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                return this.f11695a.submit(callable).get(4, TimeUnit.SECONDS);
            }
            return this.f11695a.submit(callable).get();
        } catch (RejectedExecutionException e) {
            C13920f.m44245e().mo43326c(str, "Executor is shut down because we're handling a fatal crash.");
            return null;
        } catch (Exception e2) {
            C13920f.m44245e().mo43325b(str, "Failed to execute task.", e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Future<?> mo19600a(Runnable runnable) {
        try {
            return this.f11695a.submit(new C6508o(this, runnable));
        } catch (RejectedExecutionException e) {
            C13920f.m44245e().mo43326c("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public <T> Future<T> mo19601a(Callable<T> callable) {
        try {
            return this.f11695a.submit(new C6510p(this, callable));
        } catch (RejectedExecutionException e) {
            C13920f.m44245e().mo43326c("CrashlyticsCore", "Executor is shut down because we're handling a fatal crash.");
            return null;
        }
    }
}
