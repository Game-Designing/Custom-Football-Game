package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class zzaqu extends zzfn implements zzaqt {
    /* renamed from: a */
    public static zzaqt m25682a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (queryLocalInterface instanceof zzaqt) {
            return (zzaqt) queryLocalInterface;
        }
        return new zzaqv(iBinder);
    }
}
