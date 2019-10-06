package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzauc extends zzfn implements zzaub {
    public zzauc() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo30087Ba();
        } else if (i != 2) {
            return false;
        } else {
            mo30088p(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}
