package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.hk */
final /* synthetic */ class C9473hk implements zzbwz {

    /* renamed from: a */
    private final zzcjy f22418a;

    C9473hk(zzcjy zzcjy) {
        this.f22418a = zzcjy;
    }

    /* renamed from: a */
    public final void mo28355a(boolean z, Context context) {
        zzcjy zzcjy = this.f22418a;
        try {
            ((zzams) zzcjy.f26729b).setImmersiveMode(z);
            ((zzams) zzcjy.f26729b).mo29859l(ObjectWrapper.m22188a(context));
        } catch (RemoteException e) {
            zzbad.m26358c("Cannot show rewarded .", e);
        }
    }
}
