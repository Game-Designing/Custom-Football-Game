package com.google.android.gms.internal.auth-api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zzd extends Binder implements IInterface {

    /* renamed from: a */
    private static zzf f29814a = null;

    protected zzd(String str) {
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
        return mo27253a(i, parcel, parcel2, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo27253a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }
}
