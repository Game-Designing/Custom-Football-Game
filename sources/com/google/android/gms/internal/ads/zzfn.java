package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzfn extends Binder implements IInterface {

    /* renamed from: a */
    private static zzfp f28416a = null;

    protected zzfn(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z;
        if (i > 16777215) {
            z = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        return mo29357a(i, parcel, parcel2, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }
}
