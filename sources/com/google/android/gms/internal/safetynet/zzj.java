package com.google.android.gms.internal.safetynet;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzj extends zza implements zzi {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.safetynet.internal.ISafetyNetService");
    }

    /* renamed from: a */
    public final void mo32983a(zzg zzg) throws RemoteException {
        Parcel a = mo32969a();
        zzc.m32630a(a, (IInterface) zzg);
        mo32970a(5, a);
    }
}
