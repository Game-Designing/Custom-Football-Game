package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzam extends zzb implements zzal {
    public zzam() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo27093a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo32436a((ProxyResponse) zzc.m31675a(parcel, ProxyResponse.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            mo32437n(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
