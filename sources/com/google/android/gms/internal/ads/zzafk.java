package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzafk extends zzfm implements zzafi {
    zzafk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    /* renamed from: a */
    public final void mo29697a(zzaew zzaew) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzaew);
        mo31752b(1, a);
    }
}
