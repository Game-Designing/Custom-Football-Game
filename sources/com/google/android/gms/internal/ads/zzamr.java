package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzamr extends zzfm implements zzamp {
    zzamr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    /* renamed from: j */
    public final zzams mo29834j(String str) throws RemoteException {
        zzams zzams;
        Parcel a = mo31749a();
        a.writeString(str);
        Parcel a2 = mo31750a(1, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzams = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            if (queryLocalInterface instanceof zzams) {
                zzams = (zzams) queryLocalInterface;
            } else {
                zzams = new zzamu(readStrongBinder);
            }
        }
        a2.recycle();
        return zzams;
    }

    /* renamed from: k */
    public final boolean mo29835k(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        Parcel a2 = mo31750a(2, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    /* renamed from: q */
    public final zzaov mo29836q(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        Parcel a2 = mo31750a(3, a);
        zzaov a3 = zzaow.m25592a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
