package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaev extends zzfm implements zzaeu {
    zzaev(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
    }

    /* renamed from: b */
    public final IBinder mo29649b(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) iObjectWrapper2);
        zzfo.m30221a(a, (IInterface) iObjectWrapper3);
        Parcel a2 = mo31750a(1, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        a2.recycle();
        return readStrongBinder;
    }
}
