package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.Pk */
final /* synthetic */ class C9065Pk implements zzbro {

    /* renamed from: a */
    private final zzcpw f21587a;

    /* renamed from: b */
    private final zzaje f21588b;

    C9065Pk(zzcpw zzcpw, zzaje zzaje) {
        this.f21587a = zzcpw;
        this.f21588b = zzaje;
    }

    public final void onAdFailedToLoad(int i) {
        zzcpw zzcpw = this.f21587a;
        zzaje zzaje = this.f21588b;
        zzcpw.onAdFailedToLoad(i);
        if (zzaje != null) {
            try {
                zzaje.mo29770n(i);
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }
}
