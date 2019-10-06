package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.mj */
final class C9582mj implements zzban<ParcelFileDescriptor> {

    /* renamed from: a */
    private final /* synthetic */ zzarr f22764a;

    C9582mj(zzcig zzcig, zzarr zzarr) {
        this.f22764a = zzarr;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        try {
            this.f22764a.mo30026a(zzaym.m26243a(th, zzcgm.m28419a(th)));
        } catch (RemoteException e) {
            zzawz.m26002e("Service can't call client", e);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        try {
            this.f22764a.mo30025a((ParcelFileDescriptor) obj);
        } catch (RemoteException e) {
            zzawz.m26002e("Service can't call client", e);
        }
    }
}
