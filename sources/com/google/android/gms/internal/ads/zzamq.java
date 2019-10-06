package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzamq extends zzfn implements zzamp {
    public zzamq() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    /* renamed from: a */
    public static zzamp m25249a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzamp) {
            return (zzamp) queryLocalInterface;
        }
        return new zzamr(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzams j = mo29834j(parcel.readString());
            parcel2.writeNoException();
            zzfo.m30221a(parcel2, (IInterface) j);
        } else if (i == 2) {
            boolean k = mo29835k(parcel.readString());
            parcel2.writeNoException();
            zzfo.m30223a(parcel2, k);
        } else if (i != 3) {
            return false;
        } else {
            zzaov q = mo29836q(parcel.readString());
            parcel2.writeNoException();
            zzfo.m30221a(parcel2, (IInterface) q);
        }
        return true;
    }
}
