package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzafj extends zzfn implements zzafi {
    public zzafj() {
        super("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    /* renamed from: a */
    public static zzafi m24943a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
        if (queryLocalInterface instanceof zzafi) {
            return (zzafi) queryLocalInterface;
        }
        return new zzafk(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzaew zzaew;
        if (i != 1) {
            return false;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzaew = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
            if (queryLocalInterface instanceof zzaew) {
                zzaew = (zzaew) queryLocalInterface;
            } else {
                zzaew = new zzaey(readStrongBinder);
            }
        }
        mo29697a(zzaew);
        parcel2.writeNoException();
        return true;
    }
}
