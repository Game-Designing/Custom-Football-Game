package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzdu extends zzr implements zzdt {
    public zzdu() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo32794a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo32796a(parcel.readString(), parcel.readString(), (Bundle) zzs.m32374a(parcel, Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        } else if (i != 2) {
            return false;
        } else {
            int ca = mo32797ca();
            parcel2.writeNoException();
            parcel2.writeInt(ca);
        }
        return true;
    }
}
