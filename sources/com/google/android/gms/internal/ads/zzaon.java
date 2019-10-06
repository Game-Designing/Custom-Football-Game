package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaon extends zzfn implements zzaom {
    public zzaon() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            mo28679s();
        } else if (i != 3) {
            return false;
        } else {
            mo28678b(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
