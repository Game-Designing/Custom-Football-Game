package com.paypal.android.sdk;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.paypal.android.sdk.Ga */
public final class C11727Ga {

    /* renamed from: a */
    private static final int f36676a;

    /* renamed from: b */
    private static int f36677b;

    /* renamed from: c */
    private static int f36678c = ((f36676a << 1) + 1);

    static {
        new C11727Ga();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f36676a = availableProcessors;
        f36677b = availableProcessors + 1;
    }

    private C11727Ga() {
        new C11734Ia(0);
    }

    /* renamed from: a */
    public static ThreadPoolExecutor m38839a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f36677b, f36678c, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
