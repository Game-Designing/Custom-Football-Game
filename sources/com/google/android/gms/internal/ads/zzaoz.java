package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaoz extends zzfn implements zzaoy {
    public zzaoz() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo29967d(parcel.readString());
        } else if (i != 2) {
            return false;
        } else {
            onFailure(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
