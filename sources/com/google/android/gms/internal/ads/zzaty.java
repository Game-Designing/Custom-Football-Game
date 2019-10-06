package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaty extends zzfm implements zzatw {
    zzaty(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* renamed from: T */
    public final void mo30083T() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    /* renamed from: Q */
    public final void mo30082Q() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    /* renamed from: a */
    public final void mo30084a(zzatq zzatq) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzatq);
        mo31752b(3, a);
    }

    /* renamed from: q */
    public final void mo30085q(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(4, a);
    }
}
