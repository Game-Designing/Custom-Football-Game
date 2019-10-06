package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.fyber.inneractive.sdk.util.k */
public final class C8009k {

    /* renamed from: a */
    static final Executor f16338a;

    /* renamed from: b */
    private static final ThreadFactory f16339b = new ThreadFactory() {

        /* renamed from: a */
        private final AtomicInteger f16341a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            StringBuilder sb = new StringBuilder("IAConcurrencyUtil#");
            sb.append(this.f16341a.getAndIncrement());
            return new Thread(runnable, sb.toString());
        }
    };

    /* renamed from: c */
    private static final RejectedExecutionHandler f16340c = new RejectedExecutionHandler() {

        /* renamed from: a */
        Handler f16342a = new Handler(Looper.getMainLooper());

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            StringBuilder sb = new StringBuilder("rejectedExecution received for - ");
            sb.append(runnable);
            IAlog.m18021b(sb.toString());
        }
    };

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(32), f16339b, f16340c);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f16338a = threadPoolExecutor;
    }
}
