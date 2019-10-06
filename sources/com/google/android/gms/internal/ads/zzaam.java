package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaam extends zzfm implements zzaak {
    zzaam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdReason");
    }

    public final String getDescription() throws RemoteException {
        Parcel a = mo31750a(1, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: U */
    public final String mo29360U() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
