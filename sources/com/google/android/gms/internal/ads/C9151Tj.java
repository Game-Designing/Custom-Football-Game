package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* renamed from: com.google.android.gms.internal.ads.Tj */
final /* synthetic */ class C9151Tj implements zzbwz {

    /* renamed from: a */
    private final zzcjy f21775a;

    C9151Tj(zzcjy zzcjy) {
        this.f21775a = zzcjy;
    }

    /* renamed from: a */
    public final void mo28355a(boolean z, Context context) {
        zzcjy zzcjy = this.f21775a;
        try {
            ((zzams) zzcjy.f26729b).setImmersiveMode(z);
            ((zzams) zzcjy.f26729b).showInterstitial();
        } catch (RemoteException e) {
            zzbad.m26357c("Cannot show interstitial.");
        }
    }
}
