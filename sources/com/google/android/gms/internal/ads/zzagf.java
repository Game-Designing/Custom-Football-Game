package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzagf extends zzfm implements zzagd {
    zzagf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    public final void onUnconfirmedClickReceived(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(1, a);
    }

    public final void onUnconfirmedClickCancelled() throws RemoteException {
        mo31752b(2, mo31749a());
    }
}
