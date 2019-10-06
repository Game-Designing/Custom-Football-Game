package com.google.android.gms.internal.safetynet;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zza;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;

public abstract class zzh extends zzb implements zzg {
    public zzh() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo32972a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            mo32977a((Status) zzc.m32629a(parcel, Status.CREATOR), (zza) zzc.m32629a(parcel, zza.CREATOR));
        } else if (i == 2) {
            mo32982c(parcel.readString());
        } else if (i == 3) {
            mo32976a((Status) zzc.m32629a(parcel, Status.CREATOR), (SafeBrowsingData) zzc.m32629a(parcel, SafeBrowsingData.CREATOR));
        } else if (i == 4) {
            mo32981b((Status) zzc.m32629a(parcel, Status.CREATOR), zzc.m32631a(parcel));
        } else if (i == 6) {
            mo32978a((Status) zzc.m32629a(parcel, Status.CREATOR), (zzf) zzc.m32629a(parcel, zzf.CREATOR));
        } else if (i == 8) {
            mo32968a((Status) zzc.m32629a(parcel, Status.CREATOR), (zzd) zzc.m32629a(parcel, zzd.CREATOR));
        } else if (i == 15) {
            mo32979a((Status) zzc.m32629a(parcel, Status.CREATOR), (com.google.android.gms.safetynet.zzh) zzc.m32629a(parcel, com.google.android.gms.safetynet.zzh.CREATOR));
        } else if (i == 10) {
            mo32980a((Status) zzc.m32629a(parcel, Status.CREATOR), zzc.m32631a(parcel));
        } else if (i != 11) {
            return false;
        } else {
            mo32975a((Status) zzc.m32629a(parcel, Status.CREATOR));
        }
        return true;
    }
}
