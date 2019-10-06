package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzaeo extends zzfm implements zzaem {
    zzaeo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    /* renamed from: b */
    public final void mo29538b(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(1, a);
    }

    /* renamed from: f */
    public final IObjectWrapper mo29542f(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        Parcel a2 = mo31750a(2, a);
        IObjectWrapper a3 = Stub.m22186a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    /* renamed from: d */
    public final void mo29539d(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(3, a);
    }

    public final void destroy() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    /* renamed from: a */
    public final void mo29537a(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeInt(i);
        mo31752b(5, a);
    }

    /* renamed from: e */
    public final void mo29541e(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(6, a);
    }
}
