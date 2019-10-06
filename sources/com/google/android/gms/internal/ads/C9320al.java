package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.al */
final class C9320al implements zzban<zzcrc> {

    /* renamed from: a */
    private final /* synthetic */ zzavy f22094a;

    C9320al(zzcqq zzcqq, zzavy zzavy) {
        this.f22094a = zzavy;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        try {
            this.f22094a.onError("Internal error.");
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        zzcrc zzcrc = (zzcrc) obj;
        try {
            this.f22094a.mo30137b(zzcrc.f27262a, zzcrc.f27263b);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
