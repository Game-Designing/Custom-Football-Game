package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzatl extends zzfn implements zzatk {
    public zzatl() {
        super("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
    }

    /* renamed from: a */
    public static zzatk m25796a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.mediation.client.IMediationRewardedVideoAdListener");
        if (queryLocalInterface instanceof zzatk) {
            return (zzatk) queryLocalInterface;
        }
        return new zzatm(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                mo29307w(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 2:
                mo29303b(Stub.m22186a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                mo29308y(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 4:
                mo29305s(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 5:
                mo29306t(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 6:
                mo29300E(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 7:
                mo29302a(Stub.m22186a(parcel.readStrongBinder()), (zzato) zzfo.m30220a(parcel, zzato.CREATOR));
                break;
            case 8:
                mo29301F(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 9:
                mo29304c(Stub.m22186a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                mo29309z(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 11:
                mo29299B(Stub.m22186a(parcel.readStrongBinder()));
                break;
            case 12:
                zzb((Bundle) zzfo.m30220a(parcel, Bundle.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
