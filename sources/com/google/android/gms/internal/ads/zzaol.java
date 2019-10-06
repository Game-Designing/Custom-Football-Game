package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaol extends zzfm implements zzaoj {
    zzaol(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
    }

    /* renamed from: r */
    public final void mo28265r(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(1, a);
    }

    /* renamed from: b */
    public final void mo28264b(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(2, a);
    }
}
