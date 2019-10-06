package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import java.util.ArrayList;
import java.util.List;

public final class zzafg extends zzfm implements zzafe {
    zzafg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    /* renamed from: m */
    public final String mo29691m(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        Parcel a2 = mo31750a(1, a);
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    /* renamed from: o */
    public final zzaei mo29692o(String str) throws RemoteException {
        zzaei zzaei;
        Parcel a = mo31749a();
        a.writeString(str);
        Parcel a2 = mo31750a(2, a);
        IBinder readStrongBinder = a2.readStrongBinder();
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
        a2.recycle();
        return zzaei;
    }

    public final List<String> getAvailableAssetNames() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        ArrayList createStringArrayList = a.createStringArrayList();
        a.recycle();
        return createStringArrayList;
    }

    public final String getCustomTemplateId() throws RemoteException {
        Parcel a = mo31750a(4, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void performClick(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(5, a);
    }

    public final void recordImpression() throws RemoteException {
        mo31752b(6, mo31749a());
    }

    public final zzaar getVideoController() throws RemoteException {
        Parcel a = mo31750a(7, mo31749a());
        zzaar a2 = zzaas.m24526a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void destroy() throws RemoteException {
        mo31752b(8, mo31749a());
    }

    /* renamed from: la */
    public final IObjectWrapper mo29690la() throws RemoteException {
        Parcel a = mo31750a(9, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    /* renamed from: j */
    public final boolean mo29689j(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        Parcel a2 = mo31750a(10, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }
}
