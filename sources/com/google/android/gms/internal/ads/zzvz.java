package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzvz extends zzfm implements zzvy {
    zzvz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    /* renamed from: a */
    public final zzvs mo32326a(zzvv zzvv) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzvv);
        Parcel a2 = mo31750a(1, a);
        zzvs zzvs = (zzvs) zzfo.m30220a(a2, zzvs.CREATOR);
        a2.recycle();
        return zzvs;
    }
}
