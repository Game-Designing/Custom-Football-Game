package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.kk */
final class C9539kk extends zzaot {

    /* renamed from: b */
    private zzcjy<zzaov, zzcla> f22689b;

    private C9539kk(zzcnd zzcnd, zzcjy zzcjy) {
        this.f22689b = zzcjy;
    }

    /* renamed from: s */
    public final void mo29049s() throws RemoteException {
        ((zzcla) this.f22689b.f26730c).onAdLoaded();
    }

    /* renamed from: b */
    public final void mo29048b(String str) throws RemoteException {
        ((zzcla) this.f22689b.f26730c).onAdFailedToLoad(0);
    }
}
