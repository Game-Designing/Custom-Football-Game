package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzzo extends zzfm implements zzzn {
    zzzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    /* renamed from: a */
    public final IBinder mo32395a(IObjectWrapper iObjectWrapper, zzyd zzyd, String str, zzamp zzamp, int i, int i2) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzyd);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamp);
        a.writeInt(i);
        a.writeInt(i2);
        Parcel a2 = mo31750a(2, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        a2.recycle();
        return readStrongBinder;
    }
}
