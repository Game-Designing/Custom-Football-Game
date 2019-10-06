package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzdbg extends zzfm implements zzdbf {
    zzdbg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    /* renamed from: a */
    public final zzdbd mo31367a(zzdbb zzdbb) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzdbb);
        Parcel a2 = mo31750a(1, a);
        zzdbd zzdbd = (zzdbd) zzfo.m30220a(a2, zzdbd.CREATOR);
        a2.recycle();
        return zzdbd;
    }

    /* renamed from: a */
    public final void mo31368a(zzday zzday) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzday);
        mo31752b(2, a);
    }
}
