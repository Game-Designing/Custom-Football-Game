package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzr extends Binder implements IInterface {

    /* renamed from: a */
    private static zzt f30243a = null;

    protected zzr(String str) {
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
        return mo32794a(i, parcel, parcel2, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo32794a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }
}
