package com.google.android.gms.internal.ads;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Ks */
final class C8968Ks implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ IOException f21416a;

    /* renamed from: b */
    private final /* synthetic */ C8884Gs f21417b;

    C8968Ks(C8884Gs gs, IOException iOException) {
        this.f21417b = gs;
        this.f21416a = iOException;
    }

    public final void run() {
        this.f21417b.f21095e.mo30516a(this.f21416a);
    }
}
