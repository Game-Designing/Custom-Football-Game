package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzatd extends zzfm implements zzatb {
    zzatd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void onRewardedVideoAdLoaded() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    public final void onRewardedVideoAdOpened() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    public final void onRewardedVideoStarted() throws RemoteException {
        mo31752b(3, mo31749a());
    }

    public final void onRewardedVideoAdClosed() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    /* renamed from: a */
    public final void mo30061a(zzasr zzasr) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzasr);
        mo31752b(5, a);
    }

    public final void onRewardedVideoAdLeftApplication() throws RemoteException {
        mo31752b(6, mo31749a());
    }

    public final void onRewardedVideoAdFailedToLoad(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(7, a);
    }

    public final void onRewardedVideoCompleted() throws RemoteException {
        mo31752b(8, mo31749a());
    }
}
