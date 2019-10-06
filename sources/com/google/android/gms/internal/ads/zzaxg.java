package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@zzard
public final class zzaxg {

    /* renamed from: a */
    public static final zzbbl f24958a;

    /* renamed from: b */
    public static final zzbbl f24959b;

    /* renamed from: c */
    public static final ScheduledExecutorService f24960c = new ScheduledThreadPoolExecutor(3, m26096a("Schedule"));

    /* renamed from: a */
    public static <T> zzbbh<T> m26095a(Callable<T> callable) {
        return f24958a.mo30326a(callable);
    }

    /* renamed from: a */
    private static ThreadFactory m26096a(String str) {
        return new C9355cc(str);
    }

    /* renamed from: a */
    public static zzbbh<?> m26094a(Runnable runnable) {
        return f24958a.mo30325a(runnable);
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, MoPubClientPositioning.NO_REPEAT, 10, TimeUnit.SECONDS, new SynchronousQueue(), m26096a("Default"));
        f24958a = zzbbm.m26395a(threadPoolExecutor);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), m26096a("Loader"));
        threadPoolExecutor2.allowCoreThreadTimeOut(true);
        f24959b = zzbbm.m26395a(threadPoolExecutor2);
    }
}
