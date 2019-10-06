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

public final class zzagi extends zzfm implements zzagg {
    zzagi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    /* renamed from: o */
    public final String mo29727o() throws RemoteException {
        Parcel a = mo31750a(2, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: q */
    public final List mo29729q() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        ArrayList b = zzfo.m30225b(a);
        a.recycle();
        return b;
    }

    /* renamed from: p */
    public final String mo29728p() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: t */
    public final zzaei mo29731t() throws RemoteException {
        zzaei zzaei;
        Parcel a = mo31750a(5, mo31749a());
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
    public final String mo29725m() throws RemoteException {
        Parcel a = mo31750a(6, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: x */
    public final String mo29735x() throws RemoteException {
        Parcel a = mo31750a(7, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: j */
    public final double mo29723j() throws RemoteException {
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
    public final String mo29732u() throws RemoteException {
        Parcel a = mo31750a(10, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel a = mo31750a(11, mo31749a());
        zzaar a2 = zzaas.m24526a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a = mo31750a(12, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void destroy() throws RemoteException {
        mo31752b(13, mo31749a());
    }

    /* renamed from: l */
    public final zzaea mo29724l() throws RemoteException {
        zzaea zzaea;
        Parcel a = mo31750a(14, mo31749a());
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

    /* renamed from: d */
    public final void mo29717d(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(15, a);
    }

    /* renamed from: b */
    public final boolean mo29715b(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        Parcel a2 = mo31750a(16, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    /* renamed from: c */
    public final void mo29716c(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(17, a);
    }

    /* renamed from: v */
    public final IObjectWrapper mo29734v() throws RemoteException {
        Parcel a = mo31750a(18, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: n */
    public final IObjectWrapper mo29726n() throws RemoteException {
        Parcel a = mo31750a(19, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final Bundle getExtras() throws RemoteException {
        Parcel a = mo31750a(20, mo31749a());
        Bundle bundle = (Bundle) zzfo.m30220a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    /* renamed from: a */
    public final void mo29714a(zzagd zzagd) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzagd);
        mo31752b(21, a);
    }

    /* renamed from: r */
    public final void mo29730r() throws RemoteException {
        mo31752b(22, mo31749a());
    }

    /* renamed from: Qa */
    public final List mo29710Qa() throws RemoteException {
        Parcel a = mo31750a(23, mo31749a());
        ArrayList b = zzfo.m30225b(a);
        a.recycle();
        return b;
    }

    /* renamed from: X */
    public final boolean mo29711X() throws RemoteException {
        Parcel a = mo31750a(24, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo29713a(zzaak zzaak) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzaak);
        mo31752b(25, a);
    }

    /* renamed from: a */
    public final void mo29712a(zzaag zzaag) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzaag);
        mo31752b(26, a);
    }

    /* renamed from: y */
    public final void mo29736y() throws RemoteException {
        mo31752b(27, mo31749a());
    }

    /* renamed from: ua */
    public final void mo29733ua() throws RemoteException {
        mo31752b(28, mo31749a());
    }

    /* renamed from: Ha */
    public final zzaee mo29709Ha() throws RemoteException {
        zzaee zzaee;
        Parcel a = mo31750a(29, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaee = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            if (queryLocalInterface instanceof zzaee) {
                zzaee = (zzaee) queryLocalInterface;
            } else {
                zzaee = new zzaeg(readStrongBinder);
            }
        }
        a.recycle();
        return zzaee;
    }
}
