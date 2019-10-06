package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzajb extends zzfn implements zzaja {
    public zzajb() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo29357a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzajc zzajc;
        if (i == 3) {
            zzaar videoController = getVideoController();
            parcel2.writeNoException();
            zzfo.m30221a(parcel2, (IInterface) videoController);
        } else if (i == 4) {
            destroy();
            parcel2.writeNoException();
        } else if (i != 5) {
            return false;
        } else {
            IObjectWrapper a = Stub.m22186a(parcel.readStrongBinder());
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzajc = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
                if (queryLocalInterface instanceof zzajc) {
                    zzajc = (zzajc) queryLocalInterface;
                } else {
                    zzajc = new zzajd(readStrongBinder);
                }
            }
            mo29764a(a, zzajc);
            parcel2.writeNoException();
        }
        return true;
    }
}
