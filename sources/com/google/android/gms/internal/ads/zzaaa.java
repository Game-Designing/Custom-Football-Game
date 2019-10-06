package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaaa extends zzfm implements zzzy {
    zzaaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    public final long getValue() throws RemoteException {
        Parcel a = mo31750a(1, mo31749a());
        long readLong = a.readLong();
        a.recycle();
        return readLong;
    }
}
