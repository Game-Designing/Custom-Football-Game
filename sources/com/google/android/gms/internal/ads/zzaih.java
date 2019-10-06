package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzaih extends zzfm implements zzaig {
    zzaih(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    /* renamed from: a */
    public final void mo29751a(zzaia zzaia, zzaie zzaie) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzaia);
        zzfo.m30221a(a, (IInterface) zzaie);
        mo31753c(2, a);
    }
}
