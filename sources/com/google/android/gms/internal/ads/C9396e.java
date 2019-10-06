package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.e */
final class C9396e extends zzzd {

    /* renamed from: b */
    final /* synthetic */ zzabl f22203b;

    private C9396e(zzabl zzabl) {
        this.f22203b = zzabl;
    }

    /* renamed from: I */
    public final boolean mo28920I() throws RemoteException {
        return false;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    /* renamed from: L */
    public final String mo28921L() throws RemoteException {
        return null;
    }

    /* renamed from: a */
    public final void mo28922a(zzxz zzxz) throws RemoteException {
        mo28923a(zzxz, 1);
    }

    /* renamed from: a */
    public final void mo28923a(zzxz zzxz, int i) throws RemoteException {
        zzbad.m26355b("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzazt.f25042a.post(new C9418f(this));
    }
}
