package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzauj {
    /* renamed from: a */
    public static zzatt m25860a(Context context, String str, zzamp zzamp) {
        try {
            IBinder b = ((zzatz) zzbae.m26364a(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", C9787wb.f23348a)).mo30086b(ObjectWrapper.m22188a(context), str, zzamp, 15000000);
            if (b == null) {
                return null;
            }
            IInterface queryLocalInterface = b.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzatt) {
                return (zzatt) queryLocalInterface;
            }
            return new zzatv(b);
        } catch (RemoteException | zzbag e) {
            zzbad.m26360d("#007 Could not call remote method.", e);
            return null;
        }
    }
}
