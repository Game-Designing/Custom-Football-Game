package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

@zzard
public final class zzauh implements RewardItem {

    /* renamed from: a */
    private final zzatq f24824a;

    public zzauh(zzatq zzatq) {
        this.f24824a = zzatq;
    }

    public final String getType() {
        zzatq zzatq = this.f24824a;
        if (zzatq == null) {
            return null;
        }
        try {
            return zzatq.getType();
        } catch (RemoteException e) {
            zzbad.m26358c("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    public final int getAmount() {
        zzatq zzatq = this.f24824a;
        if (zzatq == null) {
            return 0;
        }
        try {
            return zzatq.getAmount();
        } catch (RemoteException e) {
            zzbad.m26358c("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
