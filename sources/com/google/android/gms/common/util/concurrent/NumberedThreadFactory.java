package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@KeepForSdk
public class NumberedThreadFactory implements ThreadFactory {

    /* renamed from: a */
    private final String f20318a;

    /* renamed from: b */
    private final int f20319b;

    /* renamed from: c */
    private final AtomicInteger f20320c;

    /* renamed from: d */
    private final ThreadFactory f20321d;

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        this(str, 0);
    }

    private NumberedThreadFactory(String str, int i) {
        this.f20320c = new AtomicInteger();
        this.f20321d = Executors.defaultThreadFactory();
        Preconditions.m21858a(str, (Object) "Name must not be null");
        this.f20318a = str;
        this.f20319b = 0;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f20321d.newThread(new C8726a(runnable, 0));
        String str = this.f20318a;
        int andIncrement = this.f20320c.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
