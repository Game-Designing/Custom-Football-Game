package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import p019d.p271g.p272a.C12720a;

/* renamed from: com.google.android.gms.internal.ads.Xa */
final class C9226Xa implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C12720a f21911a;

    /* renamed from: b */
    private final /* synthetic */ zzanu f21912b;

    C9226Xa(zzanu zzanu, C12720a aVar) {
        this.f21912b = zzanu;
        this.f21911a = aVar;
    }

    public final void run() {
        try {
            this.f21912b.f24516a.onAdFailedToLoad(zzaog.m25541a(this.f21911a));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
