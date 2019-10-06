package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzg extends zza implements zze {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String getId() throws RemoteException {
        Parcel a = mo32397a(1, mo32396a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: h */
    public final boolean mo32402h() throws RemoteException {
        Parcel a = mo32397a(6, mo32396a());
        boolean a2 = zzc.m31635a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: i */
    public final boolean mo32403i(boolean z) throws RemoteException {
        Parcel a = mo32396a();
        zzc.m31634a(a, true);
        Parcel a2 = mo32397a(2, a);
        boolean a3 = zzc.m31635a(a2);
        a2.recycle();
        return a3;
    }
}
