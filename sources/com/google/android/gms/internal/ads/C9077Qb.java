package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.Qb */
final class C9077Qb implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f21605a = new AtomicInteger(1);

    C9077Qb(zzavg zzavg) {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f21605a.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
