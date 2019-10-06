package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzaup extends zzatr {

    /* renamed from: b */
    private final String f24830b;

    /* renamed from: c */
    private final int f24831c;

    public zzaup(zzato zzato) {
        this(zzato != null ? zzato.f24820a : "", zzato != null ? zzato.f24821b : 1);
    }

    public zzaup(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzaup(String str, int i) {
        this.f24830b = str;
        this.f24831c = i;
    }

    public final String getType() throws RemoteException {
        return this.f24830b;
    }

    public final int getAmount() throws RemoteException {
        return this.f24831c;
    }
}
