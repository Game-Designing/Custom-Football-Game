package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaou extends zzfm implements zzaos {
    zzaou(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    /* renamed from: s */
    public final void mo29049s() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    /* renamed from: b */
    public final void mo29048b(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(3, a);
    }
}
