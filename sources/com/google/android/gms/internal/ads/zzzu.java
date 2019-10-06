package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzzu extends zzfm implements zzzs {
    zzzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        a.writeString(str2);
        mo31752b(1, a);
    }
}
