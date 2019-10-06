package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

public abstract class zzv extends zzd implements zzu {
    public zzv() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo27253a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo32414a((Status) zze.m31651a(parcel, Status.CREATOR), (Credential) zze.m31651a(parcel, Credential.CREATOR));
        } else if (i == 2) {
            mo32416f((Status) zze.m31651a(parcel, Status.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            mo32415a((Status) zze.m31651a(parcel, Status.CREATOR), parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
