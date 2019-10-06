package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzcqb implements zzbro, zzbsr {

    /* renamed from: a */
    private zzaub f27212a;

    /* renamed from: a */
    public final synchronized void mo31238a(zzaub zzaub) {
        this.f27212a = zzaub;
    }

    public final synchronized void onAdLoaded() {
        if (this.f27212a != null) {
            try {
                this.f27212a.mo30087Ba();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.f27212a != null) {
            try {
                this.f27212a.mo30088p(i);
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }
}
