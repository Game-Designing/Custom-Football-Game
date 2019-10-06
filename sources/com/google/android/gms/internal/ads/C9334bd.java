package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* renamed from: com.google.android.gms.internal.ads.bd */
final /* synthetic */ class C9334bd implements Runnable {

    /* renamed from: a */
    private final Executor f22112a;

    /* renamed from: b */
    private final Runnable f22113b;

    C9334bd(Executor executor, Runnable runnable) {
        this.f22112a = executor;
        this.f22113b = runnable;
    }

    public final void run() {
        this.f22112a.execute(this.f22113b);
    }
}
