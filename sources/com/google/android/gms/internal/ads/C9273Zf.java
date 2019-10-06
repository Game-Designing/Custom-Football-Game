package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.ads.Zf */
final /* synthetic */ class C9273Zf implements Runnable {

    /* renamed from: a */
    private final AtomicReference f22024a;

    C9273Zf(AtomicReference atomicReference) {
        this.f22024a = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.f22024a.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
