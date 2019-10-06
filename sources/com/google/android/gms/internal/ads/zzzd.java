package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzzd extends zzfn implements zzzc {
    public zzzd() {
        super("com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo28922a((zzxz) zzfo.m30220a(parcel, zzxz.CREATOR));
            parcel2.writeNoException();
        } else if (i == 2) {
            String mediationAdapterClassName = getMediationAdapterClassName();
            parcel2.writeNoException();
            parcel2.writeString(mediationAdapterClassName);
        } else if (i == 3) {
            boolean I = mo28920I();
            parcel2.writeNoException();
            zzfo.m30223a(parcel2, I);
        } else if (i == 4) {
            String L = mo28921L();
            parcel2.writeNoException();
            parcel2.writeString(L);
        } else if (i != 5) {
            return false;
        } else {
            mo28923a((zzxz) zzfo.m30220a(parcel, zzxz.CREATOR), parcel.readInt());
            parcel2.writeNoException();
        }
        return true;
    }
}
