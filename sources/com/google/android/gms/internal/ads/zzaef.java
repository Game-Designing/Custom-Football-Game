package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaef extends zzfn implements zzaee {
    public zzaef() {
        super("com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        float K = mo29647K();
        parcel2.writeNoException();
        parcel2.writeFloat(K);
        return true;
    }
}
