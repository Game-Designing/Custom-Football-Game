package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.i */
final /* synthetic */ class C9484i implements Runnable {

    /* renamed from: a */
    private final zzaub f22535a;

    C9484i(zzaub zzaub) {
        this.f22535a = zzaub;
    }

    public final void run() {
        zzaub zzaub = this.f22535a;
        if (zzaub != null) {
            try {
                zzaub.mo30088p(1);
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }
}
