package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzaok extends zzfn implements zzaoj {
    public zzaok() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo28265r(Stub.m22186a(parcel.readStrongBinder()));
        } else if (i != 2) {
            return false;
        } else {
            mo28264b(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
