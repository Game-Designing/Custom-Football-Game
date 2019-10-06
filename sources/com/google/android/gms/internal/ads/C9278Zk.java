package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.Zk */
final class C9278Zk extends zzzq {

    /* renamed from: b */
    private final /* synthetic */ zzzp f22028b;

    /* renamed from: c */
    private final /* synthetic */ zzcqj f22029c;

    C9278Zk(zzcqj zzcqj, zzzp zzzp) {
        this.f22029c = zzcqj;
        this.f22028b = zzzp;
    }

    public final void onAdMetadataChanged() throws RemoteException {
        if (this.f22029c.f27245j) {
            zzzp zzzp = this.f22028b;
            if (zzzp != null) {
                zzzp.onAdMetadataChanged();
            }
        }
    }
}
