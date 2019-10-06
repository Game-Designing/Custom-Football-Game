package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzzb extends zzfm implements zzyz {
    zzzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void onAdClosed() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(2, a);
    }

    public final void onAdLeftApplication() throws RemoteException {
        mo31752b(3, mo31749a());
    }

    public final void onAdLoaded() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    public final void onAdOpened() throws RemoteException {
        mo31752b(5, mo31749a());
    }

    public final void onAdClicked() throws RemoteException {
        mo31752b(6, mo31749a());
    }

    public final void onAdImpression() throws RemoteException {
        mo31752b(7, mo31749a());
    }
}
