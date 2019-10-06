package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.Uj */
final /* synthetic */ class C9172Uj implements zzbwz {

    /* renamed from: a */
    private final zzcjy f21816a;

    /* renamed from: b */
    private final zzcjx f21817b;

    C9172Uj(zzcjy zzcjy, zzcjx zzcjx) {
        this.f21816a = zzcjy;
        this.f21817b = zzcjx;
    }

    /* renamed from: a */
    public final void mo28355a(boolean z, Context context) {
        String str = "Cannot show interstitial.";
        zzcjy zzcjy = this.f21816a;
        zzcjx zzcjx = this.f21817b;
        try {
            if (((zzaov) zzcjy.f26729b).mo29964u(ObjectWrapper.m22188a(context))) {
                zzcjx.mo31187a();
            } else {
                zzbad.m26359d(str);
            }
        } catch (RemoteException e) {
            zzbad.m26358c(str, e);
        }
    }
}
