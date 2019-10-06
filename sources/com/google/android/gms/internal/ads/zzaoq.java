package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaoq extends zzfn implements zzaop {
    public zzaoq() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo28910a(zzanh.m25416a(parcel.readStrongBinder()));
        } else if (i != 2) {
            return false;
        } else {
            mo28911b(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
