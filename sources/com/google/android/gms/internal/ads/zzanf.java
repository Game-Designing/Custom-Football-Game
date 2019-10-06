package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.ArrayList;
import java.util.List;

public final class zzanf extends zzfm implements zzand {
    zzanf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    /* renamed from: o */
    public final String mo29925o() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: q */
    public final List mo29927q() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        ArrayList b = zzfo.m30225b(a);
        a.recycle();
        return b;
    }

    /* renamed from: p */
    public final String mo29926p() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: J */
    public final zzaei mo29915J() throws RemoteException {
        Parcel a = mo31750a(5, mo31749a());
        zzaei a2 = zzaej.m24846a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: m */
    public final String mo29923m() throws RemoteException {
        Parcel a = mo31750a(6, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: x */
    public final String mo29929x() throws RemoteException {
        Parcel a = mo31750a(7, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void recordImpression() throws RemoteException {
        mo31752b(8, mo31749a());
    }

    /* renamed from: a */
    public final void mo29916a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(9, a);
    }

    /* renamed from: c */
    public final void mo29919c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(10, a);
    }

    /* renamed from: C */
    public final boolean mo29913C() throws RemoteException {
        Parcel a = mo31750a(11, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: F */
    public final boolean mo29914F() throws RemoteException {
        Parcel a = mo31750a(12, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel a = mo31750a(13, mo31749a());
        Bundle bundle = (Bundle) zzfo.m30220a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: b */
    public final void mo29918b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(14, a);
    }

    /* renamed from: B */
    public final IObjectWrapper mo29912B() throws RemoteException {
        Parcel a = mo31750a(15, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel a = mo31750a(16, mo31749a());
        zzaar a2 = zzaas.m24526a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: l */
    public final zzaea mo29922l() throws RemoteException {
        Parcel a = mo31750a(19, mo31749a());
        zzaea a2 = zzaeb.m24839a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: A */
    public final IObjectWrapper mo29911A() throws RemoteException {
        Parcel a = mo31750a(20, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final IObjectWrapper mo29924n() throws RemoteException {
        Parcel a = mo31750a(21, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo29917a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) iObjectWrapper2);
        zzfo.m30221a(a, (IInterface) iObjectWrapper3);
        mo31752b(22, a);
    }
}
