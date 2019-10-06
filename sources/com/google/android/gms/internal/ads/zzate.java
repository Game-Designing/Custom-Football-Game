package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

@zzard
public final class zzate implements RewardItem {

    /* renamed from: a */
    private final zzasr f24809a;

    public zzate(zzasr zzasr) {
        this.f24809a = zzasr;
    }

    public final String getType() {
        zzasr zzasr = this.f24809a;
        if (zzasr == null) {
            return null;
        }
        try {
            return zzasr.getType();
        } catch (RemoteException e) {
            zzbad.m26358c("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        zzasr zzasr = this.f24809a;
        if (zzasr == null) {
            return 0;
        }
        try {
            return zzasr.getAmount();
        } catch (RemoteException e) {
            zzbad.m26358c("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
