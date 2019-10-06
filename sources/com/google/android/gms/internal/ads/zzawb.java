package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzawb extends zzfn implements zzawa {
    public zzawb() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzavy zzavy;
        if (i != 1) {
            return false;
        }
        IObjectWrapper a = Stub.m22186a(parcel.readStrongBinder());
        zzawc zzawc = (zzawc) zzfo.m30220a(parcel, zzawc.CREATOR);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzavy = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
            if (queryLocalInterface instanceof zzavy) {
                zzavy = (zzavy) queryLocalInterface;
            } else {
                zzavy = new zzavz(readStrongBinder);
            }
        }
        mo30143a(a, zzawc, zzavy);
        parcel2.writeNoException();
        return true;
    }
}
