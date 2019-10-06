package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.ArrayList;
import java.util.List;

public final class zzafc extends zzfm implements zzafa {
    zzafc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    /* renamed from: v */
    public final IObjectWrapper mo29683v() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: o */
    public final String mo29680o() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: q */
    public final List mo29682q() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        ArrayList b = zzfo.m30225b(a);
        a.recycle();
        return b;
    }

    /* renamed from: p */
    public final String mo29681p() throws RemoteException {
        Parcel a = mo31750a(5, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: J */
    public final zzaei mo29669J() throws RemoteException {
        zzaei zzaei;
        Parcel a = mo31750a(6, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaei = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            if (queryLocalInterface instanceof zzaei) {
                zzaei = (zzaei) queryLocalInterface;
            } else {
                zzaei = new zzaek(readStrongBinder);
            }
        }
        a.recycle();
        return zzaei;
    }

    /* renamed from: m */
    public final String mo29678m() throws RemoteException {
        Parcel a = mo31750a(7, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: x */
    public final String mo29684x() throws RemoteException {
        Parcel a = mo31750a(8, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel a = mo31750a(9, mo31749a());
        Bundle bundle = (Bundle) zzfo.m30220a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final void destroy() throws RemoteException {
        mo31752b(10, mo31749a());
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel a = mo31750a(11, mo31749a());
        zzaar a2 = zzaas.m24526a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: d */
    public final void mo29672d(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(12, a);
    }

    /* renamed from: b */
    public final boolean mo29670b(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        Parcel a2 = mo31750a(13, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    /* renamed from: c */
    public final void mo29671c(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(14, a);
    }

    /* renamed from: l */
    public final zzaea mo29677l() throws RemoteException {
        zzaea zzaea;
        Parcel a = mo31750a(15, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaea = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            if (queryLocalInterface instanceof zzaea) {
                zzaea = (zzaea) queryLocalInterface;
            } else {
                zzaea = new zzaec(readStrongBinder);
            }
        }
        a.recycle();
        return zzaea;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a = mo31750a(17, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
