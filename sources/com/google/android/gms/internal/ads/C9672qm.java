package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.qm */
final class C9672qm implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f22907a = new AtomicInteger(1);

    C9672qm() {
    }

    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f22907a.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
