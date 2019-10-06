package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzatx extends zzfn implements zzatw {
    public zzatx() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzatq zzatq;
        if (i == 1) {
            mo30083T();
        } else if (i == 2) {
            mo30082Q();
        } else if (i == 3) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzatq = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
                if (queryLocalInterface instanceof zzatq) {
                    zzatq = (zzatq) queryLocalInterface;
                } else {
                    zzatq = new zzats(readStrongBinder);
                }
            }
            mo30084a(zzatq);
        } else if (i != 4) {
            return false;
        } else {
            mo30085q(parcel.readInt());
        }
        parcel2.writeNoException();
        return true;
    }
}
