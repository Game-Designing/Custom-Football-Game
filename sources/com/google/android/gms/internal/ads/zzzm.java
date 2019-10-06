package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public final class zzzm extends zzfm implements zzzk {
    zzzm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    /* renamed from: Aa */
    public final IObjectWrapper mo29502Aa() throws RemoteException {
        Parcel a = mo31750a(1, mo31749a());
        IObjectWrapper a2 = Stub.m22186a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void destroy() throws RemoteException {
        mo31752b(2, mo31749a());
    }

    public final boolean isReady() throws RemoteException {
        Parcel a = mo31750a(3, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: b */
    public final boolean mo29521b(zzxz zzxz) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzxz);
        Parcel a2 = mo31750a(4, a);
        boolean a3 = zzfo.m30224a(a2);
        a2.recycle();
        return a3;
    }

    public final void pause() throws RemoteException {
        mo31752b(5, mo31749a());
    }

    public final void resume() throws RemoteException {
        mo31752b(6, mo31749a());
    }

    /* renamed from: a */
    public final void mo29517a(zzyz zzyz) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzyz);
        mo31752b(7, a);
    }

    /* renamed from: a */
    public final void mo29519a(zzzs zzzs) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzzs);
        mo31752b(8, a);
    }

    public final void showInterstitial() throws RemoteException {
        mo31752b(9, mo31749a());
    }

    /* renamed from: db */
    public final void mo29523db() throws RemoteException {
        mo31752b(11, mo31749a());
    }

    /* renamed from: Za */
    public final zzyd mo29508Za() throws RemoteException {
        Parcel a = mo31750a(12, mo31749a());
        zzyd zzyd = (zzyd) zzfo.m30220a(a, zzyd.CREATOR);
        a.recycle();
        return zzyd;
    }

    /* renamed from: a */
    public final void mo29515a(zzyd zzyd) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzyd);
        mo31752b(13, a);
    }

    /* renamed from: a */
    public final void mo29511a(zzado zzado) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzado);
        mo31752b(19, a);
    }

    /* renamed from: a */
    public final void mo29516a(zzyw zzyw) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzyw);
        mo31752b(20, a);
    }

    /* renamed from: a */
    public final void mo29520a(zzzy zzzy) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzzy);
        mo31752b(21, a);
    }

    /* renamed from: m */
    public final void mo29530m(boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30223a(a, z);
        mo31752b(22, a);
    }

    /* renamed from: I */
    public final boolean mo29503I() throws RemoteException {
        Parcel a = mo31750a(23, mo31749a());
        boolean a2 = zzfo.m30224a(a);
        a.recycle();
        return a2;
    }

    /* renamed from: a */
    public final void mo29514a(zzatb zzatb) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzatb);
        mo31752b(24, a);
    }

    public final zzaar getVideoController() throws RemoteException {
        zzaar zzaar;
        Parcel a = mo31750a(26, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzaar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            if (queryLocalInterface instanceof zzaar) {
                zzaar = (zzaar) queryLocalInterface;
            } else {
                zzaar = new zzaat(readStrongBinder);
            }
        }
        a.recycle();
        return zzaar;
    }

    /* renamed from: a */
    public final void mo29510a(zzacd zzacd) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30222a(a, (Parcelable) zzacd);
        mo31752b(29, a);
    }

    /* renamed from: cb */
    public final String mo29522cb() throws RemoteException {
        Parcel a = mo31750a(31, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: Ta */
    public final zzzs mo29506Ta() throws RemoteException {
        zzzs zzzs;
        Parcel a = mo31750a(32, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzzs = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            if (queryLocalInterface instanceof zzzs) {
                zzzs = (zzzs) queryLocalInterface;
            } else {
                zzzs = new zzzu(readStrongBinder);
            }
        }
        a.recycle();
        return zzzs;
    }

    /* renamed from: Ya */
    public final zzyz mo29507Ya() throws RemoteException {
        zzyz zzyz;
        Parcel a = mo31750a(33, mo31749a());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzyz = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            if (queryLocalInterface instanceof zzyz) {
                zzyz = (zzyz) queryLocalInterface;
            } else {
                zzyz = new zzzb(readStrongBinder);
            }
        }
        a.recycle();
        return zzyz;
    }

    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30223a(a, z);
        mo31752b(34, a);
    }

    /* renamed from: L */
    public final String mo29505L() throws RemoteException {
        Parcel a = mo31750a(35, mo31749a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    /* renamed from: a */
    public final void mo29518a(zzzp zzzp) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) zzzp);
        mo31752b(36, a);
    }

    public final Bundle getAdMetadata() throws RemoteException {
        Parcel a = mo31750a(37, mo31749a());
        Bundle bundle = (Bundle) zzfo.m30220a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }
}
