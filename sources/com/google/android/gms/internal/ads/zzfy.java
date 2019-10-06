package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzfy extends zzfn implements zzfx {
    /* renamed from: a */
    public static zzfx m30234a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.clearcut.IClearcut");
        if (queryLocalInterface instanceof zzfx) {
            return (zzfx) queryLocalInterface;
        }
        return new zzfz(iBinder);
    }
}
