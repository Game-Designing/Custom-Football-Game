package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.internal.ads.cc */
final class C9355cc implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f22150a = new AtomicInteger(1);

    /* renamed from: b */
    private final /* synthetic */ String f22151b;

    C9355cc(String str) {
        this.f22151b = str;
    }

    public final Thread newThread(Runnable runnable) {
        String str = this.f22151b;
        int andIncrement = this.f22150a.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
