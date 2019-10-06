package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.internal.ads.wr */
final class C9803wr implements ThreadFactory {

    /* renamed from: a */
    private final /* synthetic */ String f23422a;

    C9803wr(String str) {
        this.f23422a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f23422a);
    }
}
