package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.j */
final class C9506j implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzabx f22585a;

    C9506j(zzabx zzabx) {
        this.f22585a = zzabx;
    }

    public final void run() {
        if (this.f22585a.f23874b != null) {
            try {
                this.f22585a.f23874b.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbad.m26358c("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
