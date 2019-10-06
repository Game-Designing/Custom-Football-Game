package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzapa extends zzfm implements zzaoy {
    zzapa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
    }

    /* renamed from: d */
    public final void mo29967d(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(1, a);
    }

    public final void onFailure(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(2, a);
    }
}
