package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* renamed from: com.google.android.gms.internal.ads.bb */
final class C9332bb implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {

    /* renamed from: a */
    private final /* synthetic */ zzaos f22108a;

    /* renamed from: b */
    private final /* synthetic */ zzamv f22109b;

    /* renamed from: c */
    private final /* synthetic */ zzapc f22110c;

    C9332bb(zzapc zzapc, zzaos zzaos, zzamv zzamv) {
        this.f22110c = zzapc;
        this.f22108a = zzaos;
        this.f22109b = zzamv;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            this.f22110c.f24520d = mediationRewardedAd;
            this.f22108a.mo29049s();
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
        return new C9398eb(this.f22109b);
    }

    public final void onFailure(String str) {
        try {
            this.f22108a.mo29048b(str);
        } catch (RemoteException e) {
            zzbad.m26356b("", e);
        }
    }
}
