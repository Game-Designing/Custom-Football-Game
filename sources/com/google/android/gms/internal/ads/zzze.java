package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzze extends zzfm implements zzzc {
    zzze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    /* renamed from: a */
    public final void mo28922a(zzxz zzxz) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzxz);
        mo31752b(1, a);
    }

    /* renamed from: I */
    public final boolean mo28920I() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: L */
    public final String mo28921L() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo28923a(zzxz zzxz, int i) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzxz);
        a.writeInt(i);
        mo31752b(5, a);
    }
}
