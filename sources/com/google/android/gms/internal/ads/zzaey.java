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

public final class zzaey extends zzfm implements zzaew {
    zzaey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    /* renamed from: v */
    public final IObjectWrapper mo29667v() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: o */
    public final String mo29662o() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: q */
    public final List mo29664q() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        ArrayList b = zzfo.m30225b(a);
        a.recycle();
        return b;
    }

    /* renamed from: p */
    public final String mo29663p() throws RemoteException {
        Parcel a = mo31750a(5, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: t */
    public final zzaei mo29665t() throws RemoteException {
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
    public final String mo29660m() throws RemoteException {
        Parcel a = mo31750a(7, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: j */
    public final double mo29658j() throws RemoteException {
        Parcel a = mo31750a(8, mo31749a());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    public final String getStore() throws RemoteException {
        Parcel a = mo31750a(9, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: u */
    public final String mo29666u() throws RemoteException {
        Parcel a = mo31750a(10, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel a = mo31750a(11, mo31749a());
        Bundle bundle = (Bundle) zzfo.m30220a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final void destroy() throws RemoteException {
        mo31752b(12, mo31749a());
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel a = mo31750a(13, mo31749a());
        zzaar a2 = zzaas.m24526a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: d */
    public final void mo29652d(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(14, a);
    }

    /* renamed from: b */
    public final boolean mo29650b(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        Parcel a2 = mo31750a(15, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    /* renamed from: c */
    public final void mo29651c(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(16, a);
    }

    /* renamed from: l */
    public final zzaea mo29659l() throws RemoteException {
        zzaea zzaea;
        Parcel a = mo31750a(17, mo31749a());
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
        Parcel a = mo31750a(19, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
