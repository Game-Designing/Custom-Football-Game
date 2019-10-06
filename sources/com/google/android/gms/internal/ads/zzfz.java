package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzfz extends zzfm implements zzfx {
    zzfz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    /* renamed from: b */
    public final void mo31760b(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        mo31752b(2, a);
    }

    /* renamed from: ab */
    public final void mo31759ab() throws RemoteException {
        mo31752b(3, mo31749a());
    }

    /* renamed from: a */
    public final void mo31758a(int[] iArr) throws RemoteException {
        Parcel a = mo31749a();
        a.writeIntArray(null);
        mo31752b(4, a);
    }

    /* renamed from: a */
    public final void mo31757a(byte[] bArr) throws RemoteException {
        Parcel a = mo31749a();
        a.writeByteArray(bArr);
        mo31752b(5, a);
    }

    /* renamed from: o */
    public final void mo31762o(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(6, a);
    }

    /* renamed from: l */
    public final void mo31761l(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(7, a);
    }

    /* renamed from: a */
    public final void mo31756a(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        a.writeString(null);
        mo31752b(8, a);
    }
}
