package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

public final class zzcpx extends AdMetadataListener {

    /* renamed from: a */
    private zzzp f27207a;

    /* renamed from: a */
    public final synchronized void mo31232a(zzzp zzzp) {
        this.f27207a = zzzp;
    }

    public final synchronized void onAdMetadataChanged() {
        if (this.f27207a != null) {
            try {
                this.f27207a.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzbad.m26358c("Remote Exception at onAdMetadataChanged.", e);
            }
        }
    }
}
