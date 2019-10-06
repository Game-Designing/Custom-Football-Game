package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaox extends zzfm implements zzaov {
    zzaox(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    /* renamed from: a */
    public final void mo29957a(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzyd, zzaoy zzaoy) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        zzfo.m30222a(a, (Parcelable) bundle);
        zzfo.m30222a(a, (Parcelable) bundle2);
        zzfo.m30222a(a, (Parcelable) zzyd);
        zzfo.m30221a(a, (IInterface) zzaoy);
        mo31752b(1, a);
    }

    /* renamed from: _a */
    public final zzapj mo29956_a() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        zzapj zzapj = (zzapj) zzfo.m30220a(a, zzapj.CREATOR);
        a.recycle();
        return zzapj;
    }

    /* renamed from: Wa */
    public final zzapj mo29955Wa() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        zzapj zzapj = (zzapj) zzfo.m30220a(a, zzapj.CREATOR);
        a.recycle();
        return zzapj;
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel a = mo31750a(5, mo31749a());
        zzaar a2 = zzaas.m24526a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo29958a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaoj zzaoj, zzamv zzamv, zzyd zzyd) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        a.writeString(str2);
        zzfo.m30222a(a, (Parcelable) zzxz);
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) zzaoj);
        zzfo.m30221a(a, (IInterface) zzamv);
        zzfo.m30222a(a, (Parcelable) zzyd);
        mo31752b(13, a);
    }

    /* renamed from: a */
    public final void mo29959a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaom zzaom, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        a.writeString(str2);
        zzfo.m30222a(a, (Parcelable) zzxz);
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) zzaom);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(14, a);
    }

    /* renamed from: u */
    public final boolean mo29964u(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        Parcel a2 = mo31750a(15, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    /* renamed from: a */
    public final void mo29961a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaos zzaos, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        a.writeString(str2);
        zzfo.m30222a(a, (Parcelable) zzxz);
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) zzaos);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(16, a);
    }

    /* renamed from: v */
    public final boolean mo29965v(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        Parcel a2 = mo31750a(17, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    /* renamed from: a */
    public final void mo29960a(String str, String str2, zzxz zzxz, IObjectWrapper iObjectWrapper, zzaop zzaop, zzamv zzamv) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        a.writeString(str2);
        zzfo.m30222a(a, (Parcelable) zzxz);
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) zzaop);
        zzfo.m30221a(a, (IInterface) zzamv);
        mo31752b(18, a);
    }
}
