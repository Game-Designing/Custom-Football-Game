package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* renamed from: com.google.android.gms.internal.ads.Jt */
final /* synthetic */ class C8948Jt implements Runnable {

    /* renamed from: a */
    private final zzbbr f21388a;

    /* renamed from: b */
    private final Future f21389b;

    C8948Jt(zzbbr zzbbr, Future future) {
        this.f21388a = zzbbr;
        this.f21389b = future;
    }

    public final void run() {
        zzbbr zzbbr = this.f21388a;
        Future future = this.f21389b;
        if (zzbbr.isCancelled()) {
            future.cancel(true);
        }
    }
}
