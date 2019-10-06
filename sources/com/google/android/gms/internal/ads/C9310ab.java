package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* renamed from: com.google.android.gms.internal.ads.ab */
final class C9310ab implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzaom f22074a;

    /* renamed from: b */
    private final /* synthetic */ zzamv f22075b;

    /* renamed from: c */
    private final /* synthetic */ zzapc f22076c;

    C9310ab(zzapc zzapc, zzaom zzaom, zzamv zzamv) {
        this.f22076c = zzapc;
        this.f22074a = zzaom;
        this.f22075b = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        try {
            this.f22076c.f24519c = mediationInterstitialAd;
            this.f22074a.mo28679s();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return new C9398eb(this.f22075b);
    }

    public final void onFailure(String str) {
        try {
            this.f22074a.mo28678b(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
