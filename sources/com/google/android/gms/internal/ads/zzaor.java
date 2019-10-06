package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzaor extends zzfm implements zzaop {
    zzaor(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    /* renamed from: a */
    public final void mo28910a(zzang zzang) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzang);
        mo31752b(1, a);
    }

    /* renamed from: b */
    public final void mo28911b(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(2, a);
    }
}
