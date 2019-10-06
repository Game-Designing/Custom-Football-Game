package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzbji extends zzfn implements zzbjh {
    /* renamed from: a */
    public static zzbjh m27096a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.measurement.IMeasurementManager");
        if (queryLocalInterface instanceof zzbjh) {
            return (zzbjh) queryLocalInterface;
        }
        return new zzbjj(iBinder);
    }
}
