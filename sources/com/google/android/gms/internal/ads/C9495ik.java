package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads.ik */
final /* synthetic */ class C9495ik implements zzbwz {

    /* renamed from: a */
    private final zzcjy f22559a;

    /* renamed from: b */
    private final zzcjx f22560b;

    C9495ik(zzcjy zzcjy, zzcjx zzcjx) {
        this.f22559a = zzcjy;
        this.f22560b = zzcjx;
    }

    /* renamed from: a */
    public final void mo28355a(boolean z, Context context) {
        String str = "Can't show rewarded video.";
        zzcjy zzcjy = this.f22559a;
        zzcjx zzcjx = this.f22560b;
        try {
            if (((zzaov) zzcjy.f26729b).mo29965v(ObjectWrapper.m22188a(context))) {
                zzcjx.mo31187a();
            } else {
                zzbad.m26359d(str);
            }
        } catch (RemoteException e) {
            zzbad.m26358c(str, e);
        }
    }
}
