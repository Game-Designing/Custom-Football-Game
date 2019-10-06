package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.Wj */
final class C9214Wj extends zzaon {

    /* renamed from: b */
    private zzcjy<zzaov, zzcla> f21900b;

    private C9214Wj(zzclq zzclq, zzcjy zzcjy) {
        this.f21900b = zzcjy;
    }

    /* renamed from: s */
    public final void mo28679s() throws RemoteException {
        ((zzcla) this.f21900b.f26730c).onAdLoaded();
    }

    /* renamed from: b */
    public final void mo28678b(String str) throws RemoteException {
        ((zzcla) this.f21900b.f26730c).onAdFailedToLoad(0);
    }
}
