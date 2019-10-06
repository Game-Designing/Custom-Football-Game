package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzaad extends zzfm implements zzaab {
    zzaad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* renamed from: E */
    public final void mo29344E() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    /* renamed from: a */
    public final void mo29346a(float f) throws RemoteException {
        Parcel a = mo31749a();
        a.writeFloat(f);
        mo31752b(2, a);
    }

    /* renamed from: g */
    public final void mo29354g(boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30223a(a, z);
        mo31752b(4, a);
    }

    /* renamed from: a */
    public final void mo29347a(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        mo31752b(5, a);
    }

    /* renamed from: a */
    public final void mo29350a(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(6, a);
    }

    /* renamed from: Ra */
    public final float mo29345Ra() throws RemoteException {
        Parcel a = mo31750a(7, mo31749a());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    /* renamed from: ga */
    public final boolean mo29355ga() throws RemoteException {
        Parcel a = mo31750a(8, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: fa */
    public final String mo29352fa() throws RemoteException {
        Parcel a = mo31750a(9, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: p */
    public final void mo29356p(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(10, a);
    }

    /* renamed from: a */
    public final void mo29349a(zzamp zzamp) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzamp);
        mo31752b(11, a);
    }
}
