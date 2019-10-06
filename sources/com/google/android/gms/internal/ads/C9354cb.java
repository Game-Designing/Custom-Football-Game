package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* renamed from: com.google.android.gms.internal.ads.cb */
final class C9354cb implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzaop f22148a;

    /* renamed from: b */
    private final /* synthetic */ zzamv f22149b;

    C9354cb(zzapc zzapc, zzaop zzaop, zzamv zzamv) {
        this.f22148a = zzaop;
        this.f22149b = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        try {
            this.f22148a.mo28910a(new zzaoi(unifiedNativeAdMapper));
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return new C9398eb(this.f22149b);
    }

    public final void onFailure(String str) {
        try {
            this.f22148a.mo28911b(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
