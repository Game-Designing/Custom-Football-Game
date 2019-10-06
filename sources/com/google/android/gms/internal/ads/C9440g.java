package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.g */
final class C9440g implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzabp f22364a;

    C9440g(zzabp zzabp) {
        this.f22364a = zzabp;
    }

    public final void run() {
        if (this.f22364a.f23872b != null) {
            try {
                this.f22364a.f23872b.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.m26358c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
