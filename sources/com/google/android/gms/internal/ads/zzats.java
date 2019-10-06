package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzats extends zzfm implements zzatq {
    zzats(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final String getType() throws RemoteException {
        Parcel a = mo31750a(1, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final int getAmount() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }
}
