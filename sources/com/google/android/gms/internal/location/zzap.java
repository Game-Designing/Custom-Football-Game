package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzap extends zza implements zzao {
    zzap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    /* renamed from: a */
    public final void mo32498a(zzbf zzbf) throws RemoteException {
        Parcel a = mo32486a();
        zzc.m31757a(a, (Parcelable) zzbf);
        mo32489b(59, a);
    }

    /* renamed from: a */
    public final void mo32499a(zzo zzo) throws RemoteException {
        Parcel a = mo32486a();
        zzc.m31757a(a, (Parcelable) zzo);
        mo32489b(75, a);
    }

    /* renamed from: c */
    public final Location mo32500c(String str) throws RemoteException {
        Parcel a = mo32486a();
        a.writeString(str);
        Parcel a2 = mo32487a(21, a);
        Location location = (Location) zzc.m31756a(a2, Location.CREATOR);
        a2.recycle();
        return location;
    }

    /* renamed from: d */
    public final void mo32501d(boolean z) throws RemoteException {
        Parcel a = mo32486a();
        zzc.m31758a(a, z);
        mo32489b(12, a);
    }
}
