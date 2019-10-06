package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzzw extends zzfn implements zzzv {
    public zzzw() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzzk zza = zza(Stub.m22186a(parcel.readStrongBinder()), (zzyd) zzfo.m30220a(parcel, zzyd.CREATOR), parcel.readString(), zzamq.m25249a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zza);
                break;
            case 2:
                zzzk zzb = zzb(Stub.m22186a(parcel.readStrongBinder()), (zzyd) zzfo.m30220a(parcel, zzyd.CREATOR), parcel.readString(), zzamq.m25249a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zzb);
                break;
            case 3:
                zzzf zza2 = zza(Stub.m22186a(parcel.readStrongBinder()), parcel.readString(), zzamq.m25249a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zza2);
                break;
            case 4:
                zzaab zzg = zzg(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zzg);
                break;
            case 5:
                zzaem zzc = zzc(Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zzc);
                break;
            case 6:
                zzasw zza3 = zza(Stub.m22186a(parcel.readStrongBinder()), zzamq.m25249a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zza3);
                break;
            case 7:
                zzaqq zzh = zzh(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zzh);
                break;
            case 8:
                zzaqg zzf = zzf(Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zzf);
                break;
            case 9:
                zzaab zza4 = zza(Stub.m22186a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zza4);
                break;
            case 10:
                zzzk zza5 = zza(Stub.m22186a(parcel.readStrongBinder()), (zzyd) zzfo.m30220a(parcel, zzyd.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zza5);
                break;
            case 11:
                zzaer zza6 = zza(Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()), Stub.m22186a(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zza6);
                break;
            case 12:
                zzatt zzb2 = zzb(Stub.m22186a(parcel.readStrongBinder()), parcel.readString(), zzamq.m25249a(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzfo.m30221a(parcel2, (IInterface) zzb2);
                break;
            default:
                return false;
        }
        return true;
    }
}
