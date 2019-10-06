package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.google.android.gms.internal.ads.Ws */
final class C9223Ws implements ThreadFactory {

    /* renamed from: a */
    private final /* synthetic */ String f21908a;

    C9223Ws(String str) {
        this.f21908a = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f21908a);
    }
}
