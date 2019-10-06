package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzatv extends zzfm implements zzatt {
    zzatv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    /* renamed from: a */
    public final void mo29552a(zzxz zzxz, zzaub zzaub) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzxz);
        zzfo.m30221a(a, (IInterface) zzaub);
        mo31752b(1, a);
    }

    /* renamed from: a */
    public final void mo29549a(zzatw zzatw) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzatw);
        mo31752b(2, a);
    }

    public final boolean isLoaded() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: C */
    public final void mo29546C(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(5, a);
    }

    /* renamed from: a */
    public final void mo29551a(zzaum zzaum) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzaum);
        mo31752b(7, a);
    }

    /* renamed from: a */
    public final void mo29548a(zzaao zzaao) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzaao);
        mo31752b(8, a);
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Parcel a = mo31750a(9, mo31749a());
        Bundle bundle = (Bundle) zzfo.m30220a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: a */
    public final void mo29547a(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30223a(a, z);
        mo31752b(10, a);
    }

    /* renamed from: xa */
    public final zzatq mo29556xa() throws RemoteException {
        zzatq zzatq;
        Parcel a = mo31750a(11, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzatq = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            if (queryLocalInterface instanceof zzatq) {
                zzatq = (zzatq) queryLocalInterface;
            } else {
                zzatq = new zzats(readStrongBinder);
            }
        }
        a.recycle();
        return zzatq;
    }
}
