package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaoo extends zzfm implements zzaom {
    zzaoo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    /* renamed from: s */
    public final void mo28679s() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    /* renamed from: b */
    public final void mo28678b(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(3, a);
    }
}
