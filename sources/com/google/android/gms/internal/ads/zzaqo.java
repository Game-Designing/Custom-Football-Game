package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class zzaqo extends zzfn implements zzaqn {
    /* renamed from: a */
    public static zzaqn m25681a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (queryLocalInterface instanceof zzaqn) {
            return (zzaqn) queryLocalInterface;
        }
        return new zzaqp(iBinder);
    }
}
