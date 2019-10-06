package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzaro extends zzfm implements zzarm {
    zzaro(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* renamed from: a */
    public final void mo30023a(zzarx zzarx, zzarr zzarr) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzarx);
        zzfo.m30221a(a, (IInterface) zzarr);
        mo31752b(4, a);
    }

    /* renamed from: b */
    public final void mo30024b(zzarx zzarx, zzarr zzarr) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzarx);
        zzfo.m30221a(a, (IInterface) zzarr);
        mo31752b(5, a);
    }
}
