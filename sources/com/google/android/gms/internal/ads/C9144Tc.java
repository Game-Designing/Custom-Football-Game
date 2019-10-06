package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.ads.Tc */
final /* synthetic */ class C9144Tc implements Runnable {

    /* renamed from: a */
    private final Future f21768a;

    C9144Tc(Future future) {
        this.f21768a = future;
    }

    public final void run() {
        Future future = this.f21768a;
        if (!future.isDone()) {
            future.cancel(true);
        }
    }
}
