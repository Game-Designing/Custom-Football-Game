package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzzh extends zzfm implements zzzf {
    zzzh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* renamed from: Fa */
    public final zzzc mo29490Fa() throws RemoteException {
        zzzc zzzc;
        Parcel a = mo31750a(1, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzzc = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            if (queryLocalInterface instanceof zzzc) {
                zzzc = (zzzc) queryLocalInterface;
            } else {
                zzzc = new zzze(readStrongBinder);
            }
        }
        a.recycle();
        return zzzc;
    }

    /* renamed from: b */
    public final void mo29500b(zzyz zzyz) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzyz);
        mo31752b(2, a);
    }

    /* renamed from: a */
    public final void mo29493a(zzafi zzafi) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzafi);
        mo31752b(3, a);
    }

    /* renamed from: a */
    public final void mo29494a(zzafl zzafl) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzafl);
        mo31752b(4, a);
    }

    /* renamed from: a */
    public final void mo29499a(String str, zzafr zzafr, zzafo zzafo) throws RemoteException {
        Parcel a = mo31749a();
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzafr);
        zzfo.m30221a(a, (IInterface) zzafo);
        mo31752b(5, a);
    }

    /* renamed from: a */
    public final void mo29492a(zzady zzady) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzady);
        mo31752b(6, a);
    }

    /* renamed from: b */
    public final void mo29501b(zzzy zzzy) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzzy);
        mo31752b(7, a);
    }

    /* renamed from: a */
    public final void mo29495a(zzafu zzafu, zzyd zzyd) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzafu);
        zzfo.m30222a(a, (Parcelable) zzyd);
        mo31752b(8, a);
    }

    /* renamed from: a */
    public final void mo29491a(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) publisherAdViewOptions);
        mo31752b(9, a);
    }

    /* renamed from: a */
    public final void mo29496a(zzafx zzafx) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzafx);
        mo31752b(10, a);
    }
}
