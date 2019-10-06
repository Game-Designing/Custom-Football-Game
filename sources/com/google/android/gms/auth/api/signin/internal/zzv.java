package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.auth-api.zzc;
import com.google.android.gms.internal.auth-api.zze;

public final class zzv extends zzc implements zzu {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    /* renamed from: a */
    public final void mo27254a(zzs zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel a = mo32409a();
        zze.m31652a(a, (IInterface) zzs);
        zze.m31653a(a, (Parcelable) googleSignInOptions);
        mo32410a(102, a);
    }

    /* renamed from: b */
    public final void mo27255b(zzs zzs, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel a = mo32409a();
        zze.m31652a(a, (IInterface) zzs);
        zze.m31653a(a, (Parcelable) googleSignInOptions);
        mo32410a(103, a);
    }
}
