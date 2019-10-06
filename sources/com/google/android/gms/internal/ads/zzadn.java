package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzadn extends zzfm implements zzadl {
    zzadn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    /* renamed from: qa */
    public final String mo29625qa() throws RemoteException {
        Parcel a = mo31750a(1, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String getContent() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: f */
    public final void mo29623f(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(3, a);
    }

    public final void recordClick() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    public final void recordImpression() throws RemoteException {
        mo31752b(5, mo31749a());
    }
}
