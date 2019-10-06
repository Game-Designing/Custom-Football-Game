package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.wq */
final class C9802wq implements ThreadFactory {

    /* renamed from: a */
    private final ThreadFactory f23420a = Executors.defaultThreadFactory();

    /* renamed from: b */
    private final AtomicInteger f23421b = new AtomicInteger(1);

    C9802wq() {
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f23420a.newThread(runnable);
        int andIncrement = this.f23421b.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        newThread.setName(sb.toString());
        return newThread;
    }
}
