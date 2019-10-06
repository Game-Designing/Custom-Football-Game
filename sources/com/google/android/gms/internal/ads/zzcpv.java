package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzcpv implements zzxr {

    /* renamed from: a */
    private zzyw f27205a;

    /* renamed from: a */
    public final synchronized void mo31229a(zzyw zzyw) {
        this.f27205a = zzyw;
    }

    public final synchronized void onAdClicked() {
        if (this.f27205a != null) {
            try {
                this.f27205a.onAdClicked();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdClicked.", e);
            }
        }
    }
}
