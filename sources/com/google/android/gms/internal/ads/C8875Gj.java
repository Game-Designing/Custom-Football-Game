package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.Gj */
final class C8875Gj extends zzaok {

    /* renamed from: b */
    private zzcjy<zzaov, zzcla> f21063b;

    /* renamed from: c */
    private final /* synthetic */ zzckm f21064c;

    private C8875Gj(zzckm zzckm, zzcjy zzcjy) {
        this.f21064c = zzckm;
        this.f21063b = zzcjy;
    }

    /* renamed from: r */
    public final void mo28265r(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.f21064c.f26751c = (View) ObjectWrapper.m22187H(iObjectWrapper);
        ((zzcla) this.f21063b.f26730c).onAdLoaded();
    }

    /* renamed from: b */
    public final void mo28264b(String str) throws RemoteException {
        ((zzcla) this.f21063b.f26730c).onAdFailedToLoad(0);
    }
}
