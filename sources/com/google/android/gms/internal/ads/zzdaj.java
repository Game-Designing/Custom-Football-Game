package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzdaj extends zzfm implements zzdah {
    zzdaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    /* renamed from: g */
    public final boolean mo31347g(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        Parcel a2 = mo31750a(2, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    /* renamed from: p */
    public final void mo31349p(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(4, a);
    }

    /* renamed from: a */
    public final void mo31346a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) iObjectWrapper2);
        mo31752b(5, a);
    }

    public final String getVersion() throws RemoteException {
        Parcel a = mo31750a(6, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: q */
    public final void mo31350q(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(7, a);
    }

    /* renamed from: a */
    public final IObjectWrapper mo31345a(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4, String str5) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeString(str2);
        a.writeString(str3);
        a.writeString(str4);
        a.writeString(str5);
        Parcel a2 = mo31750a(9, a);
        IObjectWrapper a3 = Stub.m22186a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
