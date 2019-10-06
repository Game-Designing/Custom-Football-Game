package com.facebook;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.n */
/* compiled from: FacebookSdk */
class C6783n implements ThreadFactory {

    /* renamed from: a */
    private final AtomicInteger f12464a = new AtomicInteger(0);

    C6783n() {
    }

    public Thread newThread(Runnable runnable) {
        StringBuilder sb = new StringBuilder();
        sb.append("FacebookSdk #");
        sb.append(this.f12464a.incrementAndGet());
        return new Thread(runnable, sb.toString());
    }
}
