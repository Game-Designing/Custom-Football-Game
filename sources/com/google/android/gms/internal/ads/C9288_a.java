package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* renamed from: com.google.android.gms.internal.ads._a */
final class C9288_a implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzaoj f22037a;

    /* renamed from: b */
    private final /* synthetic */ zzamv f22038b;

    C9288_a(zzapc zzapc, zzaoj zzaoj, zzamv zzamv) {
        this.f22037a = zzaoj;
        this.f22038b = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        try {
            this.f22037a.mo28265r(ObjectWrapper.m22188a(mediationBannerAd.getView()));
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return new C9398eb(this.f22038b);
    }

    public final void onFailure(String str) {
        try {
            this.f22037a.mo28264b(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
