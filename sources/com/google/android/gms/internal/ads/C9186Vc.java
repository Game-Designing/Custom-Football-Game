package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;

/* renamed from: com.google.android.gms.internal.ads.Vc */
final /* synthetic */ class C9186Vc implements Runnable {

    /* renamed from: a */
    private final zzbbr f21836a;

    /* renamed from: b */
    private final zzbbh f21837b;

    C9186Vc(zzbbr zzbbr, zzbbh zzbbh) {
        this.f21836a = zzbbr;
        this.f21837b = zzbbh;
    }

    public final void run() {
        zzbbr zzbbr = this.f21836a;
        try {
            zzbbr.mo30338b(this.f21837b.get());
        } catch (ExecutionException e) {
            zzbbr.mo30337a(e.getCause());
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            zzbbr.mo30337a(e2);
        } catch (Exception e3) {
            zzbbr.mo30337a(e3);
        }
    }
}
