package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* renamed from: com.google.android.gms.internal.ads.Ta */
final class C9142Ta implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzamv f21763a;

    /* renamed from: b */
    private final /* synthetic */ Adapter f21764b;

    /* renamed from: c */
    private final /* synthetic */ zzanl f21765c;

    C9142Ta(zzanl zzanl, zzamv zzamv, Adapter adapter) {
        this.f21765c = zzanl;
        this.f21763a = zzamv;
        this.f21764b = adapter;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.f21765c.f24493f = mediationRewardedAd;
            this.f21763a.onAdLoaded();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return new zzauo(this.f21763a);
    }

    public final void onFailure(String str) {
        try {
            String canonicalName = this.f21764b.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 30 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded medation ad: ");
            sb.append(str);
            zzbad.m26352a(sb.toString());
            this.f21763a.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
