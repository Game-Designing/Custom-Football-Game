package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public final class zzcza implements zzdti<ScheduledExecutorService> {

    /* renamed from: a */
    private final zzdtu<ThreadFactory> f27667a;

    public zzcza(zzdtu<ThreadFactory> zzdtu) {
        this.f27667a = zzdtu;
    }

    public final /* synthetic */ Object get() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, (ThreadFactory) this.f27667a.get());
        zzdto.m30114a(scheduledThreadPoolExecutor, "Cannot return null from a non-@Nullable @Provides method");
        return scheduledThreadPoolExecutor;
    }
}
