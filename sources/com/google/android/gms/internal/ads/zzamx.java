package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzamx extends zzfm implements zzamv {
    zzamx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void onAdClicked() throws RemoteException {
        mo31752b(1, mo31749a());
    }

    public final void onAdClosed() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    public final void onAdFailedToLoad(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(3, a);
    }

    public final void onAdLeftApplication() throws RemoteException {
        mo31752b(4, mo31749a());
    }

    public final void onAdOpened() throws RemoteException {
        mo31752b(5, mo31749a());
    }

    public final void onAdLoaded() throws RemoteException {
        mo31752b(6, mo31749a());
    }

    /* renamed from: a */
    public final void mo29870a(zzamy zzamy) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzamy);
        mo31752b(7, a);
    }

    public final void onAdImpression() throws RemoteException {
        mo31752b(8, mo31749a());
    }

    public final void onAppEvent(String str, String str2) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        a.writeString(str2);
        mo31752b(9, a);
    }

    /* renamed from: a */
    public final void mo29869a(zzafe zzafe, String str) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzafe);
        a.writeString(str);
        mo31752b(10, a);
    }

    /* renamed from: M */
    public final void mo29867M() throws RemoteException {
        mo31752b(11, mo31749a());
    }

    /* renamed from: r */
    public final void mo29884r(String str) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        mo31752b(12, a);
    }

    /* renamed from: N */
    public final void mo29868N() throws RemoteException {
        mo31752b(13, mo31749a());
    }

    /* renamed from: a */
    public final void mo29871a(zzato zzato) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzato);
        mo31752b(14, a);
    }

    public final void onVideoPause() throws RemoteException {
        mo31752b(15, mo31749a());
    }

    /* renamed from: a */
    public final void mo29872a(zzatq zzatq) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzatq);
        mo31752b(16, a);
    }

    /* renamed from: d */
    public final void mo29873d(int i) throws RemoteException {
        Parcel a = mo31749a();
        a.writeInt(i);
        mo31752b(17, a);
    }

    /* renamed from: wa */
    public final void mo29885wa() throws RemoteException {
        mo31752b(18, mo31749a());
    }

    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) bundle);
        mo31752b(19, a);
    }

    public final void onVideoPlay() throws RemoteException {
        mo31752b(20, mo31749a());
    }
}
