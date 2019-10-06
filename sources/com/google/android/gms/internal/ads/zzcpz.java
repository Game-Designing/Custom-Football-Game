package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

public final class zzcpz extends AdMetadataListener {

    /* renamed from: a */
    private zzaao f27209a;

    /* renamed from: a */
    public final synchronized void mo31235a(zzaao zzaao) {
        this.f27209a = zzaao;
    }

    public final synchronized void onAdMetadataChanged() {
        if (this.f27209a != null) {
            try {
                this.f27209a.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzbad.m26360d("#007 Could not call remote method.", e);
            }
        }
    }
}
