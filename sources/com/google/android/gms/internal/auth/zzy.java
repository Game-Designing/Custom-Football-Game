package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.auth.api.accounttransfer.zzl;
import com.google.android.gms.auth.api.accounttransfer.zzt;
import com.google.android.gms.common.api.Status;

public abstract class zzy extends zzb implements zzx {
    public zzy() {
        super("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferCallbacks");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo27093a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                mo32445d((Status) zzc.m31675a(parcel, Status.CREATOR));
                break;
            case 2:
                mo32443a((Status) zzc.m31675a(parcel, Status.CREATOR), (zzt) zzc.m31675a(parcel, zzt.CREATOR));
                break;
            case 3:
                mo32442a((Status) zzc.m31675a(parcel, Status.CREATOR), (zzl) zzc.m31675a(parcel, zzl.CREATOR));
                break;
            case 4:
                mo32440Sa();
                break;
            case 5:
                mo32446e((Status) zzc.m31675a(parcel, Status.CREATOR));
                break;
            case 6:
                mo32444b(parcel.createByteArray());
                break;
            case 7:
                mo32441a((DeviceMetaData) zzc.m31675a(parcel, DeviceMetaData.CREATOR));
                break;
            default:
                return false;
        }
        return true;
    }
}
