package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.flurry.sdk.vd */
public final class C7614vd implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f15117a;

    /* renamed from: b */
    private final int f15118b = 1;

    public C7614vd(String str) {
        this.f15117a = new ThreadGroup(str);
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f15117a, runnable);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15117a.getName());
        sb.append(":");
        sb.append(thread.getId());
        thread.setName(sb.toString());
        thread.setPriority(this.f15118b);
        return thread;
    }
}
