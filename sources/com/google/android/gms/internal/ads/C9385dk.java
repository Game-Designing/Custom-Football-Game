package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.dk */
final class C9385dk extends zzaoq {

    /* renamed from: b */
    private zzcjy<zzaov, zzcla> f22184b;

    /* renamed from: c */
    private final /* synthetic */ zzcmg f22185c;

    private C9385dk(zzcmg zzcmg, zzcjy zzcjy) {
        this.f22185c = zzcmg;
        this.f22184b = zzcjy;
    }

    /* renamed from: a */
    public final void mo28910a(zzang zzang) throws RemoteException {
        this.f22185c.f27010c = zzang;
        ((zzcla) this.f22184b.f26730c).onAdLoaded();
    }

    /* renamed from: b */
    public final void mo28911b(String str) throws RemoteException {
        ((zzcla) this.f22184b.f26730c).onAdFailedToLoad(0);
    }
}
