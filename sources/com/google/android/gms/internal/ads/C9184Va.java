package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import p019d.p271g.p272a.C12720a;

/* renamed from: com.google.android.gms.internal.ads.Va */
final class C9184Va implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ C12720a f21833a;

    /* renamed from: b */
    private final /* synthetic */ zzanu f21834b;

    C9184Va(zzanu zzanu, C12720a aVar) {
        this.f21834b = zzanu;
        this.f21833a = aVar;
    }

    public final void run() {
        try {
            this.f21834b.f24516a.onAdFailedToLoad(zzaog.m25541a(this.f21833a));
        } catch (RemoteException e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
        }
    }
}
