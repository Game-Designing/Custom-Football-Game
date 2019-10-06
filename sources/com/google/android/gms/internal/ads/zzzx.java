package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzzx extends zzfm implements zzzv {
    zzzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzyd, String str, zzamp zzamp, int i) throws RemoteException {
        zzzk zzzk;
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzyd);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamp);
        a.writeInt(i);
        Parcel a2 = mo31750a(1, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzzk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzk = (zzzk) queryLocalInterface;
            } else {
                zzzk = new zzzm(readStrongBinder);
            }
        }
        a2.recycle();
        return zzzk;
    }

    public final zzzk zzb(IObjectWrapper iObjectWrapper, zzyd zzyd, String str, zzamp zzamp, int i) throws RemoteException {
        zzzk zzzk;
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzyd);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamp);
        a.writeInt(i);
        Parcel a2 = mo31750a(2, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzzk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzk = (zzzk) queryLocalInterface;
            } else {
                zzzk = new zzzm(readStrongBinder);
            }
        }
        a2.recycle();
        return zzzk;
    }

    public final zzzf zza(IObjectWrapper iObjectWrapper, String str, zzamp zzamp, int i) throws RemoteException {
        zzzf zzzf;
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamp);
        a.writeInt(i);
        Parcel a2 = mo31750a(3, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzzf = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzzf) {
                zzzf = (zzzf) queryLocalInterface;
            } else {
                zzzf = new zzzh(readStrongBinder);
            }
        }
        a2.recycle();
        return zzzf;
    }

    public final zzaem zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) iObjectWrapper2);
        Parcel a2 = mo31750a(5, a);
        zzaem a3 = zzaen.m24855a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final zzasw zza(IObjectWrapper iObjectWrapper, zzamp zzamp, int i) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) zzamp);
        a.writeInt(i);
        Parcel a2 = mo31750a(6, a);
        zzasw a3 = zzasx.m25760a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final zzaqg zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        Parcel a2 = mo31750a(8, a);
        zzaqg zzac = zzaqh.zzac(a2.readStrongBinder());
        a2.recycle();
        return zzac;
    }

    public final zzaab zza(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzaab zzaab;
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeInt(i);
        Parcel a2 = mo31750a(9, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzaab = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzaab) {
                zzaab = (zzaab) queryLocalInterface;
            } else {
                zzaab = new zzaad(readStrongBinder);
            }
        }
        a2.recycle();
        return zzaab;
    }

    public final zzzk zza(IObjectWrapper iObjectWrapper, zzyd zzyd, String str, int i) throws RemoteException {
        zzzk zzzk;
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30222a(a, (Parcelable) zzyd);
        a.writeString(str);
        a.writeInt(i);
        Parcel a2 = mo31750a(10, a);
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzzk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            if (queryLocalInterface instanceof zzzk) {
                zzzk = (zzzk) queryLocalInterface;
            } else {
                zzzk = new zzzm(readStrongBinder);
            }
        }
        a2.recycle();
        return zzzk;
    }

    public final zzaer zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        zzfo.m30221a(a, (IInterface) iObjectWrapper2);
        zzfo.m30221a(a, (IInterface) iObjectWrapper3);
        Parcel a2 = mo31750a(11, a);
        zzaer a3 = zzaes.m24867a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }

    public final zzatt zzb(IObjectWrapper iObjectWrapper, String str, zzamp zzamp, int i) throws RemoteException {
        Parcel a = mo31749a();
        zzfo.m30221a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        zzfo.m30221a(a, (IInterface) zzamp);
        a.writeInt(i);
        Parcel a2 = mo31750a(12, a);
        zzatt a3 = zzatu.m25820a(a2.readStrongBinder());
        a2.recycle();
        return a3;
    }
}
