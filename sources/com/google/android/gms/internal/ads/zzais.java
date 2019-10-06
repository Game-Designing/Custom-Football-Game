package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzais extends zzfm implements zzaiq {
    zzais(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public final void onInitializationSucceeded() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    public final void onInitializationFailed(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(3, a);
    }
}
