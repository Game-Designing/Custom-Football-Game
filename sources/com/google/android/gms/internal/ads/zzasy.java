package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzasy extends zzfm implements zzasw {
    zzasy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    /* renamed from: a */
    public final void mo29562a(zzath zzath) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzath);
        mo31752b(1, a);
    }

    public final void show() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    /* renamed from: a */
    public final void mo29561a(zzatb zzatb) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzatb);
        mo31752b(3, a);
    }

    public final boolean isLoaded() throws RemoteException {
        Parcel a = mo31750a(5, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: G */
    public final void mo29559G(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(9, a);
    }

    /* renamed from: D */
    public final void mo29558D(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(10, a);
    }

    /* renamed from: h */
    public final void mo29567h(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        mo31752b(11, a);
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        Parcel a = mo31750a(12, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void setUserId(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(13, a);
    }

    /* renamed from: a */
    public final void mo29563a(zzzp zzzp) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzzp);
        mo31752b(14, a);
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Parcel a = mo31750a(15, mo31749a());
        Bundle bundle = (Bundle) zzfo.m30220a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final void setCustomData(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(19, a);
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30223a(a, z);
        mo31752b(34, a);
    }
}
