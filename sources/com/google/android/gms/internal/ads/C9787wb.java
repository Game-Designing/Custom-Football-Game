package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.gms.internal.ads.wb */
final /* synthetic */ class C9787wb implements zzbaf {

    /* renamed from: a */
    static final zzbaf f23348a = new C9787wb();

    private C9787wb() {
    }

    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        if (queryLocalInterface instanceof zzatz) {
            return (zzatz) queryLocalInterface;
        }
        return new zzaua(iBinder);
    }
}
