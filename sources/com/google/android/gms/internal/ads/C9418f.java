package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.f */
final class C9418f implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C9396e f22278a;

    C9418f(C9396e eVar) {
        this.f22278a = eVar;
    }

    public final void run() {
        if (this.f22278a.f22203b.f23871b != null) {
            try {
                this.f22278a.f22203b.f23871b.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.m26358c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
