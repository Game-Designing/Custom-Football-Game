package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.uk */
final /* synthetic */ class C9754uk implements zzbwz {

    /* renamed from: a */
    private final zzcjy f23225a;

    C9754uk(zzcjy zzcjy) {
        this.f23225a = zzcjy;
    }

    /* renamed from: a */
    public final void mo28355a(boolean z, Context context) {
        zzcjy zzcjy = this.f23225a;
        try {
            ((zzams) zzcjy.f26729b).setImmersiveMode(z);
            ((zzams) zzcjy.f26729b).showVideo();
        } catch (RemoteException e) {
            zzbad.m26358c("Cannot show rewarded video.", e);
        }
    }
}
